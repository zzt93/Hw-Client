package po;

import java.io.Serializable;

/**
 * Created by Nifury on 2014/10/20.
 */
public class ClientFilter implements Serializable {

    private static final long serialVersionUID = -7578752942546666997L;
    private final String key;
    private final Object value;

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
