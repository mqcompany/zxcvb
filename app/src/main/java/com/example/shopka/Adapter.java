package com.example.shopka;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
//    private LayoutInflater inflater;
    private List<Msg> msgList;
    private Context context;
    Adapter(Context context, List<Msg> msgList){
        this.msgList = msgList;
        this.context = context;
//        this.inflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Msg msg = msgList.get(i);
        //viewHolder.imag_lenta.setImageResource(msg.getImage());
        viewHolder.title_lenta.setText(msg.getMsg());
        Picasso.with(context).load(msg.getImage()).into(viewHolder.imag_lenta);
    }

    @Override
    public int getItemCount() {
        return msgList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
    ImageView imag_lenta;
    TextView title_lenta;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        imag_lenta = (ImageView)itemView.findViewById(R.id.imag_lenta);
        title_lenta = (TextView)itemView.findViewById(R.id.title_lenta);
    }
}
}
