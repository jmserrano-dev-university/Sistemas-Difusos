/**
 * Clase Variable REpresenta una variable del sistema
 * @author José Manuel Serrano Mármol
 * @author Raul Salazar de Torres
 */

package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Variable {
    
    //****************************** ATRIBUTOS
    private List<Tripleta> _listaTripletas;
    private int _numTripletas;
    int _iterador;
    private float _rangoInferior;
    private float _rangoSuperior;
    private String _nombreVariable;
    
    //****************************** MÉTODOS

    public Variable() {
        _listaTripletas = new ArrayList<Tripleta>();
        _numTripletas = 0;
        _iterador = 0;
        
        _rangoInferior = 0;
        _rangoSuperior = 0;
        _nombreVariable = "";
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
    
    public float getRangoInferior(){
        return _listaTripletas.get(0).getRangoInferior();
    }
    
    public float getRangoSuperior(){
        return _listaTripletas.get(_listaTripletas.size()-1).getRangoSuperior();
    }
    
    public void setNombreVariable(String nombre){
        _nombreVariable = nombre;
    }
    
    public String getNombreVariable(){
        return _nombreVariable;
    }
    
    
    public void out(){
        for(int i = 0; i < _listaTripletas.size(); i++){
            _listaTripletas.get(i).out();
        }
    }
}
