package com.server.web.entity.vo;

import lombok.Data;

import java.util.Date;

/**
 * 用来返回给客户端
 */
@Data
public class FastDfsVO {

    private String url;

    private String domain;

    private String fileUrl;

    public FastDfsVO(String url, String domain) {
        this.url = url;
        this.domain = domain;
        this.fileUrl = domain + url;
    }
}
