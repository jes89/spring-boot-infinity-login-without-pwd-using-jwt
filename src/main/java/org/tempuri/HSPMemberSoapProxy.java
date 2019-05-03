package org.tempuri;

public class HSPMemberSoapProxy implements org.tempuri.HSPMemberSoap {
  private String _endpoint = null;
  private org.tempuri.HSPMemberSoap hSPMemberSoap = null;
  
  public HSPMemberSoapProxy() {
    _initHSPMemberSoapProxy();
  }
  
  public HSPMemberSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initHSPMemberSoapProxy();
  }
  
  private void _initHSPMemberSoapProxy() {
    try {
      hSPMemberSoap = (new org.tempuri.HSPMemberLocator()).getHSPMemberSoap();
      if (hSPMemberSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)hSPMemberSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)hSPMemberSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (hSPMemberSoap != null)
      ((javax.xml.rpc.Stub)hSPMemberSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.tempuri.HSPMemberSoap getHSPMemberSoap() {
    if (hSPMemberSoap == null)
      _initHSPMemberSoapProxy();
    return hSPMemberSoap;
  }
  
  public org.tempuri.MemberInfo getTotaluser(java.lang.String userid) throws java.rmi.RemoteException{
    if (hSPMemberSoap == null)
      _initHSPMemberSoapProxy();
    return hSPMemberSoap.getTotaluser(userid);
  }
  
  public int setTotaluser_Pwd_Update(java.lang.String userid, java.lang.String pwd) throws java.rmi.RemoteException{
    if (hSPMemberSoap == null)
      _initHSPMemberSoapProxy();
    return hSPMemberSoap.setTotaluser_Pwd_Update(userid, pwd);
  }
  
  public int setUserUpdateHistory(org.tempuri.MemberInfo info, java.lang.String site, java.lang.String writerID) throws java.rmi.RemoteException{
    if (hSPMemberSoap == null)
      _initHSPMemberSoapProxy();
    return hSPMemberSoap.setUserUpdateHistory(info, site, writerID);
  }
  
  public int setUserUpdateHistory_Pwd(java.lang.String userid, java.lang.String site, java.lang.String writerID) throws java.rmi.RemoteException{
    if (hSPMemberSoap == null)
      _initHSPMemberSoapProxy();
    return hSPMemberSoap.setUserUpdateHistory_Pwd(userid, site, writerID);
  }
  
  public org.tempuri.MemberInfo getTotaluser_UserIdandUserNm(java.lang.String userId, java.lang.String userNm) throws java.rmi.RemoteException{
    if (hSPMemberSoap == null)
      _initHSPMemberSoapProxy();
    return hSPMemberSoap.getTotaluser_UserIdandUserNm(userId, userNm);
  }
  
  public org.tempuri.MemberInfo getTotaluser_UserNmandEmail(java.lang.String userNm, java.lang.String email) throws java.rmi.RemoteException{
    if (hSPMemberSoap == null)
      _initHSPMemberSoapProxy();
    return hSPMemberSoap.getTotaluser_UserNmandEmail(userNm, email);
  }
  
  public org.tempuri.MemberInfo getTotaluser_UserNmandHP(java.lang.String userNm, java.lang.String HP) throws java.rmi.RemoteException{
    if (hSPMemberSoap == null)
      _initHSPMemberSoapProxy();
    return hSPMemberSoap.getTotaluser_UserNmandHP(userNm, HP);
  }
  
  public org.tempuri.MemberInfo getTotaluser_UserNmandBirthDayandSex(java.lang.String userNm, java.lang.String birt, java.lang.String sex) throws java.rmi.RemoteException{
    if (hSPMemberSoap == null)
      _initHSPMemberSoapProxy();
    return hSPMemberSoap.getTotaluser_UserNmandBirthDayandSex(userNm, birt, sex);
  }
  
  public org.tempuri.MemberInfo getTotaluser_UserIdandUserNmandBirthDayandSex(java.lang.String userId, java.lang.String userNm, java.lang.String birthDay, java.lang.String sex) throws java.rmi.RemoteException{
    if (hSPMemberSoap == null)
      _initHSPMemberSoapProxy();
    return hSPMemberSoap.getTotaluser_UserIdandUserNmandBirthDayandSex(userId, userNm, birthDay, sex);
  }
  
  public org.tempuri.SetTotaluserResponseSetTotaluserResult setTotaluser(org.tempuri.MemberInfo info) throws java.rmi.RemoteException{
    if (hSPMemberSoap == null)
      _initHSPMemberSoapProxy();
    return hSPMemberSoap.setTotaluser(info);
  }
  
  public int setTotaluser_Update(org.tempuri.MemberInfo info) throws java.rmi.RemoteException{
    if (hSPMemberSoap == null)
      _initHSPMemberSoapProxy();
    return hSPMemberSoap.setTotaluser_Update(info);
  }
  
  public java.lang.String setTotaluser_Sex(org.tempuri.MemberInfo info) throws java.rmi.RemoteException{
    if (hSPMemberSoap == null)
      _initHSPMemberSoapProxy();
    return hSPMemberSoap.setTotaluser_Sex(info);
  }
  
  public void setTotaluser_LeaveALL(java.lang.String userid, java.lang.String closeReason) throws java.rmi.RemoteException{
    if (hSPMemberSoap == null)
      _initHSPMemberSoapProxy();
    hSPMemberSoap.setTotaluser_LeaveALL(userid, closeReason);
  }
  
  public int setUserSiteChk_Del(java.lang.String userid, java.lang.String siteType) throws java.rmi.RemoteException{
    if (hSPMemberSoap == null)
      _initHSPMemberSoapProxy();
    return hSPMemberSoap.setUserSiteChk_Del(userid, siteType);
  }
  
  public java.lang.String setUserSiteChk(java.lang.String userid, java.lang.String site) throws java.rmi.RemoteException{
    if (hSPMemberSoap == null)
      _initHSPMemberSoapProxy();
    return hSPMemberSoap.setUserSiteChk(userid, site);
  }
  
  public java.lang.String setUserRestore(java.lang.String userid, java.lang.String site) throws java.rmi.RemoteException{
    if (hSPMemberSoap == null)
      _initHSPMemberSoapProxy();
    return hSPMemberSoap.setUserRestore(userid, site);
  }
  
  public void setRecommNodeCd(java.lang.String nodeCd, java.lang.String site, java.lang.String userId) throws java.rmi.RemoteException{
    if (hSPMemberSoap == null)
      _initHSPMemberSoapProxy();
    hSPMemberSoap.setRecommNodeCd(nodeCd, site, userId);
  }
  
  public boolean getUserSiteChk_UseridandSite(java.lang.String userid, java.lang.String site) throws java.rmi.RemoteException{
    if (hSPMemberSoap == null)
      _initHSPMemberSoapProxy();
    return hSPMemberSoap.getUserSiteChk_UseridandSite(userid, site);
  }
  
  public org.tempuri.GetUserSiteChkResponseGetUserSiteChkResult getUserSiteChk(java.lang.String userid) throws java.rmi.RemoteException{
    if (hSPMemberSoap == null)
      _initHSPMemberSoapProxy();
    return hSPMemberSoap.getUserSiteChk(userid);
  }
  
  public org.tempuri.GetCheckLoginResponseGetCheckLoginResult getCheckLogin(java.lang.String userid, java.lang.String pwd) throws java.rmi.RemoteException{
    if (hSPMemberSoap == null)
      _initHSPMemberSoapProxy();
    return hSPMemberSoap.getCheckLogin(userid, pwd);
  }
  
  public org.tempuri.GetMemberManageResponseGetMemberManageResult getMemberManage(java.lang.String userid) throws java.rmi.RemoteException{
    if (hSPMemberSoap == null)
      _initHSPMemberSoapProxy();
    return hSPMemberSoap.getMemberManage(userid);
  }
  
  public org.tempuri.GetEarthCitizenMemberResponseGetEarthCitizenMemberResult getEarthCitizenMember() throws java.rmi.RemoteException{
    if (hSPMemberSoap == null)
      _initHSPMemberSoapProxy();
    return hSPMemberSoap.getEarthCitizenMember();
  }
  
  public org.tempuri.GetTermsResponseGetTermsResult getTerms(java.lang.String site, java.lang.String termsType) throws java.rmi.RemoteException{
    if (hSPMemberSoap == null)
      _initHSPMemberSoapProxy();
    return hSPMemberSoap.getTerms(site, termsType);
  }
  
  public void dormancyPreventionPeiodSet(java.lang.String userId, int dormancyPeriod) throws java.rmi.RemoteException{
    if (hSPMemberSoap == null)
      _initHSPMemberSoapProxy();
    hSPMemberSoap.dormancyPreventionPeiodSet(userId, dormancyPeriod);
  }
  
  public java.lang.String getBrainWorldFreePass() throws java.rmi.RemoteException{
    if (hSPMemberSoap == null)
      _initHSPMemberSoapProxy();
    return hSPMemberSoap.getBrainWorldFreePass();
  }
  
  
}