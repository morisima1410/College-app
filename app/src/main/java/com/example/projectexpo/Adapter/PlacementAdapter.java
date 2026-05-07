package com.example.projectexpo.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectexpo.R;
import com.example.projectexpo.model.PlacementUser;

import java.util.List;

public class PlacementAdapter extends RecyclerView.Adapter<PlacementAdapter.ViewHolder> {

    private final List<PlacementUser> userList;

    public PlacementAdapter(List<PlacementUser> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_student, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        PlacementUser user = userList.get(position);
        if (user == null) return;

        holder.tvName.setText("Name: " + safeString(user.getFullName()));
        holder.tvEnrollment.setText("Enrollment: " + safeString(user.getEnrollment()));
        holder.tvEmail.setText("Email: " + safeString(user.getEmail()));
        holder.tvMobile.setText("Mobile: " + safeString(user.getMobile()));
        holder.tvBranch.setText("Branch: " + safeString(user.getBranch()));
        holder.tvGender.setText("Gender: " + safeString(user.getGender()));
        holder.tvDOB.setText("DOB: " + safeString(user.getDob()));
        holder.tvPH.setText("PH: " + safeString(user.getPhStatus()));
        holder.tvCGPA.setText("CGPA: " + safeString(user.getCgpa()));
    }

    @Override
    public int getItemCount() {
        return userList != null ? userList.size() : 0;
    }

    private String safeString(String value) {
        return value != null ? value : "-";
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvEnrollment, tvEmail, tvMobile, tvBranch, tvGender, tvDOB, tvPH, tvCGPA;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // These IDs should exist in item_student.xml as TextViews
            tvName = itemView.findViewById(R.id.tvName);
            tvEnrollment = itemView.findViewById(R.id.tvEnrollment);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvMobile = itemView.findViewById(R.id.tvMobile);
            tvBranch = itemView.findViewById(R.id.tvBranch);
            tvGender = itemView.findViewById(R.id.tvGender);
            tvDOB = itemView.findViewById(R.id.tvDOB);
            tvPH = itemView.findViewById(R.id.tvPH);
            tvCGPA = itemView.findViewById(R.id.tvCGPA);
        }
    }
}
