/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progiciel.hmi.TechsWindow;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import progiciel.logic.Skill;
import progiciel.logic.Tech;
import progiciel.logic.User;

/**
 *
 * @author bkott
 */
public class TechWindow extends javax.swing.JFrame {
    
    User user;

    /**
     * Creates new form TechSkill
     */
    public TechWindow() {
        setLocationRelativeTo(null);
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * Creates new form TechSkill
     * @param user
     */
    public TechWindow(User user, Tech tech) {
        initComponents();
        setLocationRelativeTo(null);
        this.user = user;
        
        try {
            //Connection to the DB
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
            Statement ident = myConn.createStatement();
            ResultSet myRs = ident.executeQuery("SELECT * FROM Technicien WHERE ID="+tech.getID());
            
            while(myRs.next()){
                this.lastName.setText(myRs.getString("prenom")+" "+myRs.getString("nom"));
            }
            } catch (SQLException ex) {
            Logger.getLogger(TechWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        //Remplissage du tableau des skills
        ArrayList<Skill> skill = tech.getSkill();
        for(int i = 0; i < skill.size(); i++){
            //Load data
            String name = skill.get(i).getName();
            String level = skill.get(i).getLevel();
            
            //Tableau pour remplir une ligne
            String arrayData[]= {name, level};
            DefaultTableModel tableData = (DefaultTableModel)this.skillTable.getModel();
            
            tableData.addRow(arrayData);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lastName = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        skillTable = new javax.swing.JTable();
        lowerPanel = new javax.swing.JPanel();
        progicielLabel = new javax.swing.JLabel();
        jakovaLabel = new javax.swing.JLabel();
        supportBtn = new javax.swing.JButton();
        homeBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1050, 550));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(46, 48, 47));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/progiciel/hmi/images/logo.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Gill Sans MT", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Technicien:");

        lastName.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lastName.setForeground(new java.awt.Color(255, 255, 255));
        lastName.setText("PlaceHolder");

        skillTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Skills", "Level"
            }
        ));
        jScrollPane1.setViewportView(skillTable);
        if (skillTable.getColumnModel().getColumnCount() > 0) {
            skillTable.getColumnModel().getColumn(0).setResizable(false);
            skillTable.getColumnModel().getColumn(1).setResizable(false);
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
                .addGap(41, 41, 41))
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

        homeBtn.setBackground(new java.awt.Color(0, 153, 255));
        homeBtn.setFont(new java.awt.Font("Gill Sans MT", 1, 24)); // NOI18N
        homeBtn.setForeground(new java.awt.Color(255, 255, 255));
        homeBtn.setText("Back");
        homeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logo)
                .addGap(274, 274, 274)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(lowerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(homeBtn))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 914, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(homeBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(lowerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void homeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBtnActionPerformed
        TechsWindow techsWindow = new TechsWindow(this.user);
        techsWindow.setVisible(true);
        dispose();
    }//GEN-LAST:event_homeBtnActionPerformed

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
            java.util.logging.Logger.getLogger(TechWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TechWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TechWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TechWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TechWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton homeBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jakovaLabel;
    private javax.swing.JLabel lastName;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel lowerPanel;
    private javax.swing.JLabel progicielLabel;
    private javax.swing.JTable skillTable;
    private javax.swing.JButton supportBtn;
    // End of variables declaration//GEN-END:variables
}
