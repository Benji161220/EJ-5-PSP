import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Hijo {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String mensaje = br.readLine();

            System.out.println(mensaje.toUpperCase());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
