package com.kd.easybarrage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static com.kd.easybarrage.BarrageTools.getScreenWidth;

/**
 * Created by shiwei on 2017/8/2.
 */

public class BarrageView extends RelativeLayout {
    private Set<Integer> existMarginValues = new HashSet<>();
    private int linesCount;

    private int validHeightSpace;
    private int INTERVAL = 500;

    private Random random = new Random(System.currentTimeMillis());
    private int maxBarrageSize;
    private int textLeftPadding;
    private int textRightPadding;
    private int textTopPadding;
    private int textBottomPadding;
    private int maxTextSize;
    private int minTextSize;
    private int lineHeight;
    private int borderColor;
    private boolean random_color;
    private boolean allow_repeat;
    private final int DEFAULT_PADDING = 15;
    private final int DEFAULT_BARRAGESIZE = 10;
    private final int DEFAULT_MAXTEXTSIZE = 20;
    private final int DEFAULT_MINTEXTSIZE = 14;
    private final int DEFAULT_LINEHEIGHT = 24;
    private final int DEFAULT_BORDERCOLOR = 0xff000000;
    private final boolean DEFAULT_RANDOMCOLOR = false;
    private final boolean DEFAULT_ALLOWREPEAT = false;

    private List<Barrage> barrages = new ArrayList<>();
    private List<Barrage> cache = new ArrayList<>();

    public BarrageView(Context context) {
        this(context, null);
    }

    public BarrageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BarrageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.BarrageView, 0, 0);
        try {
            textLeftPadding = typedArray.getInt(R.styleable.BarrageView_text_left_padding, DEFAULT_PADDING);
            textRightPadding = typedArray.getInt(R.styleable.BarrageView_text_right_padding, DEFAULT_PADDING);
            textTopPadding = typedArray.getInt(R.styleable.BarrageView_text_top_padding, DEFAULT_PADDING);
            textBottomPadding = typedArray.getInt(R.styleable.BarrageView_text_bottom_padding, DEFAULT_PADDING);
            maxBarrageSize = typedArray.getInt(R.styleable.BarrageView_size, DEFAULT_BARRAGESIZE);
            maxTextSize = typedArray.getInt(R.styleable.BarrageView_max_text_size, DEFAULT_MAXTEXTSIZE);
            minTextSize = typedArray.getInt(R.styleable.BarrageView_min_text_size, DEFAULT_MINTEXTSIZE);
            lineHeight = typedArray.getDimensionPixelSize(R.styleable.BarrageView_line_height, BarrageTools.dp2px(context, DEFAULT_LINEHEIGHT));
            borderColor = typedArray.getColor(R.styleable.BarrageView_border_color, DEFAULT_BORDERCOLOR);
            random_color = typedArray.getBoolean(R.styleable.BarrageView_random_color, DEFAULT_RANDOMCOLOR);
            allow_repeat = typedArray.getBoolean(R.styleable.BarrageView_allow_repeat, DEFAULT_ALLOWREPEAT);
            if (BarrageTools.px2sp(context, lineHeight) < maxTextSize)
                maxTextSize = BarrageTools.px2sp(context, lineHeight);
        } finally {
            typedArray.recycle();
        }
    }

    public void setBarrages(List<Barrage> list) {
        if (!list.isEmpty()) {
            barrages.clear();
            barrages.addAll(list);
            mHandler.sendEmptyMessageDelayed(0, INTERVAL);
        }
    }

    public void addBarrage(Barrage tb) {
        barrages.add(tb);
        if (allow_repeat) {
            cache.add(tb);
        }
        showBarrage(tb);
        if (!mHandler.hasMessages(0)) {
            mHandler.sendEmptyMessageDelayed(0, INTERVAL);
        }
    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            checkBarrage();
            sendEmptyMessageDelayed(0, INTERVAL);
        }
    };

    public void checkBarrage() {
        int index = (int) (Math.random() * barrages.size());
        Barrage barrage = barrages.get(index);
        if (allow_repeat) {
            if (cache.contains(barrage))
                return;
            cache.add(barrage);
        }
        showBarrage(barrage);
    }

    private void showBarrage(final Barrage tb) {
        if (linesCount != 0 && getChildCount() >= linesCount)
            return;
        if (getChildCount() >= maxBarrageSize)
            return;
        final TextView textView = tb.isShowBorder() ? new BorderTextView(getContext(), borderColor) : new TextView(getContext());
        Drawable drawable = textView.getContext().getResources().getDrawable(R.drawable.shape_bg_round);
        textView.setBackgroundDrawable(tintDrawable(drawable, tb.getBackGroundColor()));
        textView.setPadding(textLeftPadding, textTopPadding, textRightPadding, textBottomPadding);

        textView.setTextSize((int) (minTextSize + (maxTextSize - minTextSize) * Math.random()));
        textView.setText(tb.getContent());
        textView.setTextColor(random_color ? Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)) : getResources().getColor(tb.getColor()));

        int leftMargin = getRight() - getLeft() - getPaddingLeft();
        int verticalMargin = getRandomTopMargin();
        textView.setTag(verticalMargin);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams
                .WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        params.topMargin = verticalMargin;
        textView.setLayoutParams(params);
        Animation anim = AnimationHelper.createTranslateAnim(getContext(), leftMargin, -getScreenWidth(getContext()));
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.i("111111", "onAnimationEnd: ");
                if (allow_repeat)
                    cache.remove(tb);
                removeView(textView);
                int verticalMargin = (int) textView.getTag();
                existMarginValues.remove(verticalMargin);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        textView.startAnimation(anim);
        addView(textView);
    }

    private int getRandomTopMargin() {
        if (validHeightSpace == 0) {
            validHeightSpace = getBottom() - getTop() - getPaddingTop() - getPaddingBottom();
        }
        if (linesCount == 0) {
            linesCount = validHeightSpace / lineHeight;
            if (linesCount == 0) {
                throw new RuntimeException("Not enough space to show text.");
            }
        }
        while (true) {
            int randomIndex = (int) (Math.random() * linesCount);
            int marginValue = randomIndex * (validHeightSpace / linesCount);
            if (!existMarginValues.contains(marginValue)) {
                existMarginValues.add(marginValue);
                return marginValue;
            }
        }
    }

    public void destroy() {
        if (mHandler.hasMessages(0))
            mHandler.removeMessages(0);
        barrages.clear();
        cache.clear();
    }

    private Drawable tintDrawable(Drawable drawable, int color) {
        ColorStateList colors = ColorStateList.valueOf(color);
        Drawable wrappedDrawable = DrawableCompat.wrap(drawable);
        DrawableCompat.setTintList(wrappedDrawable, colors);
        return wrappedDrawable;
    }

}
