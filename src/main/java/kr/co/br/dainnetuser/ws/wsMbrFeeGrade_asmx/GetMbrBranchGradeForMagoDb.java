/**
 * GetMbrBranchGradeForMagoDb.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.co.br.dainnetuser.ws.wsMbrFeeGrade_asmx;

public class GetMbrBranchGradeForMagoDb  implements java.io.Serializable {
    private java.lang.String mbrNm;

    private java.lang.String hp;

    private java.lang.String socialNoF;

    private java.lang.String mbrCd;

    public GetMbrBranchGradeForMagoDb() {
    }

    public GetMbrBranchGradeForMagoDb(
           java.lang.String mbrNm,
           java.lang.String hp,
           java.lang.String socialNoF,
           java.lang.String mbrCd) {
           this.mbrNm = mbrNm;
           this.hp = hp;
           this.socialNoF = socialNoF;
           this.mbrCd = mbrCd;
    }


    /**
     * Gets the mbrNm value for this GetMbrBranchGradeForMagoDb.
     * 
     * @return mbrNm
     */
    public java.lang.String getMbrNm() {
        return mbrNm;
    }


    /**
     * Sets the mbrNm value for this GetMbrBranchGradeForMagoDb.
     * 
     * @param mbrNm
     */
    public void setMbrNm(java.lang.String mbrNm) {
        this.mbrNm = mbrNm;
    }


    /**
     * Gets the hp value for this GetMbrBranchGradeForMagoDb.
     * 
     * @return hp
     */
    public java.lang.String getHp() {
        return hp;
    }


    /**
     * Sets the hp value for this GetMbrBranchGradeForMagoDb.
     * 
     * @param hp
     */
    public void setHp(java.lang.String hp) {
        this.hp = hp;
    }


    /**
     * Gets the socialNoF value for this GetMbrBranchGradeForMagoDb.
     * 
     * @return socialNoF
     */
    public java.lang.String getSocialNoF() {
        return socialNoF;
    }


    /**
     * Sets the socialNoF value for this GetMbrBranchGradeForMagoDb.
     * 
     * @param socialNoF
     */
    public void setSocialNoF(java.lang.String socialNoF) {
        this.socialNoF = socialNoF;
    }


    /**
     * Gets the mbrCd value for this GetMbrBranchGradeForMagoDb.
     * 
     * @return mbrCd
     */
    public java.lang.String getMbrCd() {
        return mbrCd;
    }


    /**
     * Sets the mbrCd value for this GetMbrBranchGradeForMagoDb.
     * 
     * @param mbrCd
     */
    public void setMbrCd(java.lang.String mbrCd) {
        this.mbrCd = mbrCd;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetMbrBranchGradeForMagoDb)) return false;
        GetMbrBranchGradeForMagoDb other = (GetMbrBranchGradeForMagoDb) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.mbrNm==null && other.getMbrNm()==null) || 
             (this.mbrNm!=null &&
              this.mbrNm.equals(other.getMbrNm()))) &&
            ((this.hp==null && other.getHp()==null) || 
             (this.hp!=null &&
              this.hp.equals(other.getHp()))) &&
            ((this.socialNoF==null && other.getSocialNoF()==null) || 
             (this.socialNoF!=null &&
              this.socialNoF.equals(other.getSocialNoF()))) &&
            ((this.mbrCd==null && other.getMbrCd()==null) || 
             (this.mbrCd!=null &&
              this.mbrCd.equals(other.getMbrCd())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getMbrNm() != null) {
            _hashCode += getMbrNm().hashCode();
        }
        if (getHp() != null) {
            _hashCode += getHp().hashCode();
        }
        if (getSocialNoF() != null) {
            _hashCode += getSocialNoF().hashCode();
        }
        if (getMbrCd() != null) {
            _hashCode += getMbrCd().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetMbrBranchGradeForMagoDb.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dainnetuser.br.co.kr/ws/wsMbrFeeGrade.asmx", ">GetMbrBranchGradeForMagoDb"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mbrNm");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dainnetuser.br.co.kr/ws/wsMbrFeeGrade.asmx", "mbrNm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dainnetuser.br.co.kr/ws/wsMbrFeeGrade.asmx", "hp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("socialNoF");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dainnetuser.br.co.kr/ws/wsMbrFeeGrade.asmx", "socialNoF"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mbrCd");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dainnetuser.br.co.kr/ws/wsMbrFeeGrade.asmx", "mbrCd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
