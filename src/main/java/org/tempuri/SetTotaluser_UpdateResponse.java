/**
 * SetTotaluser_UpdateResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class SetTotaluser_UpdateResponse  implements java.io.Serializable {
    private int setTotaluser_UpdateResult;

    public SetTotaluser_UpdateResponse() {
    }

    public SetTotaluser_UpdateResponse(
           int setTotaluser_UpdateResult) {
           this.setTotaluser_UpdateResult = setTotaluser_UpdateResult;
    }


    /**
     * Gets the setTotaluser_UpdateResult value for this SetTotaluser_UpdateResponse.
     * 
     * @return setTotaluser_UpdateResult
     */
    public int getSetTotaluser_UpdateResult() {
        return setTotaluser_UpdateResult;
    }


    /**
     * Sets the setTotaluser_UpdateResult value for this SetTotaluser_UpdateResponse.
     * 
     * @param setTotaluser_UpdateResult
     */
    public void setSetTotaluser_UpdateResult(int setTotaluser_UpdateResult) {
        this.setTotaluser_UpdateResult = setTotaluser_UpdateResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SetTotaluser_UpdateResponse)) return false;
        SetTotaluser_UpdateResponse other = (SetTotaluser_UpdateResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.setTotaluser_UpdateResult == other.getSetTotaluser_UpdateResult();
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
        _hashCode += getSetTotaluser_UpdateResult();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SetTotaluser_UpdateResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">SetTotaluser_UpdateResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("setTotaluser_UpdateResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "SetTotaluser_UpdateResult"));
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
