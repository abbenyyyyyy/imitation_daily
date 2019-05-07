package cn.abbenyyy.imitation_daily.vo;

import org.springframework.http.HttpStatus;

public class Result<T> {

    private final int status;

    private final String message;

    private final T data;

    private final Boolean next;

    private Result(T data, HttpStatus httpStatus, Boolean next) {
        this.data = data;
        this.status = httpStatus.value();
        this.message = httpStatus.getReasonPhrase();
        this.next = next;
    }

    public static <T> Result<T> ok(T data) {
        return new Result<>(data, HttpStatus.OK, null);
    }

    public static <T> Result<T> okWithNext(T data,Boolean next) {
        return new Result<>(data, HttpStatus.OK, next);
    }

    /**
     * 错误的请求，例如请求体格式不对
     */
    public static <T> Result<T> badRequest() {
        return new Result<>(null, HttpStatus.BAD_REQUEST, null);
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

    public Boolean getNext() {
        return next;
    }
}
