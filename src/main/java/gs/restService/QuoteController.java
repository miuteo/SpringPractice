package gs.restService;

import gs.consumingRest.Quote;
import gs.consumingRest.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by teodor.miu on 18-May-17.
 */
@RestController
public class QuoteController {
    @RequestMapping("getQoute")
    Quote[] getQuote(){

        Quote quote = new Quote();
        quote.setType("success");
        Value v= new Value();
        v.setId(7L);
        v.setQuote("The real benefit of Boot, however, is that it's just Spring. That means any direction the code takes, regardless of complexity, I know it's a safe bet.");
        quote.setValue(v);

        Quote[] quotes = {quote,quote};
        return quotes;

    }
}
