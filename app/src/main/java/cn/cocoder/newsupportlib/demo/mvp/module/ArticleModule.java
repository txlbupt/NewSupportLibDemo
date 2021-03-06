package cn.cocoder.newsupportlib.demo.mvp.module;

import android.databinding.BaseObservable;
import android.os.AsyncTask;

import cn.cocoder.newsupportlib.demo.JSONBean.JSONArticle;

/**
 * Created by xltu on 15/9/16.
 */
public class ArticleModule implements IArticleModule{

    public String title;
    public String detail;
    public boolean isCollected;
    private OnArticleListener mListener;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDetail() {
        return detail;
    }

    @Override
    public boolean getIsCollected() {
        return isCollected;
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
                Thread.sleep(2000);
            }catch (InterruptedException e){}
            JSONArticle article = new JSONArticle();
            article.detail = "This article is a step-by-step introduction to MVP on Android, from a simplest possible example to best practices. The article also introduces a new library that makes MVP on Android extremely simple.";
            article.title = "Introduction to Model-View-Presenter on Android";
            article.isCollected = true;
            return article;
        }

        @Override
        protected void onPostExecute(JSONArticle jsonArticle) {
            super.onPostExecute(jsonArticle);
            detail = jsonArticle.detail;
            title = jsonArticle.title;
            isCollected = jsonArticle.isCollected;
            if(mListener != null){
                mListener.onRequestSuccess();
            }
        }
    }

}
