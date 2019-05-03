/**
 * HSPMemberLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class HSPMemberLocator extends org.apache.axis.client.Service implements org.tempuri.HSPMember {

    public HSPMemberLocator() {
    }


    public HSPMemberLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public HSPMemberLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for HSPMemberSoap
    private java.lang.String HSPMemberSoap_address = "http://service.hsp.net/hspmember.asmx";

    public java.lang.String getHSPMemberSoapAddress() {
        return HSPMemberSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String HSPMemberSoapWSDDServiceName = "HSPMemberSoap";

    public java.lang.String getHSPMemberSoapWSDDServiceName() {
        return HSPMemberSoapWSDDServiceName;
    }

    public void setHSPMemberSoapWSDDServiceName(java.lang.String name) {
        HSPMemberSoapWSDDServiceName = name;
    }

    public org.tempuri.HSPMemberSoap getHSPMemberSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(HSPMemberSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getHSPMemberSoap(endpoint);
    }

    public org.tempuri.HSPMemberSoap getHSPMemberSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.tempuri.HSPMemberSoapStub _stub = new org.tempuri.HSPMemberSoapStub(portAddress, this);
            _stub.setPortName(getHSPMemberSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setHSPMemberSoapEndpointAddress(java.lang.String address) {
        HSPMemberSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.tempuri.HSPMemberSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                org.tempuri.HSPMemberSoapStub _stub = new org.tempuri.HSPMemberSoapStub(new java.net.URL(HSPMemberSoap_address), this);
                _stub.setPortName(getHSPMemberSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("HSPMemberSoap".equals(inputPortName)) {
            return getHSPMemberSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "HSPMember");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "HSPMemberSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("HSPMemberSoap".equals(portName)) {
            setHSPMemberSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
