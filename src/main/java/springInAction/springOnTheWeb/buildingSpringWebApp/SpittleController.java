package springInAction.springOnTheWeb.buildingSpringWebApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by teodor.miu on 07-Jun-17.
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController {
    private static final String MAX_LONG_AS_STRING = Long.MAX_VALUE+"";

    private SpittleRepository repository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.repository = spittleRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String spittles(
            @RequestParam(value="max", defaultValue=MAX_LONG_AS_STRING) long max,
            @RequestParam(value="count", defaultValue="20") int count,
            Model model){
        model.addAttribute("spittlesList",repository.findSpittles(max, count));
        return "spittles";
    }
    @RequestMapping(method = RequestMethod.GET)
    public String showSpittle(
            @RequestParam("spittle_id") long spittleId, Model model){
        model.addAttribute(repository.findOne(spittleId));
        return  "spittle";
    }
}
