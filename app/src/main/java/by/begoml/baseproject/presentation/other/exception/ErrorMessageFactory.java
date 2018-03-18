package by.begoml.baseproject.presentation.other.exception;

import by.begoml.baseproject.data.exception.NoConnectionException;

/**
 * Created by ilinich on 18.03.2018.
 */

public class ErrorMessageFactory {

    public static String create( Throwable throwable) {
        if (throwable instanceof NoConnectionException){
            return "Отсутствует интернет соединение";
        }else {
            return "Произошла непредвиденная ошибка";
        }
    }
}
