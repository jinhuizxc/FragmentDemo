package com.example.jh.fragmentdemo;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * 测试Fragment与activity
 */
public class MainActivity extends AppCompatActivity {

    private DataFragment dataFragment;
    public TextView textView;
    public FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.text);
        dataFragment = new DataFragment();
        fragmentManager = this.getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.fragment_container, dataFragment,DataFragment.TAG)
                .commit();
        // 因为在实现一个接口的情况下必定会承载其方法！
        dataFragment.setCallBack(new DataFragment.CallBack() {
            @Override
            public void onResponse(String result) {
                textView.setText(result);
            }
        });
    }

}
