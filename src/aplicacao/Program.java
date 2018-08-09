/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

import java.util.Scanner;
import model.entidade.ContaBancaria;
import model.exceptions.DomainException;

/**
 *
 * @author Nathan
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try{
            System.out.println("Entre com os dados da conta: ");
            System.out.print("Numero: ");
            int num = sc.nextInt();
            sc.next();
            System.out.print("Titular: ");
            String nome = sc.nextLine();
            System.out.print("Saldo inicial: ");
            double saldo = sc.nextDouble();
            System.out.print("Limite de saque: ");
            double limite = sc.nextDouble();
            
            ContaBancaria conta = new ContaBancaria(num, nome, saldo, limite);
            
            System.out.print("Digite a quantidade para saque: ");
            double saque = sc.nextDouble();
            
            conta.saque(saque);
            System.out.println("Novo saldo: "+conta.getSaldo());
            
        }catch(DomainException e){
            System.out.println("Erro: "+e.getMessage());
        }
        catch(RuntimeException e){
            System.out.println("Erro inesperado.");
        }
        sc.close();
    }
    
}
