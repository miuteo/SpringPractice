package gs.consumingRest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Asus x556 on 16-May-17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {
    @JsonProperty("type")
    private String type;
    private Value value;

    public Quote(){}


    public String getType() {
        return type;
    }

    public void setType(String tye) {
        this.type = tye;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "type='" + type + '\'' +
                ", value=" + value +
                '}';
    }
}
