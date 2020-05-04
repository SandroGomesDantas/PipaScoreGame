package br.com.pipa.score.exception;

public class NullParamException extends NullPointerException {

    private String message;

    public NullParamException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
