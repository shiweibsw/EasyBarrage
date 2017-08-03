#### 概述
EasyBarrage是Android平台的一种轻量级弹幕效果目前支持以下设置：

1. 自定义字体颜色，支持随机颜色设置；
2. 自定义字体大小，支持随机字体大小设置；
3. 支持边框显示，用于区分自己的弹幕和其他弹幕；
4. 自定义边框颜色；
5. 弹幕数据是否允许重复；
6. 自定义单屏显示的最大弹幕数量；
7. 弹幕数据不重叠；
8. 支持动态添加弹幕；
9. 不依赖VideoView，数据自动循环显示。

**github**：[https://github.com/shiweibsw/EasyBarrage](https://github.com/shiweibsw/EasyBarrage)

#### 显示效果

##### 横屏
![](https://user-gold-cdn.xitu.io/2017/8/3/771a0770d7f4b1713e78336e33b045d0)
##### 竖屏
![](https://user-gold-cdn.xitu.io/2017/8/3/3604808b39b42b146aadbdad54d7f1e9)

#### 使用
1 build.gradle

    compile 'com.kd.easybarrage:library:0.0.1'
2 xml

     <com.kd.easybarrage.BarrageView
        android:id="@+id/barrageView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_above="@+id/send"
        app:allow_repeat="true"
        app:border_color="@color/colorAccent"
        app:line_height="20dp"
        app:max_text_size="20"
        app:min_text_size="14"
        app:random_color="true"
        app:size="200"/>

属性说明

| 属性                              | 说明         | 
| -------------                      |:------------:|
| max_text_size           |最大字体|
| min_text_size          | 最小字体|
| size           | 单屏最大弹幕数量|
| line_height             | 行高 |
| border_color        | 边框弹幕的边框颜色|
| random_color           | 是否启用随机颜色 |
| allow_repeat      | 弹幕内容是否可重复|

3 Java代码

**添加弹幕数据**

    for (int i = 0; i < 200; i++) {
            mBarrages.add(new Barrage("弹幕数据" + i));
        }   
注意Barrage对象有多种构造，可以设置字体颜色及是否显示边框，例如

3.1指定字体颜色

    Barrage b=new Barrage("弹幕数据",R.color.colorAccent);

需要设置   app:random_color="false" 才有效

3.2显示边框

    Barrage b=new Barrage("弹幕数据",true);
3.3指定颜色及显示边框

    Barrage b=new Barrage("弹幕数据",R.color.colorAccent,true);
3.3只显示内容

    Barrage b=new Barrage("弹幕数据");
    
**添加一条弹幕**

    barrageView.addBarrage(new Barrage("我是新弹幕", true));
    
结束时调用destroy方法
    
    barrageView.destroy();
    
