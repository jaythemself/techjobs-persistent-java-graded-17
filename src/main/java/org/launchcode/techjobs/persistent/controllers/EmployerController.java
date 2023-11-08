package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;
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

    @GetMapping("add")
    public String displayAddEmployerForm(Model model) {
        model.addAttribute(new Employer());
        return "employers/add";
    }

    @PostMapping("add")
    public String processAddEmployerForm(@ModelAttribute @Valid Employer newEmployer,
                                    Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "employers/add";
        }

        return "redirect:";
    }

    @GetMapping("view/{employerId}")
    public String displayViewEmployer(Model model, @PathVariable int employerId) {

        Optional optEmployer = null;
        if (optEmployer.isPresent()) {
            Employer employer = (Employer) optEmployer.get();
            model.addAttribute("employer", employer);
            return "employers/view";
        } else {
            return "redirect:../";
        }

    }
}

// Two handlers with missing information. Task here is to make use of the EmployerRepository class in these handlers.
// 1. Add private field EmployerRepository type called employerRepository to EmployerController. Give this field an @ Autowired annotation.
// 2. Add index method that responds at /employers with a list of all employers in the database. This method should use the template
// employers/index. To figure out the name of the model attribute you should use to pass employers into view, review this template.
// 3. processAddEmployerForm already sends form back if any submitted employer object info is invalid. However, doesn't yet save a valid object.
// Use employerRepository and the appropriate method to do so.
// 4. displayViewEmployer will be in charge of rendering a page to view the contents of an indiv. employer object. Will make use of
// that employer object's id field to grab correct info from employerRepo. optEmployer currently initialized to null. Replace this by
// using the .findById() method w the right arg to look for the given employer object from the data layer. (variable holding id you want to query for is
// already provided for you in the controller mehtod's parameters)
// 5. Create a SkillController class and replicate steps above for EmployerController. New controller should have the methods, index, displayAddSkillForm,
// processAddSkillForm, and displayViewSkill. These methods should behave the same. Relevant templates already created
// 6. Test it with SQL (reference textbook and demo app again for this section)