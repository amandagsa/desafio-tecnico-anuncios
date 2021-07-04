package com.capgemini.anuncios.handler;

import com.capgemini.anuncios.error.ResourcesNotFoundDetails;
import com.capgemini.anuncios.error.ResourcesNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

//Implementa resposta personalizada para erro NotFoundException.

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(ResourcesNotFoundException.class)
    public ResponseEntity<?> handleResourcesNotFoundException(ResourcesNotFoundException rfnException) {
        ResourcesNotFoundDetails rnfDetails = ResourcesNotFoundDetails.Builder
                .newBuilder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.NOT_FOUND.value())
                .title("Resource Not Found")
                .detail(rfnException.getMessage())
                .developerMessage(rfnException.getClass().getName())
                .build();
        return new ResponseEntity<>(rnfDetails,HttpStatus.NOT_FOUND);
    }
}

