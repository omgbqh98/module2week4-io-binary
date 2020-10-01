import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {
    //copy thu muc chua file
    private static void copyFileUsingJavaFiles(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }


    //copy file:
    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;

        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] bytes = new byte[1024];
            int length;
            while ((length = is.read(bytes)) > 0) {
                os.write(bytes,0,length);
            }
        }finally {
            is.close();
            os.close();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("input source file: ");
        String sourcePath = scanner.nextLine();
        System.out.println("input destination file: ");
        String desPath = scanner.nextLine();

        File sourceFile = new File(sourcePath);
        File desFile = new File(desPath);

        try {
            copyFileUsingStream(sourceFile,desFile);
//            copyFileUsingJavaFiles(sourceFile, desFile);
            System.out.println("copy completed");

        } catch (IOException e) {
            System.out.println("ko the copy");
            System.out.println(e.getMessage());
        }
    }
}
