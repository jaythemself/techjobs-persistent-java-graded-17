package org.launchcode.techjobs.persistent.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

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
    private String skills;
    public Job() {
    }

    // Initialize the id and value fields.
    public Job(Employer anEmployer, String someSkills) {
        super();
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

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

}
