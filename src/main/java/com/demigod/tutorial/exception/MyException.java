package com.demigod.tutorial.exception;

import org.apache.logging.log4j.spi.StandardLevel;

import java.util.HashMap;
import java.util.Map;

/**
 * @author TejasS
 */
public class MyException extends RuntimeException {

    private static final long serialVersionUID = -5885089947801670586L;
    private String errorCode;
    private String errorMessage;
    private Map<String, String> errorDataMap;
    private transient Object[] errorMessageParams;
    private StandardLevel level;

    public MyException(String errorCode, StandardLevel level) {
        super("");
        this.errorCode = errorCode;
        this.level = level;
    }

    public MyException(String errorCode, String errorMessage, StandardLevel level) {
        super("");
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.level = level;
    }

    public MyException(String errorCode, Map<String, String> errorDataMap, StandardLevel level) {
        super("");
        this.errorCode = errorCode;
        this.errorDataMap = errorDataMap;
        this.level = level;
    }

    public MyException(String errorCode, Object[] errorMessageParams, String defaultErrorMessage, StandardLevel level) {
        super(defaultErrorMessage);
        this.errorCode = errorCode;
        this.errorMessage = defaultErrorMessage;
        this.errorMessageParams = errorMessageParams;
        this.level = level;

    }

    public MyException(String errorCode, Exception ex, StandardLevel level) {
        super(errorCode);
        this.errorCode = errorCode;
        this.addSuppressed(ex);
        this.errorMessage = ex.getLocalizedMessage();
        this.level = level;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Object[] getErrorMessageParams() {
        return errorMessageParams;
    }

    public void setErrorMessageParams(Object[] errorMessageParams) {
        this.errorMessageParams = errorMessageParams;
    }

    public Map<String, String> getErrorDataMap() {
        if (errorDataMap == null) {
            errorDataMap = new HashMap<>();
        }
        return errorDataMap;
    }

    public void setErrorDataMap(Map<String, String> errorDataMap) {
        this.errorDataMap = errorDataMap;
    }

    public StandardLevel getLevel() {
        return level;
    }

    public void setLevel(StandardLevel level) {
        this.level = level;
    }

}
