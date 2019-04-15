package com.ics.newapp.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ics.newapp.R;

public class HeaderAdapter extends RecyclerView.Adapter<HeaderAdapter.HeaderHolder> {
        Context mContext;

public HeaderAdapter(Context mContext) {
        this.mContext = mContext;

        }


@Override
public HeaderHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_child_menu, parent, false);
        HeaderHolder headerHolder = new HeaderHolder(view);
        return headerHolder;
        }



@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
@Override
public void onBindViewHolder(HeaderHolder holder, int position) {
        try {
        try {
        if (((position+1)%2) == 0) {
        Drawable img = mContext.getResources().getDrawable(R.drawable.dd4);
        holder.difficon.setBackground(img);
        // holder.menuitems.setText("Data - " + (position+1/**10+position*/));
        } else {
        Drawable img = mContext.getResources().getDrawable(R.drawable.dd3);
        holder.difficon.setBackground(img);
        // holder.menuitems.setText("Data - " + (position+1/**10-position*/));
        }
        } catch (Exception e) {
        e.printStackTrace();
        }
        } catch (Exception e) {
        e.printStackTrace();
        }
        }

@Override
public int getItemCount() {
        return 20;
        }

public class HeaderHolder extends RecyclerView.ViewHolder {

    private ImageView difficon;

    public HeaderHolder(View itemView) {
        super(itemView);
        difficon = (ImageView) itemView.findViewById(R.id.difficonfdg);
    }
}



}