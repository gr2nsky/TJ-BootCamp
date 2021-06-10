package com.example.day8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private String[] titles = {"Monday 월", "Tuesday ", "Wednesday 수", "Thursday 목",
            "Friday 금", "Saturday 토", "Sunday 일"};
    private String[] details = {"월요일 이상정보", "화요일 이상정보", "수요일 이상정보", "목요일 이상정보",
            "금요일 이상정보", "토요일 이상정보", "일요일 이상정보"};
    private int[] images = {R.drawable.w1, R.drawable.w2, R.drawable.w3, R.drawable.w4,
            R.drawable.w5, R.drawable.w6, R.drawable.w7};

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView itemImage;
        public TextView itemTitle;
        public TextView itemDetail;

        //todtjdwk
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.card_imageView);
            itemTitle = itemView.findViewById(R.id.card_title);
            itemDetail = itemView.findViewById(R.id.card_detail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Snackbar.make(v, details[position], Snackbar.LENGTH_LONG).setAction("",null).show();
                }
            });
        }
    }

    //초기값만드는친구
    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }
    //재사용하는친구
    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        holder.itemTitle.setText(titles[position]);
        holder.itemDetail.setText(details[position]);
        holder.itemImage.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
