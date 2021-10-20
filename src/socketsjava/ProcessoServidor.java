/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketsjava;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ProcessoServidor {

    public static void main(String[] args) throws IOException {

        // Abre uma porta e fica esperando algum cliente se conectar
        ServerSocket servidor = new ServerSocket(12345);
        // Se conseguir abrir a porta, irá exibir a mensagem 
        System.out.println("Porta 12345 aberta!");

        int i = 0;
        while (i < 4) {
            // Se uma conexão é aceita...
            Socket processoCliente = servidor.accept();
            System.out.println("Nova conexão com o cliente "
                    + processoCliente.getInetAddress().getHostAddress());

            // Referencia a classe que trata da comunicacao e cria uma thread   
            EntradaServidor input = new EntradaServidor(processoCliente);
            Thread ti = new Thread(input);
            ti.start();
        }
        servidor.close();
    }
}
