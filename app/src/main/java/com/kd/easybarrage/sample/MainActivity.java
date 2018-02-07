package com.kd.easybarrage.sample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
        barrageView.setBarrages(mBarrages);
        findViewById(R.id.send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                barrageView.addBarrage(new Barrage("111111111111", R.color.colorPrimary, Color.RED));
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        barrageView.destroy();
    }
}
