package com.xxp.pc_admin.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article implements Serializable {
    private Integer id;

    private String tittle;

    private String description;

    private Long gmtCreate;

    private Long gmtModified;

    private String creator;

    private Integer commentCount;

    private Integer viewCount;

    private Integer likeCount;

    private String tags;

    private static final long serialVersionUID = 1L;
}