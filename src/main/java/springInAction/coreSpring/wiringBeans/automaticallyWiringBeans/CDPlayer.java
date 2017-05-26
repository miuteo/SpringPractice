package springInAction.coreSpring.wiringBeans.automaticallyWiringBeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by teodor.miu on 25-May-17.
 */
@Component
public class CDPlayer implements MediaPlayer {
    private CompactDisc cd;

    @Autowired
    public CDPlayer(CompactDisc cd){
        this.cd = cd;
    }

    @Autowired(required=false)
    public void setCompactDisc(CompactDisc cd) {this.cd = cd;}

    @Autowired
    public void insertDisc(CompactDisc cd) {this.cd = cd;
    }

    @Override
    public void play() {
        cd.play();
    }
}
