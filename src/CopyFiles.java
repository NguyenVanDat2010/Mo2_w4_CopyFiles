import java.io.*;

/**Chương trình này sao chép một tệp này sang tệp khác, một byte mỗi lần.
 * Tệp nguồn và tệp đích được cung cấp từ các đối số của dòng lệnh:
 * Chương trình này chạy rất chậm vì nó sao chép chính xác một byte mỗi lần.*/

public class CopyFiles {
    public static void main(String[] args) throws IOException {
        args = new String[]{"input.txt", "output.txt"};

        if (args.length < 2) {
            System.out.println("Please provide input and output files");
            System.exit(0);
        }

        String inputFile = args[0];
        String outputFile = args[1];

//        BufferedWriter bufferedWriter1 = new BufferedWriter(new FileWriter(inputFile));
//        BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(outputFile));
//        bufferedWriter1.write("abcxyz");
//        bufferedWriter1.close();

        try (InputStream inputStream = new FileInputStream(inputFile);
             OutputStream outputStream = new FileOutputStream(outputFile)
        ) {
            int byeRead;
            while ((byeRead = inputStream.read()) != -1) {
                outputStream.write(byeRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
