/**
 * Clase Regla Representa una regla del sistema
 * @author José Manuel Serrano Mármol
 * @author Raul Salazar de Torres
 */

package Modelo;

import java.util.ArrayList;
import java.util.List;


public class Regla {
    
    //****************************** ATRIBUTOS
    private List<Tripleta> _regla;
    private int _numElementos;
    private boolean _pertenece;
    private float _altura;
    
    //****************************** MÉTODOS
    
    /**
     * Constructor
     */
    public Regla() {
        _regla = new ArrayList<Tripleta>();
        _numElementos = 0;
        _pertenece = true;
        _altura = 0;
    }
    
    public void anadirAltura(float h){
        _altura = h;
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
    
    public int numTripletasRegla(){
        return _numElementos;
    }
    
    public void setPertenecia(boolean p){
        _pertenece = p;
    }
    
    public boolean getPertenencia(){
        return _pertenece;
    }
    
    public float getAltura(){    
        return _altura;
    }
    
    public void limpiarPertenencia(){
        _pertenece = true;
    }
    
    public void limpiarAltura(){
        _altura = 0;
    }
    
    public void out(){
        for(int i = 0; i < _regla.size(); i++)
            leerParteRegla(i).out();
    }
}
