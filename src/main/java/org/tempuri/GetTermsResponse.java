/**
 * GetTermsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetTermsResponse  implements java.io.Serializable {
    private org.tempuri.GetTermsResponseGetTermsResult getTermsResult;

    public GetTermsResponse() {
    }

    public GetTermsResponse(
           org.tempuri.GetTermsResponseGetTermsResult getTermsResult) {
           this.getTermsResult = getTermsResult;
    }


    /**
     * Gets the getTermsResult value for this GetTermsResponse.
     * 
     * @return getTermsResult
     */
    public org.tempuri.GetTermsResponseGetTermsResult getGetTermsResult() {
        return getTermsResult;
    }


    /**
     * Sets the getTermsResult value for this GetTermsResponse.
     * 
     * @param getTermsResult
     */
    public void setGetTermsResult(org.tempuri.GetTermsResponseGetTermsResult getTermsResult) {
        this.getTermsResult = getTermsResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetTermsResponse)) return false;
        GetTermsResponse other = (GetTermsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getTermsResult==null && other.getGetTermsResult()==null) || 
             (this.getTermsResult!=null &&
              this.getTermsResult.equals(other.getGetTermsResult())));
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
        if (getGetTermsResult() != null) {
            _hashCode += getGetTermsResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetTermsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetTermsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getTermsResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetTermsResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetTermsResponse>GetTermsResult"));
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
