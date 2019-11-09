/**
 * BusinessService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package src;

public interface BusinessService extends javax.xml.rpc.Service {
    public java.lang.String getBusinessPortAddress();

    public src.Business getBusinessPort() throws javax.xml.rpc.ServiceException;

    public src.Business getBusinessPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
