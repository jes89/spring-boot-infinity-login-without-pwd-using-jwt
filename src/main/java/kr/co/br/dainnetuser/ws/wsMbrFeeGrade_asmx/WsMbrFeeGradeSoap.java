/**
 * WsMbrFeeGradeSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.co.br.dainnetuser.ws.wsMbrFeeGrade_asmx;

public interface WsMbrFeeGradeSoap extends java.rmi.Remote {

    /**
     * 생명전자TV연동용 회원 회비정보 조회
     */
    public kr.co.br.dainnetuser.ws.wsMbrFeeGrade_asmx.GetMbrFeeGradeForMagoDbResponseGetMbrFeeGradeForMagoDbResult getMbrFeeGradeForMagoDb(int uniqNo, java.lang.String mbrCd) throws java.rmi.RemoteException;

    /**
     * 생명전자TV에서 다인넷 회원의 소속과 급수를 알고자 할때
     */
    public kr.co.br.dainnetuser.ws.wsMbrFeeGrade_asmx.GetMbrBranchGradeForMagoDbResponseGetMbrBranchGradeForMagoDbResult getMbrBranchGradeForMagoDb(java.lang.String mbrNm, java.lang.String hp, java.lang.String socialNoF, java.lang.String mbrCd) throws java.rmi.RemoteException;
}
