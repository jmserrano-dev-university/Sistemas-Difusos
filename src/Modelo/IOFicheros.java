/**
 * Clase IOFicheros que lee ficheros de base de datos y reglas difusas
 * @author José Manuel Serrano Mármol
 */

package Modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IOFicheros {
    
    
    //****************************** ATRIBUTOS
    private Scanner _sc;
    
    
    
    
    //****************************** MÉTODOS
    
    /**
     * Constructor
     * @param nombreFichero 
     */
    public IOFicheros(String nombreFichero) {
        try {
            _sc = new Scanner(new File(nombreFichero));
        } catch (FileNotFoundException ex) {
            System.out.println("Error al abrir el fichero!");
        }
    }
    
    /**
     * Lectura de la base de datos con las variables difusas
     * @return 
     */
    public List<Variable> leerBaseDatos(){
        List<Variable> baseDatos = new ArrayList<Variable>();
        
        _sc.nextLine(); //Base de Datos inicial:
        
        while(_sc.hasNext()){
            _sc.nextLine(); //Línea vacía    
            _sc.nextLine(); //Variable ...
            
            Variable v = new Variable();
            
           while(_sc.hasNext("Etiqueta")){
               Tripleta t = new Tripleta();
               
                String token = _sc.nextLine();
                token = token.replace('(', ',');
                token = token.replace(')', ',');
                String[] num = token.split(",");
                
                for(int i = 1; i < num.length; i++){
                    t.anadirElementoTripleta(Float.parseFloat(num[i]));
                }
                v.anadirTripleta(t);
           }
           baseDatos.add(v);
        }
        
        return baseDatos;
    }
    
    /**
     * Lectura de las reglas difusas
     * @param numVariables 
     */
    public List<Regla> leerReglas(List<Variable> listaVarables){
        List<Regla> baseReglas = new ArrayList<Regla>();
        
        _sc.next();
        _sc.next();
        _sc.next();
        int numReglas = _sc.nextInt(); _sc.nextLine();
        
        for(int h = 0; h < numReglas; h++){
            Regla r = new Regla();
            _sc.nextLine();
            
            for(int j = 0; j < listaVarables.size(); j++){
                String token = _sc.nextLine();
                String[] num = token.split(" ");
                Tripleta t = new Tripleta();
                
                for(int i = 0; i < num.length; i++){
                    if(!num[i].trim().isEmpty()){
                        t.anadirElementoTripleta(Float.parseFloat(num[i]));
                    }
                }
                
                //Realizamos una búsqueda para ver si existe dichas variables
                //sino existen ERROR en la base de reglas
                if(listaVarables.get(j).existeTripleta(t)!= null){
                    r.anadirTripleta(t);
                }else{
                    System.err.println("ERROR: La base de reglas no coincide con la Base de datos");
                }
            }
            baseReglas.add(r);
        }
        return baseReglas;
    }
    
}
