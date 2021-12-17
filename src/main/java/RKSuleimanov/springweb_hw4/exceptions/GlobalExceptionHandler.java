package RKSuleimanov.springweb_hw4.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<RKSuleimanov.springweb_hw4.exceptions.AppError> catchResourceNotFoundException(RKSuleimanov.springweb_hw4.exceptions.ResourceNotFoundException  e) {
        return new ResponseEntity<>(new RKSuleimanov.springweb_hw4.exceptions.AppError (HttpStatus.NOT_FOUND.value(), e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
