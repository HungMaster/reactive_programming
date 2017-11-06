package com.it.hungvt.reactiveprogramming.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.it.hungvt.reactiveprogramming.R;
import com.it.hungvt.reactiveprogramming.model.AndroidOS;

import java.util.List;

/**
 * Created by Administrator on 11/6/2017.
 */

public class AndroidOSAdapter extends RecyclerView.Adapter<AndroidOSAdapter.ViewHolder> {

    private List<AndroidOS> androidOSs;

    public AndroidOSAdapter(List<AndroidOS> androidOSs) {
        this.androidOSs = androidOSs;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        AndroidOS androidOS = androidOSs.get(position);
        holder.txtName.setText(androidOS.getName());
        holder.txtVersion.setText(androidOS.getVersion());
        holder.txtApi.setText(androidOS.getApi());
    }

    @Override
    public int getItemCount() {
        return androidOSs.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtName;
        private TextView txtVersion;
        private TextView txtApi;

        public ViewHolder(View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txt_name);
            txtVersion = itemView.findViewById(R.id.txt_version);
            txtApi = itemView.findViewById(R.id.txt_api);
        }
    }
}
