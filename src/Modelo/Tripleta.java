/**
 * Clase Tripleta
 * @author José Manuel Serrano Márnol
 */

package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Tripleta {
    //****************************** ATRIBUTOS
    private List<Float> _listaTripleta;
    private int _numElementos;
    private float _gradoPertenencia;
    private String _etiqueta;
    
    
    //****************************** MÉTODOS

    public Tripleta() {
        _listaTripleta = new ArrayList<Float>();
        _numElementos = 0;
        _gradoPertenencia = 0;
        _etiqueta = "";
    }
    
    public Tripleta(String etiqueta) {
        _listaTripleta = new ArrayList<Float>();
        _numElementos = 0;
        _gradoPertenencia = 0;
        _etiqueta = etiqueta;
    }
    
    public int getNumElementos(){
        return _numElementos;
    }
    
    public void anadirElementoTripleta(float elemento){
        _listaTripleta.add(elemento);
        _numElementos++;
    }
    
    public List<Float> leerElementosTripleta(){
        return _listaTripleta;
    }
    
    public void setGradoPertenencia(float g){
        _gradoPertenencia = g;
    }
    
    public float getGradoPertenencia(){
        return _gradoPertenencia;
    }
    
    public float getRangoInferior(){
        return _listaTripleta.get(0);
    }
    
    public float getRangoSuperior(){
        return _listaTripleta.get(_listaTripleta.size() - 1);
    }
    
    public String getNombreEtiqueta(){
        return _etiqueta;
    }
    
    public boolean dentroRango(float valor){
        if(valor >= getRangoInferior() && valor <= getRangoSuperior()){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean tripletasIguales(Tripleta t){
        if(_numElementos != t._numElementos){
            return false;
        }
        
        for(int i = 0; i < _numElementos; i++){
            if(!_listaTripleta.get(i).equals(t._listaTripleta.get(i))){
                return false;
            }
        }
        return true;
    }
    
    public void out(){
        for(int i = 0; i < _listaTripleta.size(); i++)
            System.out.print(_listaTripleta.get(i) + " | ");
        System.out.println();
    }
}
