package com.celaandroid_zidai.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.celaandroid_zidai.R;
import com.celaandroid_zidai.base.HomePageBean;

import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * 类描述：
 * 创建人：xuyaxi
 * 创建时间：2017/7/19 15:00
 */
public class HomePageMyAdapter extends BaseAdapter {

    private List<HomePageBean.DataBean> list;
    private Context mContext;
    ImageOptions optopns;

    public HomePageMyAdapter(List<HomePageBean.DataBean> list, Context context) {
        this.list = list;
        mContext = context;
        optopns = new ImageOptions.Builder()
                .setSize(200, 200)
                .setLoadingDrawableId(R.mipmap.ic_launcher)
                .setFailureDrawableId(R.mipmap.ic_launcher)
                .build();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = View.inflate(mContext, R.layout.homepage_adapter, null);
            holder = new ViewHolder();

            x.view().inject(holder, view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        HomePageBean.DataBean bean = list.get(i);
        holder.txt_title.setText(bean.getNews_title());
        x.image().bind(holder.image, bean.getPic_url(), optopns);
        return view;
    }

    class ViewHolder {
        @ViewInject(R.id.txt_title)
        TextView txt_title;

        @ViewInject(R.id.image_pic)
        ImageView image;
    }
}
