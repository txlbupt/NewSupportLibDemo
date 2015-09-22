package cn.cocoder.newsupportlib.demo.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import cn.cocoder.newsupportlib.demo.R;

/**
 * Created by xltu on 15/9/22.
 */
public class CollapseActivity extends Activity {

    private RecyclerView mRecyclerView;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapse);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setAdapter(new YourRecyclerAdapter(this));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        mCollapsingToolbarLayout.setTitle("This is Collapse Title");
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(R.color.selector_normal);
        mCollapsingToolbarLayout.setExpandedTitleColor(R.color.selector_normal);
    }
}
