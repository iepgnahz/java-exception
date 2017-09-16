package cn.exercise.exception.exceptionHandler;

import cn.exercise.exception.exception.BasicException;
import cn.exercise.exception.exception.MyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
// 是一个全局的异常处理器（定义一个统一的异常处理类、代替每个controller中的try catch块）
@RestController
//会以 RESTful 的形式返回回复
public class GlobalExceptionHandler {
    //请注意我们通常会将最底层的（最子类）的异常放在最上面处理，由于异常进来，会从上向下匹配。
    //下面这个handler会处理MyException以及他的子类异常
    @ExceptionHandler(value = MyException.class)
    public ResponseEntity handleMyException(HttpServletRequest req, MyException myException) {
        Map<String, String> result = new HashMap<>();
        result.put("errorMessage", myException.getErrorMessage());
        return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = BasicException.class)
    public ResponseEntity handleBasicException(HttpServletRequest req, BasicException basicException) {
        Map<String, String> result = new HashMap<>();
        result.put("errorMessage", basicException.getErrorMessage());
        return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
    }
}
