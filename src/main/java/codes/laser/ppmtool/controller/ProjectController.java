/**
 * Created By Arjun Gautam .
 * Date: 2020-11-25
 * Time: 09:18
 * Project Name : ppmtool
 */
package codes.laser.ppmtool.controller;

import codes.laser.ppmtool.model.Project;
import codes.laser.ppmtool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result) {
        if(result.hasErrors()){
            return new ResponseEntity<String>("Invalid Project Object",HttpStatus.BAD_REQUEST);
        }
        Project project1=projectService.saveOrUpdateProject(project);
        return new ResponseEntity<Project>(project, HttpStatus.CREATED);
    }

}
