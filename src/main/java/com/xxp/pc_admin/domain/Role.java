package com.xxp.pc_admin.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {
    private Integer id;

    private String name;

    private static final long serialVersionUID = 1L;
}