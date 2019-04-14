/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unidor_arquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

/**
 *
 * @author Ultron
 */
public class Unidor {
    private Vector <String> arq1;
    private Vector <String> arq2;
    private Vector <String> union;
    public Unidor(Vector <String> arq1,Vector <String> arq2) throws Exception{
        this.setArq1(arq1);
        this.setArq2(arq2);
        this.juntar();
    }
    private void juntar() throws Exception{
        this.union = new Vector <String> (this.arq1.size());
        if(this.arq1.size()!=this.arq2.size()){
            throw new Exception("arquivos não iguais");
        }
        int i=0;
        do{
            String aux = new String("\n"+this.arq1.get(i)+" => "+this.arq2.get(i)+",");
            this.union.add(aux);
            i++;
        }while(i<this.arq1.size());
    }
    private void setArq1(Vector <String> arq1){
        this.arq1=(Vector<String>) arq1.clone();
    }
    private void setArq2(Vector <String> arq2){
        this.arq2=(Vector<String>) arq2.clone();
    }
    public void Escreve(String arqName) throws IOException{
        File file = new File(arqName);

        // Se o arquivo nao existir, ele gera
        if (!file.exists()) {
            file.createNewFile();
        }
        
        FileWriter arq = new FileWriter(file);
        PrintWriter gravarArq = new PrintWriter(arq);
        for(int i=0;i<this.union.size();i++){
            gravarArq.println(this.union.get(i));
        }
        
        
        arq.close();
        gravarArq.close();
    }
    public String toSting(){
        String ret ="";
        for(int i=0;i<this.union.size();i++){
            ret=ret+this.union.get(i);
        }
        return ret;
    }
    
}
