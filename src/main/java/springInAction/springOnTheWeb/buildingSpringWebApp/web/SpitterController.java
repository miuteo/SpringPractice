package springInAction.springOnTheWeb.buildingSpringWebApp.web;

import javafx.beans.NamedArg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import springInAction.springOnTheWeb.buildingSpringWebApp.data.Spitter;
import springInAction.springOnTheWeb.buildingSpringWebApp.data.SpitterRepository;
import java.io.File;
import java.io.IOException;

import javax.validation.Valid;

/**
 * Created by Asus x556 on 11-Jun-17.
 */
@Controller
@RequestMapping("/spitter")
public class SpitterController {
    SpitterRepository repository;

    @Autowired
    public SpitterController(SpitterRepository repository){
        this.repository=repository;
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String showRegistrationForm(Model model){
        model.addAttribute(new SpitterForm());
        return "registerForm";
    }

//    @RequestMapping(value="/register",method = RequestMethod.POST)
//    public String processRegistration(@Valid Spitter spitter, Errors errors){
//        if(errors.hasErrors()){
//            return "registerForm";
//        }
//        repository.save(spitter);
//        return "redirect:/spitter/"+spitter.getUsername()+"/";
//    }
@RequestMapping(value="/register",method = RequestMethod.POST)
public String processRegistration(@Valid  SpitterForm spitterForm, Errors errors) throws IllegalStateException,IOException {

        if(errors.hasErrors()){
//        model.addAttribute(new Spitter());
//        model.addAttribute("spitter",spitterForm);
//        model.addAttribute("fields",errors);
        return "registerForm";
    }
    Spitter spitter = spitterForm.toSpitter();
    repository.save(spitter);
    MultipartFile profilePicture = spitterForm.getProfilePicture();
    profilePicture.transferTo(new File("/tmp/spittr/"+spitter.getUsername()+".jpg"));
    return "redirect:/spitter/"+spitter.getUsername()+"/";
}
    @RequestMapping(value="/{username}")
    public String showSpitterProfile(@PathVariable("username")String username,Model model){
        if(!model.containsAttribute("spitter")){
            Spitter spitter = repository.findByUsername(username);
            model.addAttribute(spitter);
        }
        return "profile";
    }

}
