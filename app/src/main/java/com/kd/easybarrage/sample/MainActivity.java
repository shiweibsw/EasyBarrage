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

        mBarrages.add(new Barrage("士大夫精神放松", true));
        mBarrages.add(new Barrage("dffdfdf", R.color.colorPrimary));
        mBarrages.add(new Barrage("231231231", R.color.colorPrimary));
        mBarrages.add(new Barrage("fdsf", R.color.colorPrimary));
        mBarrages.add(new Barrage("说的发生的发发发放松的方式地方", R.color.colorPrimary));
        mBarrages.add(new Barrage("三十岁四十岁时", R.color.colorPrimary, true));
        mBarrages.add(new Barrage("嘎嘎嘎嘎嘎嘎嘎嘎嘎", R.color.colorPrimary));
        mBarrages.add(new Barrage("434235354", R.color.colorPrimary));
        mBarrages.add(new Barrage("点324324", R.color.colorPrimary));
        mBarrages.add(new Barrage("更多更深的地方都是", R.color.colorPrimary));
        mBarrages.add(new Barrage("士大夫精神放松", R.color.colorPrimary, true));
        mBarrages.add(new Barrage("dffdfdf", R.color.colorPrimary));
        mBarrages.add(new Barrage("231231231", R.color.colorPrimary));
        mBarrages.add(new Barrage("fdsf", R.color.colorPrimary));
        mBarrages.add(new Barrage("说的发生的发发发放松的方式地方", R.color.colorPrimary));
        mBarrages.add(new Barrage("三十岁四十岁时", R.color.colorPrimary, true));
        mBarrages.add(new Barrage("嘎嘎嘎嘎嘎嘎嘎嘎嘎", R.color.colorPrimary));
        mBarrages.add(new Barrage("434235354", R.color.colorPrimary));
        mBarrages.add(new Barrage("点324324", R.color.colorPrimary));
        mBarrages.add(new Barrage("更多更深的地方都是", R.color.colorPrimary));
        mBarrages.add(new Barrage("士大夫精神放松", R.color.colorPrimary, true));
        mBarrages.add(new Barrage("dffdfdf", R.color.colorPrimary));
        mBarrages.add(new Barrage("231231231", R.color.colorPrimary));
        mBarrages.add(new Barrage("fdsf", R.color.colorPrimary));
        mBarrages.add(new Barrage("说的发生的发发发放松的方式地方", R.color.colorPrimary));
        mBarrages.add(new Barrage("三十岁四十岁时", R.color.colorPrimary, true));
        mBarrages.add(new Barrage("嘎嘎嘎嘎嘎嘎嘎嘎嘎", R.color.colorPrimary));
        mBarrages.add(new Barrage("434235354", R.color.colorPrimary));
        mBarrages.add(new Barrage("点324324", R.color.colorPrimary));
        mBarrages.add(new Barrage("更多更深的地方都是", R.color.colorPrimary));
        barrageView.setBarrages(mBarrages);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        barrageView.destroy();
    }
}
