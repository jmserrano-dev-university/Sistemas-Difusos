/**
 * Clase VentanaPrincipal
 * @author José Manuel Serrano Mármol
 */

package Vista;

import Modelo.IOFicheros;
import Modelo.Regla;
import Modelo.Variable;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VentaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
        
        //Inicialización de las variables
        _baseDatos = new ArrayList<Variable>();
        _baseReglas = new ArrayList<Regla>();
        _listaGraficosVariables = new ArrayList<JFreeChart>();
        _listaGraficosReglas = new ArrayList<JFreeChart>();
        
        //Icono
        this.setIconImage(new ImageIcon(getClass().getResource("")).getImage());
        
        //Ponemos gestores de distribución
        pBaseDatos.setLayout(new javax.swing.BoxLayout(pBaseDatos,javax.swing.BoxLayout.Y_AXIS));
        pBaseReglas.setLayout(new javax.swing.BoxLayout(pBaseReglas,javax.swing.BoxLayout.Y_AXIS));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jSplitPane2 = new javax.swing.JSplitPane();
        jSplitPane3 = new javax.swing.JSplitPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taLog = new javax.swing.JTextArea();
        Resultados = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        pBaseDatos = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        pBaseReglas = new javax.swing.JLayeredPane();
        pResultados = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        mbBarraMenu = new javax.swing.JMenuBar();
        mArchivo = new javax.swing.JMenu();
        miAbrirBD = new javax.swing.JMenuItem();
        miSalir = new javax.swing.JMenuItem();
        mEdicion = new javax.swing.JMenu();
        mAcercaDe = new javax.swing.JMenu();
        miAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistemas Difusos - Mamdani");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jSplitPane2.setDividerLocation(150);

        jSplitPane3.setDividerLocation(350);
        jSplitPane3.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        taLog.setColumns(20);
        taLog.setRows(5);
        jScrollPane1.setViewportView(taLog);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane3.setRightComponent(jPanel2);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        javax.swing.GroupLayout pBaseDatosLayout = new javax.swing.GroupLayout(pBaseDatos);
        pBaseDatos.setLayout(pBaseDatosLayout);
        pBaseDatosLayout.setHorizontalGroup(
            pBaseDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 589, Short.MAX_VALUE)
        );
        pBaseDatosLayout.setVerticalGroup(
            pBaseDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 319, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(pBaseDatos);

        Resultados.addTab("Base de datos", jScrollPane2);

        jScrollPane3.setViewportView(pBaseReglas);

        Resultados.addTab("Base de Reglas", jScrollPane3);
        Resultados.addTab("Resultados", pResultados);

        jSplitPane3.setLeftComponent(Resultados);

        jSplitPane2.setBottomComponent(jSplitPane3);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 149, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 465, Short.MAX_VALUE)
        );

        jSplitPane2.setLeftComponent(jPanel3);

        mArchivo.setText("Archivo");

        miAbrirBD.setText("Abrir Base de datos...");
        miAbrirBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAbrirBDActionPerformed(evt);
            }
        });
        mArchivo.add(miAbrirBD);

        miSalir.setText("Salir");
        miSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSalirActionPerformed(evt);
            }
        });
        mArchivo.add(miSalir);

        mbBarraMenu.add(mArchivo);

        mEdicion.setText("Edición");
        mbBarraMenu.add(mEdicion);

        mAcercaDe.setText("Ayuda");

        miAcercaDe.setText("Acerca de...");
        miAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAcercaDeActionPerformed(evt);
            }
        });
        mAcercaDe.add(miAcercaDe);

        mbBarraMenu.add(mAcercaDe);

        setJMenuBar(mbBarraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAcercaDeActionPerformed
        
    }//GEN-LAST:event_miAcercaDeActionPerformed

    private void miAbrirBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAbrirBDActionPerformed
        JFileChooser archivo = new JFileChooser();
        archivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
        archivo.setMultiSelectionEnabled(true);
        int seleccion = archivo.showOpenDialog(this);
        
        if(seleccion == JFileChooser.APPROVE_OPTION){
            File[] fichero = archivo.getSelectedFiles();
            if(fichero.length > 2 || fichero.length < 1){
                System.out.println("No se ha seleccionado los archivos correctos");
            }else{
                String ruta1 = fichero[0].getAbsolutePath();
                String ruta2 = fichero[1].getAbsolutePath();
                System.out.println(ruta1.substring(ruta1.length()-3, ruta1.length()));
                if(ruta1.substring(ruta1.length()-3, ruta1.length()).equalsIgnoreCase("pwm")){
                    _rutaFicheroBD = ruta1;
                    _rutaFicheroReglas = ruta2;
                }else{
                    _rutaFicheroBD = ruta2;
                    _rutaFicheroReglas = ruta1;
                }
                
            }
            
            IOFicheros _ficheroBD = new IOFicheros(_rutaFicheroBD);
            IOFicheros _ficheroReglas = new IOFicheros(_rutaFicheroReglas);

            taLog.setText("Base de datos: Leida\n");
            System.out.println("Base de datos");
            _baseDatos = _ficheroBD.leerBaseDatos();
            for(int i = 0; i < _baseDatos.size(); i++){
                _baseDatos.get(i).out();
                System.out.println("\n******************************\n");

           taLog.append("Base de reglas: Leida\n");            }

           System.out.println("Base de reglas");
            _baseReglas = _ficheroReglas.leerReglas(_baseDatos);
            for(int i = 0; i < _baseReglas.size(); i++){
                _baseReglas.get(i).out();
                System.out.println("\n******************************\n");
            }
            
            dibujarVariablesBD();
            dibujarReglas();
        }
    }//GEN-LAST:event_miAbrirBDActionPerformed

    private void miSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSalirActionPerformed
        confirmacionSalida();
    }//GEN-LAST:event_miSalirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //confirmacionSalida();
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Resultados;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JMenu mAcercaDe;
    private javax.swing.JMenu mArchivo;
    private javax.swing.JMenu mEdicion;
    private javax.swing.JMenuBar mbBarraMenu;
    private javax.swing.JMenuItem miAbrirBD;
    private javax.swing.JMenuItem miAcercaDe;
    private javax.swing.JMenuItem miSalir;
    private javax.swing.JPanel pBaseDatos;
    private javax.swing.JLayeredPane pBaseReglas;
    private javax.swing.JScrollPane pResultados;
    private javax.swing.JTextArea taLog;
    // End of variables declaration//GEN-END:variables
    
    
    //************* VARIABLES
    private List<Variable> _baseDatos;
    private List<Regla> _baseReglas;
    private String _rutaFicheroBD;
    private String _rutaFicheroReglas;
    List<JFreeChart> _listaGraficosVariables;
    List<JFreeChart> _listaGraficosReglas;
    
    //************* MÉTODOS
    private void dibujarVariablesBD(){
        _listaGraficosVariables.clear();
        pBaseDatos.removeAll();
        for(int i = 0; i < _baseDatos.size(); i++){
            int j = 0;
            XYSeriesCollection dataset = new XYSeriesCollection();
            while(j < _baseDatos.get(i).getNumeroTripletas()){
                XYSeries serie = new XYSeries("Variable " + i + " | " + j);
                List<Float> elementosTripleta = _baseDatos.get(i).getSiguienteTripleta().leerElementosTripleta();

                if(elementosTripleta.size() == 3){
                    serie.add((double)elementosTripleta.get(0),0);
                    serie.add((double)elementosTripleta.get(1),1);
                    serie.add((double)elementosTripleta.get(2),0);
                }else{
                    serie.add((double)elementosTripleta.get(0),0);
                    serie.add((double)elementosTripleta.get(1),1);
                    serie.add((double)elementosTripleta.get(2),1);
                    serie.add((double)elementosTripleta.get(3),0);
                }
                j++;
                dataset.addSeries(serie);
            }
            //Guardamos los gráficos
            
            if(i == _baseDatos.size() - 1){
                JFreeChart grafico = ChartFactory.createXYLineChart("Y ", "", "", dataset, PlotOrientation.VERTICAL, true, true, false);
                _listaGraficosVariables.add(grafico);
            }else{
                JFreeChart grafico = ChartFactory.createXYLineChart("X " + (i + 1), "", "", dataset, PlotOrientation.VERTICAL, true, true, false);
                _listaGraficosVariables.add(grafico);
            }
            
            
            
        }
        
        for(int i =0; i < _listaGraficosVariables.size();i++){
            ChartPanel panel = new ChartPanel(_listaGraficosVariables.get(i));
            Dimension d = new Dimension(pBaseDatos.getWidth(),pBaseDatos.getHeight());
            panel.setMaximumSize(d);
            pBaseDatos.add(panel);
        }
    }
    
    private void dibujarReglas(){
        pBaseReglas.removeAll();
        for(int i = 0; i < _baseReglas.size(); i++){
            int num = _baseReglas.get(i).numTripletasRegla();
            String regla = "R" + (i+1) + ": ";
            int contador = 1;
            
            for(int j = 0; j < num; j++){
                if(j == num -1){ //resultado de la regla
                    regla = regla.substring(0, regla.length()-2);
                    regla = regla + " entonces Y es " + _baseReglas.get(i).leerParteRegla(j).getNombreEtiqueta();
                }else{ //Si de la regla
                    regla = regla + "Si X"+ contador + " es " + _baseReglas.get(i).leerParteRegla(j).getNombreEtiqueta() + " y ";
                }
                contador++;
            }
            JLabel r = new JLabel(regla);
            pBaseReglas.add(r);
        }
    }
    
    private void confirmacionSalida(){
        int opcion = JOptionPane.showConfirmDialog(this, "¿Realmente desea salir?", "Salir", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if(opcion == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }

}
