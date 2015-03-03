package com.aje.download.client;

import java.io.FileOutputStream;
import java.net.URL;

import javax.activation.DataHandler;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.aje.common.WSConnectString;

public class FileClient {
  public static void main(String[] args) throws Exception {
    // URL url = new URL("http://localhost:9899/ws/file?wsdl");
	String pPathFile = new String(args[7]);
	WSConnectString wsCon = new WSConnectString();
	
    //URL url = new URL("http://172.20.0.61:8080/WSAjeCFDI/download?wsdl");
	URL url = new URL(wsCon.getServiceGetPDF());
    QName qname = new QName("http://ws.download.aje.com/", "FileServerImplService");
    Service service = Service.create(url, qname);
    FileServer fileServer = service.getPort(FileServer.class);

    //String[] params = { "0030", "0001", "1002", "FXC", "35530" };
    DataHandler dh = fileServer.downloadFile(args);

    /* Location for downloading and storing in client machine */

    FileOutputStream outputStream = new FileOutputStream(pPathFile);
    dh.writeTo(outputStream);
    outputStream.flush();
    System.out.println(" Download Successful!");
  }
}
