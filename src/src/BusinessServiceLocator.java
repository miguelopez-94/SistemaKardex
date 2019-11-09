/**
 * BusinessServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package src;

public class BusinessServiceLocator extends org.apache.axis.client.Service implements src.BusinessService {

    public BusinessServiceLocator() {
    }


    public BusinessServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BusinessServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BusinessPort
    private java.lang.String BusinessPort_address = "http://localhost:8080/ServicesKardex/Business";

    public java.lang.String getBusinessPortAddress() {
        return BusinessPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BusinessPortWSDDServiceName = "BusinessPort";

    public java.lang.String getBusinessPortWSDDServiceName() {
        return BusinessPortWSDDServiceName;
    }

    public void setBusinessPortWSDDServiceName(java.lang.String name) {
        BusinessPortWSDDServiceName = name;
    }

    public src.Business getBusinessPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BusinessPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBusinessPort(endpoint);
    }

    public src.Business getBusinessPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            src.BusinessServiceSoapBindingStub _stub = new src.BusinessServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getBusinessPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBusinessPortEndpointAddress(java.lang.String address) {
        BusinessPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (src.Business.class.isAssignableFrom(serviceEndpointInterface)) {
                src.BusinessServiceSoapBindingStub _stub = new src.BusinessServiceSoapBindingStub(new java.net.URL(BusinessPort_address), this);
                _stub.setPortName(getBusinessPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("BusinessPort".equals(inputPortName)) {
            return getBusinessPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://src/", "BusinessService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://src/", "BusinessPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BusinessPort".equals(portName)) {
            setBusinessPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
