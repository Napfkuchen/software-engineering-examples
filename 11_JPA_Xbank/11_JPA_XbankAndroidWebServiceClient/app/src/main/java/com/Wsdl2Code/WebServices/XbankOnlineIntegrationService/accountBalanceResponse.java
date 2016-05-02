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
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import java.util.Hashtable;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

public class accountBalanceResponse implements KvmSerializable {
    
    public int accountId;
    public double balance;
    public boolean balanceSpecified;
    public String message;
    public int returnCodeField;
    
    public accountBalanceResponse(){}
    
    public accountBalanceResponse(SoapObject soapObject)
    {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("accountId"))
        {
            Object obj = soapObject.getProperty("accountId");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                accountId = Integer.parseInt(j.toString());
            }else if (obj!= null && obj instanceof Number){
                accountId = (Integer) obj;
            }
        }
        if (soapObject.hasProperty("balance"))
        {
            Object obj = soapObject.getProperty("balance");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                balance = Double.parseDouble(j.toString());
            }else if (obj!= null && obj instanceof Number){
                balance = (Double) obj;
            }
        }
        if (soapObject.hasProperty("balanceSpecified"))
        {
            Object obj = soapObject.getProperty("balanceSpecified");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                balanceSpecified = Boolean.parseBoolean(j.toString());
            }else if (obj!= null && obj instanceof Boolean){
                balanceSpecified = (Boolean) obj;
            }
        }
        if (soapObject.hasProperty("message"))
        {
            Object obj = soapObject.getProperty("message");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                message = j.toString();
            }else if (obj!= null && obj instanceof String){
                message = (String) obj;
            }
        }
        if (soapObject.hasProperty("returnCode"))
        {
            Object obj = soapObject.getProperty("returnCode");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                returnCodeField = Integer.parseInt(j.toString());
            }else if (obj!= null && obj instanceof Number){
                returnCodeField = (Integer) obj;
            }
        }
    }
    @Override
    public Object getProperty(int arg0) {
        switch(arg0){
            case 0:
                return accountId;
            case 1:
                return balance;
            case 2:
                return balanceSpecified;
            case 3:
                return message;
            case 4:
                return returnCodeField;
        }
        return null;
    }
    
    @Override
    public int getPropertyCount() {
        return 5;
    }
    
    @Override
    public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        switch(index){
            case 0:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "accountId";
                break;
            case 1:
                info.type = Double.class;
                info.name = "balance";
                break;
            case 2:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "balanceSpecified";
                break;
            case 3:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "message";
                break;
            case 4:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "returnCode";
                break;
        }
    }

    
    @Override
    public void setProperty(int arg0, Object arg1) {
    }
    
}
