package springInAction.springOnTheWeb.buildingSpringWebApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Asus x556 on 11-Jun-17.
 */
@Controller
@RequestMapping("/spitter")
public class SpitterController {
    SpitterRepository repository;

    @Autowired
    SpitterController(SpitterRepository repository){
        this.repository=repository;
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String showRegistrationForm(){
        return "registerForm";
    }

    @RequestMapping(value="/register",method = RequestMethod.POST)
    public String processRegistration(Spitter spitter){
        repository.save(spitter);
        return "redirect:/spitter/"+spitter.getUsername()+"/";
    }
    @RequestMapping(value="/{username}")
    public String showSpitterProfile(@PathVariable("username")String username,Model model){
        Spitter spitter = repository.findByUsername(username);
        model.addAttribute(spitter);
        return "profile";
    }

}