package springInAction.springOnTheWeb.buildingSpringWebApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by teodor.miu on 07-Jun-17.
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController {
    private SpittleRepository repository;

//    @Autowired
//    public SpittleController(SpittleRepository spittleRepository){
//        this.repository = spittleRepository;
//    }

    @RequestMapping(method = RequestMethod.GET)
    public String spittles(Model model){

        List<Spittle> spittles= new ArrayList<Spittle>();
        spittles.add(new Spittle("Spittle ",new Date()));
        spittles.add(new Spittle("Spittle ",new Date()));
        spittles.add(new Spittle("Spittle ",new Date()));
//        model.addAttribute(repository.findSpittles(Long.MAX_VALUE,20));
        model.addAttribute("spittles",spittles);
        return "spittles";
    }
}
