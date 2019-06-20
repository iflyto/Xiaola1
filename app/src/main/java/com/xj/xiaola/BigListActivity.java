package com.xj.xiaola;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xj.xiaola.news.bean.NewsChannel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BigListActivity extends AppCompatActivity implements View.OnClickListener{

    private List<NewsChannel> listData;
    private LinearLayout classificationHSV;
    private int cur_pos = 0;
    private BigListLeft fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_list);

        classificationHSV = findViewById(R.id.classificationHSV);

        getData();




    }

    private void getData(){
        Random rand = new Random();
        int randNumber = rand.nextInt(12 - 3 + 1) + 3;//生成3到12间的随机数
        listData = new ArrayList<NewsChannel>();

        for (int i = 0; i < 13; i++) {

            NewsChannel chan=new NewsChannel();
            chan.setTitleOne("名称"+i);
            chan.setCodeOne(i);
            listData.add(chan);
            TextView textView=new TextView(this);
            if (i == 0) {
                textView.setTextColor(Color.RED);
            } else {
                textView.setTextColor(Color.GRAY);
            }
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(20, 20, 20, 20);

            textView.setText(listData.get(i).getTitleOne());
            textView.setTextSize(15);

            textView.setOnClickListener(this);
            classificationHSV.addView(textView,params);

        }

    }

    @Override
    public void onClick(View view) {
        // 判断当前点击了哪一个
        for (int i = 0; i < classificationHSV.getChildCount(); i++) {
            TextView tv = (TextView) classificationHSV.getChildAt(i);
            if (view == tv) {
                // 让对应的这个textView变红
                tv.setTextColor(Color.RED);
                Toast.makeText(BigListActivity.this,tv.getText().toString(),Toast.LENGTH_SHORT).show();

                fragment = (BigListLeft) getFragmentManager().findFragmentById(R.id.PersonStoreLeft);
                cur_pos = i;
                int id = listData.get(cur_pos).getCodeOne();
                String name = listData.get(cur_pos).getTitleOne();
                if (fragment != null) {
                    fragment.setTextAble(id);
                    BigListLeft.inStance.changeData();
                }
            } else {
                tv.setTextColor(Color.GRAY);
            }

        }
    }
}
