package com.example.projectexpo;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectexpo.Adapter.PlacementAdapter;
import com.example.projectexpo.model.PlacementUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Show extends AppCompatActivity {

    RecyclerView recyclerView;
    PlacementAdapter adapter;
    ArrayList<PlacementUser> userList;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_show);

        recyclerView = findViewById(R.id.recyclerViewStudents);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        userList = new ArrayList<>();
        adapter = new PlacementAdapter(userList);
        recyclerView.setAdapter(adapter);

        databaseReference = FirebaseDatabase.getInstance().getReference("PlacementUsers");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                userList.clear();
                for (DataSnapshot ds : snapshot.getChildren()) {
                    PlacementUser user = ds.getValue(PlacementUser.class);
                    if (user != null) user.setFirebaseKey(ds.getKey());
                    userList.add(user);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Show.this, "Failed to load data", Toast.LENGTH_SHORT).show();
            }
        });

        // Swipe helper
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView,
                                  @NonNull RecyclerView.ViewHolder viewHolder,
                                  @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                PlacementUser user = userList.get(position);
                String key = user.getFirebaseKey();

                if (direction == ItemTouchHelper.RIGHT) {
                    // Delete
                    FirebaseDatabase.getInstance()
                            .getReference("PlacementUsers")
                            .child(key)
                            .removeValue();
                    userList.remove(position);
                    adapter.notifyItemRemoved(position);
                    Toast.makeText(Show.this, "Deleted Successfully", Toast.LENGTH_SHORT).show();
                } else if (direction == ItemTouchHelper.LEFT) {
                    // Edit
                    Intent intent = new Intent(Show.this, PlacementRegister.class);
                    intent.putExtra("firebaseKey", key);
                    startActivity(intent);
                    adapter.notifyItemChanged(position);
                }
            }

            @Override
            public void onChildDraw(@NonNull Canvas c,
                                    @NonNull RecyclerView recyclerView,
                                    @NonNull RecyclerView.ViewHolder viewHolder,
                                    float dX, float dY,
                                    int actionState,
                                    boolean isCurrentlyActive) {

                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);

                int itemHeight = viewHolder.itemView.getBottom() - viewHolder.itemView.getTop();
                int iconSize = itemHeight / 2;

                if (dX > 0) {
                    // Right swipe → delete
                    Paint paint = new Paint();
                    paint.setColor(Color.RED);
                    c.drawRect(viewHolder.itemView.getLeft(), viewHolder.itemView.getTop(),
                            viewHolder.itemView.getLeft() + dX, viewHolder.itemView.getBottom(), paint);

                    // Delete icon
                    android.graphics.drawable.Drawable icon = ContextCompat.getDrawable(Show.this, R.drawable.ic_delete);
                    int iconTop = viewHolder.itemView.getTop() + (itemHeight - iconSize) / 2;
                    int iconBottom = iconTop + iconSize;
                    int iconLeft = viewHolder.itemView.getLeft() + 16;
                    int iconRight = iconLeft + iconSize;
                    if (icon != null) {
                        icon.setBounds(iconLeft, iconTop, iconRight, iconBottom);
                        icon.draw(c);
                    }

                } else if (dX < 0) {
                    // Left swipe → edit
                    Paint paint = new Paint();
                    paint.setColor(Color.BLUE);
                    c.drawRect(viewHolder.itemView.getRight() + dX, viewHolder.itemView.getTop(),
                            viewHolder.itemView.getRight(), viewHolder.itemView.getBottom(), paint);

                    // Edit icon
                    android.graphics.drawable.Drawable icon = ContextCompat.getDrawable(Show.this, R.drawable.ic_edit);
                    int iconTop = viewHolder.itemView.getTop() + (itemHeight - iconSize) / 2;
                    int iconBottom = iconTop + iconSize;
                    int iconRight = viewHolder.itemView.getRight() - 16;
                    int iconLeft = iconRight - iconSize;
                    if (icon != null) {
                        icon.setBounds(iconLeft, iconTop, iconRight, iconBottom);
                        icon.draw(c);
                    }
                }
            }
        });

        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
}
