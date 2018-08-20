package core;

import javax.xml.bind.DatatypeConverter;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class Hashing {

    public static void main(String[] args) {
        Hashing hashing = new Hashing();
        String filename = "/Users/Viper/Iphone4S Pics/IMG_0001.MOV";
//        String hash = hashing.readEntireFile(filename);
        String hash = hashing.readChunks(filename);
        System.out.println(hash);
//        hashing.bytestoMB();
    }

    private String readEntireFile(String filename) {

        String checkSum = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(Files.readAllBytes(Paths.get(filename)));
            byte[] digest = messageDigest.digest();
            checkSum = DatatypeConverter.printHexBinary(digest).toUpperCase();
            long membytes = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
            long MEGABYTE = 1024L * 1024L;
            System.out.println("Total: "+ Runtime.getRuntime().totalMemory()/MEGABYTE + " Mb");
            System.out.println("Free: "+ Runtime.getRuntime().freeMemory()/MEGABYTE + " Mb");
            System.out.println("Used: "+ membytes/MEGABYTE + " Mb");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return checkSum;
    }

    private String readChunks(String filename) {

        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        String checkSum = null;
        try(BufferedInputStream in = new BufferedInputStream(new FileInputStream(filename))) {

            byte[] buff = new byte[4096];
            int len;
            while ((len = in.read(buff)) != -1) {
                messageDigest.update(buff);
            }
            byte[] digest = messageDigest.digest();
            checkSum = DatatypeConverter.printHexBinary(digest).toUpperCase();
            long membytes = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
            long MEGABYTE = 1024L * 1024L;
            System.out.println("Total: "+ Runtime.getRuntime().totalMemory()/MEGABYTE + " Mb");
            System.out.println("Free: "+ Runtime.getRuntime().freeMemory()/MEGABYTE + " Mb");
            System.out.println("Used: "+ membytes/MEGABYTE + " Mb");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return checkSum;
    }
}
