/**
 * SetTotaluser_SexResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class SetTotaluser_SexResponse  implements java.io.Serializable {
    private java.lang.String setTotaluser_SexResult;

    public SetTotaluser_SexResponse() {
    }

    public SetTotaluser_SexResponse(
           java.lang.String setTotaluser_SexResult) {
           this.setTotaluser_SexResult = setTotaluser_SexResult;
    }


    /**
     * Gets the setTotaluser_SexResult value for this SetTotaluser_SexResponse.
     * 
     * @return setTotaluser_SexResult
     */
    public java.lang.String getSetTotaluser_SexResult() {
        return setTotaluser_SexResult;
    }


    /**
     * Sets the setTotaluser_SexResult value for this SetTotaluser_SexResponse.
     * 
     * @param setTotaluser_SexResult
     */
    public void setSetTotaluser_SexResult(java.lang.String setTotaluser_SexResult) {
        this.setTotaluser_SexResult = setTotaluser_SexResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SetTotaluser_SexResponse)) return false;
        SetTotaluser_SexResponse other = (SetTotaluser_SexResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.setTotaluser_SexResult==null && other.getSetTotaluser_SexResult()==null) || 
             (this.setTotaluser_SexResult!=null &&
              this.setTotaluser_SexResult.equals(other.getSetTotaluser_SexResult())));
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
        if (getSetTotaluser_SexResult() != null) {
            _hashCode += getSetTotaluser_SexResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SetTotaluser_SexResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">SetTotaluser_SexResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("setTotaluser_SexResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "SetTotaluser_SexResult"));
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
