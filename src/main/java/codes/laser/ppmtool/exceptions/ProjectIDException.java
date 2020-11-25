/**
 * Created By Arjun Gautam .
 * Date: 2020-11-25
 * Time: 21:28
 * Project Name : ppmtool
 */
package codes.laser.ppmtool.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProjectIDException extends RuntimeException {
    public ProjectIDException(String message) {
        super(message);
    }
}
