package edu.nenu.tliaswebserver.exception;


import edu.nenu.tliaswebserver.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * 全局异常处理注解@RestControllerAdvice
 * 接收所有RestController捕获到的异常
 */
@RestControllerAdvice
public class GlobalExceptionHandler {


    // 指定所有异常类型
    @ExceptionHandler(Exception.class)
    public Result ex(Exception exception){
        exception.printStackTrace();
        return Result.error("服务器异常，请联系管员");
    }
}
