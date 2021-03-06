package com.example.howtoday.Memo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.howtoday.R;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    public interface OnItemClickListener{
        void onItemClick(View v, int position);
    }

    private OnItemClickListener mListener = null;

    private ArrayList<Item> mData = null;

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mListener = listener;
    }


    public RecyclerAdapter(ArrayList<Item> mData) {
        this.mData = mData;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView toptv, bottomtv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION){
                        Log.e("눌림",""+pos);
                        if(mListener != null){
                            mListener.onItemClick(view,pos);
                        }
                    }
                }
            });

            toptv = itemView.findViewById(R.id.topTv);
            bottomtv = itemView.findViewById(R.id.bottomTv);
        }
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.recyclerview_item,parent,false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("눌려짐","눌림");
            }
        });
        RecyclerAdapter.ViewHolder vh = new RecyclerAdapter.ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        Item item = mData.get(position);
        holder.toptv.setText(item.getTopTv());
        holder.bottomtv.setText(item.getBottomTv());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
