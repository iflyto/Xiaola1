package com.xj.xiaola.news;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;

import com.google.gson.reflect.TypeToken;
import com.lzy.ninegrid.NineGridView;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.cache.CacheMode;
import com.lzy.widget.tab.PagerSlidingTabStrip;
import com.xj.xiaola.R;
import com.xj.xiaola.callback.NewsCallBack;
import com.xj.xiaola.news.bean.NewsChannel;
import com.xj.xiaola.news.bean.NewsImage;
import com.xj.xiaola.utils.Urls;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;
import okhttp3.Response;

public class NewsActivity extends AppCompatActivity {

    private PagerSlidingTabStrip tab;
    private ViewPager viewPager;
    private View emptyView;

    /** Glide 加载 */
    private class GlideImageLoader implements NineGridView.ImageLoader {
        @Override
        public void onDisplayImage(Context context, ImageView imageView, String url) {
            RequestOptions options = new RequestOptions()
                    .centerCrop()
                    .placeholder(R.drawable.empty_photo)
                    .error(R.drawable.empty_photo)
                    .diskCacheStrategy(DiskCacheStrategy.ALL);
            Glide.with(context)
                    .load(url)
                    .apply(options)
                    .into(imageView);
        }

        @Override
        public Bitmap getCacheImage(String url) {
            return null;
        }
    }

    /**
     * 写死七个导航来展示
     * @return
     */
    private List<NewsChannel> suckTabStrip(){
        List<NewsChannel> imagesAll=new ArrayList<>();
        for(int i=0 ; i<7 ; i++ ){
            NewsChannel deadData=new NewsChannel();
            deadData.setChannelId(i+"");
            deadData.setName("热门啦"+i);
            imagesAll.add(deadData);
        }
        return imagesAll;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        NineGridView.setImageLoader(new GlideImageLoader());

        tab = findViewById(R.id.tab);
        viewPager = findViewById(R.id.viewPager);

        emptyView = View.inflate(this, R.layout.activity_news_emptyview, null);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        addContentView(emptyView, params);
        emptyView.setVisibility(View.GONE);

        List<NewsChannel> channelItems=suckTabStrip();
        viewPager.setAdapter(new ChannelAdapter(getSupportFragmentManager(), channelItems));
        tab.setViewPager(viewPager);

//        OkHttpUtils.get(Urls.CHANNEL)//
//                .tag(this)//
//                .cacheKey("CHANNEL")//
//                .cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)//
//                .execute(new NewsCallBack() {
//                    @Override
//                    public void onResponse(boolean isFromCache, String s, Request request, @Nullable Response response) {
//                        try {
//                            emptyView.setVisibility(View.GONE);
//                            JSONArray object = new JSONObject(s).getJSONObject("showapi_res_body").getJSONArray("channelList");
//                            Type channelItemType = new TypeToken<List<NewsChannel>>() {}.getType();
//                            List<NewsChannel> channelItems = new Gson().fromJson(object.toString(), channelItemType);
//
//                            viewPager.setAdapter(new ChannelAdapter(getSupportFragmentManager(), channelItems));
//                            tab.setViewPager(viewPager);
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                });
    }

    private class ChannelAdapter extends FragmentPagerAdapter {
        private List<NewsChannel> channelItems;

        public ChannelAdapter(FragmentManager fm, List<NewsChannel> channelItems) {
            super(fm);
            this.channelItems = channelItems;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return channelItems.get(position).getName();
        }

        @Override
        public Fragment getItem(int position) {
            NewsFragment fragment = new NewsFragment();
            NewsChannel channel = channelItems.get(position);
            Bundle bundle = new Bundle();
            bundle.putString("channelId", channel.getChannelId());
            bundle.putInt("page", 1);
            fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public int getCount() {
            return channelItems.size();
        }
    }
}

