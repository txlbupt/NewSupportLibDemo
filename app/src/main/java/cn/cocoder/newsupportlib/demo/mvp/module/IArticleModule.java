package cn.cocoder.newsupportlib.demo.mvp.module;

import cn.cocoder.newsupportlib.demo.ViewModule.JSONArticle;

/**
 * Created by xltu on 15/9/15.
 */
public interface IArticleModule {
    public String getTitle();
    public String getDetail();
    public boolean getIsCollected();
    public void setArticle(JSONArticle article);
    public void requestArticleFromNet(OnArticleListener listener);
}
