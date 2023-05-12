package com.cursoceat.controller;

import java.io.IOException;
import java.util.InputMismatchException;

import com.cursoceat.ui.Menu;

import jakarta.xml.bind.JAXBException;

public class Controller {

	public static void main(String[] args) throws InputMismatchException, JAXBException, IOException {
		Menu programa = new Menu();
		programa.saludo();
		programa.mostrarMenu();
	}
}
