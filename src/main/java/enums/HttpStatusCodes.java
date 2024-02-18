package enums;

import lombok.Getter;

@Getter
public enum HttpStatusCodes {
    OK(200);

    private final int statusCode;

    HttpStatusCodes(int statusCode) {
        this.statusCode = statusCode;
    }

}
