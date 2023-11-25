package com.nandasuna.clientrpc;

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
		Object[] params = new Object[] { 2.0, 3.0 };
		Object[] param = new Object[] { 10.0 };
		Object[] paramSinCos = new Object[] { 90.0 };
		Object[] paramRoot = new Object[] { 4.0 };


		double resultSoma = (double)client.execute("Calculadora.somar", params);
		System.out.println("2 + 3 = " + resultSoma);

		double resultSubtracao = (double)client.execute("Calculadora.subtrair", params);
		System.out.println("2 - 3 =  " + resultSubtracao);

		double resultMultiplicacao = (double)client.execute("Calculadora.multiplicar", params);
		System.out.println("2 * 3 = " + resultMultiplicacao);

		double resulDivisao = (double)client.execute("Calculadora.dividir", params);
		System.out.println("2 / 3 = " + resulDivisao);

		double resulLogE = (double)client.execute("Calculadora.logaritmomBaseE", param);
		System.out.println("log natural 10 = " + resulLogE);

		double resulLog10 = (double)client.execute("Calculadora.logaritmoBase10", param);
		System.out.println("log 10 na base 10 = " + resulLog10);

		double resulExpo = (double)client.execute("Calculadora.exponenciacao", params);
		System.out.println("2 ^ 3= " + resulExpo);

		double resulSin = (double)client.execute("Calculadora.seno", paramSinCos);
		System.out.println("sin 90 = " + resulSin);

		double resulCos = (double)client.execute("Calculadora.cosseno", paramSinCos);
		System.out.println("cos 90 = " + resulCos);

		double resulRaiz2 = (double)client.execute("Calculadora.raizQuadrada", paramRoot);
		System.out.println("raiz quadrada de 4 = " + resulRaiz2);
	
	}

}
