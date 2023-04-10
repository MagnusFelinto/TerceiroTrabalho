package com.poo.terceirotrabalho.domain.ExptionHandler;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.message.Message;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class ApiExeptionHandler extends ResponseEntityExceptionHandler {
    private MessageSource messageSource;
    @Override
    @Nullable
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {
            List<Problema.Campo> campos = new ArrayList<>();
            for (ObjectError error : ex.getBindingResult().getAllErrors()) {
                String nome = ((FieldError)error).getField();
                String message = messageSource.getMessage(error, LocaleContextHolder.getLocale());
                campos.add(new Problema.Campo(nome, message));
                
            }
            Problema problema = new Problema();
            problema.setStatus(status.value());
            problema.setTitulo("Campo invalido");
            problema.setCampo(campos);
        return handleExceptionInternal(ex, "Valor invalido", headers, status, request);
        
                // TODO Auto-generated method stub
        //   return super.handleMethodArgumentNotValid(ex, headers, status, request);
    }


}
