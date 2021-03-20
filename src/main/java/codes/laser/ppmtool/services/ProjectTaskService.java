/**
 * Created By Arjun Gautam .
 * Date: 2020-12-08
 * Time: 21:34
 * Project Name : ppmtool
 */
package codes.laser.ppmtool.services;

import codes.laser.ppmtool.exceptions.ProjectNotFoundException;
import codes.laser.ppmtool.model.Backlog;
import codes.laser.ppmtool.model.Project;
import codes.laser.ppmtool.model.ProjectTask;
import codes.laser.ppmtool.repositories.BacklogRepository;
import codes.laser.ppmtool.repositories.ProjectRepository;
import codes.laser.ppmtool.repositories.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskService {
    @Autowired
    private BacklogRepository backlogRepository;

    @Autowired
    private ProjectTaskRepository projectTaskRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectService projectService;


    public ProjectTask addProjectTask(String projectIdentifier, ProjectTask projectTask, String username) {
        //Exceptions : Project not found


        //PTs to be added to specific project , !=project , backlog exists
        Backlog backlog = projectService.findProjectByIdentifier(projectIdentifier, username).getBacklog();//backlogRepository.findByProjectIdentifier(projectIdentifier);
        //set the backlog to Project Task
        projectTask.setBacklog(backlog);

        //we want our project sequence to be like this IDPRO-1  IDPRO-2
        Integer BacklogSequence = backlog.getPTSequence();

        //Update the Backlog sequence
        BacklogSequence++;
        backlog.setPTSequence(BacklogSequence);

        //Add Sequence to project Task
        projectTask.setProjectSequence(backlog.getProjectIdentifier() + "-" + BacklogSequence);
        projectTask.setProjectIdentifier(projectIdentifier);
        //Initial priority when priority null
        if (projectTask.getPriority() == 0 || projectTask.getPriority() == null) {//In the future we need projectTask.getPriority()==0 to handle the form
            projectTask.setPriority(3);
        }
        //Initial status when status null
        if (projectTask.getStatus() == "" || projectTask.getStatus() == null) {
            projectTask.setStatus("TO_DO");
        }
        return projectTaskRepository.save(projectTask);


    }

    public Iterable<ProjectTask> findBacklogById(String id, String username) {
        projectService.findProjectByIdentifier(id, username);
        return projectTaskRepository.findByProjectIdentifierOrderByPriority(id);
    }

    public ProjectTask findPTByProjectSequence(String backlog_id, String pt_id, String username) {
        //We are searching on the right backlog
        projectService.findProjectByIdentifier(backlog_id, username);
        //make sure that our task exists

        ProjectTask projectTask = projectTaskRepository.findByProjectSequence(pt_id);
        {
            if (projectTask == null) {
                throw new ProjectNotFoundException("Project task :'" + pt_id + "'not found ");
            }
        }

        //make sure that the backlog/project id in the path corresponds to the right project
        if (!projectTask.getProjectIdentifier().equals(backlog_id)) {
            throw new ProjectNotFoundException("Project Task '" + pt_id + "'does not exist in project'" + backlog_id);
        }

        return projectTask;

    }

    public ProjectTask updateByProjectSequence(ProjectTask updatedTask, String backlog_id, String pt_id,String username) {
        ProjectTask projectTask = findPTByProjectSequence(backlog_id, pt_id,username);

        projectTask = updatedTask;
        return projectTaskRepository.save(projectTask);
    }

    public void deletePTByProjectSequence(String backlog_id, String pt_id,String username) {
        ProjectTask projectTask = findPTByProjectSequence(backlog_id, pt_id,username);
        projectTaskRepository.delete(projectTask);

    }


}
