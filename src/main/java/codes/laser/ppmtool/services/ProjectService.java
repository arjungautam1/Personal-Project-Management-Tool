/**
 * Created By Arjun Gautam .
 * Date: 2020-11-25
 * Time: 07:13
 * Project Name : ppmtool
 */
package codes.laser.ppmtool.services;

import codes.laser.ppmtool.model.Project;
import codes.laser.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project) {
        //Logic
        return projectRepository.save(project);
    }


}
