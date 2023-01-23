/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.shengdong.examenrecuperacion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 *
 * @author shengdong
 */
public class ExamenRecuperacion {

    public static void main(String[] s) throws FileNotFoundException, IOException {
        File f = new File("ArchivoAleatorioEmpleados.dat");
        RandomAccessFile raf = new RandomAccessFile(f, "rw");

        if (s.length != 4) {
            System.out.println("Numero de argumentos invalidos");
        } else {
            var id = (byte) (raf.length() / 150) + 1;
            raf.seek(raf.length());

            // Escribir el id
            raf.writeByte(id);  // 1byte

            // Escribir el nombre
            StringBuffer bNombre = new StringBuffer(s[0]); //s[0] el el nombre
            bNombre.setLength(20);
            raf.writeChars(bNombre.toString());

            // Escribir  los apellidos
            StringBuffer bApellidos = new StringBuffer(s[1]);
            bApellidos.setLength(50);
            raf.writeChars(bApellidos.toString());

            // Escribir el departamento
            raf.writeByte(Byte.parseByte(s[2]));

            // Escribir el sueldo
            raf.writeDouble(Double.parseDouble(s[2]));
        }

        String lineaNew = "asd";
        int lineaPos = 1;
        String linea = raf.readLine();
        f.createNewFile();

        FileWriter writer = new FileWriter(f);

        raf = new RandomAccessFile(f, "r");

        int pos = 1;

        linea = raf.readLine();

        while (linea != null) {
            String lineaAEscribir = (pos == lineaPos) ? lineaNew : linea;
            writer.write(lineaAEscribir + "\n");

            linea = raf.readLine();
            pos++;
        }

        raf.close();
        writer.close();
        f.delete();
        f.renameTo(f);

    }
}
