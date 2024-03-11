package pro.sky.examination.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)

public class QuestionIsAlreadyCreatedException extends RuntimeException {
    public QuestionIsAlreadyCreatedException() {
    }

    public QuestionIsAlreadyCreatedException(String message) {
        super(message);
    }

    public QuestionIsAlreadyCreatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionIsAlreadyCreatedException(Throwable cause) {
        super(cause);
    }

    public QuestionIsAlreadyCreatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
