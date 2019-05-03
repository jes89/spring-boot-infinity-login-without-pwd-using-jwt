/**
 * HSPMemberSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public interface HSPMemberSoap extends java.rmi.Remote {
    public org.tempuri.MemberInfo getTotaluser(java.lang.String userid) throws java.rmi.RemoteException;
    public int setTotaluser_Pwd_Update(java.lang.String userid, java.lang.String pwd) throws java.rmi.RemoteException;
    public int setUserUpdateHistory(org.tempuri.MemberInfo info, java.lang.String site, java.lang.String writerID) throws java.rmi.RemoteException;
    public int setUserUpdateHistory_Pwd(java.lang.String userid, java.lang.String site, java.lang.String writerID) throws java.rmi.RemoteException;
    public org.tempuri.MemberInfo getTotaluser_UserIdandUserNm(java.lang.String userId, java.lang.String userNm) throws java.rmi.RemoteException;
    public org.tempuri.MemberInfo getTotaluser_UserNmandEmail(java.lang.String userNm, java.lang.String email) throws java.rmi.RemoteException;
    public org.tempuri.MemberInfo getTotaluser_UserNmandHP(java.lang.String userNm, java.lang.String HP) throws java.rmi.RemoteException;
    public org.tempuri.MemberInfo getTotaluser_UserNmandBirthDayandSex(java.lang.String userNm, java.lang.String birt, java.lang.String sex) throws java.rmi.RemoteException;
    public org.tempuri.MemberInfo getTotaluser_UserIdandUserNmandBirthDayandSex(java.lang.String userId, java.lang.String userNm, java.lang.String birthDay, java.lang.String sex) throws java.rmi.RemoteException;
    public org.tempuri.SetTotaluserResponseSetTotaluserResult setTotaluser(org.tempuri.MemberInfo info) throws java.rmi.RemoteException;
    public int setTotaluser_Update(org.tempuri.MemberInfo info) throws java.rmi.RemoteException;
    public java.lang.String setTotaluser_Sex(org.tempuri.MemberInfo info) throws java.rmi.RemoteException;
    public void setTotaluser_LeaveALL(java.lang.String userid, java.lang.String closeReason) throws java.rmi.RemoteException;
    public int setUserSiteChk_Del(java.lang.String userid, java.lang.String siteType) throws java.rmi.RemoteException;
    public java.lang.String setUserSiteChk(java.lang.String userid, java.lang.String site) throws java.rmi.RemoteException;
    public java.lang.String setUserRestore(java.lang.String userid, java.lang.String site) throws java.rmi.RemoteException;
    public void setRecommNodeCd(java.lang.String nodeCd, java.lang.String site, java.lang.String userId) throws java.rmi.RemoteException;
    public boolean getUserSiteChk_UseridandSite(java.lang.String userid, java.lang.String site) throws java.rmi.RemoteException;
    public org.tempuri.GetUserSiteChkResponseGetUserSiteChkResult getUserSiteChk(java.lang.String userid) throws java.rmi.RemoteException;
    public org.tempuri.GetCheckLoginResponseGetCheckLoginResult getCheckLogin(java.lang.String userid, java.lang.String pwd) throws java.rmi.RemoteException;
    public org.tempuri.GetMemberManageResponseGetMemberManageResult getMemberManage(java.lang.String userid) throws java.rmi.RemoteException;
    public org.tempuri.GetEarthCitizenMemberResponseGetEarthCitizenMemberResult getEarthCitizenMember() throws java.rmi.RemoteException;
    public org.tempuri.GetTermsResponseGetTermsResult getTerms(java.lang.String site, java.lang.String termsType) throws java.rmi.RemoteException;
    public void dormancyPreventionPeiodSet(java.lang.String userId, int dormancyPeriod) throws java.rmi.RemoteException;
    public java.lang.String getBrainWorldFreePass() throws java.rmi.RemoteException;
}
