package com.xj.xiaola;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.liji.takephoto.Constatnt;
import com.liji.takephoto.IMakePic;
import com.liji.takephoto.MakePicAdapter;
import com.liji.takephoto.OnImageUploadListener;
import com.liji.takephoto.PhotoInfo;
import com.liji.takephoto.TakePhoto;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试九宫格样式图片使用 'liji.library.dev:takephotolib:2.0.1'
 */
public class NineGridViewActivity  extends AppCompatActivity implements IMakePic {

    RecyclerView mRecyclerView;

    MakePicAdapter mMakePicAdapter;

    ArrayList<PhotoInfo> photoInfos = new ArrayList<>();

    StringBuffer sb = new StringBuffer();

    /**
     * 网络图片
     */
    final String[] urls = new String[] {
            "http://imgsrc.baidu.com/forum/w%3d580/sign=95035e68d70735fa91f04eb1ae510f9f/8af78a13632762d0c91858cca3ec08fa513dc6be.jpg",
            "http://h.hiphotos.baidu.com/zhidao/pic/item/0823dd54564e9258469ab81a9e82d158cdbf4e93.jpg",
            "http://img.25pp.com/uploadfile/bizhi/ipad3/2015/0120/20150120090811863_ipadm.jpg",
            "http://image.tianjimedia.com/uploadImages/2012/289/71X94T2PF22Z.jpg" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nine_gv);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_addphoto);

        //预加载网络图片
        for (int i = 0; i < urls.length; i++) {
            PhotoInfo photoInfo = new PhotoInfo();
            photoInfo.setImgUrl(urls[i]);
            photoInfos.add(photoInfo);
        }

        //图片列表
        GridLayoutManager mLayoutManager = new GridLayoutManager(this, 3);
        mRecyclerView.setLayoutManager(mLayoutManager);


        mMakePicAdapter = new MakePicAdapter(this, photoInfos, this, Constatnt.EDIT);
        mRecyclerView.setAdapter(mMakePicAdapter);

    }

    OnImageUploadListener mImageUploadListener;

    @Override
    public void setPicUploadListener(OnImageUploadListener onImageUploadListener) {
        this.mImageUploadListener = onImageUploadListener;
    }

    @Override
    public void takePic(final int position) {
        TakePhoto takePhoto = new TakePhoto(NineGridViewActivity.this);
        takePhoto.setOnPictureSelected(new TakePhoto.onPictureSelected() {
            @Override
            public void select(String path, String compresspath) {
                showInfo(position, path, compresspath);
            }
        });
        takePhoto.show();
    }

    /**
     *
     * @param position
     * @param path
     * @param compresspath
     */
    private void showInfo(int position, String path, String compresspath) {

        sb.append("原始的大小：" + new File(path).length() / 1024 + " k");
        sb.append("   ");
        sb.append("原始路径：" + path);

        sb.append("\n");

        sb.append("压缩后大小：" + new File(compresspath).length() / 1024 + " k");
        sb.append("   ");
        sb.append("压缩路径：" + compresspath + "\n");

        List<PhotoInfo> photoInfos = new ArrayList<>();
        PhotoInfo photoInfo = new PhotoInfo();
        photoInfo.setCompressPath(path);
        photoInfo.setOriginalPath(compresspath);
        photoInfos.add(photoInfo);

        if (null != mImageUploadListener) {
            NineGridViewActivity.this.mImageUploadListener.onImageUploadList(photoInfos);
        }

        Log.d("takephotolib", "" + sb.toString());

    }

    @Override
    public void delPic(String url) {

    }
}
