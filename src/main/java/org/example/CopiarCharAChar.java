package org.example;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

public class CopiarCharAChar {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

        System.out.println("Seleccione un archivo origen");
        File origen = seleccionarFichero();

        System.out.println("Seleccione un archivo destino");
        File destino = seleccionarFichero();


        try {
            FileReader fr = new FileReader(origen);
            BufferedReader br = new BufferedReader(fr);

            FileWriter fw = new FileWriter(destino);
            PrintWriter pw = new PrintWriter(fw);

            String linea = "";
            while ((linea = br.readLine()) != null) {
                char[] caracteres = linea.toCharArray();
                for (char c : caracteres) {
                    pw.print(c);
                }
                pw.println();
            }

            } catch(FileNotFoundException e){
                System.out.println("No se encuentra el archivo");
            } catch(IOException e){
                System.out.println("Error de lectura/escritura");
            }


        });
    }
    public static File seleccionarFichero() {
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Seleccione un archivo");
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Texto", "txt");
        fc.setFileFilter(filter);
        int option = fc.showOpenDialog(null);

        if (option == JFileChooser.APPROVE_OPTION) {
            return null;
        }
        return fc.getSelectedFile();
    }
}
