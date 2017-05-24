package springInAction.coreSpring.wiringBeans.automaticallyWiringBeans;

import org.springframework.stereotype.Component;


/**
 * Created by Asus x556 on 24-May-17.
 */
@Component("lonelyHeartsClub")
public class SgtPeppers implements CompactDisc {
    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    public void play(){
        System.out.println("Playing "+ title + " by " + artist);
    }

}
