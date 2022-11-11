package com.zyd.blog.business.enums;

/**
 * @author
 * @version 1.0
 * @website 
 * @date 2018/4/16 16:26
 * @since 1.0
 */
public enum FileUploadType {
    COMMON("oneblog/"),
    QRCODE("oneblog/qrcode/"),
    SIMPLE("oneblog/article/"),
    COVER_IMAGE("oneblog/cover/");

    private String path;

    FileUploadType(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
