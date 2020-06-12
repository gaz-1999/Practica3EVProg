package vista;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GUIInstrucciones extends javax.swing.JFrame {

    public GUIInstrucciones() throws IOException {
        initComponents();

        this.setLocationRelativeTo(null);
        this.setVisible(true);

        JTextArea jtx = new JTextArea();
        jtx.setText(controlador.Controlador.LeerInstrucciones());
        JScrollPane scroll = new JScrollPane();
        scroll.setViewportView(jtx);
        jtx.setEditable(false);
        this.panelRestIns.add(scroll);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelContenedorIns = new javax.swing.JPanel();
        panelSupIns = new javax.swing.JPanel();
        Encabezado = new javax.swing.JLabel();
        panelInfIns = new javax.swing.JPanel();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        BotonVolver = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        panelRestIns = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelContenedorIns.setLayout(new java.awt.BorderLayout());

        panelSupIns.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 1, 20, 1));
        panelSupIns.setLayout(new java.awt.GridBagLayout());

        Encabezado.setText("Lee antentamente las instrucciones, podrás acceder a ellas en cualquier momento en el juego. Cuando hayas acabado pulsa en empezar:");
        Encabezado.setAlignmentX(0.5F);
        Encabezado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelSupIns.add(Encabezado, gridBagConstraints);

        panelContenedorIns.add(panelSupIns, java.awt.BorderLayout.PAGE_START);

        panelInfIns.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 1, 10, 1));
        panelInfIns.setLayout(new javax.swing.BoxLayout(panelInfIns, javax.swing.BoxLayout.LINE_AXIS));
        panelInfIns.add(filler4);

        BotonVolver.setText("Volver");
        BotonVolver.setAlignmentX(0.5F);
        BotonVolver.setMargin(new java.awt.Insets(20, 20, 20, 20));
        BotonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonVolverActionPerformed(evt);
            }
        });
        panelInfIns.add(BotonVolver);
        panelInfIns.add(filler1);

        panelContenedorIns.add(panelInfIns, java.awt.BorderLayout.PAGE_END);

        panelRestIns.setMinimumSize(new java.awt.Dimension(1050, 300));
        panelRestIns.setPreferredSize(new java.awt.Dimension(1050, 300));
        panelRestIns.setRequestFocusEnabled(false);
        panelRestIns.setLayout(new java.awt.BorderLayout());
        panelContenedorIns.add(panelRestIns, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelContenedorIns, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_BotonVolverActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonVolver;
    private javax.swing.JLabel Encabezado;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler4;
    private javax.swing.JPanel panelContenedorIns;
    private javax.swing.JPanel panelInfIns;
    private javax.swing.JPanel panelRestIns;
    private javax.swing.JPanel panelSupIns;
    // End of variables declaration//GEN-END:variables
}
