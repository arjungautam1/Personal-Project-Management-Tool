/**
 * Created By Arjun Gautam .
 * Date: 2020-12-08
 * Time: 21:34
 * Project Name : ppmtool
 */
package codes.laser.ppmtool.services;

import codes.laser.ppmtool.model.Backlog;
import codes.laser.ppmtool.model.ProjectTask;
import codes.laser.ppmtool.repositories.BacklogRepository;
import codes.laser.ppmtool.repositories.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskService {
    @Autowired
    private BacklogRepository backlogRepository;

    @Autowired
    private ProjectTaskRepository projectTaskRepository;


    public ProjectTask addProjectTask(String projectIdentifier, ProjectTask projectTask) {
        //Exceptions : Project not found
        //PTs to be added to specific project , !=project , backlog exists
        Backlog backlog = backlogRepository.findByProjectIdentifier(projectIdentifier);
        //set the backlog to Project Task
        projectTask.setBacklog(backlog);

        //we want our project sequence to be like this IDPRO-1  IDPRO-2
        Integer BacklogSequence = backlog.getPTSequence();

        //Update the Backlog sequence
        BacklogSequence++;

        //Add Sequence to project Task
        projectTask.setProjectSequence(backlog.getProjectIdentifier() + "-" + BacklogSequence);
        projectTask.setProjectIdentifier(projectIdentifier);
        //Initial priority when priority null
//        if (projectTask.getPriority() == 0 || projectTask.getPriority() == null) {
//            projectTask.setPriority(3);
//        }
        //Initial status when status null
        if (projectTask.getStatus() == "" || projectTask.getStatus() == null) {
            projectTask.setStatus("TO_DO");
        }
        return projectTaskRepository.save(projectTask);

    }
}
