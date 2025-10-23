package org.example;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

public class CopiarCharAChar {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            System.out.println("Seleccione un archivo origen");
            File origen = seleccionarFichero();
            if (origen == null) {
                System.out.println("Operación cancelada (origen).");
                return;
            }

            System.out.println("Seleccione un archivo destino");
            File destino = seleccionarFichero();
            if (destino == null) {
                System.out.println("Operación cancelada (destino).");
                return;
            }

            try (BufferedReader br = new BufferedReader(new FileReader(origen));
                 PrintWriter pw = new PrintWriter(new FileWriter(destino))) {

                String linea;
                while ((linea = br.readLine()) != null) {
                    pw.println(linea);
                }

            } catch (FileNotFoundException e) {
                System.out.println("No se encuentra el archivo: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Error de lectura/escritura: " + e.getMessage());
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
            return fc.getSelectedFile();
        }
        return null;
    }
}
