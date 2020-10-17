package com.xxp.pc_admin.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xxp.pc_admin.domain.Rounds;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @description: 回复DTO
 * @author: xxp
 * @create: 2020-10-15 16:03
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RoundDTO extends Rounds {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private String articleTittle;
}
