package cn.cocoder.newsupportlib.demo.mvp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import cn.cocoder.newsupportlib.demo.R;
import cn.cocoder.newsupportlib.demo.mvp.presenter.ArticlePresenter;
import cn.cocoder.newsupportlib.demo.mvp.view.IView;

/**
 * Created by xltu on 15/9/15.
 */
public class MVPActivity extends Activity implements IView {

    private TextView mTitle, mDetail;
    private ImageView mCollect;
    private ProgressBar mProgress;
    private ArticlePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        mTitle = (TextView) findViewById(R.id.tv_title);
        mDetail = (TextView) findViewById(R.id.tv_detail);
        mCollect = (ImageView) findViewById(R.id.iv_collect);
        mProgress = (ProgressBar) findViewById(R.id.pb_progress);
        if(mPresenter != null) {
            mPresenter = new ArticlePresenter();
            mPresenter.requestFromInternet();
        }
        mPresenter.onTakeView(this);
    }

    @Override
    public void setTitleView(String text) {
        mTitle.setText(text);
    }

    @Override
    public void setDetailView(String text) {
        mDetail.setText(text);
    }

    @Override
    public void setCollectView(boolean isCollected) {
        if(isCollected) {
            mCollect.setImageResource(R.drawable.collection_checkbox_true);
        } else {
            mCollect.setImageResource(R.drawable.collection_checkbox_false);
        }
    }

    @Override
    public void setLoadingState(boolean isLoading) {
        if(isLoading)
            mProgress.setVisibility(View.VISIBLE);
        else
            mProgress.setVisibility(View.GONE);
    }
}
