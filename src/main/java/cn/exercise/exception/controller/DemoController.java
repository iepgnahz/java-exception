package cn.exercise.exception.controller;

import cn.exercise.exception.exception.BasicException;
import cn.exercise.exception.exception.MyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/exception")
public class DemoController {
    @RequestMapping
    public ResponseEntity get() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/basicException")
    public ResponseEntity throwBasicException() throws BasicException {
        System.out.println("throw basic exception before");
        throw new BasicException("this is a basic exception");
    }

    @RequestMapping(value = "/MyException")
    public ResponseEntity throwMyException() throws MyException {
        System.out.println("throw my exception before");
        throw new MyException("this is a my exception");
    }
}
