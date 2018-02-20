package com.prm.base_mvvm.ProjectUtils;

import java.io.Serializable;

/**
 * created by PARAMBIR SINGH on 29/9/17.
 */

public class WebInnerStackModel implements Serializable
{
    private String title;
    private String url;

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
}
