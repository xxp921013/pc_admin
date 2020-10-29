package com.xxp.pc_admin.domain;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 每日数据记录
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailyLog implements Serializable {

    private Integer id;

    /**
     * 每日登陆用户数
     */
    private Long loginuser;

    /**
     * 每日回复数
     */
    private Long round;

    /**
     * 每日文章数
     */
    private Long article;

    /**
     * 新注册用户
     */
    private Long newuser;

    /**
     * 文章阅读
     */
    private Long articleRead;

    /**
     * 记录日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    private static final long serialVersionUID = 1L;

}
