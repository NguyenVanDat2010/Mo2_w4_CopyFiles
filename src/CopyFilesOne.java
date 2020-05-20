import java.io.*;

/** Chương trình sau chạy nhanh hơn vì nó đọc toàn bộ tệp đầu vào thành một mảng byte
 * và sau đó ghi toàn bộ mảng byte vào tệp đầu ra*/

public class CopyFilesOne {
    public static void main(String[] args) {
        args = new String[]{"input.txt", "output.txt"};

        if (args.length < 2) {
            System.out.println("Please provide input and output files");
            System.exit(0);
        }

        String inputFile = args[0];
        String outputFile = args[1];

        try (InputStream inputStream = new FileInputStream(inputFile);
             OutputStream outputStream = new FileOutputStream(outputFile);
        ) {
            long fileSize = new File(inputFile).length();

            //khởi tạo số lượng phần tử fileSize
            byte[] allBytes = new byte[(int) fileSize];

            inputStream.read(allBytes);
            outputStream.write(allBytes);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
