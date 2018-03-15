package cn.abbenyyy.imitation_daily.vo;

import org.springframework.http.HttpStatus;

public class Result<T> {

    private final int status;

    private final String message;


    private final T data;

    public Result(T data, HttpStatus httpStatus) {
        this.data = data;
        this.status = httpStatus.value();
        this.message = httpStatus.getReasonPhrase();
    }

    public static <T> Result<T> ok(T data) {
        return new Result<>(data, HttpStatus.OK);
    }

    /**
     * 错误的请求，例如请求体格式不对
     *
     * @param <T>
     * @return
     */
    public static <T> Result<T> badRequest() {
        return new Result<>(null, HttpStatus.BAD_REQUEST);
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
