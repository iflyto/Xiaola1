package com.xj.xiaola.news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.cache.CacheMode;
import com.lzy.okhttputils.model.HttpParams;
import com.xj.xiaola.R;
import com.xj.xiaola.callback.NewsCallBack;
import com.xj.xiaola.news.bean.NewsChannel;
import com.xj.xiaola.news.bean.NewsContent;
import com.xj.xiaola.news.bean.NewsImage;
import com.xj.xiaola.utils.Urls;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import okhttp3.Request;
import okhttp3.Response;

/**
 * ================================================
 * 作    者：廖子尧
 * 版    本：1.0
 * 创建日期：2016/3/20
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class NewsFragment extends Fragment {

    PtrClassicFrameLayout ptr;
    RecyclerView recyclerView;

    private List<NewsContent> newsContentList;
    private NewsContentAdapter mAdapter;
    private String channelId;
    private int page;

    private int randomNum= (int) (Math.random()*960);//产生0-960的随机数
    /**
     * 随机产生图片
     * @return
     */
    private String  returnUrl(int ranN){
        ranN = randomNum+ranN;
        String theUrl = "http://zxpic.gtimg.com/infonew/0/wechat_pics_-2143"+ranN+"1.jpg/168";
        return theUrl;
    }



    /**
     * 写死十八张图片来展示
     * @return
     */
    private List<NewsImage> suckNewsImage(int num){
        List<NewsImage> imagesAll=new ArrayList<>();
        for(int i=0 ; i < 14 ; i++ ){
            NewsImage urlsData=new NewsImage();
//            urlsData.setWidth(10);
//            urlsData.setHeight(10);
            urlsData.setUrl(returnUrl(i+num));
            imagesAll.add(urlsData);
        }
        return imagesAll;
    }

    /**
     * 写死12条新闻来展示
     * @return
     */
    private List<NewsContent> suckNewContent(){
        List<NewsContent> newsContentListD=new ArrayList<>();
        for(int i = 0 ; i < 12 ; i++ ){
            NewsContent deadData=new NewsContent();
            deadData.setChannelId(i+"");
            deadData.setTitle("标题"+i);//消息标题
            deadData.setDesc("这是描述呢"+i);//消息描述
            deadData.setLink("http://v.juhe.cn/weixin/redirect?wid=wechat_20150401071583");//详情链接
            deadData.setPubDate("2018-7-9");//消息时间
            deadData.setSource("澎湃网");//消息来源
            deadData.setImageurls(suckNewsImage(i));
            newsContentListD.add(deadData);
        }
        return newsContentListD;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        ptr=view.findViewById(R.id.ptr);
        recyclerView=view.findViewById(R.id.recyclerView);

        Bundle bundle = getArguments();
        channelId = bundle.getString("channelId");
        page = bundle.getInt("page");

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new NewsContentAdapter(getActivity(), new ArrayList<NewsContent>());
        recyclerView.setAdapter(mAdapter);

//        initData(false);
        initDead(false);

        ptr.setLastUpdateTimeRelateObject(this);
        ptr.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
//                initData(true);
                initDead(true);
            }
        });

        return view;
    }
    private void initDead(final boolean isMore){
        if(isMore){
            newsContentList.addAll(0,suckNewContent());
        }else {
            newsContentList = suckNewContent();
        }

        mAdapter.setData(newsContentList);
        page++;
        ptr.refreshComplete();
    }


//    private void initData(final boolean isMore) {
//        HttpParams params = new HttpParams();
//        params.put("channelId", channelId);
//        params.put("page", String.valueOf(page));
//        OkHttpUtils.get(Urls.NEWS)//
//                .tag(this)//
//                .params(params)//
//                .cacheKey("NEWS")//
//                .cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)//
//                .execute(new NewsCallBack() {
//                    @Override
//                    public void onResponse(boolean isFromCache, String s, Request request, @Nullable Response response) {
//                        try {
//                            JSONArray object = new JSONObject(s).getJSONObject("showapi_res_body").getJSONObject("pagebean").getJSONArray("contentlist");
//                            Type newsContentType = new TypeToken<List<NewsContent>>() {}.getType();
//                            if (isMore) {
//                                List<NewsContent> more = new Gson().fromJson(object.toString(), newsContentType);
//                                newsContentList.addAll(0, more);
//                            } else {
//                                newsContentList = new Gson().fromJson(object.toString(), newsContentType);
//                            }
//
//                            mAdapter.setData(newsContentList);
//                            page++;
//                            ptr.refreshComplete();
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                });
//    }
}
