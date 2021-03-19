/**
 * Created By Arjun Gautam .
 * Date: 2020-11-24
 * Time: 21:52
 * Project Name : ppmtool
 */
package codes.laser.ppmtool.repositories;

import codes.laser.ppmtool.model.Project;
import codes.laser.ppmtool.model.ProjectTask;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
    Project findByProjectIdentifier(String projectId);

    @Override
    Iterable<Project> findAll();

    Iterable<Project> findAllByProjectLeader(String username);


}
