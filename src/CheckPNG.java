import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/** Chương trình sau đây đọc 8 byte đầu tiên của tệp để xác định xem đó
 *  có phải là định dạng hình ảnh PNG hay không
 *  */

public class CheckPNG {
    private static int[] pngSignature = {137, 80, 78, 71, 13, 10, 26, 10};

    public static void main(String[] args) {
        args = new String[]{"input.txt", "output.txt"};

        if (args.length < 1) {
            System.out.println("Please provide the input file");
            System.exit(0);
        }
        String inputFile = args[0];

        try {
            InputStream inputStream = new FileInputStream(inputFile);
//            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(inputFile))

            int[] headerBytes = new int[8];
            boolean isPNG = true;
            for (int i = 0; i < 8; i++) {
                headerBytes[i] = inputStream.read();
                if (headerBytes[i] != pngSignature[i]) {
                    isPNG = false;
                    break;
                }
            }
            System.out.println("Is file PNG? " + isPNG);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
