import java.io.*;

/** chương trình sau đây chạy nhanh hơn nhiều bằng cách sao chép một đoạn byte mỗi lần
 * (chính xác là 4096 byte mỗi lần)
 *
 *Sử dụng BufferedInputStream và BufferedOutputStream cũng giống như FileInputStream và FileOutputStream .
 * Sự khác biệt duy nhất là một luồng được đệm sử dụng một mảng byte bên trong để đệm đầu vào và đầu ra
 * để giảm số lượng cuộc gọi đến API gốc, do đó làm tăng hiệu suất IO.
 * Theo mặc định, cả BufferedInputStream và BufferedOutputStream đều có bộ đệm bên trong 8192 byte (8KB),
 * nhưng chúng ta có thể chỉ định kích thước bộ đệm tùy chỉnh khi khởi tạo.*/

public class CopyFilesChunk {
    private static final int BUFFER_SIZE = 4096; // 4KB

    public static void main(String[] args) {
        args = new String[]{"input.txt", "output.txt"};

        if (args.length < 2) {
            System.out.println("Please provide input and output files");
            System.exit(0);
        }

        String inputFile = args[0];
        String outputFile = args[1];

        try {
            long start = System.currentTimeMillis();

//            InputStream inputStream = new FileInputStream(inputFile);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(inputFile));
//            OutputStream outputStream = new FileOutputStream(outputFile);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(outputFile));

            byte[] buffer = new byte[BUFFER_SIZE];

            while (bufferedInputStream.read(buffer) != -1) {
                bufferedOutputStream.write(buffer);
            }
            bufferedInputStream.close();
            bufferedOutputStream.close();

            long end = System.currentTimeMillis();
            System.out.println("Copied in " + (end - start) + " ms");
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
