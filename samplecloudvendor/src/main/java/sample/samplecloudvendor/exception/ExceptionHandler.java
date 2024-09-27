package sample.samplecloudvendor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value={CloudVendorNotFoundException.class, CloudVendorNotUpdatedException.class})
    public ResponseEntity<Object> CloudVendorNotFoundExceptionHandler(CloudVendorNotFoundException cloudVendorNotFoundException)
    {   NoticeException noticeException=new NoticeException(
            cloudVendorNotFoundException.getMessage(),
            cloudVendorNotFoundException.getCause(),
            HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(noticeException, HttpStatus.NOT_FOUND);
    }


}
