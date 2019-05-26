package com.scujcc.tv;

import java.io.Serializable;

public class Channel implements Serializable {
    private String head;
    private String quality;
    private String url;

    public String getTitle() {
        return head;
    }

    public void setTitle(String title) {
        this.head = title;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
