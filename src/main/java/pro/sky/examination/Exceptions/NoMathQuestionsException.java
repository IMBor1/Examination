package pro.sky.examination.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
public class NoMathQuestionsException extends RuntimeException {
    public NoMathQuestionsException() {
    }

    public NoMathQuestionsException(String message) {
        super(message);
    }

    public NoMathQuestionsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoMathQuestionsException(Throwable cause) {
        super(cause);
    }

    public NoMathQuestionsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
