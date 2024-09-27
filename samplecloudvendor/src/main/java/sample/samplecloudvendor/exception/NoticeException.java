package sample.samplecloudvendor.exception;

import org.springframework.http.HttpStatus;

public class NoticeException {

    private String message;
    private Throwable throwable;
    private HttpStatus httpStatus;

    public NoticeException(String message, Throwable throwable, HttpStatus httpStatus) {
        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
