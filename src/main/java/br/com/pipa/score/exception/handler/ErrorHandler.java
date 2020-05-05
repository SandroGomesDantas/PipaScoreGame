package br.com.pipa.score.exception.handler;

import br.com.pipa.score.exception.BasicException;
import br.com.pipa.score.exception.NullParamException;
import br.com.pipa.score.exception.ZeroOrNegativeParamException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private ResourceLoader loader;

    private String getLocale(HttpServletRequest request) {

        String _language[] = request.getHeader("Accept-Language").split("_");

        if((_language == null) || (_language.length <= 1)) {
            return "pt_BR";
        }
        return new Locale(_language[0].toLowerCase(), _language[1].toUpperCase()).toString();
    }

    private String translateErrorHandler(BasicException error, HttpServletRequest request) {

        String bundleFile = "terms-" + getLocale(request);

        ResourceBundle bundle = ResourceBundle.getBundle(bundleFile);

        String term = bundle.getString(error.getMessage()) == null ? error.getMessage() : bundle.getString(error.getMessage());

        if((error.getParamsError() != null) && (error.getParamsError().length > 0)) {
            term = MessageFormat.format(term, error.getParamsError());
        }

        return term;
    }

    @ExceptionHandler(NullParamException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handleNotFoundException(NullParamException ex, HttpServletRequest request, HttpServletResponse response) {
        String error = translateErrorHandler(ex, request);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ZeroOrNegativeParamException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handleZeroOrNegativeException(ZeroOrNegativeParamException ex, HttpServletRequest request, HttpServletResponse response) {
        String error = translateErrorHandler(ex, request);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
