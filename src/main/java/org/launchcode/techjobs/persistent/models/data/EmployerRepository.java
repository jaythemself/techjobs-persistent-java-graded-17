package org.launchcode.techjobs.persistent.models.data;

import org.launchcode.techjobs.persistent.models.Employer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// Task 2.3.1 Create new EmployerRepository interface. Should extend CrudRepository and annotated @Repository.
@Repository
public interface EmployerRepository extends CrudRepository<Employer, Integer> {
}
