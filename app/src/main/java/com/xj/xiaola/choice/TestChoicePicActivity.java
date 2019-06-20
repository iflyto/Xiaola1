package com.xj.xiaola.choice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jaiky.imagespickers.ImageConfig;
import com.jaiky.imagespickers.ImageSelector;
import com.jaiky.imagespickers.ImageSelectorActivity;
import com.xj.xiaola.R;

import java.util.ArrayList;
import java.util.List;

public class TestChoicePicActivity extends AppCompatActivity {

    private Button btn1, btn2;
    private TextView tv1;
    private ArrayList<String> path = new ArrayList<>();

    public static final int REQUEST_CODE = 123;

    private ImageConfig imageConfig;

    private LinearLayout llContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_pic);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        tv1 = (TextView) findViewById(R.id.tv1);
        llContainer = (LinearLayout) findViewById(R.id.llContainer);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageConfig = new ImageConfig.Builder(
                        new GlideLoader())
                        .steepToolBarColor(getResources().getColor(R.color.titleBlue))
                        .titleBgColor(getResources().getColor(R.color.titleBlue))
                        .titleSubmitTextColor(getResources().getColor(R.color.white))
                        .titleTextColor(getResources().getColor(R.color.white))
                        // 开启单选   （默认为多选）
                        .singleSelect()
                        // 裁剪 (只有单选可裁剪)
                        //.crop()
                        // 开启拍照功能 （默认关闭）
                        .showCamera()
                        //设置显示容器
                        .setContainer(llContainer)
                        .requestCode(REQUEST_CODE)
                        .build();
                ImageSelector.open(TestChoicePicActivity.this, imageConfig);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageConfig = new ImageConfig.Builder(
                        new GlideLoader())
                        .steepToolBarColor(getResources().getColor(R.color.titleBlue))
                        .titleBgColor(getResources().getColor(R.color.titleBlue))
                        .titleSubmitTextColor(getResources().getColor(R.color.white))
                        .titleTextColor(getResources().getColor(R.color.white))
                        // 开启多选   （默认为多选）
                        .mutiSelect()
                        // 多选时的最大数量   （默认 9 张）
                        .mutiSelectMaxSize(9)
                        //设置图片显示容器，参数：、（容器，每行显示数量，是否可删除）
                        .setContainer(llContainer, 4, true)
                        // 已选择的图片路径
                        .pathList(path)
                        // 拍照后存放的图片路径（默认 /temp/picture）
                        .filePath("/temp")
                        // 开启拍照功能 （默认关闭）
                        .showCamera()
                        .requestCode(REQUEST_CODE)
                        .build();
                ImageSelector.open(TestChoicePicActivity.this, imageConfig);
            }
        });
    }

//08-14 10:03:59.943 7806-7806/com.gavinandre.product.a I/System.out: --前大小：999.56KB
//08-14 10:04:00.398 7806-7806/com.gavinandre.product.a I/System.out: --后大小：1997568
//08-14 10:08:22.287 7806-7806/com.gavinandre.product.a I/System.out: --前大小：837.58KB
//08-14 10:08:22.545 7806-7806/com.gavinandre.product.a I/System.out: --后大小：1123632
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            List<String> pathList = data.getStringArrayListExtra(ImageSelectorActivity.EXTRA_RESULT);


            tv1.setText("");
            for (String path : pathList) {
                tv1.append(path);
                tv1.append("\n");
            }

            path.clear();
            path.addAll(pathList);
        }
    }
}
