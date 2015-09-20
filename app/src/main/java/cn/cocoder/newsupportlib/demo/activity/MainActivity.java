package cn.cocoder.newsupportlib.demo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import cn.cocoder.newsupportlib.demo.R;
import cn.cocoder.newsupportlib.demo.mvp.activity.MVPActivity;
import cn.cocoder.newsupportlib.demo.mvvm.MVVMActivity;

/**
 * Created by xltu on 15/9/15.
 */
public class MainActivity extends Activity implements View.OnClickListener {

    private TextView mMvp, mMvvm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMvp = (TextView) findViewById(R.id.tv_mvp);
        mMvvm = (TextView) findViewById(R.id.tv_mvvm);
        mMvp.setOnClickListener(this);
        mMvvm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.tv_mvp:
                Intent intent = new Intent(this, MVPActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_mvvm:
                Intent intent1 = new Intent(this, MVVMActivity.class);
                startActivity(intent1);
        }
    }
}
