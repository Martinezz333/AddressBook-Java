package com.mycompany.addressbook;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {

    private Map<String, String> contacts;

    public AddressBook() {
        contacts = new HashMap<>();
    }

    public void load(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",", 2);

                if (data.length == 2) {
                    String phone = data[0];
                    String name = data[1];

                    contacts.put(phone, name);
                }
            }

            System.out.println("Contactos cargados correctamente.");

        } catch (IOException e) {
            System.out.println("No se pudo cargar el archivo.");
        }
    }

    public void save(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {

            for (Map.Entry<String, String> contact : contacts.entrySet()) {
                writer.println(contact.getKey() + "," + contact.getValue());
            }

            System.out.println("Contactos guardados correctamente.");

        } catch (IOException e) {
            System.out.println("No se pudo guardar el archivo.");
        }
    }

    public void list() {
        System.out.println("\nContactos:");

        if (contacts.isEmpty()) {
            System.out.println("No hay contactos registrados.");
            return;
        }

        for (Map.Entry<String, String> contact : contacts.entrySet()) {
            System.out.println(contact.getKey() + " : " + contact.getValue());
        }
    }

    public void create(Scanner scanner) {

        System.out.print("Ingresa el nombre del contacto: ");
        String name = scanner.nextLine();

        System.out.print("Ingresa el número telefónico: ");
        String phone = scanner.nextLine();

        if (contacts.containsKey(phone)) {
            System.out.println("Ese número ya está registrado.");
            return;
        }

        contacts.put(phone, name);

        System.out.println("Contacto creado correctamente.");
    }

    public void delete(Scanner scanner) {

        System.out.print("Ingresa el número telefónico a eliminar: ");
        String phone = scanner.nextLine();

        if (contacts.containsKey(phone)) {
            contacts.remove(phone);
            System.out.println("Contacto eliminado correctamente.");
        } else {
            System.out.println("No se encontró un contacto con ese número.");
        }
    }
}