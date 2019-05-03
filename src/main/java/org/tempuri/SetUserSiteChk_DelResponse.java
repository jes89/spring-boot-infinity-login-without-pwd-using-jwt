/**
 * SetUserSiteChk_DelResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class SetUserSiteChk_DelResponse  implements java.io.Serializable {
    private int setUserSiteChk_DelResult;

    public SetUserSiteChk_DelResponse() {
    }

    public SetUserSiteChk_DelResponse(
           int setUserSiteChk_DelResult) {
           this.setUserSiteChk_DelResult = setUserSiteChk_DelResult;
    }


    /**
     * Gets the setUserSiteChk_DelResult value for this SetUserSiteChk_DelResponse.
     * 
     * @return setUserSiteChk_DelResult
     */
    public int getSetUserSiteChk_DelResult() {
        return setUserSiteChk_DelResult;
    }


    /**
     * Sets the setUserSiteChk_DelResult value for this SetUserSiteChk_DelResponse.
     * 
     * @param setUserSiteChk_DelResult
     */
    public void setSetUserSiteChk_DelResult(int setUserSiteChk_DelResult) {
        this.setUserSiteChk_DelResult = setUserSiteChk_DelResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SetUserSiteChk_DelResponse)) return false;
        SetUserSiteChk_DelResponse other = (SetUserSiteChk_DelResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.setUserSiteChk_DelResult == other.getSetUserSiteChk_DelResult();
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
        _hashCode += getSetUserSiteChk_DelResult();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SetUserSiteChk_DelResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">SetUserSiteChk_DelResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("setUserSiteChk_DelResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "SetUserSiteChk_DelResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
