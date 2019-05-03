/**
 * GetUserSiteChkResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetUserSiteChkResponse  implements java.io.Serializable {
    private org.tempuri.GetUserSiteChkResponseGetUserSiteChkResult getUserSiteChkResult;

    public GetUserSiteChkResponse() {
    }

    public GetUserSiteChkResponse(
           org.tempuri.GetUserSiteChkResponseGetUserSiteChkResult getUserSiteChkResult) {
           this.getUserSiteChkResult = getUserSiteChkResult;
    }


    /**
     * Gets the getUserSiteChkResult value for this GetUserSiteChkResponse.
     * 
     * @return getUserSiteChkResult
     */
    public org.tempuri.GetUserSiteChkResponseGetUserSiteChkResult getGetUserSiteChkResult() {
        return getUserSiteChkResult;
    }


    /**
     * Sets the getUserSiteChkResult value for this GetUserSiteChkResponse.
     * 
     * @param getUserSiteChkResult
     */
    public void setGetUserSiteChkResult(org.tempuri.GetUserSiteChkResponseGetUserSiteChkResult getUserSiteChkResult) {
        this.getUserSiteChkResult = getUserSiteChkResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetUserSiteChkResponse)) return false;
        GetUserSiteChkResponse other = (GetUserSiteChkResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getUserSiteChkResult==null && other.getGetUserSiteChkResult()==null) || 
             (this.getUserSiteChkResult!=null &&
              this.getUserSiteChkResult.equals(other.getGetUserSiteChkResult())));
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
        if (getGetUserSiteChkResult() != null) {
            _hashCode += getGetUserSiteChkResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetUserSiteChkResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetUserSiteChkResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getUserSiteChkResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetUserSiteChkResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetUserSiteChkResponse>GetUserSiteChkResult"));
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
