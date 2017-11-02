package com.douane.exception;

import org.apache.commons.lang.ObjectUtils;

import java.lang.reflect.Method;

/**
 * Created by hasina on 10/28/17.
 */
public class NullPointerAttributeException extends NullPointerException {
    private GetFieldName getFieldName;
    public NullPointerAttributeException(String message)
    {
        super(message);
    }
    public NullPointerAttributeException(String message, GetFieldName getFieldName,Method method)
    {
        super(getFieldName.getFieldName(method)+" must not be empty");
    }
}
