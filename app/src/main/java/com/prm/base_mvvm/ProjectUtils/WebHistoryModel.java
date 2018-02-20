package com.prm.base_mvvm.ProjectUtils;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * created by PARAMBIR SINGH on 22/9/17.
 */

public class WebHistoryModel implements Serializable
{
    private String title;
    private String url;
    private String icon;
    private ArrayList<WebInnerStackModel> innerstack;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public ArrayList<WebInnerStackModel> getInnerstack() {
        return innerstack;
    }

    public void setInnerstack(ArrayList<WebInnerStackModel> innerstack) {
        this.innerstack = innerstack;
    }
}
