/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketsjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SaidaCliente implements Runnable {

    private Socket cliente;

    // Construtor do metódo
    SaidaCliente(Socket cliente) {
        this.cliente = cliente;
    }

    // Objeto que permite a leitura do teclado
    BufferedReader teclado = new BufferedReader(
            new InputStreamReader(System.in));

    @Override
    public void run() {

        PrintStream saida = null;
        try {
            saida = new PrintStream(cliente.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(SaidaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Loop principal
        while (true) {
            try {
                // Lê a linha do teclado e envia para o servidor 
                saida.println(teclado.readLine());
            } catch (IOException e) {
                System.out.println("..");
            }
        }
    }
}
