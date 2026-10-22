import java.io.*;
import java.util.Scanner;

public class claseDelGrep {
    /**
     * Este main ejecutará un proceso findstr el cual recibirá
     * un argumento en la llamada de la clase por consola ej: java (nombreClase).java \<patrón\>.
     * El programa te preguntará por un maximo de 6 frase, a menos de introduzcas una cadena vacia
     * Si la frase contiene el patrón del argumento pasado en consola, devolverá una confirmación de que la frase contiene dicho argumento
     * si no lo contiene, recibirá otro mensaje.
     *
     * @param \<Patrón pasado en consola\>
     * @author Daniel
     * @Version 1.0
     */
    public static void main(String[] args) {
        //System.out.println(args[0]);
        try {
            Scanner sc = new Scanner(System.in);
            int i = 0;
            String linea = "...";
            while(i < 6){
                //Proceso que inicia la ejecución en consola del findstr
                ProcessBuilder pb = new ProcessBuilder("findstr", args[0]);
                Process p = pb.start();

                System.out.println("Introduce una frase:");
                linea = sc.nextLine();

                //Si la frase pasada está vacia, el bucle se rompe
                if(linea.isEmpty()){break;}


                PrintWriter pw = new PrintWriter(p.getOutputStream());
                pw.write(linea);
                pw.flush();
                pw.close();

                //Lectura de lineas
                InputStream in = p.getInputStream();
                InputStreamReader inp = new InputStreamReader(in);
                BufferedReader bfRead = new BufferedReader(inp);
                String lot = bfRead.readLine();

                //Si la linea recibida en el codigo está vacia, significa que no se a encontrado el patrón pasado
                if(lot != null) {
                    System.out.println("Se ha encontrado el patron "+ args[0] +" en la palabra " + lot);
                }else {
                    System.out.println("No se ha encontrado el patrón");
                }

                i++;
            }

        } catch (IOException e) {
            System.err.println(e);
        }

    }
}
