/**
 * Created By Arjun Gautam .
 * Date: 2020-11-25
 * Time: 21:26
 * Project Name : ppmtool
 */
package codes.laser.ppmtool.exceptions;

public class ProjectIdExceptionResponse {
    private String projectIdentifier;

    public ProjectIdExceptionResponse(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }

    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    public void setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }
}
