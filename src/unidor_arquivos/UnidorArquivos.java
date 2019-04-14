/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unidor_arquivos;

/**
 *
 * @author Ultron
 */
public class UnidorArquivos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
        LeitorArquivo arq1 =new LeitorArquivo("E://2.txt");
        LeitorArquivo arq2 =new LeitorArquivo("E://1.txt");
        Unidor uni = new Unidor(arq1.getConteudo(),arq2.getConteudo());
        uni.Escreve("E://uniao.txt");
        System.out.println(uni.toSting());
        }catch(Exception erro){
            System.err.println(erro.getMessage());
        }
    }
    
}
