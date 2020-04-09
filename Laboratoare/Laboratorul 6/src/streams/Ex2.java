package streams;

import java.io.*;
import java.util.logging.FileHandler;

public class Ex2 {
    private static final String BASE_PATH = "./src/streams";


    public static void main(String[] args) {
        // fluxuri la nivel de fisier
        try (FileReader fr = new FileReader(BASE_PATH + "/file1.txt");
             FileWriter fw = new FileWriter(new File(BASE_PATH + "/file2.txt"), true)) {

            int c;
            while ((c = fr.read()) != -1) {
                fw.write(c);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream(BASE_PATH + "/file2.txt");
             FileOutputStream fos = new FileOutputStream(BASE_PATH + "/file3.txt")) {
            int size = fis.available();
            byte[] buffer = new byte[size];
            fis.read(buffer,12,12);
            fos.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
