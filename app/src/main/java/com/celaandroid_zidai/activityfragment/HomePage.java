package com.celaandroid_zidai.activityfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.celaandroid_zidai.R;
import com.celaandroid_zidai.adapter.HomePageMyAdapter;
import com.celaandroid_zidai.base.HomePageBean;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;


/**
 * 类描述：首页界面
 * 创建人：xuyaxi
 * 创建时间：2017/7/12 11:23
 */


public class HomePage extends Fragment {

    private Gson gson;
    private List<HomePageBean.DataBean> list = new ArrayList<>();
    private String urlPath = "http://api.expoon.com/AppNews/getNewsList/type/1/p/1";
    private HomePageMyAdapter adapter;
    private ListView lv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.homepage_activity, null);
        x.view().inject(getActivity());
        lv = (ListView) view.findViewById(R.id.lv);
       // list = new ArrayList<>();
        adapter = new HomePageMyAdapter(list,getContext());
        lv.setAdapter(adapter);
        loadData();
        return view;
    }

    private void loadData() {
        RequestParams params = new RequestParams(urlPath);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                HomePageBean bean = new Gson().fromJson(result, HomePageBean.class);
                list.addAll(bean.getData());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Toast.makeText(getActivity(), ex.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
}
