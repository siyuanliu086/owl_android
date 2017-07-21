package com.owl_android.view.listview;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.owl_android.annotations.AnnotationUtil;
import com.owl_android.annotations.ListEnum;
import com.owl_android.annotations.OwlDataBean;
import com.owl_android.annotations.OwlListBean;
import com.owl_android.utils.OwlUtils;
import com.owl_android.utils.R;
import com.owl_android.view.IOwlLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package com.owl_android.view.detail
 * @Description show a detail View, default extends form LinearLayout
 * @Date 2017/7/20
 * @Author siyuan
 * @Refactor
 * @Company ISoftStone ZHHB
 * @Project OWL_Android
 */

public class OwlListView implements IOwlLayout {
    private ListView listLayout;
    private OwlListView owlListView = this;
    private Context mContext = null;

    public OwlListView(Context context) {
        mContext = context;
        listLayout = new ListView(context);
        listLayout.setBackgroundColor(Color.WHITE);
    }

    public OwlListView setAnnotationBean(List<? extends Object> beanList) {
        List<OwlDataBean> dataBeanList = new ArrayList<>();
        for(Object bean : beanList) {
            OwlDataBean owlDataBean = AnnotationUtil.getParseAnnotationInfo(bean);
            dataBeanList.add(owlDataBean);
        }

//        List<OwlListBean> listBeenList = owlDataBean.getListBeanList();
        MyListAdapter adapter = new MyListAdapter(mContext, dataBeanList);
        listLayout.setAdapter(adapter);
        return owlListView;
    }

    /**
     * Define setAnnotationBean
     *
     * @return ViewGroup
     */
    @Override
    public ListView getTargetView() {
        return listLayout;
    }

    /**
     * 解析完成回调
     *
     * @param bean
     */
    @Override
    public ViewGroup onParsingCompleted(Object bean) {
        return listLayout;
    }

    private class MyListAdapter extends BaseAdapter {
        private Context mContext;
        private LayoutInflater mInflater;
        private List<OwlDataBean> dataBeanList;

        public MyListAdapter(Context mContext, List<OwlDataBean> dataBeanList) {
            this.mContext = mContext;
            this.mInflater = LayoutInflater.from(mContext);
            this.dataBeanList = dataBeanList;
        }

        @Override
        public int getCount() {
            return dataBeanList.size();
        }

        @Override
        public OwlDataBean getItem(int i) {
            return dataBeanList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        public List<OwlListBean> getItemListBean(int i) {
            return dataBeanList.get(i).getListBeanList();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            ViewHolder viewHolder ;
            if (convertView==null) {
                viewHolder = new ViewHolder();
                convertView= mInflater.inflate(R.layout.owl_layout_listitem_type1, null);
                viewHolder.iconImageview=(ImageView) convertView.findViewById(R.id.owl_listitem_icon);
                viewHolder.titleTextView=(TextView) convertView.findViewById(R.id.owl_listitem_title);
                viewHolder.contentTextView=(TextView) convertView.findViewById(R.id.owl_listitem_content);
                viewHolder.timeTextView=(TextView) convertView.findViewById(R.id.owl_listitem_time);
                convertView.setTag(viewHolder);
            }else{
                viewHolder=(ViewHolder) convertView.getTag();
            }

            List<OwlListBean> owlListBeanList = getItemListBean(position);
            for(OwlListBean listBean : owlListBeanList) {
                if(listBean.listEnum == ListEnum.image) {
                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) viewHolder.iconImageview.getLayoutParams();
                    params.width = OwlUtils.dip2px(mContext, listBean.imageSize);
                    params.height = OwlUtils.dip2px(mContext, listBean.imageSize);
                    viewHolder.iconImageview.setBackgroundResource(R.mipmap.owl_android);
//                    Glide.with(mContext)
//                            .load(listBean.value)
//                            .bitmapTransform(new BlurTransformation(mContext, 25), new CropCircleTransformation(mContext))
//                            .into(viewHolder.iconImageview);
                } else if(listBean.listEnum == ListEnum.title) {
                    viewHolder.titleTextView.setText(listBean.value);
                    viewHolder.titleTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, listBean.titleSize);
                } else if(listBean.listEnum == ListEnum.content) {
                    viewHolder.contentTextView.setText(listBean.value);
                    viewHolder.contentTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, listBean.contentSize);
                } else if(listBean.listEnum == ListEnum.subtitle) {
                    viewHolder.subTextView.setText(listBean.value);
                } else if(listBean.listEnum == ListEnum.timeText) {
                    viewHolder.timeTextView.setText(listBean.value);
                    viewHolder.timeTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, listBean.timeSize);
                }
            }

            return convertView;
        }
    }

    class ViewHolder {
        TextView titleTextView, subTextView, contentTextView, timeTextView;
        ImageView iconImageview;
    }

    private void setEnumValue(ViewHolder viewHolder, OwlListBean listBean) {
        if(listBean.listEnum == ListEnum.image) {
//            viewHolder.iconImageview.setText(listBean.value);
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) viewHolder.iconImageview.getLayoutParams();
            params.width = OwlUtils.dip2px(mContext, listBean.imageSize);
            params.height = OwlUtils.dip2px(mContext, listBean.imageSize);
            Glide.with(mContext).load(listBean.value).into(viewHolder.iconImageview);
        } else if(listBean.listEnum == ListEnum.title) {
            viewHolder.titleTextView.setText(listBean.value);
            viewHolder.titleTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, listBean.titleSize);
        } else if(listBean.listEnum == ListEnum.content) {
            viewHolder.contentTextView.setText(listBean.value);
            viewHolder.contentTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, listBean.contentSize);
        } else if(listBean.listEnum == ListEnum.subtitle) {
            viewHolder.subTextView.setText(listBean.value);
        } else if(listBean.listEnum == ListEnum.timeText) {
            viewHolder.timeTextView.setText(listBean.value);
            viewHolder.timeTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, listBean.timeSize);
        }
    }
}
