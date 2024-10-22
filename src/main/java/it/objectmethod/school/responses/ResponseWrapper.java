package it.objectmethod.school.responses;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResponseWrapper<TYPE> {
    private String msg;
    private TYPE type;

    public ResponseWrapper(String msg) {
        this.msg = msg;
    }

    public ResponseWrapper(String msg, TYPE type) {
        this.msg = msg;
        this.type = type;
    }
}
