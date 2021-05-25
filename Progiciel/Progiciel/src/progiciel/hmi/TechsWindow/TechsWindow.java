/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progiciel.hmi.TechsWindow;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import progiciel.database.UserDao;
import progiciel.hmi.MainWindowPackage.MainWindow;
import progiciel.logic.Tech;
import progiciel.logic.User;

/**
 * Permet de visualiser les techniciens 
 * @author bkott / margu
 */
public class TechsWindow extends javax.swing.JFrame {

    User user;
    /**
     * Creates new form TechsWindow
     */
    public TechsWindow() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    /**
     * Creates new form TechsWindow
     */
    public TechsWindow(User user) {
        this.user = user;
        initComponents();
        setLocationRelativeTo(null);
        
        this.techsTable.setAutoCreateRowSorter(true);
        //Load all the techs
        UserDao techLoader = new UserDao();
        ResultSet loader = techLoader.listTech();
        
        try {
            while(loader.next()){
                //Load data 
                String id = loader.getString("id");
                String lastname = loader.getString("nom");
                String firstname = loader.getString("prenom");
                String price = String.valueOf(loader.getFloat("coutHoraire"));
                String grade = loader.getString("grade");
                
                //Tableau pour remplir le JTable
                String arrayTechs[] = {id, lastname, firstname, price, grade};
                DefaultTableModel tableData = (DefaultTableModel)this.techsTable.getModel();
                
                tableData.addRow(arrayTechs);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(TechsWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Permet de consulter les compétences d'un techniciens 
     */
    public void ViewTech(){
        DefaultTableModel tableData = (DefaultTableModel)this.techsTable.getModel();
        
        //Récupération ID technicien
        int IDtech = Integer.parseInt(tableData.getValueAt(this.techsTable.getSelectedRow(),0).toString());
        
        //Création d'un techos
        Tech techTosee = new Tech(IDtech);
        //Appel de TechWindow
        TechWindow techWindow = new TechWindow(this.user, techTosee);
        techWindow.setVisible(true);
        dispose();
 
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        exitBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        techsTable = new javax.swing.JTable();
        lowerPanel = new javax.swing.JPanel();
        progicielLabel = new javax.swing.JLabel();
        jakovaLabel = new javax.swing.JLabel();
        supportBtn = new javax.swing.JButton();
        consultBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Techs");

        jPanel2.setBackground(new java.awt.Color(46, 48, 47));

        exitBtn.setBackground(new java.awt.Color(255, 51, 51));
        exitBtn.setFont(new java.awt.Font("Gill Sans MT", 1, 18)); // NOI18N
        exitBtn.setText("Exit");
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Gill Sans MT", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Techniciens :");

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/progiciel/hmi/images/logo.png"))); // NOI18N

        techsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Lastname", "Firstname", "Hourly cost", "Grade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(techsTable);
        if (techsTable.getColumnModel().getColumnCount() > 0) {
            techsTable.getColumnModel().getColumn(1).setResizable(false);
            techsTable.getColumnModel().getColumn(3).setResizable(false);
            techsTable.getColumnModel().getColumn(4).setResizable(false);
        }

        lowerPanel.setBackground(new java.awt.Color(153, 153, 153));

        progicielLabel.setFont(new java.awt.Font("Gill Sans MT", 1, 12)); // NOI18N
        progicielLabel.setForeground(new java.awt.Color(0, 0, 0));
        progicielLabel.setText("Progiciel V0.1 for MSP gmBH.");

        jakovaLabel.setFont(new java.awt.Font("Gill Sans MT", 1, 12)); // NOI18N
        jakovaLabel.setForeground(new java.awt.Color(0, 0, 0));
        jakovaLabel.setText("© 2021 Jakova.All rigths reserved");

        supportBtn.setBackground(new java.awt.Color(153, 153, 153));
        supportBtn.setFont(new java.awt.Font("Gill Sans MT", 1, 12)); // NOI18N
        supportBtn.setForeground(new java.awt.Color(0, 0, 0));
        supportBtn.setText("Support");
        supportBtn.setBorderPainted(false);
        supportBtn.setFocusPainted(false);
        supportBtn.setOpaque(false);
        supportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supportBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lowerPanelLayout = new javax.swing.GroupLayout(lowerPanel);
        lowerPanel.setLayout(lowerPanelLayout);
        lowerPanelLayout.setHorizontalGroup(
            lowerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lowerPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(supportBtn)
                .addGap(28, 28, 28)
                .addComponent(progicielLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jakovaLabel)
                .addGap(63, 63, 63))
        );
        lowerPanelLayout.setVerticalGroup(
            lowerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lowerPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(lowerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(supportBtn)
                    .addComponent(progicielLabel)
                    .addComponent(jakovaLabel)))
        );

        consultBtn.setBackground(new java.awt.Color(255, 102, 0));
        consultBtn.setFont(new java.awt.Font("Gill Sans MT", 1, 18)); // NOI18N
        consultBtn.setText("Consult");
        consultBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lowerPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(logo)
                                .addGap(359, 359, 359)
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 902, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(consultBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(logo))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(consultBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46)
                .addComponent(lowerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void supportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supportBtnActionPerformed
        Desktop desktop = Desktop.getDesktop();
        String message = "mailto:Valentin_Marguerie@etu.u-bourgogne.fr?subject=Support%20Email";
        URI uri = URI.create(message);
        try {
            desktop.mail(uri);
        } catch (IOException ex) {
            Logger.getLogger(TechsWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_supportBtnActionPerformed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        MainWindow mainwindow = new MainWindow(this.user);
        mainwindow.setVisible(true);
        dispose();
    }//GEN-LAST:event_exitBtnActionPerformed

    private void consultBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultBtnActionPerformed
        this.ViewTech();
    }//GEN-LAST:event_consultBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TechsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TechsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TechsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TechsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TechsWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton consultBtn;
    private javax.swing.JButton exitBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jakovaLabel;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel lowerPanel;
    private javax.swing.JLabel progicielLabel;
    private javax.swing.JButton supportBtn;
    private javax.swing.JTable techsTable;
    // End of variables declaration//GEN-END:variables
}
