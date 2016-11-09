package com.hello_world.vikas.task_list;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vikas on 11/9/2016.
 */
public class Adapter extends RecyclerView.Adapter<Adapter.Holder>
{
    Context context;
    ArrayList<Item> list;

    public Adapter(Context context, ArrayList<Item> list){
        this.context = context;
        this.list = list;
    }

    public class Holder extends RecyclerView.ViewHolder{

        TextView holderTitle;

        public Holder(View itemView){
            super(itemView);
            holderTitle = (TextView) itemView.findViewById(R.id.titleTextView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int i = getAdapterPosition();
                    Item item = list.get(i);
                    Intent intent = new Intent();
                    intent.setClass(context, Show.class);
                    intent.putExtra("position", i);
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public Adapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rcv_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Adapter.Holder holder, int position) {
        Item item = list.get(position);
        holder.holderTitle.setText(item.getTitle());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
