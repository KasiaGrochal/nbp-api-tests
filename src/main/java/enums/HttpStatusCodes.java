package enums;

import lombok.Getter;

public enum HttpStatusCodes {
    OK(200);

    @Getter
    private int statusCode;


    HttpStatusCodes(int statusCode) {
        this.statusCode = statusCode;
    }

}
