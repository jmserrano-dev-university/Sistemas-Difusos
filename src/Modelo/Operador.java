/**
 * Clase Operador
 * @author José Manuel Serrano Marmol
 */

package Modelo;


public class Operador {
    public static float TnormaMIN(float a, float b){
        return Math.min(a, b);
    }
    
    public static float TnormaPROD(float a, float b){
        return a * b;
    }
    
    public static float TConormaMAX(float a, float b){
        return Math.max(a, b);
    }
    
    public static float TconormaSUMALG(float a, float b){
        return a + b - a * b;
    }
}
