/**
 * CLASE: MiJTextField Implementación de un cuadro de texto usable
 */

package Vista;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.text.Highlighter;


public class MiJTextField extends JTextField{
    
    //Atributos
    private String _valorPorDefecto;
    private Color _colorPorDefecto, _colorTextNormal;
    private boolean _textoPorDefecto = true;
    Highlighter _highlighter;
    
    public MiJTextField(String valorPorDefecto, int tamano, Color colorTextNormal) {
        super(valorPorDefecto, tamano);
        
        _valorPorDefecto = valorPorDefecto;
        _colorPorDefecto = Color.LIGHT_GRAY;
        _colorTextNormal = colorTextNormal;
        
        inicializa();
    }
    
    
    public MiJTextField(String valorPorDefecto, int tamano,Color colorPorDefecto, Color colorTextNormal) {
        this(valorPorDefecto,tamano, colorTextNormal);
        _colorPorDefecto = colorPorDefecto;
    }
    
    private void inicializa(){
        //Ponemos de gris el color del texto por defecto
        setForeground(_colorPorDefecto);
        _highlighter = getHighlighter(); //Guardamos la iluminación al seleccionar
        setHighlighter(null);
        
        // --------------------- EVENTOS DE TECLADO
        addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyPressed(KeyEvent e){
                
                //Comprobamos las teclas de Fin | -> | <-
                if(e.getKeyCode() == 35 || e.getKeyCode() == 37 || e.getKeyCode() == 39){
                if(_textoPorDefecto){
                        e.consume(); //Consumimos la teclas para no hacer nada
                    }
                }else{
                    if(_valorPorDefecto.length() -1 < getText().length()){
                        if(_textoPorDefecto == true){
                            _textoPorDefecto = false;
                            setHighlighter(_highlighter);
                            setForeground(_colorTextNormal);
                            setText("");
                        }
                    }
                }
            }
            
            @Override
            public void keyReleased(KeyEvent e){
               //Cuando borramos, si nos quedamos sin texto ponemos el valor por defecto
                if(e.getKeyCode() == 8){
                    if(getText().length() == 0){
                        _textoPorDefecto = true;
                        setHighlighter(null);
                        setForeground(_colorPorDefecto);
                        setText(_valorPorDefecto);
                        setCaretPosition(0);
                    }
                }
            }
        });
        
        // --------------------- EVENTOS DE RATÓN
        addMouseListener(new MouseAdapter() {
            //Al dejar de pulsar el ratón volvemos al inicio
            @Override
            public void mousePressed(MouseEvent e) {
                if(_textoPorDefecto)
                    setCaretPosition(0);
            }
            
            @Override
            public void mouseDragged(MouseEvent e){
                if(_textoPorDefecto)
                    setCaretPosition(0);
            }
            
        });
      
    }
    
}
