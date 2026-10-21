import java.io.*;
import java.util.Scanner;

public class claseDelGrep {
    public static void main(String[] args) {
        //System.out.println(args[0]);
        try {
            Scanner sc = new Scanner(System.in);
            int i = 0;
            String linea = "...";
            while(i < 6){
                ProcessBuilder pb = new ProcessBuilder("findstr", args[0]);
                Process p = pb.start();
                System.out.println("Introduce una frase:");
                linea = sc.nextLine();
                if(linea.isEmpty()){break;}
                PrintWriter pw = new PrintWriter(p.getOutputStream());

                pw.write(linea);
                pw.flush();
                pw.close();

                InputStream in = p.getInputStream();
                InputStreamReader inp = new InputStreamReader(in);
                BufferedReader bfRead = new BufferedReader(inp);
                String lot = bfRead.readLine();
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
