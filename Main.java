package com.mycompany.addressbook;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        AddressBook addressBook = new AddressBook();

        String filename = "contacts.txt";

        addressBook.load(filename);

        int option;

        do {
            System.out.println("\n===== AGENDA TELEFÓNICA =====");
            System.out.println("1. Listar contactos");
            System.out.println("2. Crear contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Guardar y salir");
            System.out.print("Selecciona una opción: ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {

                case 1:
                    addressBook.list();
                    break;

                case 2:
                    addressBook.create(scanner);
                    break;

                case 3:
                    addressBook.delete(scanner);
                    break;

                case 4:
                    addressBook.save(filename);
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (option != 4);

        scanner.close();
    }
}