package com.kd.easybarrage;

import android.view.animation.Interpolator;

public class DecelerateAccelerateInterpolator implements Interpolator {
    @Override
    public float getInterpolation(float input) {  
        return (float) (Math.tan((input * 2 - 1) / 4 * Math.PI)) / 2.0f + 0.5f;
    }  
}  