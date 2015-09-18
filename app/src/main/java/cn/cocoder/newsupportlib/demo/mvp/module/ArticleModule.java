package cn.cocoder.newsupportlib.demo.mvp.module;

import android.os.AsyncTask;

import cn.cocoder.newsupportlib.demo.ViewModule.JSONArticle;

/**
 * Created by xltu on 15/9/16.
 */
public class ArticleModule implements IArticleModule {

    private JSONArticle mArticle;
    private OnArticleListener mListener;

    @Override
    public String getTitle() {
        return mArticle == null ? null : mArticle.title;
    }

    @Override
    public String getDetail() {
        return mArticle == null ? null : mArticle.detail;
    }

    @Override
    public boolean getIsCollected() {
        return mArticle == null ? false : mArticle.isCollected;
    }

    public void setArticle(JSONArticle article) {
        this.mArticle = article;
    }

    @Override
    public void requestArticleFromNet(OnArticleListener listener) {
        mListener = listener;
        NetworkTask task = new NetworkTask();
        task.execute();
    }

    private class NetworkTask extends AsyncTask<String, Void, JSONArticle> {

        @Override
        protected JSONArticle doInBackground(String... params) {
            try {
                Thread.sleep(5000);
            }catch (InterruptedException e){}
            JSONArticle article = new JSONArticle();
            article.detail = "This article is a step-by-step introduction to MVP on Android, from a simplest possible example to best practices. The article also introduces a new library that makes MVP on Android extremely simple.";
            article.title = "Introduction to Model-View-Presenter on Android";
            article.isCollected = false;
            return article;
        }

        @Override
        protected void onPostExecute(JSONArticle jsonArticle) {
            super.onPostExecute(jsonArticle);
            setArticle(jsonArticle);
            if(mListener != null){
                mListener.onRequestSuccess();
            }
        }
    }

}
