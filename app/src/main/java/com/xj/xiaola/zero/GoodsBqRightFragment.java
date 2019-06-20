package com.xj.xiaola.zero;

import java.util.ArrayList;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.xj.xiaola.R;

public class GoodsBqRightFragment extends Fragment {
	private TextView title;
	private LabelsView labelsView;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_goods_fragment_right_hot, null);
		title = (TextView) view.findViewById(R.id.book_title);
		labelsView = (LabelsView) view.findViewById(R.id.labels);

		GoodsBiaoqianActivity.instance.setOnChangeListener(new GoodsBiaoqianActivity.OnChangeListener() {
			@Override
			public void changeText(GoodsBiaoqianBean book) {
				title.setText(book.getName());
			}
		});
		initData();

		return view;
	}

	private void initData() {

		// 测试的数据
		ArrayList<String> label = new ArrayList<String>();
		label.add("鸡蛋");
		label.add("面粉");
		label.add("胡萝卜");
		label.add("牛奶");
		label.add("土豆");
		label.add("黄油");
		label.add("豆腐");
		label.add("猪肉");
		label.add("青椒");
		label.add("羊肉");
		label.add("牛肉");
		label.add("丝瓜");
		label.add("西红柿");
		label.add("五花肉");
		label.add("法式牛排");
		label.add("藕");
		label.add("酸菜");
		label.add("黑鱼");
		label.add("香飘飘奶茶");
		label.add("东瓜");
		labelsView.setLabels(label);

		labelsView.setSelectType(LabelsView.SelectType.SINGLE);
		labelsView.setOnLabelClickListener(new LabelsView.OnLabelClickListener() {
			@Override
			public void onLabelClick(View label, String labelText, int position) {
				Toast.makeText(getActivity(), position + " : " + labelText, Toast.LENGTH_LONG).show();
				//调用这个接口方法  
		        callback.getResult(labelText);  
			}
		});

	}
	private CallRIGHTBack callback;
	public interface CallRIGHTBack {
		/* 定义一个获取信息的方法 */
		public void getResult(String result);
	}

	// 步骤2:设置监听器
	public void setCallBack(CallRIGHTBack callBack) {
		this.callback = callBack;
	}
}