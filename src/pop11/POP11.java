/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pop11;

// Clase de Java para leer el texto de una secuencia de entrada almacenada en un buffer
import java.io.BufferedReader;
// Clase que nos permite escribir texto en un outputstream, utilizando un buffer
import java.io.BufferedWriter;
// Son los encargados de gestionar las operaciones de entrada/salida, asi como las excepciones del archivo.
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
// Clase de java que se encarga de leer el archivo
import java.io.FileReader;
// Clase de java que se encarga de escribir en el archivo externo
import java.io.FileWriter;
import java.io.IOException;
//
import java.io.InputStreamReader;
// Clase que permite imprimir escritura fuera del archivo
import java.io.PrintWriter;
// Proporciona una variedad de métodos con los que se pueden registrar los datos.
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import static java.time.InstantSource.system;
// Sirve para separar cadenas en tokens 
import java.util.StringTokenizer;

/**
 *
 * @author alumno
 */
public class POP11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("");
         File archivo = new File("archivo.txt");
         System.out.println(archivo.exists());
        if (archivo.exists()){
        try {    
        boolean seCreo = archivo.createNewFile();
        System.out.println(seCreo);
        } catch(IOException ex){
        System.out.println(ex.getMessage());
        }
        }
      System.out.println("###########################");
      FileOutputStream fos = null;
      byte[] buffer = new byte [81];
      int nBytes;
      System.out.println("Escriba texto a guardar en el archivo es:");
      try{
      nBytes= System.in.read(buffer);
      fos = new FileOutputStream("fos.txt");
      fos.write(buffer,0,nBytes);
      }  catch(IOException ex){ 
         System.out.println(ex.getMessage());
      } finally{
         
       if(fos!=null){
           try {
               fos.close();
           } catch (IOException ex){
               System.out.println(ex.getMessage());
           }
       }
      }
      
      System.out.println("##########################");
      FileInputStream fis = null;
      try {
          fis = new FileInputStream("fos.txt");
          nBytes = fis.read(buffer,0,buffer.length);
          String texto= new String (buffer,0,nBytes);
          System.out.println("texto en el archivo");
          System.out.println(texto);
              
      } catch(FileNotFoundException ex){
          System.out.println(ex.getMessage());
      } catch (IOException ex){
          System.out.println(ex.getMessage());
      } finally{
          if(fis!= null){
              try{
                  fis.close();
              } catch (IOException ex){
                  System.out.println(ex.getMessage());
              }
           
           }
       }
        System.out.println("###########FileWrite###############");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("escribe el texto para el archivo");
        try{
           String texto2 = br.readLine();
           //System.out.println(texto2)
           FileWriter fw = new FileWriter("fw.csv");
           BufferedWriter bw= new BufferedWriter(fw);
           PrintWriter salida = new PrintWriter(bw);
           salida.println(texto2);
           
           for(int i= 0; i < 10; i++){
           salida.println("Linea"+1);
           }
           for(int i=0;i<10;i++){
            salida.println("Enrique,Ichazo,Bautista,242424242"+i+"2,"+i);
           }
           
           salida.close();
           } catch (IOException ex){
               System.out.println(ex.getMessage());
              }finally{
        }
           
        System.out.println("###############FileReader###############"); 
        
        try{
        
        FileReader fr= new FileReader("fw.csv");
        br= new BufferedReader(fr);
            System.out.println("El texto del archivo es :");
        
         String linea = br.readLine();
         while(linea!= null){
             System.out.println(linea);
             linea=br.readLine();
         }
         br.close();
        } catch(FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        System.out.println("###############StringTokenizer###############");
        String cadena = "Enrique,Ichazo,Bautista,24242424292,9";
        StringTokenizer tokenizador = new StringTokenizer(cadena,",");
        while(tokenizador .hasMoreTokens()){
            System.out.println(tokenizador.nextToken());
        }
        System.out.println("##############Alumno###############");
      
        
         String[] alumno = new String[10];
       
       alumno[0]= "Enrique, Ichazo, Bautista, 20, 242535";
       alumno[1]= "Juan, perez, Granadilla, 21, 222738";
       alumno[2]= "Sofia, Rivera, Caloca, 20, 161803";
       alumno[3]= "Ximena, Flores, Rangel, 20, 333333";
       alumno[4]= "Santiago, Alessio, Robles, 20, 990803";
       alumno[5]= "Gerardo, Santigo, Ruiz, 20, 242535";
       alumno[6]= "Mario, Silva, Cordoba, 21, 121517";
       alumno[7]= "Ricardo, Quevedo, Gonzales, 32, 105761";
       alumno[8]= "Gustavo, Ramirez, Arteaga, 30, 723690";
       alumno[9]= "Juan, Dinenno, Cara, 27, 133567";
       
        try (BufferedReader reader = new BufferedReader(new FileReader("text.csv"))) {
            for (int i = 0; i < 10; i++) {
                alumno[i] = reader.readLine();
            }
        } catch (IOException e) {
             
        }
        for (String s : alumno) {
            StringTokenizer st = new StringTokenizer(s, ",");
            while (st.hasMoreTokens()) {
                System.out.println( st.nextToken());
            }
      
        }
       
      
                
        }
    
    }
            
         
        
      
    
    
    

