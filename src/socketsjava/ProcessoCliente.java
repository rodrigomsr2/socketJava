/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketsjava;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ProcessoCliente {
   public static void main(String[] args)
           throws UnknownHostException, IOException {
    
     // Tenta se conectar a um servidor no IP 127.0.0.1 (máquina local) e porta 12345:
       Socket conexao = new Socket("127.0.0.1", 12345);
       System.out.println("O cliente se conectou ao servidor!");
      
     // Referencia a classe que trata da comunicacao/entrada e cria uma thread  
       EntradaCliente input = new EntradaCliente(conexao);
       Thread ti = new Thread(input);
       ti.start();
      
     // Referencia a classe que trata da comunicacao/saida e cria uma thread  
       SaidaCliente output = new SaidaCliente(conexao);
       Thread to = new Thread(output);
       to.start();
      
   }
}