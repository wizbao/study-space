package com.abot.common.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author weibao
 */
@Schema(title = "电脑")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Computer implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @Schema(name = "size",description = "规格")
    private BigDecimal size;

    @Schema(name = "operation",description = "操作系统")
    private String operation;

    @Schema(name = "year",description = "年份")
    private String year;
}
