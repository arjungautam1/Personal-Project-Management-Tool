/**
 * Created By Arjun Gautam .
 * Date: 2020-12-10
 * Time: 11:37
 * Project Name : ppmtool
 */
package codes.laser.ppmtool.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProjectNotFoundException extends RuntimeException{
    public ProjectNotFoundException(String message) {
        super(message);
    }

}
