package com.aje.download.client;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.aje.common.WSConnectString;

public class FileTextClient {
  public static void main(String[] args) throws Exception {
    // URL url = new URL("http://localhost:9899/ws/file?wsdl");
	WSConnectString wsCon = new WSConnectString();  
    //URL url = new URL("http://172.20.0.61:8080/WSAjeCFDI/create?wsdl");
	URL url = new URL(wsCon.getServiceCreateFileText());
	QName qname = new QName("http://ws.download.aje.com/", "FileTextImplService");
    Service service = Service.create(url, qname);
    FileText fileText = service.getPort(FileText.class);

    //String[] params = { "0030", "0001", "1002", "FXC", "35530" };
    int dh = fileText.createFileText(args);

    System.out.println("Resp: " + dh);
  }
}
