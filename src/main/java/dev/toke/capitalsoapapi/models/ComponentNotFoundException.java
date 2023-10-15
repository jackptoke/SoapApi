package dev.toke.capitalsoapapi.models;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CLIENT)
public class ComponentNotFoundException extends Exception {
    private static final long serialVersionUID = 3518170101751491969L;
    public ComponentNotFoundException(String s) {
        super(s);
    }
}
