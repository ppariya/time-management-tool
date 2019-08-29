package io.swagger.repository;

import io.swagger.model.TimeEntry;
import io.swagger.model.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TimeEntriesRepository extends CrudRepository<TimeEntry, Long> {

    List<TimeEntry> findAllById(UserModel id);

    List<TimeEntry> findAllByUserModel_Id(long userId);
}
