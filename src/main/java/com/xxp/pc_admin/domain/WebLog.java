package com.xxp.pc_admin.domain;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * controller访问日志
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebLog implements Serializable {
    private Integer id;

    /**
     * 操作描述
     */
    private String description;

    /**
     * 用户名
     */
    private String name;

    /**
     * 操作开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /**
     * 消耗时间
     */
    private Long spendTime;

    /**
     * uri
     */
    private String uri;

    /**
     * url
     */
    private String url;

    /**
     * ip
     */
    private String ip;

    /**
     * 返回状态码
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String message;

    private static final long serialVersionUID = 1L;
}
