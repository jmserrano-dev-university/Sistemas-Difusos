/**
 * Clase Variable
 * @author José Manuel Serrano Mármol
 */

package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Variable {
    
    //****************************** ATRIBUTOS
    private List<Tripleta> _listaTripletas;
    private int _numTripletas;
    int _iterador;
    
    //****************************** MÉTODOS

    public Variable() {
        _listaTripletas = new ArrayList<Tripleta>();
        _numTripletas = 0;
        _iterador = 0;
    }
    
    public void anadirTripleta(Tripleta t){
        _listaTripletas.add(t);
        _numTripletas++;
    }
    
    public Tripleta getSiguienteTripleta(){
        if(_iterador < _numTripletas){
            return _listaTripletas.get(_iterador++);
        }else{
            _iterador = 0;
            return null;
        }
        
    }
    
    public Tripleta existeTripleta(Tripleta t){
        for (int i = 0; i < _listaTripletas.size(); i++){
            if(_listaTripletas.get(i).tripletasIguales(t)){
                return _listaTripletas.get(i);
            }
        }
        return null;
    }
    
    public int getNumeroTripletas(){
        return _numTripletas;
    }
    
    public void out(){
        for(int i = 0; i < _listaTripletas.size(); i++){
            _listaTripletas.get(i).out();
        }
    }
}
