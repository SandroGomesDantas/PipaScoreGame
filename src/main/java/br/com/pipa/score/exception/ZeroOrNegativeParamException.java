package br.com.pipa.score.exception;

public class ZeroOrNegativeParamException extends RuntimeException {

    private String message;

    public ZeroOrNegativeParamException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
