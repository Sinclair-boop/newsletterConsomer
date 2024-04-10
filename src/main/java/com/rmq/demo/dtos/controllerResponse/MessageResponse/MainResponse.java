package com.rmq.demo.dtos.controllerResponse.MessageResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class MainResponse {

    public static ResponseEntity<ResponseDto> responseOk(Object data){
        return new ResponseEntity<>(new ResponseDto(data), HttpStatus.OK);
    }

    public static ResponseEntity<ResponseDto> response(Object data){
        if (data!=null)
            return responseOk(data);
        return responseNotFound("Entity not found");
    }

    public static ResponseEntity<ResponseDto> responseNotFound(String description){
        return responseNotFound(description, description);
    }

    public static ResponseEntity<ResponseDto> responseNotFound(String description, String message){
        var meta = MetaDataDto.builder()
                .statusCode(404)
                .statusDescription(description)
                .message(message)
                .build();
        return new ResponseEntity<>(new ResponseDto(meta), HttpStatus.OK);
    }

    public static ResponseEntity<ResponseDto> responseError(Object errors){
        var data = ResponseDto.builder()
                .data(null)
                .errors(errors)
                .meta(MetaDataDto.builder()
                        .statusCode(500)
                        .statusDescription("INTERNAL_SERVER_ERROR")
                        .message(errors.toString())
                        .build())
                .build();
        return new ResponseEntity<>(new ResponseDto(data), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
