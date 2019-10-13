package com.example.viewpagerfragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewpagerfragment.R;

import java.util.List;

/**
 * @description: 列表adapter
 * @author: zhukai
 * @date: 2019/4/1 8:33
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    private Context mContext;
    private List<String> mData;

    public ListAdapter(Context context, List<String> data) {
        this.mContext = context;
        this.mData = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_list, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        holder.tvTitle.setText(mData.get(i));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
        }
    }
}
