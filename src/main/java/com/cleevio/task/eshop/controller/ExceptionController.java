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
        // Log the exception
        logger.error(exception, exception);

        // Hmm..
        // This doesn't seem right tho
        if (exception.getCause() != null && exception.getCause().getCause() instanceof ConstraintViolationException) {
            var cause = (ConstraintViolationException) exception.getCause().getCause();
            var message = new StringBuilder();

            for (ConstraintViolation<?> violation : cause.getConstraintViolations()) {
                message.append(violation.getPropertyPath())
                        .append(" ")
                        .append(violation.getMessage())
                        .append(" ");
            }

            var httpStatus = HttpStatus.BAD_REQUEST;

            var dto = new MessageExceptionDTO();
            dto.setMessage(message.toString().trim());
            var statusMessage = httpStatus.value() + " " + httpStatus.getReasonPhrase();
            dto.setHttpStatus(statusMessage);

            return new ResponseEntity<>(dto, httpStatus);
        }

        throw exception;
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
