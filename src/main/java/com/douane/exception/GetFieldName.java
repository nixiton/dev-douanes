package com.douane.exception;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * Created by hasina on 10/28/17.
 */
public class GetFieldName {
    public String getFieldName(Method method)
    {
        try
        {
            Class<?> clazz=method.getDeclaringClass();
            BeanInfo info = Introspector.getBeanInfo(clazz);
            PropertyDescriptor[] props = info.getPropertyDescriptors();
            for (PropertyDescriptor pd : props)
            {
                if(method.equals(pd.getWriteMethod()) || method.equals(pd.getReadMethod()))
                {
                    System.out.println(pd.getDisplayName());
                    return pd.getName();
                }
            }
        }
        catch (IntrospectionException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        return null;
    }

}
