package com.xj.xiaola;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.awen.photo.FrescoImageLoader;
import com.awen.photo.photopick.bean.PhotoResultBean;
import com.awen.photo.photopick.controller.PhotoPagerConfig;
import com.awen.photo.photopick.controller.PhotoPickConfig;
import com.awen.photo.photopick.controller.PhotoPreviewConfig;
import com.xj.xiaola.choice.CompressPicUtils;
import com.xj.xiaola.choice.TestChoicePicActivity;
import com.xj.xiaola.eleme.EleMeHomeActivity;
import com.xj.xiaola.floatbutton.FloatButtonTotalActivity;
import com.xj.xiaola.news.NewsActivity;
import com.xj.xiaola.utils.ImageProviderUri;
import com.xj.xiaola.zero.GoodsBiaoqianActivity;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static com.xj.xiaola.choice.CompressPicUtils.getBitmapSize;
import static com.xj.xiaola.choice.CompressPicUtils.saveBitmapFile;

/**
 * 测试放大图片方法二   'com.github.Awent:PhotoPick-Master:v1.095'
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
        findViewById(R.id.button7).setOnClickListener(this);
        findViewById(R.id.button8).setOnClickListener(this);
        findViewById(R.id.button9).setOnClickListener(this);
        findViewById(R.id.button10).setOnClickListener(this);
        findViewById(R.id.button11).setOnClickListener(this);
        findViewById(R.id.button12).setOnClickListener(this);
        findViewById(R.id.button13).setOnClickListener(this);
        findViewById(R.id.button14).setOnClickListener(this);
        findViewById(R.id.button15).setOnClickListener(this);
        findViewById(R.id.button16).setOnClickListener(this);
        findViewById(R.id.button17).setOnClickListener(this);
        findViewById(R.id.button18).setOnClickListener(this);
        findViewById(R.id.button19).setOnClickListener(this);
        findViewById(R.id.button20).setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button://图库
                //方法1
                new PhotoPickConfig.Builder(this)
                        .pickMode(PhotoPickConfig.MODE_MULTIP_PICK)
                        .maxPickSize(15)
                        .showCamera(false)
//                        .showGif(false)
                        .build();

                //方法2
//                PhotoPickBean bean = new PhotoPickBean();
//                bean.setMaxPickSize(15);
//                bean.setShowCamera(false);
//                bean.setSpanCount(3);
//                bean.setPickMode(PhotoPickConfig.MODE_MULTIP_PICK);
//                new PhotoPickConfig.Builder(this)
//                        .setPhotoPickBean(bean)
//                        .build();
                break;
            case R.id.button4://图库(可以启动拍照)
                new PhotoPickConfig.Builder(this)
                        .pickMode(PhotoPickConfig.MODE_MULTIP_PICK)
                        .maxPickSize(15)
                        .showCamera(true)
                        .setOriginalPicture(true)//让用户可以选择原图
                        .setOnPhotoResultCallback(new PhotoPickConfig.Builder.OnPhotoResultCallback() {
                            @Override
                            public void onResult(PhotoResultBean result) {
                                Log.e("TestChoicePicActivity", "result = " + result.getPhotoLists().size());
                            }
                        })
                        .build();
                break;
            case R.id.button2://裁剪头像
                new PhotoPickConfig.Builder(this)
                        .clipPhoto(true)
                        .build();
                break;
            case R.id.button3://查看(网络)大图
                new PhotoPagerConfig.Builder(this)
                        .setBigImageUrls(ImageProviderUri.getImageUrls())
                        .setSavaImage(true)
//                        .setPosition(2)
//                        .setSaveImageLocalPath("这里是你想保存的图片地址")
                        .build();
                break;
            case R.id.button5://大图展示前先显示小图
                //方法1
                new PhotoPagerConfig.Builder(this)
                        .setBigImageUrls(ImageProviderUri.getBigImgUrls())
                        .setSmallImageUrls(ImageProviderUri.getSmallImgUrls())
                        .setSavaImage(true)
                        .build();

                //方法2,一张一张图片地添加
//                new PhotoPagerConfig.Builder(this)
//                        //添加大图
//                        .addSingleBigImageUrl("http://120.27.113.153/frogdrfs/2016/08/22/0ac279d511de46a0858a1812efe9a1ce.jpg")
//                        .addSingleBigImageUrl("http://120.27.113.153/frogdrfs/2016/08/29/62e2cd190a174e6c83ea3e948ecba66a.jpg")
//                        .addSingleSmallImageUrl("http://120.27.113.153/frogdrfs/2016/08/22/0ac279d511de46a0858a1812efe9a1ce.jpg&64X64.jpg")
//                        .addSingleSmallImageUrl("http://120.27.113.153/frogdrfs/2016/08/29/62e2cd190a174e6c83ea3e948ecba66a.jpg&64X64.jpg")
//                        .setSavaImage(true)
//                        .build();

                //方法3
                //先构建实体类,在实体类里设置好参数
//                PhotoPagerBean bean = new PhotoPagerBean();
//                bean.setBigImgUrls(ImageProvider.getBigImgUrls());
//                bean.setSmallImgUrls(ImageProvider.getSmallImgUrls());
//                bean.setSaveImage(true);
//                //再设置实体类
//                new PhotoPagerConfig.Builder(this)
//                        .setPhotoPagerBean(bean)
//                        .build();
                break;
            case R.id.button6://获取缓存大小:
                ((Button) findViewById(R.id.button6)).setText("缓存大小：" + FrescoImageLoader.getSDCacheSizeFormat());
                break;
            case R.id.button7://清除所有缓存
                FrescoImageLoader.clearCaches();
                ((Button) findViewById(R.id.button6)).setText("缓存大小：" + FrescoImageLoader.getSDCacheSizeFormat());
                break;
            case R.id.button8://跳到自定义view界面
                startActivity(new Intent(MainActivity.this,BigActivity.class));
//                /**
//                 * 1、传递数据：实现Parcelable接口，把你想传递的数据封装进Bundle，然后.setBundle(bundle)即可
//                 * 2、获取数据：Bundle bundle = getBundle();
//                 if(bundle != null) {
//                 list = bundle.getParcelableArrayList("test_bundle");
//                 if (list != null && !list.isEmpty()){
//                 //you can do something
//                 }
//                 }
//                 */
//                ArrayList<MyPhotoBean> list = new ArrayList<>();
//                for (int i = 0; i < ImageProvider.getImageUrls().size(); i++) {
//                    MyPhotoBean bean = new MyPhotoBean();
//                    bean.setId(i);
//                    bean.setContent("content = 你是否还记得？那年我们在春暖花开里相遇，我们都用真情，守护着相遇后的每一秒光阴。每一次与你目光碰触，你的眼睛清澈如水，深邃如诗，绽不尽的芳华，浪漫依依。" + "---" + i);
//                    list.add(bean);
//                }
//                Bundle bundle = new Bundle();
//                bundle.putParcelableArrayList("test_bundle", list);
//
//                new PhotoPagerConfig.Builder(this, MyPhotoPagerActivity.class)
//                        .setBigImageUrls(ImageProvider.getImageUrls())
//                        .setSavaImage(true)
//                        .setBundle(bundle) //传递自己的数据，如果数据中包含java bean，必须实现Parcelable接口
//                        .setOpenDownAnimate(false)
//                        .build();
                break;
            case R.id.button9:
                startActivity(new Intent(MainActivity.this,TestPictureSelectorActivity.class));
                break;
            case R.id.button10:
                startActivity(new Intent(MainActivity.this,NineGridViewActivity.class));
                break;
            case R.id.button11:
                startActivity(new Intent(MainActivity.this,TestChoicePicActivity.class));
                break;
            case R.id.button12:
                startActivity(new Intent(MainActivity.this,NewsActivity.class));
                break;
            case R.id.button13:
                startActivity(new Intent(MainActivity.this,FullDelDemoActivity.class));
                break;
            case R.id.button14:
                startActivity(new Intent(MainActivity.this,SimpleXmlExampleActivity.class));
                break;
            case R.id.button15:
                startActivity(new Intent(MainActivity.this,FloatButtonTotalActivity.class));
                break;
            case R.id.button16:
                startActivity(new Intent(MainActivity.this,VerifyDataActivity.class));
                break;
            case R.id.button17:
                startActivity(new Intent(MainActivity.this,EleMeHomeActivity.class));
                break;
            case R.id.button18:
                mFilePath = Environment.getExternalStorageDirectory().getPath()+File.separator + "temp.png";
                showCamera();
                break;
            case R.id.button19:
                startActivity(new Intent(MainActivity.this,GoodsBiaoqianActivity.class));
                break;
            case R.id.button20:
                startActivity(new Intent(MainActivity.this,BigListActivity.class));
                break;
        }
    }

    private String mFilePath;
    private File mTmpFile ;
    private static final int CAMERA_CODE = 1;
    private void showCamera() {
        // 跳转到系统照相机
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (cameraIntent.resolveActivity(getPackageManager()) != null) {
            mTmpFile=createFile(getApplicationContext());
            // 设置系统相机拍照后的输出路径
            cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(mTmpFile));
            startActivityForResult(cameraIntent, CAMERA_CODE);
        } else {
            Toast.makeText(getApplicationContext(), R.string.msg_no_camera, Toast.LENGTH_SHORT).show();
        }

    }
    public static File createFile(Context context){
        File file;
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            String timeStamp = String.valueOf(new Date().getTime());
            file = new File(Environment.getExternalStorageDirectory() +
                    File.separator + timeStamp+".jpg");
        }else{
            File cacheDir = context.getCacheDir();
            String timeStamp = String.valueOf(new Date().getTime());
            file = new File(cacheDir, timeStamp+".jpg");
        }
        return file;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != Activity.RESULT_OK || data == null) {
            return;
        }
        switch (requestCode) {
            case PhotoPickConfig.PICK_REQUEST_CODE://图片
                ArrayList<String> photoLists = data.getStringArrayListExtra(PhotoPickConfig.EXTRA_STRING_ARRAYLIST);
                //用户选择的是否是原图
                boolean isOriginalPicture = data.getBooleanExtra(PhotoPreviewConfig.EXTRA_ORIGINAL_PIC, false);
                if (photoLists != null && !photoLists.isEmpty()) {
                    Log.i("TestChoicePicActivity", "selected photos = " + photoLists.toString());
                    Toast.makeText(this, "selected photos size = " + photoLists.size() + "\n" + photoLists.toString(), Toast.LENGTH_LONG).show();
                    File file = new File(photoLists.get(0));

                    String o1= CompressPicUtils.getFileOrFilesSize(photoLists.get(0));
                    System.out.println("--前大小："+o1);

                    try {

                       System.out.println("--后大小1："+CompressPicUtils.compressImage(photoLists.get(0)));
                       System.out.println("--后大小2："+CompressPicUtils.getBitmapSize(CompressPicUtils.revitionImageSize(photoLists.get(0))));
                        //保存图片
                        CompressPicUtils.saveBitmapFile(CompressPicUtils.revitionImageSize(photoLists.get(0)));

                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                    if (file.exists()) {
                        //you can do something

                    } else {
                        //toast error

                    }
                }
                break;
            case CAMERA_CODE:

                if (mTmpFile != null) {
                    String qqq=mTmpFile.getAbsolutePath();
                    System.out.println("--大小和路径：" + qqq + "w" + CompressPicUtils.getFileOrFilesSize(qqq));
                    Toast.makeText(this, "--大小和路径：" + qqq + "w" + CompressPicUtils.getFileOrFilesSize(qqq), Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
