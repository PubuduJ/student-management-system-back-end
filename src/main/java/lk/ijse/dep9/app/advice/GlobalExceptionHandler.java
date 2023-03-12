package lk.ijse.dep9.app.advice;

import lk.ijse.dep9.app.api.exception.PathMismatchException;
import lk.ijse.dep9.app.service.exception.NotFoundException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, Object> validationExceptions(MethodArgumentNotValidException exp) {
        LinkedHashMap<String, Object> errAttributes = new LinkedHashMap<>();
        errAttributes.put("status", HttpStatus.BAD_REQUEST.value());
        errAttributes.put("error", HttpStatus.BAD_REQUEST.getReasonPhrase());
        errAttributes.put("timestamp", new Date().toString());
        ArrayList<String> validationErrorList = new ArrayList<>();
        List<FieldError> fieldErrors = exp.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            validationErrorList.add(fieldError.getField().concat(": ").concat(fieldError.getDefaultMessage()));
        }
        errAttributes.put("errors", validationErrorList);
        return errAttributes;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PathMismatchException.class)
    public Map<String, Object> pathMismatchExceptionHandler(PathMismatchException exp){
        Map<String, Object> errAttributes = new LinkedHashMap<>();
        errAttributes.put("status", HttpStatus.BAD_REQUEST.value());
        errAttributes.put("error", HttpStatus.BAD_REQUEST.getReasonPhrase());
        errAttributes.put("message", exp.getMessage());
        errAttributes.put("timestamp", new Date().toString());
        return errAttributes;
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DuplicateKeyException.class)
    public Map<String, Object> duplicateEntityExceptionHandler(DuplicateKeyException exp){
        Map<String, Object> errAttributes = new LinkedHashMap<>();
        errAttributes.put("status", HttpStatus.CONFLICT.value());
        errAttributes.put("error", HttpStatus.CONFLICT.getReasonPhrase());
        errAttributes.put("message", exp.getMessage());
        errAttributes.put("timestamp", new Date().toString());
        return errAttributes;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public Map<String, Object> notFoundEntityExceptionHandler(NotFoundException exp){
        Map<String, Object> errAttributes = new LinkedHashMap<>();
        errAttributes.put("status", HttpStatus.NOT_FOUND.value());
        errAttributes.put("error", HttpStatus.NOT_FOUND.getReasonPhrase());
        errAttributes.put("message", exp.getMessage());
        errAttributes.put("timestamp", new Date().toString());
        return errAttributes;
    }
}
