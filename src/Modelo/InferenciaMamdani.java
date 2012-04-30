/**
 * Clase InferenciaMamdani
 * @author José Manuel Serrano Mármol
 */

package Modelo;

import java.util.ArrayList;
import java.util.List;


public class InferenciaMamdani {
    public List<Variable> _baseDatos;
    public List<Regla> _baseReglas;
    public List<Regla> _reglasDisparadas;

    public InferenciaMamdani() {
        _baseDatos = new ArrayList<Variable>();
        _baseReglas = new ArrayList<Regla>();
        _reglasDisparadas = new ArrayList<Regla>();
    }
    
    private void CalcularGradoPertenencia(List<Float> valores){
        for(int i = 0; i < _baseReglas.size(); i++){
            Regla r = _baseReglas.get(i);
            for(int j = 0; j < r.numTripletasRegla() - 1; j++){
                r.leerParteRegla(j).gradoPertenencia(valores.get(j));
            }
        }
    }
    
    private void CalcularPertenenciaReglas(){
        for(int i = 0; i < _baseReglas.size(); i++){
            Regla r = _baseReglas.get(i);
            for(int j = 0; j < r.numTripletasRegla() - 1; j++){
                if(r.leerParteRegla(j).getGradoPertenencia() == 0.0){
                    r.setPertenecia(false);
                }
            }
            if(r.getPertenencia()){
                _reglasDisparadas.add(r);
            }
        }
    }
    
    private void CalcularAlturas(int operacion){
        for(int i = 0; i < _baseReglas.size(); i++){
            Regla r = _baseReglas.get(i);
            List<Float> valores = new ArrayList<Float>();
            
            if(r.getPertenencia()){
                for(int j = 0; j < r.numTripletasRegla() - 1; j++){
                    valores.add(r.leerParteRegla(j).getGradoPertenencia());
                }
                switch(operacion){
                    case Operador.TNORMAMIN:
                        r.anadirAltura(Operador.TnormaMIN(valores));
                    break;
                     
                    case Operador.TNORMAPROD:
                        r.anadirAltura(Operador.TnormaPROD(valores));
                    break;
                        
                    case Operador.TCONORMAMAX:
                        r.anadirAltura(Operador.TConormaMAX(valores));
                    break;
//                        
//                    case Operador.TCONORMASUMAALG:
//                        r.anadirAltura(Operador.TconormaSUMALG(valores));
//                    break;
                }
            }
        }
    }
    
    public void ejecutarMamdani(List<Float> entradas, int operacion){
        CalcularGradoPertenencia(entradas);
        //CalcularPertenenciaReglas();
        //CalcularAlturas(operacion);
    }
}
