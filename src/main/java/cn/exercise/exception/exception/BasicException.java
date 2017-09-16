package cn.exercise.exception.exception;

public class BasicException extends Exception {
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    private String errorMessage;

    public BasicException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public BasicException() {
    }

}


//所有的异常类的基类都是Exception,而不是Throwable，因为Throwable还包含Error，并且提供的方法没有那么多
