package br.com.pipa.score.exception;

public class ZeroOrNegativeParamException extends BasicException {

    public ZeroOrNegativeParamException(String message) {
        super(message);
    }

    public ZeroOrNegativeParamException(String message, Object[] paramsError) {
        super(message, paramsError);
    }
}
