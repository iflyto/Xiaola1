package com.xj.xiaola.zero;

import java.util.List;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.xj.xiaola.R;

public class GoodsBqLeftAdapter extends BaseAdapter {
	private List<String> mData;
	private LayoutInflater layoutInflater;
	private int selectionPosition = -1;

	public GoodsBqLeftAdapter(List<String> data, Context context) {
		this.mData = data;
		this.layoutInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return mData.size();
	}

	@Override
	public Object getItem(int position) {
		return mData.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup viewGroup) {
		ViewHolder viewHolder = null;
		if (convertView == null) {
			viewHolder = new ViewHolder();
			convertView = layoutInflater.inflate(R.layout.activity_goods_item_xungoal, null);
			viewHolder.tv = (TextView) convertView.findViewById(R.id.left_hot);
			viewHolder.boxname = (CheckBox) convertView.findViewById(R.id.item_checkbox);
			
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.boxname.setVisibility(View.GONE);
		viewHolder.tv.setVisibility(View.VISIBLE);
		viewHolder.tv.setText(mData.get(position));
		if (selectionPosition == position) {
			viewHolder.tv.setBackgroundColor(Color.YELLOW);
		} else {
			viewHolder.tv.setBackgroundColor(Color.WHITE);
		}
		return convertView;
	}

	public void setSelectedPosition(int position) {
		this.selectionPosition = position;
	}

	class ViewHolder {
		TextView tv;
		CheckBox boxname;
	}
}
