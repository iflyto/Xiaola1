package com.xj.xiaola.zero;

import java.util.ArrayList;
import java.util.List;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.xj.xiaola.R;

public class GoodsBiaoqianActivity extends AppCompatActivity implements OnClickListener,GoodsBqRightFragment.CallRIGHTBack {

	public static GoodsBiaoqianActivity instance;

	private OnChangeListener onchangedListener;
	private List<GoodsBiaoqianBean> books;
	private List<String> book_name = new ArrayList<String>();
	private ListView listView;
	private GoodsBqLeftAdapter adapter;

	private TextView hot_choiced;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_goods_hot_biaoqian);

		instance = this;
		initView();
		initChushi();
	}

	private void initChushi() {
		books = new ArrayList<GoodsBiaoqianBean>();
		initData();
		for (int i = 0; i < books.size(); i++) {
			book_name.add(books.get(i).getName());
		}

		listView = (ListView) findViewById(R.id.book_list);
		adapter = new GoodsBqLeftAdapter(book_name, GoodsBiaoqianActivity.this);
		listView.setAdapter(adapter);

		GoodsBqRightFragment fragment = new GoodsBqRightFragment();
		FragmentManager fragmentManager = getFragmentManager();
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		transaction.replace(R.id.book_detail_container, fragment);
		transaction.commit();
		
		//步骤3:设置监听器，实现接口里面的方法  
	    fragment.setCallBack(this); 
		
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				adapter.setSelectedPosition(position);
				adapter.notifyDataSetInvalidated();

				if (onchangedListener != null) {
					onchangedListener.changeText(books.get(position));
				}
			}
		});

	}

	private void initData() {
		GoodsBiaoqianBean book1 = new GoodsBiaoqianBean();
		book1.setId(1);
		book1.setName("疯狂");
		book1.setDesc("一本全面的，深入的Java学习图书，受到广大读者的热烈喜爱，已经被多家高校选为教材，成为国内一线的Java学习素材");
		books.add(book1);

		GoodsBiaoqianBean book2 = new GoodsBiaoqianBean();
		book2.setId(2);
		book2.setName("疯狂");
		book2.setDesc("Android学习者的首选教材，常年占据京东，当当，亚马逊3大网店Android销量排行榜首，是人人可必备的Android入门图书");
		books.add(book2);

		GoodsBiaoqianBean book3 = new GoodsBiaoqianBean();
		book3.setId(3);
		book3.setName("Ja");
		book3.setDesc("全面介绍Java EE开发的Struts2 ， Spring 3 ， Hibernate 4 架构，可以通过该书系统学习企业级开发，全面掌握Java学习");
		books.add(book3);

		GoodsBiaoqianBean book4 = new GoodsBiaoqianBean();
		book4.setId(4);
		book4.setName("HT");
		book4.setDesc("全面介绍HTML5，CSS ，JavaScript等知识点，通过该书可以系统的学习Web前端开发，通常Javascript脚本设置动态页面");
		books.add(book4);
	}

	public void setOnChangeListener(OnChangeListener onChangeListener) {
		this.onchangedListener = onChangeListener;
	}

	interface OnChangeListener {
		void changeText(GoodsBiaoqianBean book);
	}

	private void initView() {
		ImageButton order_back = (ImageButton) findViewById(R.id.order_back);
		hot_choiced = (TextView) findViewById(R.id.hot_choiced);
		TextView hot_over = (TextView) findViewById(R.id.hot_over);
		order_back.setOnClickListener(this);
		hot_over.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.hot_over:
			Toast.makeText(GoodsBiaoqianActivity.this, "完成选择", Toast.LENGTH_SHORT).show();
			break;
		case R.id.order_back:
			finish();
			break;
		default:
			break;
		}
	}

	@Override
	public void getResult(String result) {
		hot_choiced.setText(result);
		
	}

}
