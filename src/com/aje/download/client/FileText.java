package com.aje.download.client;

import javax.activation.DataHandler;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Action;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.2.3-b01- Generated source version: 2.2
 * 
 */
@WebService(name = "FileText", targetNamespace = "http://ws.download.aje.com/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface FileText {

  /**
   * 
   * @param arg0
   * @return returns byte[]
   */
  @WebMethod
  @WebResult(partName = "return")
  @Action(input = "http://ws.download.aje.com/FileText/createFileTextRequest", output = "http://ws.download.aje.com/FileText/createFileTextResponse")
  public int createFileText(@WebParam(name = "arg0", partName = "arg0")
  String[] arg0);

}