package com.example.jimmy_pc.ingdemo.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jimmy_pc.ingdemo.DetailsActivity;
import com.example.jimmy_pc.ingdemo.Model.RecyclerViewPojo.RecyclerViewItem;
import com.example.jimmy_pc.ingdemo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jimmy-PC on 11/8/2017.
 */

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolder> {

    /**
     *
     * Define necessary params
     */
    private List<RecyclerViewItem> dataList = new ArrayList<>();
    private Context context;

    /**
     *
     * @param context
     * @param dataList
     */
    public MainRecyclerViewAdapter(Context context, List<RecyclerViewItem> dataList){
        this.dataList = dataList;
        this.context = context;
    }

    /**
     *
     * Inflate a layout and insert into a view holder
     *
     * @param parent
     * @param viewType
     * @return view holder
     */
    @Override
    public MainRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.main_page_recyclerview_cell,parent,false);
        return new ViewHolder(view);
    }

    /**
     *
     * Set content to the view holder based on their
     * respective position.
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(final MainRecyclerViewAdapter.ViewHolder holder, final int position) {
        holder.developerLabel.setText(dataList.get(position).getName());
        holder.phoneNoLabel.setText(dataList.get(position).getPhoneNo());
        holder.cellLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("name",dataList.get(position).getName());
                intent.putExtra("email",dataList.get(position).getEmail());
                intent.putExtra("balance",dataList.get(position).getBalance());
                intent.putExtra("image",dataList.get(position).getImg());
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return dataList.size();
    } //get amount to be shown from the list

    /**
     *
     * Define/Initialize UI widget inside a view holder
     */
    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.developerLabelTV)
        TextView developerLabel;

        @BindView(R.id.phoneNoLabelTV)
        TextView phoneNoLabel;

        @BindView(R.id.cellLayout)
        LinearLayout cellLayout;

        public ViewHolder(View view){
            super(view);
            ButterKnife.bind(this,view);
        }
    }
}