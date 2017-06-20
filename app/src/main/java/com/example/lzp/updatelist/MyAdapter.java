package com.example.lzp.updatelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

/**
 * Created by lzp on 2017/6/19.
 */

public class MyAdapter extends BaseAdapter {
    private Context context;
    private List<String> datas;
    private OnUpdateClickListener onUpdateClickListener;

    public MyAdapter(Context context, List<String> datas, OnUpdateClickListener onUpdateClickListener){
        this.context = context;
        this.datas = datas;
        this.onUpdateClickListener = onUpdateClickListener;
    }
    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = null;
        final ViewHolder holder;
        if(convertView == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_list,null,false);
            holder = new ViewHolder();
            holder.button = (Button) view.findViewById(R.id.button);
            view.setTag(holder);
        }else{
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }

        if(((MainActivity) context).getTag()){

            holder.button.setText("btn");
            holder.button.setTextColor(context.getResources().getColor(R.color.colorAccent));
            holder.button.setBackgroundDrawable(context.getResources().getDrawable(R.color.colorPrimary));
        }else{

            holder.button.setText("按钮"+datas.get(position));
            holder.button.setTextColor(context.getResources().getColor(R.color.black));
            holder.button.setBackgroundDrawable(context.getResources().getDrawable(R.color.white));
        }

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"点击"+position, Toast.LENGTH_SHORT).show();
//                MainActivity mainActivity = (MainActivity)context;

                onUpdateClickListener.OnUpdate();
            }
        });

        return view;
    }
    class ViewHolder{
        private Button button;
    }

    public static interface OnUpdateClickListener{
        public void OnUpdate();
    }
}
