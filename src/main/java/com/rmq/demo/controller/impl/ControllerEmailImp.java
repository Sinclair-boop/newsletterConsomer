package com.rmq.demo.controller.impl;

import com.rmq.demo.controller.ControllerEmail;
import com.rmq.demo.dtos.EmailDto;
import com.rmq.demo.dtos.controllerResponse.MetaDto;
import com.rmq.demo.dtos.controllerResponse.PaginationDto;
import com.rmq.demo.dtos.controllerResponse.ResponseDto;
import com.rmq.demo.dtos.controllerResponse.ResponsesDetails;
import com.rmq.demo.service.ServiceEmail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@Slf4j
@RestController
public class ControllerEmailImp implements ControllerEmail {
    private final ResponsesDetails responsesDetails;
    private final ServiceEmail serviceEmail;
    @Override
    public ResponseEntity<ResponseDto> makeEmailController(@RequestBody EmailDto dto){
        try {
            serviceEmail.createEmailService(dto);
            return new ResponseEntity<>(ResponseDto.builder()
                    .data(null)
                    .errors(null)
                    .meta(MetaDto.builder().message("Creation d'une category")
                            .statusCode(HttpStatus.OK.value()).statusDescription("Réussi").build())
                    .pagination(PaginationDto.builder().count(0).total(0).build())
                    .build(), HttpStatus.OK);
        } catch (Exception e) {
            // Construit une réponse d'erreur en cas d'exception.
            return new ResponseEntity<>(responsesDetails.GetErrorResponseDetails(e.getMessage(),
                    HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<ResponseDto> makeEmailsController(List<EmailDto> dtos) {

        log.info("===>request saving menu {}...", dtos);
        try{
            var emailsSave = serviceEmail.createEmailsService(dtos);
            if (emailsSave != null){
                return new ResponseEntity<>(ResponseDto.builder()
                        .data(emailsSave)
                        .errors(null)
                        .meta(MetaDto.builder().message("La liste des categories")
                                .statusCode(HttpStatus.OK.value()).statusDescription("Réussi").build())
                        .pagination(PaginationDto.builder().count(5).total(5).build())
                        .build(), HttpStatus.OK);
            }
            return new ResponseEntity<>(ResponseDto.builder()
                    .data(emailsSave)
                    .errors(null)
                    .meta(MetaDto.builder().message("messages menu failed saving")
                            .statusCode(404).statusDescription("echec de la sauvegarde").build())
                    .pagination(PaginationDto.builder().count(0).total(0).build())
                    .build(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(responsesDetails.GetErrorResponseDetails(e.getMessage(),
                    HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<ResponseDto> getAllEmailsController() {
        try {
            var getAllCategory = serviceEmail.getAllEmailsService();
            return new ResponseEntity<>(ResponseDto.builder()
                    .data(getAllCategory)
                    .errors(null)
                    .meta(MetaDto.builder().message("La liste des categories")
                            .statusCode(HttpStatus.OK.value()).statusDescription("Réussi").build())
                    .pagination(PaginationDto.builder().count(0).total(0).build())
                    .build(), HttpStatus.OK);
        } catch (Exception e) {
            // Construit une réponse d'erreur en cas d'exception.
            return new ResponseEntity<>(responsesDetails.GetErrorResponseDetails(e.getMessage(),
                    HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<ResponseDto> getEmailController(String name) {
        try {
            var getCategory = serviceEmail.findEmailService(name);
            return new ResponseEntity<>(ResponseDto.builder()
                    .data(getCategory)
                    .errors(null)
                    .meta(MetaDto.builder().message("selection de la category avec l'id: "+ name)
                            .statusCode(HttpStatus.OK.value()).statusDescription("Réussi").build())
                    .pagination(PaginationDto.builder().count(0).total(0).build())
                    .build(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(responsesDetails.GetErrorResponseDetails(e.getMessage(),
                    HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<ResponseDto> updateEmailController(EmailDto dto) {
        try {
           var responseUpdateCategory = serviceEmail.updateEmailService(dto);
            return new ResponseEntity<>(ResponseDto.builder()
                    .data(responseUpdateCategory)
                    .errors(null)
                    .meta(MetaDto.builder().message("mise a jour d'un email: "+ dto.getEmail())
                            .statusCode(HttpStatus.OK.value()).statusDescription("Réussi").build())
                    .pagination(PaginationDto.builder().count(0).total(0).build())
                    .build(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(responsesDetails.GetErrorResponseDetails(e.getMessage(),
                    HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<ResponseDto> deleteEmailController(String name) {
        try {
            serviceEmail.deleteEmailService(name);
            return new ResponseEntity<>(ResponseDto.builder()
                    .data(null)
                    .errors(null)
                    .meta(MetaDto.builder().message("supression de la category avec id: "+ name)
                            .statusCode(HttpStatus.OK.value()).statusDescription("Réussi").build())
                    .pagination(PaginationDto.builder().count(0).total(0).build())
                    .build(), HttpStatus.OK);
        } catch (Exception e) {
            // Construit une réponse d'erreur en cas d'exception.
            return new ResponseEntity<>(responsesDetails.GetErrorResponseDetails(e.getMessage(),
                    HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
        }
    }

}
