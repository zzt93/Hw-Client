package po;

import java.io.Serializable;

/**
 * Created by Nifury on 2014/10/25.
 */
public class ResultMessage<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    private String errMessage;
    private T obj;
    @SuppressWarnings("unchecked")
    public static final ResultMessage noErr = new ResultMessage(null, null);

    public ResultMessage(String errMessage, T obj) {
        this.errMessage = errMessage;
        this.obj = obj;
    }

    public void throwIfFailed() throws Exception {
        if (errMessage != null)
            throw new Exception(errMessage);
    }

    public String getErrMessage() {
        return errMessage;
    }

    public T getObj() {
        return obj;
    }
}