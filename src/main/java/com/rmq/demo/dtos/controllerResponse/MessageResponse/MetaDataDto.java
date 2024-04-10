package com.rmq.demo.dtos.controllerResponse.MessageResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MetaDataDto {
    public int statusCode ;
    public String statusDescription ;
    public String message ;
}
