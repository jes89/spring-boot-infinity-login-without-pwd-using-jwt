/**
 * SetUserRestoreResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class SetUserRestoreResponse  implements java.io.Serializable {
    private java.lang.String setUserRestoreResult;

    public SetUserRestoreResponse() {
    }

    public SetUserRestoreResponse(
           java.lang.String setUserRestoreResult) {
           this.setUserRestoreResult = setUserRestoreResult;
    }


    /**
     * Gets the setUserRestoreResult value for this SetUserRestoreResponse.
     * 
     * @return setUserRestoreResult
     */
    public java.lang.String getSetUserRestoreResult() {
        return setUserRestoreResult;
    }


    /**
     * Sets the setUserRestoreResult value for this SetUserRestoreResponse.
     * 
     * @param setUserRestoreResult
     */
    public void setSetUserRestoreResult(java.lang.String setUserRestoreResult) {
        this.setUserRestoreResult = setUserRestoreResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SetUserRestoreResponse)) return false;
        SetUserRestoreResponse other = (SetUserRestoreResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.setUserRestoreResult==null && other.getSetUserRestoreResult()==null) || 
             (this.setUserRestoreResult!=null &&
              this.setUserRestoreResult.equals(other.getSetUserRestoreResult())));
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
        if (getSetUserRestoreResult() != null) {
            _hashCode += getSetUserRestoreResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SetUserRestoreResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">SetUserRestoreResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("setUserRestoreResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "SetUserRestoreResult"));
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
