package com.telefonia_vivas.exception;

import com.telefonia_vivas.util.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExeceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleResourceNotFound(ResourceNotFoundException exception) {
        return buildResponse(exception.getMessage(), HttpStatus.NOT_FOUND, null);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Map<String, String>>> handleValidationException(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return buildResponse("Errores de validación", HttpStatus.BAD_REQUEST, errors);
    }

    @ExceptionHandler(RunExistenteException.class)
    public ResponseEntity<ApiResponse<String>> handleRunExistente(RunExistenteException exception) {
        return buildResponse(exception.getMessage(), HttpStatus.CONFLICT, null);
    }

    @ExceptionHandler(NombreExistenteException.class)
    public ResponseEntity<ApiResponse<String>> handleNombreExistente(NombreExistenteException exception) {
        return buildResponse(exception.getMessage(), HttpStatus.CONFLICT, null);
    }

    @ExceptionHandler(RegionNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleRegionNotFound(RegionNotFoundException exception) {
        return buildResponse(exception.getMessage(), HttpStatus.NOT_FOUND, null);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiResponse<String>> handleInvalidJson(HttpMessageNotReadableException exception) {
        String errorMessage = "Error en el formato del JSON enviado. " + extractErrorDetails(exception);
        return buildResponse(errorMessage, HttpStatus.BAD_REQUEST, null);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleGenericException(Exception exception) {
        return buildResponse("Ha ocurrido un error inesperado.", HttpStatus.INTERNAL_SERVER_ERROR, null);
    }

    private <T> ResponseEntity<ApiResponse<T>> buildResponse(String message, HttpStatus status, T data) {
        ApiResponse<T> response = new ApiResponse<>(message, status.value(), data);
        return ResponseEntity.status(status).body(response);
    }

    private String extractErrorDetails(HttpMessageNotReadableException exception) {
        if (exception.getCause() instanceof com.fasterxml.jackson.databind.exc.InvalidFormatException invalidFormatException) {
            String field = invalidFormatException.getPath().stream()
                    .findFirst()
                    .map(ref -> ref.getFieldName())
                    .orElse("campo desconocido");
            String invalidValue = invalidFormatException.getValue().toString();
            return "El valor '" + invalidValue + "' no es válido para el campo '" + field + "'.";
        }
        return "Detalles del error no disponibles.";
    }

}