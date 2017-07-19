package com.celaandroid_zidai.activityfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 类描述：未登录界面
 * 创建人：xuyaxi
 * 创建时间：2017/7/12 11:25
 */
public class NotLoggedIn extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView t = new TextView(getActivity());
        t.setText("4");
        return t;
    }
}
