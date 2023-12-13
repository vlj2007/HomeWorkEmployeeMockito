package pro.sky.HomeWorkEmployeeMockito.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeIllegalNameOrLastNameException extends RuntimeException {

    public EmployeeIllegalNameOrLastNameException() {
    }

    public EmployeeIllegalNameOrLastNameException(String message) {
        super(message);
    }

    public EmployeeIllegalNameOrLastNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeIllegalNameOrLastNameException(Throwable cause) {
        super(cause);
    }

    public EmployeeIllegalNameOrLastNameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
