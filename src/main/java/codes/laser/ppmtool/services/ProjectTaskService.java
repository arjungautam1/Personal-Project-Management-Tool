/**
 * Created By Arjun Gautam .
 * Date: 2020-12-08
 * Time: 21:34
 * Project Name : ppmtool
 */
package codes.laser.ppmtool.services;

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


    public ProjectTask addProjectTask(){
        //PTs to be added to specific project , !=project , backlog exists
        //set the backlog to Project Task

        //we want our project sequence to be like this IDPRO-1  IDPRO-2
        //Update the Backlog sequence

        //Initail priority

    }
}
