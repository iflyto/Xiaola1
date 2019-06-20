package com.xj.xiaola.choice;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jaiky.imagespickers.ImageLoader;
import com.xj.xiaola.R;

public class GlideLoader implements ImageLoader {

	private static final long serialVersionUID = 1L;

	@Override
    public void displayImage(Context context, String path, ImageView imageView) {
        Glide.with(context)
                .load(path)
                .into(imageView);
    }

}
