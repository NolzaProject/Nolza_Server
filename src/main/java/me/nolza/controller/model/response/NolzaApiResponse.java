package me.nolza.controller.model.response;

/**
 * Created by gain on 2017. 8. 7..
 */
public class NolzaApiResponse<T> {
    public static final Integer OK = 200;

    public static final Integer INVALID_USERPASSWORD = 1002;
    public static final Integer INVALID_COOKIE = 1003;
    public static final Integer DUPLICATE_PATH = 1004;

    public static final Integer EXCEPTION = 3001;
    public static final Integer NOT_FOUND = 3002;
    public static final Integer INVALID_STATUS = 3003;

    private Integer code;
    private T result;

    public NolzaApiResponse() {
        this.code = OK;
    }

    public NolzaApiResponse(Integer code) {
        this.code = code;
    }

    public NolzaApiResponse(T result) {
        this.code = OK;
        this.result = result;
    }

    public NolzaApiResponse(Integer code, T result) {
        this.code = code;
        this.result = result;
    }

    public Integer getCode() {
        return code;
    }

    public T getResult() {
        return result;
    }
}
