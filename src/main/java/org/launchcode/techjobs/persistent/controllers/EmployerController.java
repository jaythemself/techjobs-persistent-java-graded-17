package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.launchcode.techjobs.persistent.models.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("employers")
public class EmployerController {

    // Task 2.4.1 Add private field EmployerRepository type called employerRepository to EmployerController. Give this field an @ Autowired annotation.
    @Autowired
    private EmployerRepository employerRepository;

    // Task 2.4.2 Add index method that responds at /employers with a list of all employers in the database. This method should use the template
    // employers/index. To figure out the name of the model attribute you should use to pass employers into view, review this template.
    // ("list of all employers" isn't a hint to use List right?? Read back over if first way fails)
    @GetMapping("/")
    public String index (Model model) {
        model.addAttribute("employers", employerRepository.findAll());
        return "employers/index";
    }

    @GetMapping("add")
    public String displayAddEmployerForm(Model model) {
        model.addAttribute(new Employer());
        return "employers/add";
    }

    // 2.4.3. processAddEmployerForm already sends form back if any submitted employer object info is invalid. However, doesn't save a valid object.
    // Use employerRepository and the appropriate method to do so.
    @PostMapping("add")
    public String processAddEmployerForm(@ModelAttribute @Valid Employer newEmployer,
                                    Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "employers/add";
        }
        employerRepository.save(newEmployer);
        model.addAttribute("employers", employerRepository);

        return "redirect:";
    }

    // 2.4.4. displayViewEmployer will be in charge of rendering a page to view the contents of an individual employer object.
    // Will make use of that employer object's id field to grab correct info from employerRepo.
    // optEmployer currently initialized to null. Replace this by using the .findById() method w the right arg to look for
    // the given employer object from data layer. (variable holding id to query for is already provided in the controller method's params)
    @GetMapping("view/{employerId}")
    public String displayViewEmployer(Model model, @PathVariable int employerId) {

        Optional optEmployer = employerRepository.findById(employerId);
        if (optEmployer.isPresent()) {
            Employer employer = (Employer) optEmployer.get();
            model.addAttribute("employer", employer);
            return "employers/view";
        } else {
            return "redirect:../";
        }

    }
}
