package cn.cocoder.newsupportlib.demo.mvp.view;

/**
 * Created by xltu on 15/9/15.
 */
public interface IView {
    public void setTitleView(String text);
    public void setDetailView(String text);
    public void setCollectView(boolean isCollected);
    public void setLoadingState(boolean isLoading);
}
