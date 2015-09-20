package cn.cocoder.newsupportlib.demo.mvvm;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import cn.cocoder.newsupportlib.demo.R;
import cn.cocoder.newsupportlib.demo.databinding.ActivityMvvmBinding;
import cn.cocoder.newsupportlib.demo.mvvm.ArticleViewModule;

/**
 * Created by xltu on 15/9/15.
 */
public class MVVMActivity extends Activity  {

    private ActivityMvvmBinding mDataBinding;
    private ArticleViewModule mDataModule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
        mDataModule = new ArticleViewModule();
        mDataBinding.setArticle(mDataModule);
        mDataModule.requestArticleFromNet(null);
    }
}
