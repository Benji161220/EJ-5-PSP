import java.io.*;
import java.util.Scanner;

public class Mayusculas {
    public static void main(String[] args) {
        try {
            System.out.println("Introduce el texto para convertirlo en mayusculas");
            Scanner teclado = new Scanner(System.in);
            String texto, linea;
            ProcessBuilder pb = new ProcessBuilder("java", "src/Hijo.java");
            pb.redirectErrorStream(true);
            Process hijo;

            OutputStream os;
            PrintWriter pw;
            InputStream is;
            BufferedReader br;
            do {
                hijo = pb.start();
                os = hijo.getOutputStream();
                pw = new PrintWriter(os,true);
                is = hijo.getInputStream();
                br = new BufferedReader(new InputStreamReader(is));
            texto = teclado.nextLine();
            pw.println(texto);
            pw.flush();
            if(!texto.equals("fin")){
                while ((linea = br.readLine()) != null) {
                    System.out.println("Desde el hijo: " + linea);
                }
            }
            } while (!texto.equals("fin"));
            hijo.waitFor();
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

    }
}
