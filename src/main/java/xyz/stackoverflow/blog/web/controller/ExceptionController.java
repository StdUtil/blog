package xyz.stackoverflow.blog.web.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.stackoverflow.blog.pojo.ResponseMessage;

public class ExceptionController {

    private final Integer exceptionStatus = -1;

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseMessage handleException(Exception e){
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setStatus(exceptionStatus);
        responseMessage.setData(e.getClass().getSimpleName());
        return responseMessage;
    }
}
