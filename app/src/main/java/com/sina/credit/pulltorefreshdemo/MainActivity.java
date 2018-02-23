package com.sina.credit.pulltorefreshdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

public class MainActivity extends AppCompatActivity {

    private PullToRefreshListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (PullToRefreshListView) findViewById(R.id.pull_refresh_list);
        listView.setMode(PullToRefreshBase.Mode.BOTH);
        ListView refreshableView = listView.getRefreshableView();
        listView.getLoadingLayoutProxy(false, true).setPullLabel(getString(R.string.pull_to_refresh_pull_label));
        listView.getLoadingLayoutProxy(false, true)
                .setRefreshingLabel(getString(R.string.pull_to_refresh_refreshing_label));
        listView.getLoadingLayoutProxy(false, true)
                .setReleaseLabel(getString(R.string.pull_to_refresh_from_bottom_release_label));
        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                //设置时间pulltorefresh的时间
//				String label = DateUtils.formatDateTime(mActivity, System.currentTimeMillis(),
//						DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);
//				refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);

                if (refreshView.isHeaderShown()) {
                    new Thread(new Runnable() {

                        @Override
                        public void run() {

                        }
                    }).start();
                } else if (refreshView.isFooterShown()) {

                }
                //500毫秒之后完成刷新
                listView.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        listView.onRefreshComplete();
                        // adapter.notifyDataSetChanged();
                    }
                }, 500);

                // Do work to refresh the list here.
                // new GetDataTask().execute();
                // listView.onRefreshComplete();
            }
        });
    }
}
