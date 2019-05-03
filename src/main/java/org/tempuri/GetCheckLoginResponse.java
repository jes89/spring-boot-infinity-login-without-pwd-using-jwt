/**
 * GetCheckLoginResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetCheckLoginResponse  implements java.io.Serializable {
    private org.tempuri.GetCheckLoginResponseGetCheckLoginResult getCheckLoginResult;

    public GetCheckLoginResponse() {
    }

    public GetCheckLoginResponse(
           org.tempuri.GetCheckLoginResponseGetCheckLoginResult getCheckLoginResult) {
           this.getCheckLoginResult = getCheckLoginResult;
    }


    /**
     * Gets the getCheckLoginResult value for this GetCheckLoginResponse.
     * 
     * @return getCheckLoginResult
     */
    public org.tempuri.GetCheckLoginResponseGetCheckLoginResult getGetCheckLoginResult() {
        return getCheckLoginResult;
    }


    /**
     * Sets the getCheckLoginResult value for this GetCheckLoginResponse.
     * 
     * @param getCheckLoginResult
     */
    public void setGetCheckLoginResult(org.tempuri.GetCheckLoginResponseGetCheckLoginResult getCheckLoginResult) {
        this.getCheckLoginResult = getCheckLoginResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetCheckLoginResponse)) return false;
        GetCheckLoginResponse other = (GetCheckLoginResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getCheckLoginResult==null && other.getGetCheckLoginResult()==null) || 
             (this.getCheckLoginResult!=null &&
              this.getCheckLoginResult.equals(other.getGetCheckLoginResult())));
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
        if (getGetCheckLoginResult() != null) {
            _hashCode += getGetCheckLoginResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetCheckLoginResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetCheckLoginResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getCheckLoginResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetCheckLoginResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetCheckLoginResponse>GetCheckLoginResult"));
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
