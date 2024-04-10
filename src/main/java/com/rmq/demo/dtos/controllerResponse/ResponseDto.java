package com.rmq.demo.dtos.controllerResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {
private MetaDto meta;
private Object data;
private String errors;
private PaginationDto pagination;
}
