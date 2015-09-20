package cn.cocoder.newsupportlib.demo.mvvm;

import android.databinding.BaseObservable;
import android.os.AsyncTask;
import android.view.View;

import cn.cocoder.newsupportlib.demo.JSONBean.JSONArticle;
import cn.cocoder.newsupportlib.demo.mvp.module.IArticleModule;
import cn.cocoder.newsupportlib.demo.mvp.module.OnArticleListener;

/**
 * Created by xltu on 15/9/16.
 */
public class ArticleViewModule extends BaseObservable {

    public String title;
    public String detail;
    public boolean isCollected;
    public Boolean isLoading;
    private OnArticleListener mListener;

    public String getTitle() {
        return title;
    }

    public String getDetail() {
        return detail;
    }

    public boolean getIsCollected() {
        return isCollected;
    }

    public void requestArticleFromNet(OnArticleListener listener) {
        mListener = listener;
        isLoading = true;
        notifyChange();
        NetworkTask task = new NetworkTask();
        task.execute();
    }

    public View.OnClickListener requestCollect(){
        return new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                isCollected = !isCollected;
                notifyChange();
            }
        };
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
            isLoading = false;
            if(mListener != null){
                mListener.onRequestSuccess();
            }
            notifyChange();
        }
    }

}
