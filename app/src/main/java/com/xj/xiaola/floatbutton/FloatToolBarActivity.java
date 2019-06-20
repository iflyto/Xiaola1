package com.xj.xiaola.floatbutton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;

import com.nightonke.boommenu.Animation.OrderEnum;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;
import com.xj.xiaola.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 全图弹出悬浮的动画
 */
public class FloatToolBarActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar);

        initBmb(R.id.bmb1);
        initBmb(R.id.bmb2);
        initBmb(R.id.bmb3);
        initBmb(R.id.bmb4);
        initBmb(R.id.bmb5);
        initBmb(R.id.bmb6);
        initBmb(R.id.bmb7);
        initBmb(R.id.bmb8);
        initBmb(R.id.bmb9);
    }

    private BoomMenuButton initBmb(int res) {
        BoomMenuButton bmb = (BoomMenuButton) findViewById(res);
        assert bmb != null;
        for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++)
            bmb.addBuilder(BuilderManager.getSimpleCircleButtonBuilder());
        return bmb;
    }

}
