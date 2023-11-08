package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Size;

@Entity
public class Skill extends AbstractEntity {

    @Size (max = 250, message = "Description limited to 250 characters.")
    private String description;
    public Skill() {}

    public String getDescription() {
        return description;
    }

    public void setDescription() {
        this.description = description;
    }

}

// Add field for a longer description of skill, named description with public accessor methods
// Give @ Entity annotation and be sure it contains no-arg constructor
