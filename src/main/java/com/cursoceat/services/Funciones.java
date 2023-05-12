package com.cursoceat.services;

import java.io.File;
import java.io.IOException;

import com.cursoceat.dao.DatosBanco;
import com.cursoceat.xml.schema.Banco;
import com.cursoceat.xml.schema.Banco.Cliente;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public interface Funciones {

	public void darDeAlta(String n, String dni, String fN, double s);
	
	public default void escribirXML(Object o, String ruta) throws JAXBException, IOException {
		DatosBanco temp = (DatosBanco) o;
		File archivo = new File(ruta);
		JAXBContext contexto = JAXBContext.newInstance(Banco.class);
		Marshaller mars = contexto.createMarshaller();
		mars.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		mars.marshal(temp.miBanco, archivo);
	}
	
	public default void leerXML(String ruta) throws JAXBException, IOException {
		File archivo = new File(ruta);
		JAXBContext contexto = JAXBContext.newInstance(Banco.class);
		Unmarshaller unmars = contexto.createUnmarshaller();
		Banco temp = (Banco) unmars.unmarshal(archivo);
		for (Cliente cli : temp.getCliente()) {
			System.out.println(cli.toString());
		}
	}
}
