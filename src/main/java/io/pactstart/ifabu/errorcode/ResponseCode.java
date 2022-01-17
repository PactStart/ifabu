package io.pactstart.ifabu.errorcode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseCode<T> {

    private int code;

    private String msg;

    private T data;

    public static final ResponseCode SUCCESS = new ResponseCode(0,"success");

    public static final ResponseCode EMAIL_NOT_EXIST = new ResponseCode(1001,"邮箱不存在");
    public static final ResponseCode PASSWORD_ERROR = new ResponseCode(1002,"密码错误");
    public static final ResponseCode EMAIL_EXIST = new ResponseCode(1001,"邮箱已存在");

    public ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
