package src;

public class BusinessProxy implements src.Business {
  private String _endpoint = null;
  private src.Business business = null;
  
  public BusinessProxy() {
    _initBusinessProxy();
  }
  
  public BusinessProxy(String endpoint) {
    _endpoint = endpoint;
    _initBusinessProxy();
  }
  
  private void _initBusinessProxy() {
    try {
      business = (new src.BusinessServiceLocator()).getBusinessPort();
      if (business != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)business)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)business)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (business != null)
      ((javax.xml.rpc.Stub)business)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public src.Business getBusiness() {
    if (business == null)
      _initBusinessProxy();
    return business;
  }
  
  public src.Item[] lista_Productos() throws java.rmi.RemoteException, src.Exception{
    if (business == null)
      _initBusinessProxy();
    return business.lista_Productos();
  }
  
  public java.lang.String registro_Producto(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws java.rmi.RemoteException{
    if (business == null)
      _initBusinessProxy();
    return business.registro_Producto(arg0, arg1, arg2, arg3);
  }
  
  public java.lang.String registro_Venta(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (business == null)
      _initBusinessProxy();
    return business.registro_Venta(arg0, arg1);
  }
  
  
}