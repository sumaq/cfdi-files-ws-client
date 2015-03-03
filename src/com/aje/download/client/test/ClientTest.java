package com.aje.download.client.test;

import com.aje.download.client.FileClient;
import com.aje.download.client.FileTextClient;

public class ClientTest {

	public static void main(String[] args) {
		try {
			String[] paramsPDF = { "0030", "0071", "1002", "FXC", "26171", "",
					"", "c:\\wilPrueba.pdf" };
			String[] paramsTextFile = { "EXEC USP_FEX_CFDI_GEN_FILE_ESTANDAR '0030','0071','1002','FXC',26171" };
			FileClient fc = new FileClient();
			fc.main(paramsPDF);

			FileTextClient fct = new FileTextClient();
			fct.main(paramsTextFile);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
