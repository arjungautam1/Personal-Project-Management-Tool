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
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Iterator;
import java.util.List;

@Service
public class ProjectTaskService {
    @Autowired
    private BacklogRepository backlogRepository;

    @Autowired
    private ProjectTaskRepository projectTaskRepository;

    @Autowired
    private ProjectRepository projectRepository;


    public ProjectTask addProjectTask(String projectIdentifier, ProjectTask projectTask) {
        //Exceptions : Project not found

        try {

            //PTs to be added to specific project , !=project , backlog exists
            Backlog backlog = backlogRepository.findByProjectIdentifier(projectIdentifier);
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
            if (projectTask.getPriority() == null) {//In the future we need projectTask.getPriority()==0 to handle the form
                projectTask.setPriority(3);
            }
            //Initial status when status null
            if (projectTask.getStatus() == "" || projectTask.getStatus() == null) {
                projectTask.setStatus("TO_DO");
            }
            return projectTaskRepository.save(projectTask);

        } catch (Exception e) {
            throw new ProjectNotFoundException("Project Not Found .");

        }

    }

    public Iterable<ProjectTask> findBacklogById(String id) {

        Project project = projectRepository.findByProjectIdentifier(id);

        if (project == null) {
            throw new ProjectNotFoundException("Project with id :'" + id + "'does not exist");
        }

        return projectTaskRepository.findByProjectIdentifierOrderByPriority(id);
    }

    public ProjectTask findPTByProjectSequence(String backlog_id, String pt_id) {
        //We are searching on the right backlog
        Backlog backlog = backlogRepository.findByProjectIdentifier(backlog_id);
        if (backlog == null) {
            throw new ProjectNotFoundException("Project with id :'" + backlog_id + "'does not exist");
        }

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

    public ProjectTask updateByProjectSequence(ProjectTask updatedTask,String backlog_id,String pt_id){
        ProjectTask projectTask=findPTByProjectSequence(backlog_id,pt_id);

        projectTask=updatedTask;
        return projectTaskRepository.save(projectTask);
    }



}
