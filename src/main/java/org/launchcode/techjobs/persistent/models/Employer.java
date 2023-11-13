package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

// Task 2.2.2 Employer class will be mapped to one of our tables. @Entity annotation
@Entity
public class Employer extends AbstractEntity {

    // Task 2.2.1 In addition to the fields inherited from AbstractEntity, Employer should have a string field for location.
    // Add the field for location with validation that ensures it's not empty and has reasonable length.
    @NotBlank(message = "This field must be filled out.")
    @Size(min = 1, max = 100, message = "Must contain between 1-100 characters.")
    private String location;

    // 3.1.1 Add a private property jobs of type List<Job> and initialize it to an empty ArrayList.
    // After we set up Job class to work with Employer objects, this list will represent the list of all items in a given job.
    // 3.1.2 Use the @OneToMany and @JoinColumn annotations on the jobs list in Employer to declare the relationship between data tables.
    @OneToMany
    @JoinColumn(name = "employer_id")
    private List<Job> jobs = new ArrayList<>();

    // Task 2.2.2 Make sure Employer has a no-arg constructor required for Hibernate to create an object.
    public Employer() {}

    //Use constructor when initially setting Employer location, updating later uses setter/mutator. No-arg is just for Hibernate.
    public Employer(String location) { this.location = location; }

    // Task 2.2.1 Add public accessor methods (getter methods) to Employer. (test also looks for setter so. not just accessor method.)
    // For the purposes of this application an employer can only have one location.
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

}
