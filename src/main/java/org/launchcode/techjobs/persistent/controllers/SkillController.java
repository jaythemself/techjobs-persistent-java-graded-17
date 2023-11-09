package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

// Task 2.4.5 create SkillController class identical to EmployerController class.
// Must import into TestTaskTwo.
@Controller
@RequestMapping("skills")
public class SkillController {

    // Add private field SkillRepository type called skillRepository to SkillController. Give this field an @ Autowired annotation.
    @Autowired
    private SkillRepository skillRepository;

    // Add index method that responds at /skills with a list of all skills in the database. This method should use the template
    // skills/index. To figure out the name of the model attribute you should use to pass skills into view, review this template.
    @GetMapping("/")
    public String index (Model model) {
        model.addAttribute("skills", skillRepository.findAll());
        return "skills/index";
    }

    @GetMapping("add")
    public String displayAddSkillForm(Model model) {
        model.addAttribute(new Skill());
        return "skills/add";
    }

    // processAddSkillForm already sends form back if any submitted skill object info is invalid. However, doesn't save a valid object.
    // Use skillRepository and the appropriate method to do so.
    @PostMapping("add")
    public String processAddSkillForm(@ModelAttribute @Valid Skill newSkill,
                                      Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "skills/add";
        }
        skillRepository.save(newSkill);
        model.addAttribute("skills", skillRepository);

        return "redirect:";
    }

    // displayViewSkill will be in charge of rendering a page to view the contents of an individual skill object.
    // Will make use of that skill object's id field to grab correct info from skillRepo.
    // optSkill currently initialized to null. Replace this by using the .findById() method w the right arg to look for
    // the given skill object from data layer. (variable holding id to query for is already provided in the controller method's params)
    @GetMapping("view/{skillId}")
    public String displayViewSkill(Model model, @PathVariable int skillId) {

        Optional optSkill = skillRepository.findById(skillId);
        if (optSkill.isPresent()) {
            Skill skill = (Skill) optSkill.get();
            model.addAttribute("skill", skill);
            return "skills/view";
        } else {
            return "redirect:../";
        }

    }

}

// 2.4.6. Test it with SQL (reference textbook and demo app again for this section)
