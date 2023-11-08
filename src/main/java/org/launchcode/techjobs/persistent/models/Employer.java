package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Employer extends AbstractEntity {

    @NotBlank(message = "This field must be filled out.")
    @Size(min = 1, max = 100, message = "Must contain between 1-100 characters.")
    private String location;

    public Employer() {}

    public String getLocation() {
        return location;
    }
    public void setLocation() {
        this.location = location;
    }

}

// In addition to the fields inherited from AbstractEntity, Employer should have a string field for location. add the
// field for location with validation that ensures it's not empty and has reasonable length
// In addition, add public accessor methods (getter methods) to Employer. (test also looks for setter so. not just accessor method.)
// Employer can have only one location.
// Mapped to a table. @ Entity annotation, as well as no arg constructor