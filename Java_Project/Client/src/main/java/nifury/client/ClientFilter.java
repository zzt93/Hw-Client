package nifury.client;

/**
 * Created by Nifury on 2014/10/20.
 */
public class ClientFilter {

    private String key;
    private Object value;

    public ClientFilter(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

}
