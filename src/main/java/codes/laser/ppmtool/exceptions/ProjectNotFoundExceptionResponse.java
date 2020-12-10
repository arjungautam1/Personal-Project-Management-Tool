/**
 * Created By Arjun Gautam .
 * Date: 2020-12-10
 * Time: 11:35
 * Project Name : ppmtool
 */
package codes.laser.ppmtool.exceptions;

public class ProjectNotFoundExceptionResponse {
    private String ProjectNotFound;

    public ProjectNotFoundExceptionResponse(String projectNotFound) {
        ProjectNotFound = projectNotFound;
    }

    public String getProjectNotFound() {
        return ProjectNotFound;
    }

    public void setProjectNotFound(String projectNotFound) {
        ProjectNotFound = projectNotFound;
    }


}
