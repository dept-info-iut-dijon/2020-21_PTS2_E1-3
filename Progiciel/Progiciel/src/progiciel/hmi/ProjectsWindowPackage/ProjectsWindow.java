/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progiciel.hmi.ProjectsWindowPackage;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import progiciel.database.ProjectDao;
import progiciel.hmi.MainWindowPackage.MainWindow;
import progiciel.logic.Project;
import progiciel.logic.ProjectStatus;
import progiciel.logic.User;

/**
 *
 * @author margu
 */
public class ProjectsWindow extends javax.swing.JFrame {
    
    User user;
    
    /**
     * Creates new form ProjectsWindow
     */
    public ProjectsWindow() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * Creates new form ProjectsWindow
     */
    public ProjectsWindow(User user) {
        this.user = user; 
        initComponents();
        setLocationRelativeTo(null);
        
        this.projectTable.setAutoCreateRowSorter(true);
        ProjectDao projectLoader = new ProjectDao();
        ResultSet loader = projectLoader.listAll();
        
        try {
            while(loader.next()){
                //Load data
                String ID = loader.getString("ID");
                String name = loader.getString("nom");
                String estimated = String.valueOf(loader.getInt("dureeEstimee"));
                String finale = String.valueOf(loader.getInt("dureeFinale"));
                String status = loader.getString("statut");
                
                //Tableau pour remplir une ligne 
                String arrayData[] = {ID,name,estimated,finale,status};
                DefaultTableModel tableData = (DefaultTableModel)projectTable.getModel();
                
                tableData.addRow(arrayData);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjectsWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Modification d'un projet 
     */
    public void modify(){
        DefaultTableModel tableData = (DefaultTableModel)this.projectTable.getModel();
        
        //Récupération des données 
        String IDString = tableData.getValueAt(this.projectTable.getSelectedRow(), 0).toString();
        String name = tableData.getValueAt(this.projectTable.getSelectedRow(), 1).toString();
        String estimatedTimeString = tableData.getValueAt(this.projectTable.getSelectedRow(), 2).toString();
        String durationString = tableData.getValueAt(this.projectTable.getSelectedRow(), 3).toString();
        String status = tableData.getValueAt(this.projectTable.getSelectedRow(), 4).toString();
        
        //Conversion
        int ID = Integer.parseInt(IDString);
        int estimatedMinutes = Integer.parseInt(estimatedTimeString);
        int finaleDuration = Integer.parseInt(durationString);
        
        //Création d'un object projet
        Project projectToUpdate = new Project(name, finaleDuration, status, ID, estimatedMinutes);
        
        //Utilisation de ProjectDao
        ProjectDao update = new ProjectDao();
        update.update(projectToUpdate);
        
    }
    
    /**
     * Fermeture d'un projet 
     */
    public void close(){
        boolean res = this.changeStatus(ProjectStatus.ENDED);
        
        if(res == true){
            DeleteConfirm delete = new DeleteConfirm(this.user);
            delete.setVisible(true);
            dispose();
        }
    }
    
    /**
     * Permet de démarrer un projet 
     */
    public void start(){
        boolean res = this.changeStatus(ProjectStatus.WORKING);
        
        if(res == true){
            StartConfirm start = new StartConfirm(this.user);
            start.setVisible(true);
            dispose();
        }
    }
    
    /**
     * Permet de définir un projet comme fini
     */
    public void ended(){
        boolean res = this.changeStatus(ProjectStatus.ENDED);
        
        if(res == true){
            EndConfirm start = new EndConfirm(this.user);
            start.setVisible(true);
            dispose();
        }
    }
    
    /**
     * PErmet de mettre un projet en attente 
     */
    public void waiting(){
        boolean res = this.changeStatus(ProjectStatus.WAITING);
        
        if(res == true){
            WaitConfirm start = new WaitConfirm(this.user);
            start.setVisible(true);
            dispose();
        }
    }
    
    /**
     * PErmet de chnager le statut d'un projet 
     * @param newStatus nouveau statut du projet
     * @return 
     */
    public boolean changeStatus(ProjectStatus newStatus){
        DefaultTableModel tableData = (DefaultTableModel)this.projectTable.getModel();
        
        //Récupération des données 
        String IDString = tableData.getValueAt(this.projectTable.getSelectedRow(), 0).toString();
        String name = tableData.getValueAt(this.projectTable.getSelectedRow(), 1).toString();
        String estimatedTimeString = tableData.getValueAt(this.projectTable.getSelectedRow(), 2).toString();
        String durationString = tableData.getValueAt(this.projectTable.getSelectedRow(), 3).toString();
        String status = tableData.getValueAt(this.projectTable.getSelectedRow(), 4).toString();
        
        //Conversion
        int ID = Integer.parseInt(IDString);
        int estimatedMinutes = Integer.parseInt(estimatedTimeString);
        int finaleDuration = Integer.parseInt(durationString);
        
        //Création d'un object projet
        Project projectToUpdate = new Project(name, finaleDuration, status, ID, estimatedMinutes);
        boolean res = false;
        
        switch(newStatus){
            case WAITING:
                res = projectToUpdate.Waiting();
                break;
            case WORKING:
                res = projectToUpdate.Start();
                break;
            case ENDED:
                res = projectToUpdate.Ended();
                break;
            case CANCELED:
                res = projectToUpdate.Cancel();
                break;
        }
        
        return res;
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
        titleLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        projectTable = new javax.swing.JTable();
        closeBtn = new javax.swing.JButton();
        uptBtn = new javax.swing.JButton();
        lowerPanel = new javax.swing.JPanel();
        progicielLabel = new javax.swing.JLabel();
        jakovaLabel = new javax.swing.JLabel();
        supportBtn = new javax.swing.JButton();
        returnBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        startBtn = new javax.swing.JButton();
        waitBtn = new javax.swing.JButton();
        endBtn = new javax.swing.JButton();
        detailBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Projects");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(46, 48, 47));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/progiciel/hmi/images/logo.png"))); // NOI18N

        titleLabel.setFont(new java.awt.Font("Gill Sans MT", 1, 48)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setText("Projects :");

        projectTable.setBackground(new java.awt.Color(153, 153, 153));
        projectTable.setForeground(new java.awt.Color(0, 0, 0));
        projectTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Estimated time", "Duration", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        projectTable.setColumnSelectionAllowed(true);
        projectTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                projectTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(projectTable);
        projectTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        if (projectTable.getColumnModel().getColumnCount() > 0) {
            projectTable.getColumnModel().getColumn(0).setResizable(false);
            projectTable.getColumnModel().getColumn(1).setResizable(false);
            projectTable.getColumnModel().getColumn(2).setResizable(false);
            projectTable.getColumnModel().getColumn(3).setResizable(false);
            projectTable.getColumnModel().getColumn(4).setResizable(false);
        }

        closeBtn.setBackground(new java.awt.Color(255, 51, 51));
        closeBtn.setFont(new java.awt.Font("Gill Sans MT", 1, 18)); // NOI18N
        closeBtn.setText("Cancel Project");
        closeBtn.setToolTipText("");
        closeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBtnActionPerformed(evt);
            }
        });

        uptBtn.setBackground(new java.awt.Color(255, 204, 0));
        uptBtn.setFont(new java.awt.Font("Gill Sans MT", 1, 18)); // NOI18N
        uptBtn.setText("Update");
        uptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uptBtnActionPerformed(evt);
            }
        });

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 747, Short.MAX_VALUE)
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

        returnBtn.setBackground(new java.awt.Color(51, 153, 255));
        returnBtn.setFont(new java.awt.Font("Gill Sans MT", 1, 18)); // NOI18N
        returnBtn.setText("Back");
        returnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnBtnActionPerformed(evt);
            }
        });

        addBtn.setBackground(new java.awt.Color(0, 204, 51));
        addBtn.setFont(new java.awt.Font("Gill Sans MT", 1, 18)); // NOI18N
        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Gill Sans MT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Actions on projects");

        startBtn.setBackground(new java.awt.Color(0, 204, 51));
        startBtn.setFont(new java.awt.Font("Gill Sans MT", 1, 18)); // NOI18N
        startBtn.setText("Start Project");
        startBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startBtnActionPerformed(evt);
            }
        });

        waitBtn.setBackground(new java.awt.Color(204, 0, 255));
        waitBtn.setFont(new java.awt.Font("Gill Sans MT", 1, 18)); // NOI18N
        waitBtn.setText("Waiting");
        waitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                waitBtnActionPerformed(evt);
            }
        });

        endBtn.setBackground(new java.awt.Color(255, 153, 0));
        endBtn.setFont(new java.awt.Font("Gill Sans MT", 1, 18)); // NOI18N
        endBtn.setText("End Project");
        endBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endBtnActionPerformed(evt);
            }
        });

        detailBtn.setBackground(new java.awt.Color(51, 102, 255));
        detailBtn.setFont(new java.awt.Font("Gill Sans MT", 1, 18)); // NOI18N
        detailBtn.setText("View Details");
        detailBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lowerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logo)
                        .addGap(361, 361, 361)
                        .addComponent(titleLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(detailBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 858, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(returnBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(uptBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(startBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(waitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(endBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(40, 40, 40))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(returnBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logo)))
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(uptBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(startBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(endBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(waitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(detailBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
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

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        this.close();        
    }//GEN-LAST:event_closeBtnActionPerformed

    private void supportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supportBtnActionPerformed
        Desktop desktop = Desktop.getDesktop();
        String message = "mailto:Valentin_Marguerie@etu.u-bourgogne.fr?subject=Support%20Email";
        URI uri = URI.create(message);
        try {
            desktop.mail(uri);
        } catch (IOException ex) {
            Logger.getLogger(ProjectsWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_supportBtnActionPerformed

    private void returnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnBtnActionPerformed
        MainWindow mainwindow = new MainWindow(user);
        mainwindow.setVisible(true);
        dispose();
    }//GEN-LAST:event_returnBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        DefaultTableModel tableData = (DefaultTableModel)projectTable.getModel();
        int ID = Integer.parseInt(tableData.getValueAt(0, 0).toString());
        AddProject newProject = new AddProject(ID, this.user);
        newProject.setVisible(true);
        dispose();
    }//GEN-LAST:event_addBtnActionPerformed

    private void projectTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_projectTableMouseClicked
        
    }//GEN-LAST:event_projectTableMouseClicked

    private void uptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uptBtnActionPerformed
        this.modify();
    }//GEN-LAST:event_uptBtnActionPerformed

    private void startBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startBtnActionPerformed
        this.start();
    }//GEN-LAST:event_startBtnActionPerformed

    private void waitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_waitBtnActionPerformed
        this.waiting();
    }//GEN-LAST:event_waitBtnActionPerformed

    private void endBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endBtnActionPerformed
        this.ended();
    }//GEN-LAST:event_endBtnActionPerformed

    private void detailBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailBtnActionPerformed
        DefaultTableModel tableData = (DefaultTableModel)this.projectTable.getModel();
        
        //Récupération des données 
        String IDString = tableData.getValueAt(this.projectTable.getSelectedRow(), 0).toString();
        String name = tableData.getValueAt(this.projectTable.getSelectedRow(), 1).toString();
        String estimatedTimeString = tableData.getValueAt(this.projectTable.getSelectedRow(), 2).toString();
        String durationString = tableData.getValueAt(this.projectTable.getSelectedRow(), 3).toString();
        String status = tableData.getValueAt(this.projectTable.getSelectedRow(), 4).toString();
        
        //Conversion
        int ID = Integer.parseInt(IDString);
        int estimatedMinutes = Integer.parseInt(estimatedTimeString);
        int finaleDuration = Integer.parseInt(durationString);
        
        //Création d'un object projet
        Project projectToUpdate = new Project(name, finaleDuration, status, ID, estimatedMinutes);
        
        ProjectWindow projectToSee = new ProjectWindow(this.user, projectToUpdate);
        projectToSee.setVisible(true);
        dispose();
    }//GEN-LAST:event_detailBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ProjectsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProjectsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProjectsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProjectsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProjectsWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton closeBtn;
    private javax.swing.JButton detailBtn;
    private javax.swing.JButton endBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jakovaLabel;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel lowerPanel;
    private javax.swing.JLabel progicielLabel;
    private javax.swing.JTable projectTable;
    private javax.swing.JButton returnBtn;
    private javax.swing.JButton startBtn;
    private javax.swing.JButton supportBtn;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton uptBtn;
    private javax.swing.JButton waitBtn;
    // End of variables declaration//GEN-END:variables
}
