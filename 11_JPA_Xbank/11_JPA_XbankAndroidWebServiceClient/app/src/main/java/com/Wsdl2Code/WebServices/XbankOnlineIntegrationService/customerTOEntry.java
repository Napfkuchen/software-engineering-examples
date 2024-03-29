package com.Wsdl2Code.WebServices.XbankOnlineIntegrationService;

//------------------------------------------------------------------------------
// <wsdl2code-generated>
//    This code was generated by http://www.wsdl2code.com version  2.6
//
// Date Of Creation: 4/30/2016 1:10:31 AM
//    Please dont change this code, regeneration will override your changes
//</wsdl2code-generated>
//
//------------------------------------------------------------------------------
//
//This source code was auto-generated by Wsdl2Code  Version
//
import com.Wsdl2Code.WebServices.XbankOnlineIntegrationService.account;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import java.util.Hashtable;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

public class customerTOEntry implements KvmSerializable {
    
    public int key;
    public boolean keySpecified;
    public account value;
    
    public customerTOEntry(){}
    
    public customerTOEntry(SoapObject soapObject)
    {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("key"))
        {
            Object obj = soapObject.getProperty("key");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                key = Integer.parseInt(j.toString());
            }else if (obj!= null && obj instanceof Number){
                key = (Integer) obj;
            }
        }
        if (soapObject.hasProperty("keySpecified"))
        {
            Object obj = soapObject.getProperty("keySpecified");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                keySpecified = Boolean.parseBoolean(j.toString());
            }else if (obj!= null && obj instanceof Boolean){
                keySpecified = (Boolean) obj;
            }
        }
        if (soapObject.hasProperty("value"))
        {
            SoapObject j = (SoapObject)soapObject.getProperty("value");
            value =  new account (j);
            
        }
    }
    @Override
    public Object getProperty(int arg0) {
        switch(arg0){
            case 0:
                return key;
            case 1:
                return keySpecified;
            case 2:
                return value;
        }
        return null;
    }
    
    @Override
    public int getPropertyCount() {
        return 3;
    }
    
    @Override
    public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        switch(index){
            case 0:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "key";
                break;
            case 1:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "keySpecified";
                break;
            case 2:
                info.type = account.class;
                info.name = "value";
                break;
        }
    }
    

    @Override
    public void setProperty(int arg0, Object arg1) {
    }
    
}
