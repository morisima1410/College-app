package com.example.projectexpo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.BaseAdapter;

import com.example.projectexpo.R;

import java.util.ArrayList;

public class ActivityAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> items;
    private OnDeleteClickListener onDeleteClickListener;

    public ActivityAdapter(Context context, ArrayList<String> items) {
        this.context = context;
        this.items = items;
    }

    public interface OnDeleteClickListener {
        void onDeleteClick(int position);
    }

    public void setOnDeleteClickListener(OnDeleteClickListener listener) {
        this.onDeleteClickListener = listener;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_activity, parent, false);
        }

        TextView txtActivity = convertView.findViewById(R.id.txtActivity);
        ImageView imgDelete = convertView.findViewById(R.id.imgDelete);

        txtActivity.setText(items.get(position));

        imgDelete.setOnClickListener(v -> {
            if (onDeleteClickListener != null) {
                onDeleteClickListener.onDeleteClick(position);
            }
        });

        return convertView;
    }
}
