import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class hiloCliente extends Thread{
    private Socket socket_cliente;
    public hiloCliente(Socket socket_cliente) {
        this.socket_cliente = socket_cliente;
    }
    public void run () {
        try {
            //Crear buffers par arecibir y enviar datps al cliente
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket_cliente.getInputStream()));
            PrintWriter salida = new PrintWriter(socket_cliente.getOutputStream(), true);
            //Leer datos recibidos desde el cliente
            String datos_recibidos = entrada.readLine();
            System.out.println("Mensaje recibido: "+datos_recibidos);
            //Enviar datos al cliente
            String mensaje = "Hola, soy el servidor";
            salida.println(mensaje);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
