package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Size;

// Task 2.2.4 Give Skill the @Entity annotation
@Entity
public class Skill extends AbstractEntity {

    // Task 2.2.3 Add a field for a longer description of the skill, named description.
    @Size (max = 250, message = "Description limited to 250 characters.")
    private String description;
    // Task 2.2.4 Give Skill no-arg constructor for Hibernate
    public Skill() {}

    // Task 2.2.3 Give Skill public accessor methods (again code of test also looks for mutator/setter).
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

// Task 4.1
// In Skill, add a jobs field. Add a getter and setter for the field. Annotate @ManyToMany with an arg mappedBy="skills"