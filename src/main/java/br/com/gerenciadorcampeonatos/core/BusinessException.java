package br.com.gerenciadorcampeonatos.core;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class BusinessException extends Exception {

    public BusinessException(Throwable throwable) {
        super(throwable);
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
