package cn.abbenyyy.imitation_daily.vo;

import static cn.abbenyyy.imitation_daily.vo.Status.ERROR;
import static cn.abbenyyy.imitation_daily.vo.Status.SUCCESS;

public class Result<T> {

    private final Status status;

    private final String message;


    private final T data;

    public Result(Status status, T data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(SUCCESS, data, null);
    }

    public static <T> Result<T> error(String msg, T data) {
        return new Result<>(ERROR, data, msg);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Result<?> result = (Result<?>) o;

        if (status != result.status) {
            return false;
        }
        if (message != null ? !message.equals(result.message) : result.message != null) {
            return false;
        }
        return data != null ? data.equals(result.data) : result.data == null;
    }

    @Override
    public int hashCode() {
        int result = status.hashCode();
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Result{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
