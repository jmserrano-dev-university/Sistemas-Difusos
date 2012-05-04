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
    
    public float[] getValorIntermedio(){
        if(esTriangulo()){
            float[] valores = {_listaTripleta.get(1)};
            return valores;
        }else{
            float[] valores = {_listaTripleta.get(1), _listaTripleta.get(2)};
            return valores;
        }
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
    
    public void gradoPertenencia(float valor){
        if(valor > getRangoInferior() && valor < getRangoSuperior()){ 
           if(esTriangulo()){//Tringulo
               if(valor <= _listaTripleta.get(1)){
                   _gradoPertenencia = (valor - _listaTripleta.get(0)) / (_listaTripleta.get(1) - _listaTripleta.get(0));
               }else{
                   _gradoPertenencia = (valor - _listaTripleta.get(1)) / (_listaTripleta.get(2) - _listaTripleta.get(1));
               }
               
           }else{ //Trapecio
               if(valor < _listaTripleta.get(1)){
                   _gradoPertenencia = (valor - _listaTripleta.get(0)) / (_listaTripleta.get(1) - _listaTripleta.get(0));
               }else{
                   if(valor >_listaTripleta.get(2)){
                       _gradoPertenencia = (valor - _listaTripleta.get(2)) / (_listaTripleta.get(3) - _listaTripleta.get(2));
                   }else{ //Está en la parte plana del trapecio
                       _gradoPertenencia = 1;
                   }
               }
           }
        }else{ //Sale fuera de rango
            _gradoPertenencia = 0;
        }
        
    }
    
    public void limpiarGradoPertenencia(){
        _gradoPertenencia = 0;
    }
    
    public boolean esTriangulo(){    
        if(_numElementos == 3){
            return true;
        }else{
            return false;
        }
    }
    
    
    public void out(){
        for(int i = 0; i < _listaTripleta.size(); i++)
            System.out.print(_listaTripleta.get(i) + " | ");
        System.out.println();
    }
}
