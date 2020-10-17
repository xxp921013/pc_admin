package com.xxp.pc_admin.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SecurityUser implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private String image;

    private Long gmtCreate;

    private Long gmtModified;

    private Integer newround;

    private static final long serialVersionUID = 1L;
}