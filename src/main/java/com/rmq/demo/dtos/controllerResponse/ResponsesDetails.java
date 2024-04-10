package com.rmq.demo.dtos.controllerResponse;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ResponsesDetails {
    public ResponseDto ResponseBuilder(Object data, PaginationDto paginationDto, MetaDto metaDto, String errors){
    return ResponseDto.builder()
            .meta(metaDto)
            .pagination(paginationDto)
            .data(data)
            .errors(errors)
            .build();
    }
    public MetaDto MetaBuilder(int code, String type, String message){
    return MetaDto.builder()
            .statusCode(code)
            .message(message)
            .statusDescription(type)
            .build();
    }
    public PaginationDto PaginationBuilder(int count, int total){
    return PaginationDto.builder()
            .count(count)
            .total(total)
            .build();
    }
    public ResponseDto GetErrorResponseDetails(Object errorMessage, int code){
    var meta =MetaBuilder(code, "FAILED", errorMessage.toString());
    var pagination =PaginationBuilder(0,0);
    return ResponseBuilder(null, pagination, meta, errorMessage.toString());
    }
}
