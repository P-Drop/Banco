package com.cursoceat.ui;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.cursoceat.dao.DatosBanco;

import jakarta.xml.bind.JAXBException;

public class Menu {
	
	Scanner kb = new Scanner(System.in);
	DatosBanco datafun = new DatosBanco();
	
	public void mostrarMenu() throws InputMismatchException, JAXBException, IOException {
		boolean salir = false;
		do {
			System.out.println("\n------------------");
			System.out.println("1. Alta del cliente");
			System.out.println("2. Generar XML");
			System.out.println("3. Leer XML");
			System.out.println("4. Salir");
			System.out.println("------------------");
			System.out.print("\nOpcion -> ");
			try {
				int opcion = kb.nextInt();
				kb.nextLine();
				switch (opcion) {
				case 1:
					opcionAlta();
					break;
				case 2:
					opcionGenerarXML();
					break;
				case 3:
					opcionLeerXML();
					break;
				case 4:
					salir = true;
					break;
				default:
					System.err.println("\nError -> Opcion no valida");
					break;
				}
			}
			catch (Exception e) {
				System.err.println("\nError -> "+e.getMessage());
			}
		}while(!salir);
		despedida();
		kb.close();
	}
	public void saludo() {
		System.out.println("\tBANCO MOLOCOS");
	}
	public void despedida() throws InputMismatchException, JAXBException, IOException {
		System.out.println("\n¿Quieres guardar los cambios antes de salir? (y/n)");
		if(confirma()) {
			opcionGenerarXML();
		}
		System.out.println("\n\tNOS VEMOS");
	}
	public void opcionAlta() throws InputMismatchException {
		System.out.print("\nNombre completo: ");
		String nombre = kb.nextLine();
		System.out.print("DNI (nnnnnnnnX): ");
		String dni = kb.next();
		System.out.print("Fecha de nacimiento (dd-mm-aaaa): ");
		String fecha = kb.next();
		System.out.print("Saldo: ");
		double saldo = kb.nextDouble();
		datafun.darDeAlta(nombre, dni, fecha, saldo);
		System.out.println("\nSE HA CREADO EL CLIENTE\n");
	}
	public void opcionGenerarXML() throws JAXBException, IOException, InputMismatchException{
		System.out.print("\nIntroduce el nombre del archivo (sin.xml)-> ");
		String nombreGuardar = kb.next();
		String rutaGuardar = rutaArchivo(nombreGuardar);
		datafun.escribirXML(datafun, rutaGuardar);
		System.out.println("\nSE HAN GUARDADO LOS DATOS EN \""+rutaGuardar+"\n");
	}
	public void opcionLeerXML() throws JAXBException, IOException, InputMismatchException {
		System.out.print("\nIntroduce la ruta del archivo -> ");
		String nombreCargar = kb.next();
		String rutaCargar = rutaArchivo(nombreCargar);
		datafun.leerXML(rutaCargar);
	}
	public String rutaArchivo(String nombre) {
		return "C:\\Users\\PROGRAMACION\\Desktop\\STERK BOX\\Java\\ClientesBanco\\MisClientes\\"+nombre+".xml";
	}
	public boolean confirma() {
		if(kb.next().equalsIgnoreCase("y")) {
			return true;
		}else {
			return false;
		} 
	}
}
