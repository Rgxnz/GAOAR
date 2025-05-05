package view.console;

import model.Funciones;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        
        while (!salir) {
            mostrarMenu();
            int opcion = sc.nextInt();
            sc.nextLine(); 

            try {
                switch (opcion) {
                    case 1:
                        System.out.print("Nombre de la carpeta: ");
                        Funciones.createFolder(sc.nextLine());
                        System.out.println("Carpeta creada.");
                        break;
                    case 2:
                        System.out.print("Ruta: ");
                        String ruta = sc.nextLine();
                        System.out.print("Nombre del archivo: ");
                        String archivo = sc.nextLine();
                        System.out.print("Contenido: ");
                        Funciones.createFile(ruta, archivo, sc.nextLine());
                        System.out.println("Archivo creado.");
                        break;
                    case 3:
                        System.out.print("Ruta a listar: ");
                        String[] archivos = Funciones.showListFiles(sc.nextLine());
                        System.out.println("Archivos:");
                        for (String a : archivos) System.out.println("- " + a);
                        break;
                    case 4:
                        System.out.print("Ruta del archivo: ");
                        String rutaArchivo = sc.nextLine();
                        System.out.print("Nombre del archivo: ");
                        System.out.println("Contenido:\n" + Funciones.showFile(rutaArchivo, sc.nextLine()));
                        break;
                    case 5:
                        System.out.print("Ruta del archivo: ");
                        String x = sc.nextLine();
                        System.out.print("Nombre del archivo: ");
                        String y = sc.nextLine();
                        System.out.print("Nuevo contenido: ");
                        boolean exito = Funciones.overWriteFile(x, y, sc.nextLine());
                        System.out.println(exito ? "Sobrescrito." : "Archivo no existe.");
                        break;


                    case 6:
                        System.out.print("Ruta del archivo: ");
                        String z = sc.nextLine();
                        System.out.print("Nombre del archivo: ");
                        Funciones.deleteFile(z, sc.nextLine());
                        System.out.println("Archivo borrado.");
                        break;

                    case 7:
                        System.out.print("Ruta del archivo: ");
                        String a = sc.nextLine();
                        System.out.print("Nombre del archivo: ");
                        System.out.println("Caracteres: " + Funciones.countChars(a, sc.nextLine()));
                        break;

                    case 8:
                        System.out.print("Ruta del archivo: ");
                        String b = sc.nextLine();
                        System.out.print("Nombre del archivo: ");
                        System.out.println("Palabras: " + Funciones.countWords(b, sc.nextLine()));
                        break;

                    case 9:
                        System.out.print("Ruta del archivo: ");
                        String c = sc.nextLine();
                        System.out.print("Nombre del archivo: ");
                        String d = sc.nextLine();
                        System.out.print("Palabra a reemplazar: ");
                        String oldW = sc.nextLine();
                        System.out.print("Nueva palabra: ");
                        String newW = sc.nextLine();
                        System.out.println("Nuevo contenido:\n" + Funciones.swapWords(c, d, oldW, newW));
                        break;

                    case 0:
                        salir = true;
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (UnsupportedOperationException e) {
                System.out.println("Advertencia: " + e.getMessage());
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Crear carpeta");
        System.out.println("2. Crear/actualizar archivo");
        System.out.println("3. Listar archivos");
        System.out.println("4. Mostrar contenido");
        System.out.println("5. Sobrescribir archivo");
        System.out.println("6. Borrar archivo");
        System.out.println("7. Contar caracteres");
        System.out.println("8. Contar palabras");
        System.out.println("9. Reemplazar palabras");
        System.out.println("0. Salir");
        System.out.print("Opcion: ");
    }
}