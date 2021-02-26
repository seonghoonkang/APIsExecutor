package sample.apis.vo;

import java.io.Serializable;

public class ResponseApiDataVo<T> implements Serializable {
    private T resultData;

    public T getResultData() {
        return resultData;
    }

    public void setResultData(T resultData) {
        this.resultData = resultData;
    }
}
