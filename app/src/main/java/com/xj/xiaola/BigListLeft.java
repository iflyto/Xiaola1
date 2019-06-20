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

import com.xj.xiaola.news.bean.NewsChannel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BigListLeft extends Fragment {

    private int cId = 0;
    private int cur_pos = 0;
    private List<NewsChannel> listData;
    private MyTwoAdapter myTwoAdapter;
    private ListView listview;
    private BigListRight fragment2;
    public static BigListLeft inStance = null;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.left_layout, null);
        inStance = this;

        listview = (ListView) view.findViewById(R.id.classificationlableList);
        jsonAble();
        return view;
    }


    /**
     * 加载biglist的左侧数据
     * @param cid
     */
    public void setTextAble(int cid) {
        System.out.println("------左侧传来的id数字"+cid);
        cId = cid;
        cur_pos = 0;
        jsonAble();
    }

    private void jsonAble(){
        Random rand = new Random();
        int randNumber = rand.nextInt(20 - 9 + 1) + 9;//生成9到20间的随机数
        listData = new ArrayList<NewsChannel>();
        for (int i = 0; i < 13 ; i++) {

            NewsChannel chan=new NewsChannel();
            chan.setTitleTwo("次次次"+cId);
            chan.setCodeTwo(i);
            listData.add(chan);

        }

        myTwoAdapter = new MyTwoAdapter(getActivity(), listData);
        if (listview != null) {
            listview.setAdapter(myTwoAdapter);
            listview.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                    cur_pos = arg2;
                    changeData();
                }

            });
        }



    }
    public void changeData(){

        myTwoAdapter.notifyDataSetInvalidated();
        fragment2 = (BigListRight) getActivity().getFragmentManager().findFragmentById(R.id.PersonStoreRight);
        if(listData.size() != 0){
            int id = listData.get(cur_pos).getCodeTwo();
            String name = listData.get(cur_pos).getTitleTwo();
            fragment2.setTextAble(id);
        }else{
            fragment2.setTextAble(999);
        }
    }




    private class MyTwoAdapter extends BaseAdapter {
        private LayoutInflater inflater;
        private List<NewsChannel> mlist;

        @SuppressWarnings("unused")
        public MyTwoAdapter(Context context, List<NewsChannel> data) {
            inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            mlist = data;
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

            ViewHolder viewHolder;
            if(convertView == null){
                viewHolder = new ViewHolder();
                convertView = inflater.inflate(R.layout.classificationlable_item2, null, false);
                viewHolder.tv = (TextView) convertView.findViewById(R.id.classificationlableTv);// 显示文字
                viewHolder.tvview = (View) convertView.findViewById(R.id.classificationlableTvView2);
                convertView.setTag(viewHolder);
            }else{
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.tv.setText(mlist.get(position).getTitleTwo());
            viewHolder.tv.setSingleLine();
            viewHolder.tv.setEllipsize(TextUtils.TruncateAt.END);
            viewHolder.tvview.setVisibility(View.VISIBLE);
            if (position == cur_pos) {// 如果当前的行就是ListView中选中的一行，就更改显示样式
                convertView.setBackgroundColor(Color.parseColor("#ffffff"));// 更改整行的背景色
                viewHolder.tv.setTextColor(Color.parseColor("#000000"));// 更改字体颜色
            } else {
                convertView.setBackgroundColor(Color.parseColor("#f4f4f4"));// 更改整行的背景色
                viewHolder.tv.setTextColor(Color.parseColor("#545454"));// 更改字体颜色
            }
            return convertView;
        }
        class ViewHolder {
            public TextView tv;
            public View tvview;
        }
    }

}
