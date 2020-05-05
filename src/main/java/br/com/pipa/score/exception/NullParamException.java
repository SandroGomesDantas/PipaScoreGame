package br.com.pipa.score.exception;

public class NullParamException extends BasicException {

    public NullParamException(String message) {
        super(message);
    }

    public NullParamException(String message, Object[] paramsError) {
        super(message, paramsError);
    }

}
