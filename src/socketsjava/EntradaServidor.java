/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketsjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EntradaServidor implements Runnable {

    private Socket cliente;

    // Construtor do metódo
    EntradaServidor(Socket cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {

        // Obtendo os objetos de controle do fluxo de comunicação
        BufferedReader entrada = null;
        try {
            entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(EntradaServidor.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Loop principal
        while (true) {
            try {
                // Recebe mensagem do cliente
                System.out.println(entrada.readLine());

            } catch (IOException e) {
                System.out.println("..");
            }
        }
    }
}
