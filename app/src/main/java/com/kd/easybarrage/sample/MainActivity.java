package com.kd.easybarrage.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kd.easybarrage.Barrage;
import com.kd.easybarrage.BarrageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private BarrageView barrageView;
    private List<Barrage> mBarrages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        barrageView = (BarrageView) findViewById(R.id.barrageView);

        mBarrages.add(new Barrage("弹幕数据01带边框", true));
        mBarrages.add(new Barrage("弹幕数据02"));
        mBarrages.add(new Barrage("弹幕数据03"));
        mBarrages.add(new Barrage("弹幕数据04"));
        mBarrages.add(new Barrage("弹幕数据05", R.color.colorPrimary));
        mBarrages.add(new Barrage("弹幕数据06", R.color.colorPrimary, true));
        mBarrages.add(new Barrage("弹幕数据07"));
        mBarrages.add(new Barrage("弹幕数据08"));
        mBarrages.add(new Barrage("弹幕数据09", R.color.colorPrimary));
        mBarrages.add(new Barrage("弹幕数据10"));
        mBarrages.add(new Barrage("超长弹幕测试数据超长弹幕测试数据超长弹幕测试数据", true));
        mBarrages.add(new Barrage("弹幕数据11"));
        mBarrages.add(new Barrage("弹幕数据12"));
        mBarrages.add(new Barrage("弹幕数据13"));
        mBarrages.add(new Barrage("弹幕数据14"));
        mBarrages.add(new Barrage("弹幕数据15", true));

        barrageView.setBarrages(mBarrages);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        barrageView.destroy();
    }
}
