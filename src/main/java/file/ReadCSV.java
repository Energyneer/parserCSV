package file;

import java.io.*;

public class ReadCSV {
    public static void main(String[] args) throws IOException {
        File file = new File("/home/konstantin/Downloads/data-20190423t000000-structure-20171231t000000.csv");
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), "windows-1251"));
        for (int i = 0; i < 10; i++) {
            System.out.println(bufferedReader.readLine());
        }
        bufferedReader.close();
    }
}
