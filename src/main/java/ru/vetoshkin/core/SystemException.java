package ru.vetoshkin.core;
/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class SystemException extends Exception {


    private static final long serialVersionUID = -7136669172549011651L;
    

    public SystemException() {
        super();
    }


    public SystemException(String message) {
        super(message);
    }


    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }


    public SystemException(Throwable cause) {
        super(cause);
    }


    protected SystemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
