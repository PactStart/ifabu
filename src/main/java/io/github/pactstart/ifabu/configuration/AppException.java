package io.github.pactstart.ifabu.configuration;

import io.github.pactstart.ifabu.errorcode.ResponseCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AppException extends RuntimeException {

    private ResponseCode responseCode;

}
