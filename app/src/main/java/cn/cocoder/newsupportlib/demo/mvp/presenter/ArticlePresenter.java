package cn.cocoder.newsupportlib.demo.mvp.presenter;

import cn.cocoder.newsupportlib.demo.mvp.module.ArticleModule;
import cn.cocoder.newsupportlib.demo.mvp.module.IArticleModule;
import cn.cocoder.newsupportlib.demo.mvp.module.OnArticleListener;
import cn.cocoder.newsupportlib.demo.mvp.view.IView;

/**
 * Created by xltu on 15/9/16.
 */
public class ArticlePresenter implements OnArticleListener{

    private IArticleModule mArticleModule;

    private IView mView;

    public ArticlePresenter() {
        mArticleModule = new ArticleModule();
    }

    public void onTakeView(IView view) {
        mView = view;
    }


    public void requestFromInternet(){
        mView.setLoadingState(true);
        mArticleModule.requestArticleFromNet(this);
    }

    @Override
    public void onRequestSuccess() {
        mView.setLoadingState(false);
        mView.setTitleView(mArticleModule.getTitle());
        mView.setDetailView(mArticleModule.getDetail());
        mView.setCollectView(mArticleModule.getIsCollected());
    }

}
