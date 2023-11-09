package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Job;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.launchcode.techjobs.persistent.models.data.JobRepository;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

/**
 * Created by LaunchCode
 */
@Controller
public class HomeController {

    // 3.3.1. Add a field employerRepository annotated with @Autowired.
    @Autowired
    private EmployerRepository employerRepository;
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private JobRepository jobRepository;

    @RequestMapping("/")
    public String index(Model model) {

        model.addAttribute("title", "MyJobs");

        return "index";
    }

    // 3.3.2. User will select an employer when creating a job. Add employer data from employerRepo into form template.
    // The add job form includes employer selection option. Be sure your variable name for the employer data matches
    // that already used in templates/add.
    @GetMapping("add")
    public String displayAddJobForm(Model model) {
	model.addAttribute("title", "Add Job");
        model.addAttribute("employers", employerRepository.findAll());
        model.addAttribute("skills", skillRepository.findAll());
        model.addAttribute(new Job());
        return "add";
    }

    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Job newJob,
                                       Errors errors, Model model, @RequestParam int employerId) {

        if (errors.hasErrors()) {
	    model.addAttribute("title", "Add Job");
            return "add";
        }

        // 3.3.4. In processAddJobForm add code inside this method to select the employer object chosen to be affiliated
        // with the new job. You will need to select the employer using the request parameter you've added to the method.
        // An employer only needs to be found and set on the new job object if the form data is validated.
        Optional<Employer> optEmployer = employerRepository.findById(employerId);
        if (optEmployer.isPresent()) {
            Employer employer = optEmployer.get();
            newJob.setEmployer(employer);
        }

        return "redirect:";
    }

    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) {

            return "view";
    }

}

// Task 4.3
// You need to wire HomeController wiht the skills data in order to add skills objects to a new job. This will look almost
// precisely like what was done for employer data above (4.1-2)
// Difference: job form being processed only accepts one employer by an id field. Many skills can be added to a single job.
// The code for the view has already been written. Look in templates/add.html. Form-group section iterates over abailable skills
// data and renders a checkbox for each skill. Each checkbox contains attribute name="skills". Pass that value to
// processAddJobForm as a @RequestParam (@RequestParam List<Integer> skills)
// Then, to get the skills data from a list of ids (rather than a single id) use CrudRepo method .findAllById(ids)
// (List<Skill> skillObjs = (List<Skill>) skillRepository.findAllById(skills); \n newJob.setSkills(skillObjs);)
// Uncomment testtaskfour and check