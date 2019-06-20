package com.xj.xiaola;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import xyz.zpayh.hdimage.HDImageView;
import xyz.zpayh.hdimage.ImageSource;
import xyz.zpayh.hdimage.ImageSourceBuilder;

/**
 * 测试放大图片'xyz.zpayh:hdimageview:2.0.0'
 */
public class BigActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big);
        HDImageView mImageView = (HDImageView) findViewById(R.id.image);

        mImageView.setImageURI("http://ww1.sinaimg.cn/bmiddle/6f0a8a65gy1fqq0vq1sbrj213y8zu4qw.jpg");
        // Or
//        ImageSource imageSource = ImageSourceBuilder.newBuilder()
//                .setUri(R.mipmap.ic_launcher)
//                .build();
//        mImageView.setImageSource(imageSource);
    }
}
