package com.xj.xiaola.floatbutton;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.xj.xiaola.R;

/**
 * 测试悬浮
 */
public class FloatButtonTotalActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_float_button);

        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
        findViewById(R.id.button7).setOnClickListener(this);
        findViewById(R.id.button8).setOnClickListener(this);
        findViewById(R.id.button9).setOnClickListener(this);
        findViewById(R.id.button10).setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                startActivity(new Intent(FloatButtonTotalActivity.this,SimpleCircleButtonActivity.class));
                break;
            case R.id.button2:
                startActivity(new Intent(FloatButtonTotalActivity.this,TextInsideCircleButtonActivity.class));
                break;
            case R.id.button3:
                startActivity(new Intent(FloatButtonTotalActivity.this,TextOutsideCircleButtonActivity.class));
                break;
            case R.id.button4:
                startActivity(new Intent(FloatButtonTotalActivity.this,HamButtonActivity.class));
                break;
            case R.id.button5:
                startActivity(new Intent(FloatButtonTotalActivity.this,SquareAndPieceCornerRadiusActivity.class));
                break;
            case R.id.button6:
                startActivity(new Intent(FloatButtonTotalActivity.this,BoomExampleActivity.class));
                break;
            case R.id.button7:
                startActivity(new Intent(FloatButtonTotalActivity.this,ButtonPlaceAlignmentActivity.class));
                break;
            case R.id.button8:
                startActivity(new Intent(FloatButtonTotalActivity.this,FloatToolBarActivity.class));
                break;
            case R.id.button9:
                startActivity(new Intent(FloatButtonTotalActivity.this,ListenerActivity.class));
                break;
            case R.id.button10:
                startActivity(new Intent(FloatButtonTotalActivity.this,CustomPositionActivity.class));
                break;
        }
    }
}