import java.io.*;
import java.util.Scanner;

public class ManejoArchivos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("----- Menú -----");
            System.out.println("1. Crear archivo y escribir contenido");
            System.out.println("2. Mostrar contenido de archivo");
            System.out.println("3. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    crearArchivo();
                    break;
                case 2:
                    mostrarContenido();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 3);

        scanner.close();
    }

    public static void crearArchivo() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del archivo (con extensión .txt): ");
        String nombreArchivo = scanner.nextLine();

        if (!nombreArchivo.endsWith(".txt")) {
            nombreArchivo += ".txt";
        }

        try {
            FileWriter fileWriter = new FileWriter(nombreArchivo);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            System.out.println("Escriba el contenido del archivo (Escriba 'fin' para terminar):");

            String linea;
            while (!(linea = scanner.nextLine()).equalsIgnoreCase("fin")) {
                bufferedWriter.write(linea);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            System.out.println("Archivo '" + nombreArchivo + "' creado y contenido guardado con éxito.");
        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
    }

    public static void mostrarContenido() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del archivo a mostrar: ");
        String nombreArchivo = scanner.nextLine();

        try {
            File file = new File(nombreArchivo);

            if (!file.exists() || !file.isFile()) {
                System.out.println("El archivo no existe o no es válido.");
                return;
            }

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            System.out.println("Contenido del archivo '" + nombreArchivo + "':");
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                System.out.println(linea);
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
