/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progiciel.hmi.MainWindowPackage;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import progiciel.database.ProjectDao;
import progiciel.hmi.ProfileWindow.ProfileWindow;
import progiciel.hmi.ProjectsWindowPackage.ProjectsWindow;
import progiciel.hmi.TechsWindow.TechsWindow;
import progiciel.logic.User;

/**
 *
 * @author margu
 */
public class MainWindow extends javax.swing.JFrame {
    private User user;

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        this.user = null;
        setDisplay();
    }
    
    /**
     * Create new form MainWindow 
     * @param user
     * @param name Username
     */
    public MainWindow(User user){
        initComponents();
        this.user = user;
        this.welcomeLabel.setText("Welcome "+this.user.getLogin()+" !");
        setDisplay();
        
        ProjectDao projectLoader = new ProjectDao();
        ResultSet loader = projectLoader.listAll();
        
        try {
            while(loader.next()){
                //Load data
                String name = loader.getString("nom");
                String status = loader.getString("statut");
                
                //Tableau pour remplir une ligne 
                String arrayData[] = {name, status};
                DefaultTableModel tableData = (DefaultTableModel)projectTable.getModel();
                
                tableData.addRow(arrayData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjectsWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Permet d'afficher les éléments en fonction de si l'utilisateur est connecté
     */
    public void setDisplay(){
        if(this.user == null){
            popUp popup = new popUp();
            popup.setVisible(true); 
        }
        setLocationRelativeTo(null);
    }
    
    public boolean isUserConnected(){
        return (this.user != null);
    }
    /**
     * Permet d'ouvir le pop up de deconnexion 
     */
    public void Disconnect(){
        Disconnect disconnect = new Disconnect(this.user);
        disconnect.setVisible(true);
        dispose();
    }
    
    /**
     * Permet d'éditer son profil
     */
    public void editProfile(){
        dispose();
        ProfileWindow profilewindow = new ProfileWindow(this.user);
        profilewindow.setVisible(true);
    }
    
    /**
     * Permet de voir la liste des projets
     */
    public void projects(){
        dispose();
        ProjectsWindow projectswindow = new ProjectsWindow(this.user);
        projectswindow.setVisible(true);
    }
    
    /**
     * Permet de voir la liste des techniciens 
     */
    public void viewTechs(){
        dispose();
        TechsWindow techswindow = new TechsWindow(this.user);
        techswindow.setVisible(true);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        lowerPanel = new javax.swing.JPanel();
        progicielLabel = new javax.swing.JLabel();
        jakovaLabel = new javax.swing.JLabel();
        supportBtn = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        logoutBtn = new javax.swing.JButton();
        profilBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        projectTable = new javax.swing.JTable();
        welcomeLabel = new javax.swing.JLabel();
        tableLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        homeMenu = new javax.swing.JMenu();
        homeBtn = new javax.swing.JMenuItem();
        techBtn = new javax.swing.JMenuItem();
        projectsBtn = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Progiciel");
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setResizable(false);

        mainPanel.setBackground(new java.awt.Color(46, 48, 47));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 723, Short.MAX_VALUE)
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

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/progiciel/hmi/images/logo.png"))); // NOI18N

        logoutBtn.setBackground(new java.awt.Color(255, 51, 51));
        logoutBtn.setFont(new java.awt.Font("Gill Sans MT", 1, 24)); // NOI18N
        logoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        logoutBtn.setText("Disconnect");
        logoutBtn.setBorderPainted(false);
        logoutBtn.setFocusPainted(false);
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        profilBtn.setBackground(new java.awt.Color(237, 132, 38));
        profilBtn.setFont(new java.awt.Font("Gill Sans MT", 1, 24)); // NOI18N
        profilBtn.setForeground(new java.awt.Color(255, 255, 255));
        profilBtn.setText("My Profil");
        profilBtn.setBorderPainted(false);
        profilBtn.setFocusPainted(false);
        profilBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profilBtnActionPerformed(evt);
            }
        });

        projectTable.setBackground(new java.awt.Color(153, 153, 153));
        projectTable.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        projectTable.setForeground(new java.awt.Color(0, 0, 0));
        projectTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(projectTable);

        welcomeLabel.setFont(new java.awt.Font("Gill Sans MT", 1, 48)); // NOI18N
        welcomeLabel.setForeground(new java.awt.Color(255, 255, 255));
        welcomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomeLabel.setText("Welcome placeholder !");
        welcomeLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        tableLabel.setFont(new java.awt.Font("Gill Sans MT", 1, 48)); // NOI18N
        tableLabel.setForeground(new java.awt.Color(255, 255, 255));
        tableLabel.setText("Last edited projects :");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lowerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(welcomeLabel)
                .addGap(61, 61, 61)
                .addComponent(profilBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logoutBtn)
                .addGap(12, 12, 12))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 858, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tableLabel)
                .addGap(396, 396, 396))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(logo)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(logoutBtn)
                                    .addComponent(profilBtn)))))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(welcomeLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(tableLabel)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(lowerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenuBar1.setBackground(new java.awt.Color(102, 102, 102));
        jMenuBar1.setBorder(null);
        jMenuBar1.setForeground(new java.awt.Color(102, 102, 102));
        jMenuBar1.setOpaque(false);

        homeMenu.setBackground(new java.awt.Color(153, 153, 153));
        homeMenu.setForeground(new java.awt.Color(0, 0, 0));
        homeMenu.setText("Menu");
        homeMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeMenuActionPerformed(evt);
            }
        });

        homeBtn.setText("Home");
        homeMenu.add(homeBtn);

        techBtn.setText("Techniciens ");
        techBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                techBtnActionPerformed(evt);
            }
        });
        homeMenu.add(techBtn);

        projectsBtn.setText("Projects");
        projectsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectsBtnActionPerformed(evt);
            }
        });
        homeMenu.add(projectsBtn);

        jMenuBar1.add(homeMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeMenuActionPerformed
        
    }//GEN-LAST:event_homeMenuActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        Disconnect();
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void profilBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profilBtnActionPerformed
        editProfile();
    }//GEN-LAST:event_profilBtnActionPerformed

    private void supportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supportBtnActionPerformed
        Desktop desktop = Desktop.getDesktop();
        String message = "mailto:Valentin_Marguerie@etu.u-bourgogne.fr?subject=Support%20Email";
        URI uri = URI.create(message);
        try {
            desktop.mail(uri);
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_supportBtnActionPerformed

    private void techBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_techBtnActionPerformed
        viewTechs();
    }//GEN-LAST:event_techBtnActionPerformed

    private void projectsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectsBtnActionPerformed
        projects();
    }//GEN-LAST:event_projectsBtnActionPerformed

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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainWindow mainwindow = new MainWindow();
                if(mainwindow.isUserConnected() != true) mainwindow.setVisible(false);
                if(mainwindow.isUserConnected() == true) mainwindow.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem homeBtn;
    private javax.swing.JMenu homeMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jakovaLabel;
    private javax.swing.JLabel logo;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JPanel lowerPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton profilBtn;
    private javax.swing.JLabel progicielLabel;
    private javax.swing.JTable projectTable;
    private javax.swing.JMenuItem projectsBtn;
    private javax.swing.JButton supportBtn;
    private javax.swing.JLabel tableLabel;
    private javax.swing.JMenuItem techBtn;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
