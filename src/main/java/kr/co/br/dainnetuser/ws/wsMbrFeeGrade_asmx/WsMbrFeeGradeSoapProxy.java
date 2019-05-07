package kr.co.br.dainnetuser.ws.wsMbrFeeGrade_asmx;

public class WsMbrFeeGradeSoapProxy implements kr.co.br.dainnetuser.ws.wsMbrFeeGrade_asmx.WsMbrFeeGradeSoap {
  private String _endpoint = null;
  private kr.co.br.dainnetuser.ws.wsMbrFeeGrade_asmx.WsMbrFeeGradeSoap wsMbrFeeGradeSoap = null;
  
  public WsMbrFeeGradeSoapProxy() {
    _initWsMbrFeeGradeSoapProxy();
  }
  
  public WsMbrFeeGradeSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initWsMbrFeeGradeSoapProxy();
  }
  
  private void _initWsMbrFeeGradeSoapProxy() {
    try {
      wsMbrFeeGradeSoap = (new kr.co.br.dainnetuser.ws.wsMbrFeeGrade_asmx.WsMbrFeeGradeLocator()).getwsMbrFeeGradeSoap();
      if (wsMbrFeeGradeSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wsMbrFeeGradeSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wsMbrFeeGradeSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wsMbrFeeGradeSoap != null)
      ((javax.xml.rpc.Stub)wsMbrFeeGradeSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public kr.co.br.dainnetuser.ws.wsMbrFeeGrade_asmx.WsMbrFeeGradeSoap getWsMbrFeeGradeSoap() {
    if (wsMbrFeeGradeSoap == null)
      _initWsMbrFeeGradeSoapProxy();
    return wsMbrFeeGradeSoap;
  }
  
  public kr.co.br.dainnetuser.ws.wsMbrFeeGrade_asmx.GetMbrFeeGradeForMagoDbResponseGetMbrFeeGradeForMagoDbResult getMbrFeeGradeForMagoDb(int uniqNo, java.lang.String mbrCd) throws java.rmi.RemoteException{
    if (wsMbrFeeGradeSoap == null)
      _initWsMbrFeeGradeSoapProxy();
    return wsMbrFeeGradeSoap.getMbrFeeGradeForMagoDb(uniqNo, mbrCd);
  }
  
  public kr.co.br.dainnetuser.ws.wsMbrFeeGrade_asmx.GetMbrBranchGradeForMagoDbResponseGetMbrBranchGradeForMagoDbResult getMbrBranchGradeForMagoDb(java.lang.String mbrNm, java.lang.String hp, java.lang.String socialNoF, java.lang.String mbrCd) throws java.rmi.RemoteException{
    if (wsMbrFeeGradeSoap == null)
      _initWsMbrFeeGradeSoapProxy();
    return wsMbrFeeGradeSoap.getMbrBranchGradeForMagoDb(mbrNm, hp, socialNoF, mbrCd);
  }
  
  
}