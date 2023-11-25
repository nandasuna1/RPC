package com.nandasuna.serverrpc;

public class Calculator {
	
	public double somar(double x, double y) {
		return x + y;
	}
	
	public double multiplicar(double x, double y) {
		return x * y;
	}
	
	public double subtrair(double x, double y) {
		return x - y;
	}
	
	public double dividir(double x, double y) {
		return x / y;
	}

	public double logaritmomBaseE(double num) {
        return Math.log(num);
    }

    public double logaritmoBase10(double num) {
        return Math.log10(num);
    }

    public double exponenciacao(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public double seno(double num) {
        return Math.sin(Math.toRadians(num));
    }

    public double cosseno(double num) {
        return Math.round(Math.cos(Math.toRadians(num)));
    }

    public double raizQuadrada(double num) {
        if (num >= 0) {
            return Math.sqrt(num);
        } else {
            // Handle square root of a negative number
			System.out.println("Não é possivel calcular raiz de numeros negativos");
            num = Double.NaN; // You may choose a different approach
			return num;
        }
    }

}
