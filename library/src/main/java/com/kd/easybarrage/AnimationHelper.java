package com.kd.easybarrage;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

public class AnimationHelper {
    public static Animation createTranslateAnim(Context context, int fromX, int toX) {
        TranslateAnimation tlAnim = new TranslateAnimation(fromX, toX, 0, 0);
        long duration = (long) (Math.abs(toX - fromX) * 1.0f / Tools.getScreenWidth(context) * 4000);
        tlAnim.setDuration(duration);
        tlAnim.setInterpolator(new DecelerateAccelerateInterpolator());
        tlAnim.setFillAfter(true);
        return tlAnim;
    }

}