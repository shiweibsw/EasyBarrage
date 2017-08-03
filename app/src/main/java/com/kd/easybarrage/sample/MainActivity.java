package com.kd.easybarrage.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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
        for (int i = 0; i < 200; i++) {
            mBarrages.add(new Barrage("弹幕数据" + i));
        }
        barrageView.setBarrages(mBarrages);
        findViewById(R.id.send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                barrageView.addBarrage(new Barrage("我是新弹幕", true));
            }
        });

        Barrage b=new Barrage("弹幕数据");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        barrageView.destroy();
    }
}
