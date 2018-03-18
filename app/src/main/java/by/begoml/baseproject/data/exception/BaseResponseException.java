package by.begoml.baseproject.data.exception;

import java.io.IOException;

/**
 * Created by ilinich on 18.03.2018.
 */

public class BaseResponseException extends IOException {

    public static final int ERR_CONNECT_CODE = 10000001;
    public static final int ERR_CONNECT_TIME_OUT_CODE = 10000002;
    public static final int ERR_CONNECT_NO_DATA = 10000003;
    public static final int ERR_INTERNAL_SERVER = 10000004;

    private int errCode;

    public BaseResponseException( ) {

    }

    public BaseResponseException(int errCode) {
        this.errCode = errCode;
    }

    public int getErrCode() {
        return errCode;
    }
}
