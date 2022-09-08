package com.amsa.capacitacion.profesor.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * @developedBy Ing. Dausbel Torreblanca Pavo
 */
@RestControllerAdvice
@Slf4j
public class ExceptionHandlerApp extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(value = {ProfesorException.class})
    public ResponseEntity<Object> handleProfesor(ProfesorException ex, WebRequest request) {
        return new ResponseEntity<>(ErrorMensaje.builder().mensaje(ex.getMensaje()).build(), HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex,
        WebRequest request) {
        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
        final List<Object> invalidValues = constraintViolations.stream().map(ConstraintViolation::getInvalidValue).collect(Collectors.toList());
        final List<String> errorMensajes = constraintViolations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
        log.error("HandleConstrations : invalidValues={}  errors={}", invalidValues, errorMensajes);
        return new ResponseEntity<>(ErrorMensaje.builder().mensaje(errorMensajes.get(0)).build(), HttpStatus.BAD_REQUEST);
    }
    
    
    @ExceptionHandler(value = {SQLException.class})
    public ResponseEntity<Object> handleSql(SQLException ex, WebRequest request) {
        return new ResponseEntity<>(ErrorMensaje.builder().mensaje(ex.getMessage()).build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(value = {MappingException.class,CursoException.class })
    public ResponseEntity<Object> handleMappingException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ErrorMensaje.builder().mensaje(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
    }
    
    
    @Override
    protected final ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
        HttpHeaders headers, HttpStatus status, WebRequest request) {
        
        List<String> errorMessages = ex.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
        log.error("handleMethodArgumentNotValid: errors=[{}]", errorMessages);
        return new ResponseEntity<>(ErrorMensaje.builder().mensaje(errorMessages.get(0)).build(), HttpStatus.BAD_REQUEST);
    }
}
