package com.cursoceat.dao;

import com.cursoceat.services.Funciones;
import com.cursoceat.xml.schema.Banco;

public class DatosBanco implements Funciones{

	public Banco miBanco = new Banco();
	
	@Override
	public void darDeAlta(String n, String dni, String fN, double s) {
		miBanco.altaCliente(n, dni, fN, s);
	}
}
