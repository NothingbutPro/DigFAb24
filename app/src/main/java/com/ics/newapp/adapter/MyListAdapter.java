package com.ics.newapp.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ics.newapp.DetailsActivity;
import com.ics.newapp.R;
import com.ics.newapp.model.MyListData;

import java.sql.Time;
import java.util.Calendar;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder> {

    private MyListData[] listdata;
    Calendar c = Calendar.getInstance();
    // RecyclerView recyclerView;
    public MyListAdapter(MyListData[] listdata) {
        this.listdata = listdata;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final MyListData myListData = listdata[position];
        int wtf = position +3;
        holder.textView.setText(listdata[position].getDescription());
        holder.textView2sdf.setText(String.valueOf(wtf).concat("PM"));
//        if(position ==0)
//        {

            holder.imageView.setImageResource(R.drawable.prof);
//        }

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(view.getContext(),DetailsActivity.class);
//                view.getContext().startActivity(intent);
             // Toast.makeText(view.getContext(),"click on item",Toast.LENGTH_LONG).show();
            }
        });
        holder.bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),DetailsActivity.class);
                intent.putExtra("ideaname" , ""+holder.textView.getText().toString());
                view.getContext().startActivity(intent);
                // Toast.makeText(view.getContext(),"click on item",Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public CircleImageView imageView;
        public TextView textView;
        public RelativeLayout relativeLayout;
        private Button bt_add;
        TextView textView2df,textbrand,textView2sdf;
        @SuppressLint("WrongViewCast")
        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = (CircleImageView) itemView.findViewById(R.id.dunb_image);
            this.textView = (TextView) itemView.findViewById(R.id.textView);
            this.textbrand = itemView.findViewById(R.id.textbrand);
            this.textView2df = itemView.findViewById(R.id.textView2df);
            this.textView2sdf = itemView.findViewById(R.id.textView2sdf);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.relativeLayout);
            bt_add = (Button) itemView.findViewById(R.id.bt_add);
        }
    }
}
