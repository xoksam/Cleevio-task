package com.cleevio.task.eshop.controller;

import com.cleevio.task.eshop.common.dto.MessageExceptionDTO;
import com.cleevio.task.eshop.common.exceptions.MessageException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Order;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionController {
    private Logger logger = LogManager.getLogger(ExceptionController.class);

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<MessageExceptionDTO> defaultHandler(HttpServletRequest request,
                                                              HttpServletResponse response,
                                                              Throwable exception) throws Throwable {
        // Log the exception and then re-throw it
        logger.error(exception, exception);

        throw exception;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MessageExceptionDTO> handleMethodArgumentNotValidException(HttpServletRequest request,
                                                                                     HttpServletResponse response,
                                                                                     MethodArgumentNotValidException exception) {
        logger.error(exception, exception);

        var httpStatus = HttpStatus.BAD_REQUEST;

        var dto = new MessageExceptionDTO();
        if (exception.getFieldError() != null) {
            dto.setMessage(exception.getFieldError().getField() + " " + exception.getFieldError().getDefaultMessage());
        } else {
            dto.setMessage(exception.getLocalizedMessage());
        }

        var statusMessage = httpStatus.value() + " " + httpStatus.getReasonPhrase();
        dto.setHttpStatus(statusMessage);

        return new ResponseEntity<>(dto, httpStatus);
    }

    @ExceptionHandler(MessageException.class)
    public ResponseEntity<MessageExceptionDTO> handleMessageException(HttpServletRequest request,
                                                                      HttpServletResponse response,
                                                                      MessageException exception) {
        logger.error(exception, exception);
        var exceptionStatus = exception.getHttpStatus();

        var httpStatus = exceptionStatus == null
                ? HttpStatus.BAD_REQUEST
                : exceptionStatus;

        var dto = new MessageExceptionDTO();
        dto.setMessage(exception.getMessage());
        var statusMessage = httpStatus.value() + " " + httpStatus.getReasonPhrase();
        dto.setHttpStatus(statusMessage);

        return new ResponseEntity<>(dto, httpStatus);
    }

}
