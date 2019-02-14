/**
 * FileName:MainActivity.java
 * Explain:此类为主页面实现以下功能
 *         1、用帧动画实现人物的动作变化
 *         2、向左滑动，调出菜单栏
 * @author  luohui
 * @Date  2019.02.13
 * @version  1.00
 */
package com.example.asus.cti;

import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private DrawerLayout drawerLayout;
    private ArrayAdapter adapter;
    private ImageView imageView;
    /**定义动画类
     */
    private AnimationDrawable animationDrawable;
    /**菜单栏的选项*/
    private String[] item = {"主题","人物","皮肤","VIP","设置"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gain();
        right();
    }

    /**
     * 初始化控件
     */
    public void gain(){
        listView = (ListView) findViewById(R.id.lv_side);
        imageView = (ImageView) findViewById(R.id.mian_animation);
        drawerLayout = (DrawerLayout) findViewById(R.id.dra_lay);
        animationDrawable = (AnimationDrawable) imageView.getDrawable();
    }

    /**
     * 用数组适配器向右窗口添加菜单选项
     * 并设置窗口监听事件，监测选项数据
     */
    public void right(){
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,item);
        //设置适配器
        listView.setAdapter(adapter);
        //  设置窗口监听事件
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener(){
            //当适配器发生变化时调用
            @Override
            public void onDrawerSlide(@NonNull View view, float v) {

            }
            //当抽屉完全打开时调用
            @Override
            public void onDrawerOpened(@NonNull View view) {

            }
            //当抽屉关闭时调用
            @Override
            public void onDrawerClosed(@NonNull View view) {

            }
            //抽屉发改变时调用
            //状态值STATE_IDLE：闲置、STATE_DRAGGING：拖拽、STATE_SETTLING：固定
            @Override
            public void onDrawerStateChanged(int i) {

            }
        });
    }

    /**
     * 帧动画开始播放
     */
    @Override
    protected void onResume() {
        super.onResume();
        animationDrawable.start();
    }

    /**
     * 帧动画停止播放
     */
    @Override
    protected void onPause() {
        super.onPause();
        animationDrawable.stop();
    }

}
