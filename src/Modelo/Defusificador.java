/**
 * Clase Defusificador Metodo de defusificación del sistema difuso
 * @author José Manuel Serrano Mármol
 * @author Raul Salazar de Torres
 */

package Modelo;

import java.util.ArrayList;
import java.util.List;


public class Defusificador {
    private InferenciaMamdani _mamdani;
    private List<Float> _resultados;
    
    /**
     * Constructor
     * @param m Inferencia de Mamdani
     */
    public Defusificador(InferenciaMamdani m) {
        _mamdani = m;
        _resultados = new ArrayList<Float>();
    }
    
    /**
     * Función para ejecutar la defusificación
     * @return Valor de defusificación
     */
    public float ejecutarDefusificacion(){
        _resultados.clear();
        for(int i = 0; i < _mamdani._reglasDisparadas.size(); i++){
            Regla r = _mamdani._reglasDisparadas.get(i);
            float A, B, C, D;
            Tripleta t = r.leerParteRegla(r.numTripletasRegla()-1);
            
            if(t.esTriangulo()){ //Es triangulo
                A = t.getRangoInferior();
                D = t.getRangoSuperior();
                
                float []valoresIntermedios = t.getValorIntermedio();
                
                B = A + (valoresIntermedios[0] - A) * r.getAltura();
                C = D + (valoresIntermedios[0] - D) * r.getAltura();
            }else{ //Es trapecio
                A = t.getRangoInferior();
                D = t.getRangoSuperior();
                
                float []valoresIntermedios = t.getValorIntermedio();
                
                B = A + (valoresIntermedios[0] - A) * r.getAltura();
                C = D + (valoresIntermedios[1] - D) * r.getAltura();
            }
            
            _resultados.add((A + B + C + D) / 4);
        }
        
        float sumatotal = 0;
        float sumaAlturas = 0;
        
        for(int i = 0; i < _resultados.size(); i++){
            sumatotal += _mamdani._reglasDisparadas.get(i).getAltura() * _resultados.get(i);
            sumaAlturas += _mamdani._reglasDisparadas.get(i).getAltura();
        }
        return sumatotal / sumaAlturas;
    }
    
}
