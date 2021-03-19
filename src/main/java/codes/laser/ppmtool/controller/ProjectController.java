/**
 * Created By Arjun Gautam .
 * Date: 2020-11-25
 * Time: 09:18
 * Project Name : ppmtool
 */
package codes.laser.ppmtool.controller;

import codes.laser.ppmtool.model.Project;

import codes.laser.ppmtool.services.MapValidationErrorService;
import codes.laser.ppmtool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/api/project")
@CrossOrigin(origins = "http://localhost:3000")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result, Principal principal) {

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null) return errorMap;

        Project project1 = projectService.saveOrUpdateProject(project,principal.getName());
        return new ResponseEntity<Project>(project1, HttpStatus.CREATED);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> getProjectById(@PathVariable String projectId,Principal principal) {
        Project project = projectService.findProjectByIdentifier(projectId,principal.getName());
        return new ResponseEntity<Project>(project, HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<Project> getAllProjects(Principal principal) {
        return projectService.findAllProjects(principal.getName());
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<?> deleteProject(@PathVariable String projectId,Principal principal) {
        projectService.deleteProjectByIdentifier(projectId,principal.getName());
        return new ResponseEntity<String>("Project with ID:'" + projectId + "'was deleted", HttpStatus.OK);
    }
}
