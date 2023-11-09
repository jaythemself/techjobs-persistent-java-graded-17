package org.launchcode.techjobs.persistent.models.data;

import org.launchcode.techjobs.persistent.models.Skill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// Task 2.3.2 Create new SkillRepository interface. Should extend CrudRepository and be annotated @Repository.
@Repository
public interface SkillRepository extends CrudRepository<Skill, Integer> {
}
