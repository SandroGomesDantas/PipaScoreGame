package br.com.pipa.score.exception;

public class BasicException extends RuntimeException {

    private String message;

    private Object[] paramsError;

    public BasicException(String message) {
        this.message = message;
    }

    public BasicException(String message, Object[] paramsError) {
        this.message = message;
        this.paramsError = paramsError;
    }

    public Object[] getParamsError() {
        return this.paramsError;
    }

    public String getMessage() {
        return this.message;
    }
}
