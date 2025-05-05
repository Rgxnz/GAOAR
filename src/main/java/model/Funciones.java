package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Funciones {

    /**
     * Crea una carpeta con el nombre especificado.
     * @param folderName Nombre de la carpeta a crear.
     * @throws IOException Si ocurre un error al crear la carpeta.
     */
    public static void createFolder(String folderName) throws IOException {
        Path path = Paths.get(folderName);
        if (!Files.exists(path)) {
            Files.createDirectory(path);
        }
    }

    /**
     * Crea o actualiza un archivo en la ruta especificada.
     * @param path Ruta del archivo.
     * @param fileName Nombre del archivo.
     * @param content Contenido a escribir.
     * @throws IOException Si ocurre un error de E/S.
     */
    public static void createFile(String path, String fileName, String content) throws IOException {
        Path dirPath = Paths.get(path);
        if (!Files.exists(dirPath)) {
            Files.createDirectories(dirPath);  // Crea directorios padres
        }
        Path filePath = dirPath.resolve(fileName);
        Files.write(filePath, content.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    /**
     * Retorna la lista de archivos en una ruta.
     * @param path Ruta a listar.
     * @return Array con nombres de archivos.
     */
    public static String[] showListFiles(String path) {
        Path dir = Paths.get(path);
        if (Files.isDirectory(dir)) {
            return dir.toFile().list();
        }
        return new String[0];
    }

    /**
     * Muestra el contenido de un archivo.
     * @param path Ruta del archivo.
     * @param fileName Nombre del archivo.
     * @return Contenido del archivo.
     * @throws IOException Si ocurre un error de E/S.
     */
    public static String showFile(String path, String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path, fileName)));
    }

    /**
     * Sobrescribe el contenido de un archivo.
     * @param path Ruta del archivo.
     * @param fileName Nombre del archivo.
     * @param newContent Nuevo contenido.
     * @return true si el archivo existe, false si no.
     * @throws IOException Si ocurre un error de E/S.
     */
    public static boolean overWriteFile(String path, String fileName, String newContent) throws IOException {
        Path filePath = Paths.get(path, fileName);
        if (!Files.exists(filePath)) return false;
        Files.write(filePath, newContent.getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
        return true;
    }

    /**
     * Borra un archivo.
     * @param path Ruta del archivo.
     * @param filename Nombre del archivo.
     * @throws IOException Si ocurre un error de E/S.
     */
    public static void deleteFile(String path, String filename) throws IOException {
        Files.delete(Paths.get(path, filename));
    }

    /**
     * Cuenta los caracteres en un archivo.
     * @param path Ruta del archivo.
     * @param fileName Nombre del archivo.
     * @return Número de caracteres.
     * @throws IOException Si ocurre un error de E/S.
     */
    public static int countChars(String path, String fileName) throws IOException {
        return showFile(path, fileName).length();
    }

    /**
     * Cuenta las palabras en un archivo.
     * @param path Ruta del archivo.
     * @param fileName Nombre del archivo.
     * @return Número de palabras.
     * @throws IOException Si ocurre un error de E/S.
     */
    public static int countWords(String path, String fileName) throws IOException {
        String content = showFile(path, fileName);
        return content.isEmpty() ? 0 : content.split("\\s+").length;
    }

    /**
     * Reemplaza palabras en un archivo.
     * @param path Ruta del archivo.
     * @param fileName Nombre del archivo.
     * @param oldWord Palabra a reemplazar.
     * @param newWord Palabra nueva.
     * @return Contenido actualizado.
     * @throws IOException Si ocurre un error de E/S.
     */
    public static String swapWords(String path, String fileName, String oldWord, String newWord) throws IOException {
        String content = showFile(path, fileName);
        String newContent = content.replace(oldWord, newWord);  
        overWriteFile(path, fileName, newContent);
        return newContent;
    }
}