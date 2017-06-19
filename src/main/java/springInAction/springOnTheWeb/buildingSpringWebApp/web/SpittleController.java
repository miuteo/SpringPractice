package springInAction.springOnTheWeb.buildingSpringWebApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springInAction.springOnTheWeb.buildingSpringWebApp.data.Spittle;
import springInAction.springOnTheWeb.buildingSpringWebApp.data.SpittleRepository;

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
    public List<Spittle> spittles(
            @RequestParam(value="max", defaultValue=MAX_LONG_AS_STRING) long max,
            @RequestParam(value="count", defaultValue="20") int count){
//        model.addAttribute("spittlesList",repository.findSpittles(max, count));
        return repository.findSpittles(max, count);
    }
    @RequestMapping(value = "/show",method = RequestMethod.GET)
    public String showSpittle(
            @RequestParam("spittle_id") long spittleId, Model model){
        model.addAttribute(repository.findOne(spittleId));
        return  "spittle";
    }

    @RequestMapping(value="/{spittleId}",method = RequestMethod.GET)
    public String spittle(@PathVariable("spittleId") long spittleId, Model model){
        Spittle spittle = repository.findOne(spittleId);
        if(spittle == null){
            throw new SpittleNotFoundException();
        }
        model.addAttribute(spittle);

        return "spittle";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String saveSpittle(SpittleForm form,Model model){
        try{
            repository.save(new Spittle(form.getMessage(),new Date(),
                    form.getLongitude(),form.getLatitude()));
            return "redirect:/spittles";
        }catch (Exception e){
            return "error/duplicate";
        }
    }

    @ExceptionHandler(DuplicateSpittleException.class)
    public String handleNotFound() {
        return "error/duplicate";
    }


}
