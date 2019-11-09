/**
 * Business.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package src;

public interface Business extends java.rmi.Remote {
    public src.Item[] lista_Productos() throws java.rmi.RemoteException, src.Exception;
    public java.lang.String registro_Producto(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws java.rmi.RemoteException;
    public java.lang.String registro_Venta(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
}
