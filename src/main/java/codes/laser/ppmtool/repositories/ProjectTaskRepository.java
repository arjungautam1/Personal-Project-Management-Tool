/**
 * Created By Arjun Gautam .
 * Date: 2020-12-08
 * Time: 19:31
 * Project Name : ppmtool
 */
package codes.laser.ppmtool.repositories;

import codes.laser.ppmtool.model.ProjectTask;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectTaskRepository extends CrudRepository<ProjectTask,Long> {
}