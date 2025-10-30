import java.io.*;
import java.util.Scanner;

public class Mayusculas {
    public static void main(String[] args) {
        try {
            System.out.println("Introduce el texto para convertirlo en mayusculas");
            Scanner teclado = new Scanner(System.in);
            String texto = teclado.nextLine();
            ProcessBuilder pb = new ProcessBuilder("java", "src/Hijo.java");
            pb.redirectErrorStream(true);
            Process hijo = pb.start();

            OutputStream os = hijo.getOutputStream();
            PrintWriter pw = new PrintWriter(os,true);

            InputStream is = hijo.getInputStream();
            pw.println(is);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            pw.println(texto);
            pw.flush();

            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println("Desde el hijo: " + linea);
            }
            hijo.waitFor();
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

    }
}
