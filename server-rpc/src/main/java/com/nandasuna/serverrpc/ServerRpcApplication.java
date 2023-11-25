package com.nandasuna.serverrpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class ServerRpcApplication {

	public static void main(String[] args) {
		// SpringApplication.run(ServerRpcApplication.class, args);
		System.out.println("Iniciando o servidor........");

	
		try {
			// Instanciando o objetivo WebServer com a definição da porta
			WebServer server = new WebServer(8080);

			XmlRpcServer xmlRpcServer = server.getXmlRpcServer();

			PropertyHandlerMapping phm = new PropertyHandlerMapping();

			phm.addHandler("Calculadora", Calculadora.class);
			xmlRpcServer.setHandlerMapping(phm);

			XmlRpcServerConfigImpl serverConfig = (XmlRpcServerConfigImpl) xmlRpcServer.getConfig();
			serverConfig.setEnabledForExtensions(true); // Habilita valores float

			server.start();

			System.out.println("Servidor inicializado.");
			System.out.println("Aguardando requisições.");

		} catch (IOException | XmlRpcException e) {
			e.printStackTrace();
		}
	}

}
