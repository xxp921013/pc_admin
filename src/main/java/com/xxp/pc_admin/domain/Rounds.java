package com.xxp.pc_admin.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rounds implements Serializable {
    private Integer rid;

    private Integer articleId;

    private String roundText;

    private String roundCreator;

    private String name;

    private String image;

    private Long gmtCreate;

    private Long gmtModified;

    private Integer thumbsUp;

    private static final long serialVersionUID = 1L;
}