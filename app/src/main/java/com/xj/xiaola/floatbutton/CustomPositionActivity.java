package com.xj.xiaola.floatbutton;

import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.Util;
import com.xj.xiaola.R;

public class CustomPositionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_position);

        initializeBmb1();
        initializeBmb2();
        initializeBmb3();
        initializeBmb4();
        initializeBmb5();
        initializeBmb6();
        initializeBmb7();
    }

    private void initializeBmb1() {
        BoomMenuButton bmb = (BoomMenuButton) findViewById(R.id.bmb1);
        for (int i = 0; i < bmb.getButtonPlaceEnum().buttonNumber(); i++)
            bmb.addBuilder(BuilderManager.getHamButtonBuilder());

        float w_0_5 = bmb.getHamWidth() / 2;
        float h_0_5 = bmb.getHamHeight() / 2;

        float hm_0_5 = bmb.getPieceHorizontalMargin() / 2;
        float vm_0_5 = bmb.getPieceVerticalMargin() / 2;

        bmb.getCustomPiecePlacePositions().add(new PointF(-w_0_5 - hm_0_5, -h_0_5 - vm_0_5));
        bmb.getCustomPiecePlacePositions().add(new PointF(+w_0_5 + hm_0_5, -h_0_5 - vm_0_5));
        bmb.getCustomPiecePlacePositions().add(new PointF(-w_0_5 - hm_0_5, +h_0_5 + vm_0_5));
        bmb.getCustomPiecePlacePositions().add(new PointF(+w_0_5 + hm_0_5, +h_0_5 + vm_0_5));
    }

    private void initializeBmb2() {
        BoomMenuButton bmb = (BoomMenuButton) findViewById(R.id.bmb2);
        for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++)
            bmb.addBuilder(BuilderManager.getSimpleCircleButtonBuilder());

        bmb.getCustomButtonPlacePositions().add(new PointF(Util.dp2px(-80), Util.dp2px(-80)));
        bmb.getCustomButtonPlacePositions().add(new PointF(0, 0));
        bmb.getCustomButtonPlacePositions().add(new PointF(Util.dp2px(+80), Util.dp2px(+80)));
    }

    private void initializeBmb3() {
        BoomMenuButton bmb = (BoomMenuButton) findViewById(R.id.bmb3);
        for (int i = 0; i < 12; i++)
            bmb.addBuilder(BuilderManager.getTextOutsideCircleButtonBuilderWithDifferentPieceColor());

        float w = Util.dp2px(80);
        float h = Util.dp2px(96);
        float h_0_5 = h / 2;
        float h_1_5 = h * 1.5f;

        float hm = bmb.getButtonHorizontalMargin();
        float vm = bmb.getButtonVerticalMargin();
        float vm_0_5 = vm / 2;
        float vm_1_5 = vm * 1.5f;

        bmb.getCustomButtonPlacePositions().add(new PointF(-w - hm, -h_1_5 - vm_1_5));
        bmb.getCustomButtonPlacePositions().add(new PointF(      0, -h_1_5 - vm_1_5));
        bmb.getCustomButtonPlacePositions().add(new PointF(+w + hm, -h_1_5 - vm_1_5));
        bmb.getCustomButtonPlacePositions().add(new PointF(-w - hm, -h_0_5 - vm_0_5));
        bmb.getCustomButtonPlacePositions().add(new PointF(      0, -h_0_5 - vm_0_5));
        bmb.getCustomButtonPlacePositions().add(new PointF(+w + hm, -h_0_5 - vm_0_5));
        bmb.getCustomButtonPlacePositions().add(new PointF(-w - hm, +h_0_5 + vm_0_5));
        bmb.getCustomButtonPlacePositions().add(new PointF(      0, +h_0_5 + vm_0_5));
        bmb.getCustomButtonPlacePositions().add(new PointF(+w + hm, +h_0_5 + vm_0_5));
        bmb.getCustomButtonPlacePositions().add(new PointF(-w - hm, +h_1_5 + vm_1_5));
        bmb.getCustomButtonPlacePositions().add(new PointF(      0, +h_1_5 + vm_1_5));
        bmb.getCustomButtonPlacePositions().add(new PointF(+w + hm, +h_1_5 + vm_1_5));
    }

    private void initializeBmb4() {
        BoomMenuButton bmb = (BoomMenuButton) findViewById(R.id.bmb4);
        for (int i = 0; i < 4; i++)
            bmb.addBuilder(BuilderManager.getTextInsideCircleButtonBuilder());

        bmb.getCustomPiecePlacePositions().add(new PointF(Util.dp2px(+12), Util.dp2px(-12)));
        bmb.getCustomPiecePlacePositions().add(new PointF(Util.dp2px(+4), Util.dp2px(-4)));
        bmb.getCustomPiecePlacePositions().add(new PointF(Util.dp2px(-4), Util.dp2px(+4)));
        bmb.getCustomPiecePlacePositions().add(new PointF(Util.dp2px(-12), Util.dp2px(+12)));


        bmb.getCustomButtonPlacePositions().add(new PointF(Util.dp2px(-120), Util.dp2px(-120)));
        bmb.getCustomButtonPlacePositions().add(new PointF(Util.dp2px(-40), Util.dp2px(-40)));
        bmb.getCustomButtonPlacePositions().add(new PointF(Util.dp2px(+40), Util.dp2px(+40)));
        bmb.getCustomButtonPlacePositions().add(new PointF(Util.dp2px(+120), Util.dp2px(+120)));
    }




    private void initializeBmb5() {
        BoomMenuButton bmb = (BoomMenuButton) findViewById(R.id.bmb5);
        for (int i = 0; i < 3; i++)
            bmb.addBuilder(BuilderManager.getTextInsideCircleButtonBuilder());

        bmb.getCustomPiecePlacePositions().add(new PointF(Util.dp2px(+6), Util.dp2px(-6)));
        bmb.getCustomPiecePlacePositions().add(new PointF(0, 0));
        bmb.getCustomPiecePlacePositions().add(new PointF(Util.dp2px(-6), Util.dp2px(+6)));

        bmb.getCustomButtonPlacePositions().add(new PointF(Util.dp2px(-80), Util.dp2px(-80)));
        bmb.getCustomButtonPlacePositions().add(new PointF(0, 0));
        bmb.getCustomButtonPlacePositions().add(new PointF(Util.dp2px(+80), Util.dp2px(+80)));
    }

    private void initializeBmb6() {
        BoomMenuButton bmb = (BoomMenuButton) findViewById(R.id.bmb6);
        for (int i = 0; i < 6; i++)
            bmb.addBuilder(BuilderManager.getTextInsideCircleButtonBuilder());

        bmb.getCustomPiecePlacePositions().add(new PointF(Util.dp2px(+10), Util.dp2px(-10)));
        bmb.getCustomPiecePlacePositions().add(new PointF(Util.dp2px(+6), Util.dp2px(-6)));
        bmb.getCustomPiecePlacePositions().add(new PointF(Util.dp2px(+2), Util.dp2px(-2)));
        bmb.getCustomPiecePlacePositions().add(new PointF(Util.dp2px(-2), Util.dp2px(+2)));
        bmb.getCustomPiecePlacePositions().add(new PointF(Util.dp2px(-6), Util.dp2px(+6)));
        bmb.getCustomPiecePlacePositions().add(new PointF(Util.dp2px(-10), Util.dp2px(+10)));


        bmb.getCustomButtonPlacePositions().add(new PointF(Util.dp2px(-150), Util.dp2px(-150)));
        bmb.getCustomButtonPlacePositions().add(new PointF(Util.dp2px(-90), Util.dp2px(-90)));
        bmb.getCustomButtonPlacePositions().add(new PointF(Util.dp2px(-30), Util.dp2px(-30)));
        bmb.getCustomButtonPlacePositions().add(new PointF(Util.dp2px(+30), Util.dp2px(+30)));
        bmb.getCustomButtonPlacePositions().add(new PointF(Util.dp2px(+90), Util.dp2px(+90)));
        bmb.getCustomButtonPlacePositions().add(new PointF(Util.dp2px(+150), Util.dp2px(+150)));

    }
    private void initializeBmb7() {
        BoomMenuButton bmb = (BoomMenuButton) findViewById(R.id.bmb7);
        for (int i = 0; i < 5; i++)
            bmb.addBuilder(BuilderManager.getTextInsideCircleButtonBuilder());


        bmb.getCustomPiecePlacePositions().add(new PointF(Util.dp2px(+12), Util.dp2px(-12)));//按钮显示的图标
        bmb.getCustomPiecePlacePositions().add(new PointF(Util.dp2px(+6), Util.dp2px(-6)));
        bmb.getCustomPiecePlacePositions().add(new PointF(Util.dp2px(0), Util.dp2px(0)));
        bmb.getCustomPiecePlacePositions().add(new PointF(Util.dp2px(-6), Util.dp2px(+6)));
        bmb.getCustomPiecePlacePositions().add(new PointF(Util.dp2px(-12), Util.dp2px(+12)));


        bmb.getCustomButtonPlacePositions().add(new PointF(Util.dp2px(-120), Util.dp2px(-120)));//弹出来的间距
        bmb.getCustomButtonPlacePositions().add(new PointF(Util.dp2px(-60), Util.dp2px(-60)));
        bmb.getCustomButtonPlacePositions().add(new PointF(Util.dp2px(0), Util.dp2px(0)));
        bmb.getCustomButtonPlacePositions().add(new PointF(Util.dp2px(+60), Util.dp2px(+60)));
        bmb.getCustomButtonPlacePositions().add(new PointF(Util.dp2px(+120), Util.dp2px(+120)));

    }
}
