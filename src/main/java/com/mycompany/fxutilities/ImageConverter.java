/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fxutilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 *
 * @author taleb
 */
public class ImageConverter {

    public static void readFile(Long id, byte[] data, String extension) throws IOException {
        File outfile = new File("out/"+extension+"/data" + id + "."+extension);
        writeFile(outfile, data);

    }
    public static String getExtension(String path){
        return path.substring(path.length()-3, path.length());
    }

    private static void writeFile(File file, byte[] data) throws IOException {

        // Write the data
        try (OutputStream fo = new FileOutputStream(file)) {
            // Write the data
            fo.write(data);
            // flush the file (down the toilet)
            fo.flush();
            // Close the door to keep the smell in.
        }

    }

    public static byte[] toByteArray(String path) throws FileNotFoundException, FileNotFoundException, IOException {
        try (FileInputStream fi = new FileInputStream(path)) {
            System.out.println("loaded : " + fi.available());
            try (FileChannel fic = fi.getChannel()) {
                ByteBuffer buffer = ByteBuffer.allocateDirect(1024); // direct buffer
                long size = fic.size(), n = 0;
                // time to play the old game - clear, read, flip and write
                while (n < size) {
                    buffer.clear(); // makes the buffer ready by resetting the pointers
                    if (fic.read(buffer) < 0) // fill the buffer by reading from channel
                    {
                        break;
                    }
                    buffer.flip(); // makes the buffer writing the data just read
                    // buffer.
                    // n+= fcout.write(buffer);
                }
            } // direct buffer
        }

        return null;
    }
}
