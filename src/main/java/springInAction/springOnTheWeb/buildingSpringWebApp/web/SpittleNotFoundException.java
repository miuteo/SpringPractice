package springInAction.springOnTheWeb.buildingSpringWebApp.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Asus x556 on 19-Jun-17.
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Spittle Not Found")
public class SpittleNotFoundException extends RuntimeException {

}
