package com.xj.xiaola.news.bean;

import java.io.Serializable;

/**
 * ================================================
 * 作    者：廖子尧
 * 版    本：1.0
 * 创建日期：2016/3/20
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class NewsChannel implements Serializable {
    private String channelId;
    private String name;

    private String titleOne;
    private int codeOne;
    private String titleTwo;
    private int codeTwo;
    private String titleThree;
    private int codeThree;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitleOne() {
        return titleOne == null ? "" : titleOne;
    }

    public void setTitleOne(String titleOne) {
        this.titleOne = titleOne;
    }

    public int getCodeOne() {
        return codeOne;
    }

    public void setCodeOne(int codeOne) {
        this.codeOne = codeOne;
    }

    public String getTitleTwo() {
        return titleTwo == null ? "" : titleTwo;
    }

    public void setTitleTwo(String titleTwo) {
        this.titleTwo = titleTwo;
    }

    public String getTitleThree() {
        return titleThree == null ? "" : titleThree;
    }

    public void setTitleThree(String titleThree) {
        this.titleThree = titleThree;
    }

    public int getCodeThree() {
        return codeThree;
    }

    public void setCodeThree(int codeThree) {
        this.codeThree = codeThree;
    }

    public int getCodeTwo() {
        return codeTwo;
    }

    public void setCodeTwo(int codeTwo) {
        this.codeTwo = codeTwo;
    }

    @Override
    public String toString() {
        return "NewsChannel{" +
                "channelId='" + channelId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
