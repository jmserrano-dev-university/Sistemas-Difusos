/**
 * Clase InferenciaMamdani
 * @author José Manuel Serrano Mármol
 * @author Raul Salazar de Torres
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
    
    private void calcularGradoPertenencia(List<Float> valores){
        for(int i = 0; i < _baseReglas.size(); i++){
            Regla r = _baseReglas.get(i);
            System.out.println("REGLA " + (i+1));
            for(int j = 0; j < r.numTripletasRegla() - 1; j++){
                r.leerParteRegla(j).gradoPertenencia(valores.get(j));
                System.out.println("PARTE REGLA " + j + " grado: " + r.leerParteRegla(j).getGradoPertenencia());
            }
        }
    }
    
    private void calcularPertenenciaReglas(int op){
        System.out.println("REGLAS DISPARADAS");
        if(op == Operador.TNORMAMIN || op == Operador.TNORMAPROD){ //OPERADOR MIN - PROD
            for(int i = 0; i < _baseReglas.size(); i++){
                Regla r = _baseReglas.get(i);
                for(int j = 0; j < r.numTripletasRegla() - 1; j++){
                    if(r.leerParteRegla(j).getGradoPertenencia() == 0.0){
                        r.setPertenecia(false);
                    }
                }
                if(r.getPertenencia()){
                    _reglasDisparadas.add(r);
                    System.out.println("REGLA " + (i+1) + " disparada");
                }
            }
        }else{ //OPERADOR MAX - SUM_ALG
            for(int i = 0; i < _baseReglas.size(); i++){
                boolean bandera = false;
                Regla r = _baseReglas.get(i);
                for(int j = 0; j < r.numTripletasRegla() - 1; j++){
                    if(r.leerParteRegla(j).getGradoPertenencia() != 0.0){
                        bandera = true;
                        break;
                    }
                }
                
                if(bandera){
                    r.setPertenecia(true);
                    _reglasDisparadas.add(r);
                    System.out.println("REGLA " + (i+1) + " disparada");
                }else{
                    r.setPertenecia(false);
                }
            }
                
        }
    }
    
    private void calcularAlturas(int operacion){
        System.out.println("CALCULO DE ALTURAS -> OPERACIÓN: " + operacion);
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
                        
                    case Operador.TCONORMASUMAALG:
                        r.anadirAltura(Operador.TconormaSUMALG(valores));
                    break;
                }
                System.out.println("REGLA " + (i + 1) + " " + r.getAltura());
            }
        }
    }
    
    private void limpiarSistema(){
        for(int i = 0; i < _baseReglas.size(); i++){
            _baseReglas.get(i).limpiarAltura();
            _baseReglas.get(i).limpiarPertenencia();
            for(int j = 0; j < _baseReglas.get(i).numTripletasRegla(); j++){
                _baseReglas.get(i).leerParteRegla(j).limpiarGradoPertenencia();
            }
        }
    }
    
    public void ejecutarMamdani(List<Float> entradas, int operacion){
        limpiarSistema();
        _reglasDisparadas.clear();
        calcularGradoPertenencia(entradas);
        calcularPertenenciaReglas(operacion);
        calcularAlturas(operacion);
    }
}
