package com.xj.xiaola;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.xj.xiaola.news.bean.NewsChannel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class BigListRight extends Fragment {
    private ListView listview;
    private MyThreeAdapter myThreeAdapter;
    private List<NewsChannel> listData;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.right_layout, null);
        listview = (ListView) view.findViewById(R.id.listClass);
        goods();
        return view;
    }





    private int rightId=0;
    private int cur_pos = 0;
    /**
     * 加载数据
     * @param
     */
    public void setTextAble(int id) {
        System.out.println("------右侧侧传来的id数字"+id);
        rightId = id;
        cur_pos = 0;
        if(id == 999){   // 没有2级菜单内容 不请求三级接口
            if(myThreeAdapter != null){
                myThreeAdapter.notifyDataSetChanged();
            }
        }else{
            goods();
        }
    }

    private void goods(){


        Random rand = new Random();
        int randNumber = rand.nextInt(12 - 3 + 1) + 3;//生成3到12间的随机数
        listData = new ArrayList<NewsChannel>();
        for (int i = 0; i < 13 ; i++) {

            NewsChannel chan=new NewsChannel();
            chan.setTitleThree("三三三三三三三三三"+rightId);
            chan.setCodeThree(i);
            listData.add(chan);

        }
        if(myThreeAdapter == null){
            myThreeAdapter = new MyThreeAdapter(getActivity(), listData);
            if (listview != null) {
                listview.setAdapter(myThreeAdapter);
                listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        cur_pos = i;
                        Toast.makeText(getActivity(),"内容："+listData.get(i).getCodeThree(),Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }else {
            myThreeAdapter.onDateChange(listData);
        }



    }




    private class MyThreeAdapter extends BaseAdapter {
        private LayoutInflater inflater;
        private List<NewsChannel> mlist;

        @SuppressWarnings("unused")
        public MyThreeAdapter(Context context, List<NewsChannel> data) {
            inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            mlist = data;
        }
        private void onDateChange(List<NewsChannel> list) {
            this.mlist = list;
            this.notifyDataSetChanged();
        }
        @Override
        public int getCount() {
            return mlist.size();
        }

        @Override
        public Object getItem(int position) {
            return mlist.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @SuppressLint("ViewHolder")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            MyThreeAdapter.ViewHolder viewHolder;
            if(convertView == null){
                viewHolder = new MyThreeAdapter.ViewHolder();
                convertView = inflater.inflate(R.layout.classificationlable_item2, null, false);
                viewHolder.tv = (TextView) convertView.findViewById(R.id.classificationlableTv);// 显示文字

                convertView.setTag(viewHolder);
            }else{
                viewHolder = (MyThreeAdapter.ViewHolder) convertView.getTag();
            }

            viewHolder.tv.setText(mlist.get(position).getTitleThree());
            viewHolder.tv.setTextSize(25);
            viewHolder.tv.setTextColor(Color.BLUE);


            return convertView;
        }
        class ViewHolder {
            public TextView tv;
        }
    }
}
