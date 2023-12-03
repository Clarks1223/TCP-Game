import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class clienteTCP {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String mensaje ="";
        try {
            while (!(mensaje.equals("s"))) {
            //Crear socket para conectarse al sv
            Socket socket_cliente = new Socket("172.31.118.74",1213);
            System.out.println("Cliente conectado");
                //Crear buffers par arecibir y enviar datps al cliente
                BufferedReader entrada = new BufferedReader(new InputStreamReader(socket_cliente.getInputStream()));
                PrintWriter salida = new PrintWriter(socket_cliente.getOutputStream(), true);
                //Enviar datos al cliente
                System.out.print("Mensaje: ");
                mensaje = sc.nextLine();
                salida.println(mensaje);
                String datos_recibidos = entrada.readLine();
                System.out.println("Respuesta: "+datos_recibidos);
                socket_cliente.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}