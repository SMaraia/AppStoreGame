package com.seanmaraia.sean_mbp.listdemospm;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Sean-MBP on 9/18/15.
 */


public class AppItemAdapter extends RecyclerView.Adapter<AppItemAdapter.AppItemViewHolder> {

    private Context mContext;

    List<AppItem> mItemList;
    public class AppItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView mealname;
        TextView calorieCount;
        TextView mDate;
        CardView mCardView;

        AppItemViewHolder(View itemView) {
            super(itemView);
            mCardView = (CardView)itemView.findViewById(R.id.cv);
            mealname = (TextView)itemView.findViewById(R.id.label);
            calorieCount = (TextView)itemView.findViewById(R.id.calories);
            mDate = (TextView)itemView.findViewById(R.id.date);

            mealname.setOnLongClickListener(
                    new RecyclerView.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View view) {
                            delete(getAdapterPosition());
                            return true;
                        }
                    }
            );
        }

        @Override
        public void onClick(View v) {
            delete(getAdapterPosition());
        }
    }

    public void delete(int position){
        mItemList.remove(position);
        notifyItemRemoved(position);
    }

    AppItemAdapter(List<AppItem> todos){
        mItemList = todos;
    }
    @Override
    public int getItemCount(){

        return mItemList.size();
    }

    @Override
    public AppItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.better_list_item, viewGroup, false);
        AppItemViewHolder mvh = new AppItemViewHolder(v);
        return mvh;

    }

    @Override
    public void onBindViewHolder(AppItemViewHolder viewHolder, int i){
        //viewHolder.mealname.setText(mItemList.get(i).text);
        //viewHolder.calorieCount.setText(mItemList.get(i).calText);
        //viewHolder.mDate.setText(mItemList.get(i).formattedDate);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
