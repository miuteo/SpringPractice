package gs.servingWebContent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by teodor.miu on 06-Jun-17.
 */
@Controller
public class GreetingController {
    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name",required = false,defaultValue = "World")String name,Model model){
        model.addAttribute(name);
        return "gs/servingWebContent/greeting";
    }
}
