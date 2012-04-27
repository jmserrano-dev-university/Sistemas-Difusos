/**
 * Clase Regla
 * @author José Manuel Serrano Mármol
 */

package Modelo;

import java.util.ArrayList;
import java.util.List;


public class Regla {
    
    //****************************** ATRIBUTOS
    private List<Tripleta> _regla;
    private int _numElementos;
    
    //****************************** MÉTODOS

    public Regla() {
        _regla = new ArrayList<Tripleta>();
        _numElementos = 0;
    }
    
    public void anadirTripleta(Tripleta t){
        _regla.add(t);
        _numElementos++;
    }
    
    public Tripleta leerParteRegla(int i){
        if(i > _numElementos){
            return null;
        }else{
            return _regla.get(i);
        }
    }
    
    public void out(){
        for(int i = 0; i < _regla.size(); i++)
            leerParteRegla(i).out();
    }
}
