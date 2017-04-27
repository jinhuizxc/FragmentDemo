package com.example.jh.fragmentdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * 作者：jinhui on 2017/4/27
 * 邮箱：1004260403@qq.com
 */

public class DataFragment extends Fragment implements View.OnClickListener {

    public static final String TAG = "com.example.jh.fragmentdemo.DataFragment";
    public Button button1;
    public Button button2;
    public Button button3;
    public Button button4;
    // 引用接口对象
    CallBack callback;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        button1 = (Button)view.findViewById(R.id.button_1);
        button2 = (Button)view.findViewById(R.id.button_2);
        button3 = (Button)view.findViewById(R.id.button_3);
        button4 = (Button)view.findViewById(R.id.button_4);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_1:
                notifyData("按钮一的内容");
                break;
            case R.id.button_2:
                notifyData("按钮二的内容");
                break;
            case R.id.button_3:
                notifyData("按钮三的内容");
                break;
            case R.id.button_4:
                notifyData("按钮四的内容");
                break;
        }
    }

    private void notifyData(String result) {
        callback.onResponse(result);
    }


    // 定义内部接口
    public interface CallBack{
        void onResponse(String result);
    }
    // 方法调用
    public void setCallBack(CallBack callback){
        this.callback = callback;
    }
}
