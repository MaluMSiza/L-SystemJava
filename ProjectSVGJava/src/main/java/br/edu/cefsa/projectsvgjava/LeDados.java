/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.cefsa.projectsvgjava;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Integer.parseInt;

import java.util.Scanner;

/**
 *
 * @author maria
 */
public class LeDados {
    
    public LeDados() {}
   
    public static void main(String args[])throws FileNotFoundException, IOException{
       
        File arquivotexto = new File("gramatica.txt");
        Scanner scan = new Scanner(arquivotexto);
        
	String	Axioma   = scan.nextLine();
        int     numLoops = parseInt(scan.nextLine());
        int     curva = parseInt(scan.nextLine());
        int     numRegras = parseInt(scan.nextLine());
        
        String[] Regras = new String[numRegras];
        String[] tituloRegras = new String[numRegras];
        
        for(int i=0; i < numRegras; i++){
            String[] textoquebrado = scan.nextLine().split("=") ;
            tituloRegras[i] = textoquebrado[0];
            Regras[i] = textoquebrado[1];
        }
        
        String palavra = Axioma;
        
        for(int i = 0; i< numLoops; i++){
            for(int j = 0; j< numRegras; j++){
                palavra = palavra.replaceAll(tituloRegras[j], Regras[j]);
            }
        }   
	char[] letrasPalavra = palavra.toCharArray();
        double anguloAtual = 0;
        double[] pontoAtual = {1000,1000};
        
        String textoSVG ="<svg height=\"3000\" width=\"3000\" style=\"background-color:#d4486f\">\n"
                + "<polyline points=\"";
        
        for(char a: letrasPalavra){
            
            if( a == '+')
                anguloAtual += curva;
            else if( a == '-')
                anguloAtual -= curva;
            else if( a == 'F'){
                double passoAtual = 9;

                double[] novoPonto = {pontoAtual[0] + passoAtual * Math.cos(Math.toRadians(anguloAtual)),
                                      pontoAtual[1] + passoAtual * Math.sin(Math.toRadians(anguloAtual))};
                textoSVG += " "+novoPonto[0]+","+novoPonto[1]+" ";
                pontoAtual[0] = novoPonto[0];
                pontoAtual[1] = novoPonto[1];     
            }
        }
        
        textoSVG +="\"style=\"fill:#dacdbd;stroke:#ef97a3;stroke-width:2\" /></svg>";
        
        FileWriter imagemHTML = new FileWriter("imagemHTML.html");
        imagemHTML.write("<html>\n<body>\n"+ textoSVG +"\n</body>\n</html>");
        imagemHTML.close();
    }
}
