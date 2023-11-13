package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.ArrayList;
import java.util.List;


// 3.2.1. Since Job model class has id and name fields, it can also inherit from AbstractEntity.
// Update class definition of Job to extend AbstractEntity. Remove redundant fields from Job.
@Entity
public class Job extends AbstractEntity {

    // 3.2.2. Replace the type of the field employer to be of type Employer.
    // Refactor affected constructor, getter, and setter that used the previous field.
    // 3.2.3. Add the @ManyToOne annotation on the field employer.
    @ManyToOne
    private Employer employer;

    // Task 4.2 Update Job model class to fit its ManyToMany relationship with skills
    @ManyToMany
    @JoinColumn(name = "skills_id")
    private List<Skill> skills = new ArrayList<>();
    public Job() {
    }

    // Initialize the id and value fields.
    public Job(Employer anEmployer, List<Skill> someSkills) {
        //super();
        this.employer = anEmployer;
        this.skills = someSkills;
    }

    // Getters and setters.

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

}
