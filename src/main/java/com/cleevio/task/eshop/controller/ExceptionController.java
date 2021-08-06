package com.cleevio.task.eshop.controller;

import com.cleevio.task.eshop.common.dto.MessageExceptionDTO;
import com.cleevio.task.eshop.common.exceptions.MessageException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Order;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionController {
    private Logger logger = LogManager.getLogger(ExceptionController.class);

    @ExceptionHandler(Throwable.class)
    public void defaultHandler(HttpServletRequest request,
                               HttpServletResponse response,
                               Throwable exception) throws Throwable {
        // Log every exception to log and re-throw it
        logger.error(exception);

        throw exception;
    }

    @ExceptionHandler(MessageException.class)
    public ResponseEntity<MessageExceptionDTO> handleMessageException(HttpServletRequest request,
                                                                      HttpServletResponse response,
                                                                      MessageException exception) {
        logger.error(exception, exception);

        var httpStatus = exception.getHttpStatus() == null
                ? HttpStatus.BAD_REQUEST
                : exception.getHttpStatus();

        var dto = new MessageExceptionDTO();
        dto.setMessage(exception.getMessage());
        dto.setHttpStatus(exception.getHttpStatus());

        return new ResponseEntity<>(dto, httpStatus);
    }

}
