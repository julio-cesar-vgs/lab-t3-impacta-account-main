package br.com.lab.impacta.account.api.handler;

import br.com.lab.impacta.account.application.dto.response.ErrorMessageResponse;
import br.com.lab.impacta.account.domain.exception.AccountNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

public class ControllerExceptionHandler {


    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ErrorMessageResponse> accountNotFoundException(AccountNotFoundException exception){


        return getErrorResponse(exception.getLocalizedMessage(), exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<ErrorMessageResponse> getErrorResponse(String errorMessageResponse, String description, HttpStatus httpStatus){
        var error = new ErrorMessageResponse(LocalDateTime.now(), errorMessageResponse, description);

        return new ResponseEntity(error, httpStatus);
    }
}
