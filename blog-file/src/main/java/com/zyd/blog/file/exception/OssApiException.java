package com.zyd.blog.file.exception;

/**
 * @author
 * @version 1.0
 * @website
 * @date 2017/7/12 10:29
 * @since 1.8
 */
public class OssApiException extends GlobalFileException {

    public OssApiException(String message) {
        super(message);
    }

    public OssApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
