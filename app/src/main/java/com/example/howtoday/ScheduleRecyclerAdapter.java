package com.example.howtoday;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ScheduleRecyclerAdapter extends RecyclerView.Adapter<ScheduleRecyclerAdapter.ViewHolder> {

    private ArrayList<ScheduleItem> mData = new ArrayList<>();

    public ScheduleRecyclerAdapter(ArrayList<ScheduleItem> mData) {
        this.mData = mData;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView scheduleTextView;
        ImageView blackCircle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            scheduleTextView = itemView.findViewById(R.id.scheduleTextView);
            blackCircle = itemView.findViewById(R.id.blackCircle);

        }
    }

    @NonNull
    @Override
    public ScheduleRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.calendar_recycler_item, parent, false);
        ScheduleRecyclerAdapter.ViewHolder vh = new ScheduleRecyclerAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleRecyclerAdapter.ViewHolder holder, int position) {
        ScheduleItem scheduleItem = mData.get(position);
        holder.blackCircle.setImageDrawable(scheduleItem.getBlackCircle());
        holder.scheduleTextView.setText(scheduleItem.getSchedule());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
