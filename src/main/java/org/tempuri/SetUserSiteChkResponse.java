/**
 * SetUserSiteChkResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class SetUserSiteChkResponse  implements java.io.Serializable {
    private java.lang.String setUserSiteChkResult;

    public SetUserSiteChkResponse() {
    }

    public SetUserSiteChkResponse(
           java.lang.String setUserSiteChkResult) {
           this.setUserSiteChkResult = setUserSiteChkResult;
    }


    /**
     * Gets the setUserSiteChkResult value for this SetUserSiteChkResponse.
     * 
     * @return setUserSiteChkResult
     */
    public java.lang.String getSetUserSiteChkResult() {
        return setUserSiteChkResult;
    }


    /**
     * Sets the setUserSiteChkResult value for this SetUserSiteChkResponse.
     * 
     * @param setUserSiteChkResult
     */
    public void setSetUserSiteChkResult(java.lang.String setUserSiteChkResult) {
        this.setUserSiteChkResult = setUserSiteChkResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SetUserSiteChkResponse)) return false;
        SetUserSiteChkResponse other = (SetUserSiteChkResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.setUserSiteChkResult==null && other.getSetUserSiteChkResult()==null) || 
             (this.setUserSiteChkResult!=null &&
              this.setUserSiteChkResult.equals(other.getSetUserSiteChkResult())));
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
        if (getSetUserSiteChkResult() != null) {
            _hashCode += getSetUserSiteChkResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SetUserSiteChkResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">SetUserSiteChkResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("setUserSiteChkResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "SetUserSiteChkResult"));
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
