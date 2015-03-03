/* Clase    : Connection
 * Autor    : Wilmer Reyes Alfaro
 * Revision : 22/06/2013 12:45
 * Funcion  : Permite obtener la cadena de conexi�n hacia la base de datos APM. 
 * 			  Se obtiene a partir del archivo config.xml de la carpeta conf del proyecto.
 * */
package com.aje.common;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.aje.common.OperatingSystem;

public class WSConnectString extends DefaultHandler {
  String xmlFileName;
  String tmpValue;
  String WSName;
  String WSUrlServiceGetPDF;
  String WSUrlServiceCreateFileText;
  String WSUser;
  String WSPassword;
  OperatingSystem OS = new OperatingSystem();
  Boolean fName;
  Boolean fUrlServiceGetPDF;
  Boolean fUrlServiceCreateFileText;
  Boolean fUser;
  Boolean fPassword;

  public WSConnectString() {
    // this.xmlFileName = "/home/wil/workspace/APM/conf/config.xml" ;
    // this.xmlFileName = "C:\\Users\\wil\\workspace\\APM\\conf\\config.xml" ;
    // this.xmlFileName = new File("").getAbsolutePath() + "\\conf\\config.xml" ;

    // Debe ejecutarse la clase dentro del home del proyecto
    if (OS.isWindows()) {
      this.xmlFileName = "conf\\WSConfig.xml"; // Windows
    }
    if (OS.isUnix()) {
      this.xmlFileName = "conf/WSConfig.xml"; // Linux
    }
    parseDocument();
  }

  private void parseDocument() {
    // parse
    SAXParserFactory factory = SAXParserFactory.newInstance();
    fName = false;
    fUrlServiceGetPDF = false;
    fUrlServiceCreateFileText = false;
    fUser = false;
    fPassword = false;

    try {
      SAXParser parser = factory.newSAXParser();
      parser.parse(this.xmlFileName, this);
    } catch (ParserConfigurationException e) {
      System.out.println("ParserConfig error");
    } catch (SAXException e) {
      System.out.println("SAXException : xml not well formed");
    } catch (IOException e) {
      System.out.println("IO error");
    }
  }

  @Override
  public void startElement(String s, String s1, String elementName, Attributes attributes)
      throws SAXException {

    if (elementName.equalsIgnoreCase("name")) {
      fName = true;
    }
    if (elementName.equalsIgnoreCase("urlServiceGetPDF")) {
      fUrlServiceGetPDF = true;
    }
    if (elementName.equalsIgnoreCase("urlServiceCreateFileText")) {
        fUrlServiceCreateFileText = true;
      }
    if (elementName.equalsIgnoreCase("user")) {
      fUser = true;
    }
    if (elementName.equalsIgnoreCase("password")) {
      fPassword = true;
    }

  }

  @Override
  public void endElement(String s, String s1, String element) throws SAXException {
    // if end of book element add to list

  }

  @Override
  public void characters(char[] ac, int i, int j) throws SAXException {
    if (fName) {
      this.setName(new String(ac, i, j));
      fName = false;
    }
    if (fUrlServiceGetPDF) {
      this.setUrlServiceGetPDF(new String(ac, i, j));
      fUrlServiceGetPDF = false;
    }
    if (fUrlServiceCreateFileText) {
        this.setUrlServiceCreateFileText(new String(ac, i, j));
        fUrlServiceCreateFileText = false;
      }
    if (fUser) {
      this.setUser(new String(ac, i, j));
      fUser = false;
    }
    if (fPassword) {
      this.setPassword(new String(ac, i, j));
      fPassword = false;
    }
  }

  public String getName() {
    return WSName;
  }

  public void setName(String name) {
    this.WSName = name;
  }

  public String getServiceGetPDF() {
    return WSUrlServiceGetPDF;
  }

  public void setUrlServiceGetPDF(String service) {
    this.WSUrlServiceGetPDF = service;
  }
  
  public String getServiceCreateFileText() {
	    return WSUrlServiceCreateFileText;
  }

  public void setUrlServiceCreateFileText(String service) {
	    this.WSUrlServiceCreateFileText = service;
  }
  public String getUser() {
    return WSUser;
  }

  public void setUser(String dataBaseUser) {
    this.WSUser = dataBaseUser;
  }

  public String getPassword() {
    return WSPassword;
  }

  public void setPassword(String dataBasePassword) {
    this.WSPassword = dataBasePassword;
  }

}
