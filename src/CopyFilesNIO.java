import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/** Đọc và ghi tệp nhị phân bằng API I / O tệp mới (NIO)
 * Phương pháp này dành cho việc đọc các tệp nhỏ, không phải tệp lớn.*/

public class CopyFilesNIO {
    public static void main(String[] args) {
        args = new String[]{"input.txt", "output.txt"};

        if (args.length < 2) {
            System.out.println("Please provide the input file");
            System.exit(0);
        }

        String inputFile = args[0];
        String outputFile = args[0];

        try {
            long start = System.currentTimeMillis();

            byte[] allBytes = Files.readAllBytes(Paths.get(inputFile));
            Files.write(Paths.get(outputFile), allBytes);

//            Files.close();

            long end = System.currentTimeMillis();
            System.out.println("Copied in " + (end - start) + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
