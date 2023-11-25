package com.nandasuna.clientrpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URL;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.XmlRpcCommonsTransportFactory;


@SpringBootApplication
public class ClientRpcApplication {

	public static void main(String[] args) throws Exception {
		// SpringApplication.run(ClientRpcApplication.class, args);
		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
    	  
		config.setServerURL(new URL("http://localhost:8080/xmlrpc"));
		
		config.setEnabledForExtensions(true); // Habilita  valores float
		

		XmlRpcClient client = new XmlRpcClient();
	
		// Usa Commons HttpClient como transporte
		client.setTransportFactory(
			new XmlRpcCommonsTransportFactory(client));
		// set configuration
		client.setConfig(config);

		// Faz uma chamada remota
		Object[] params = new Object[]
			{ 2.0, 3.0 };
		double result = (double)client.execute("Calculadora.somar", params);
		System.out.println("40 + 9 = " + result);
	
	}

}
