package com.example.double2.studentinfomanager.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.double2.studentinfomanager.R;
import com.example.double2.studentinfomanager.activity.EditActivity;

import java.util.ArrayList;

/**
 * 项目名称：StudentInfoManager
 * 创建人：Double2号
 * 创建时间：2016/7/26 10:25
 * 修改备注：
 */
public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.ViewHolder> {
    private Context mContext;

    private ArrayList<String> mNumber;
    private ArrayList<String> mName;
    private ArrayList<String> mGender;

    public final static int maxSize = 50;//最多显示50条

    public ShowAdapter(Context context,
                       ArrayList<String> number, ArrayList<String> name, ArrayList<String> gender) {
        mContext = context;
        mNumber = number;
        mName = name;
        mGender = gender;
    }

    @Override
    public ShowAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View views = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_show, parent, false);

        return new ViewHolder(views);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public CardView cvShow;
        public TextView tvNumber;
        public TextView tvName;
        public TextView tvGender;

        public ViewHolder(View itemView) {
            super(itemView);
            cvShow = (CardView) itemView.findViewById(R.id.cv_show);
            tvNumber = (TextView) itemView.findViewById(R.id.tv_show_number);
            tvName = (TextView) itemView.findViewById(R.id.tv_show_name);
            tvGender = (TextView) itemView.findViewById(R.id.tv_show_gender);
        }

    }

    @Override
    public void onBindViewHolder(ShowAdapter.ViewHolder holder, final int position) {

        holder.tvNumber.setText(mNumber.get(position));
        holder.tvName.setText(mName.get(position));
        holder.tvGender.setText(mGender.get(position));

        holder.cvShow.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View v) {
                                                 Intent intent = new Intent(mContext, EditActivity.class);
                                                 intent.putExtra("type", EditActivity.TYPE_EDIT);
                                                 intent.putExtra("number", mNumber.get(position));
                                                 mContext.startActivity(intent);
                                             }
                                         }
        );

    }

    @Override
    public int getItemCount() {
        if (mNumber.size() < maxSize)
            return mNumber.size();
        else
            return maxSize;
    }


}
