/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progiciel.hmi.ProfileWindow;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import progiciel.hmi.MainWindowPackage.MainWindow;
import progiciel.logic.User;
import progiciel.logic.Utils;

/**
 *
 * @author bkott
 */
public class ProfileWindow extends javax.swing.JFrame {
    
    User user;
    /**
     * Creates new form ProfileWindow
     * @param user
     */
    public ProfileWindow(User user) {
        this.user = user;
        initComponents();
        setLocationRelativeTo(null);
        setField();
    }

    /**
     * Create new form ProfileWindow 
     */
    public ProfileWindow(){
        setLocationRelativeTo(null);
        initComponents();
    }
     
    /**
     * Permet de valider le changement de mot de passe 
     */
    public void validateChange(){
        char[] passwordArray;
        String passString = "";
        
        //Modification mot de passe 
        if(this.passwordField.getPassword().length != 0){
            if(this.comparePassword(this.passwordField.getPassword(), this.confirmationField.getPassword())){
                passwordArray = this.passwordField.getPassword();
                for(int i = 0; i != passwordArray.length; i++){
                    passString += passwordArray[i];
                }
                String passHash = Utils.HashPassword(passString);

                if(Utils.IsPasswordSafe(passString)){
                    try {
                    //Connection to the DB
                    Connection myConn;
                    myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
                    Statement ident = myConn.createStatement();
                    ident.executeUpdate("UPDATE utilisateur SET password ="+"'"+passHash+"'"+" WHERE ID="+this.user.getID());
                    ConfirmUpdate conf = new ConfirmUpdate();
                    conf.setVisible(true);
                    } catch (SQLException ex) {
                        Logger.getLogger(ProfileWindow.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else{
                    UnsafePass error = new UnsafePass();
                    error.setVisible(true);
                }
            
            } else{
                ErrorProfile errorProfile = new ErrorProfile();
                errorProfile.setVisible(true);
            }
        }
        
        if(!this.loginField.getText().equals(this.user.getLogin()) && this.loginField != null){
            this.changeLogin();
        }
    }
    
    /**
     * Permet de changer de Login
     */
    public void changeLogin(){
        boolean loginExist = false;
        String newLogin = this.loginField.getText();
        
        try {
            //Connection to the DB
            Connection myConn;
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
            Statement ident = myConn.createStatement();
            ResultSet myRs = ident.executeQuery("SELECT Login FROM Utilisateur");
            
            //Check si le login existe déjà 
            while(myRs.next()){
                if(newLogin.equals(myRs.getString("Login"))){
                    loginExist = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfileWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(!loginExist){
            try {
            //Connection to the DB
            Connection myConn;
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
            Statement ident = myConn.createStatement();
            ident.executeUpdate("UPDATE Utilisateur SET LOGIN ="+"'"+newLogin+"'"+" WHERE ID="+this.user.getID());
            ConfirmUpdate conf = new ConfirmUpdate();
            conf.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(ProfileWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            LoginExist exist = new LoginExist();
            exist.setVisible(true);
        }   
    }
    
    /**
     * Compare deux mot de passe 
     * @param passwordArray
     * @param confirmationArray
     * @return 
     */
    public boolean comparePassword(char[] passwordArray, char[] confirmationArray){
        String passString = "";
        String confString = "";
        
        for(int i = 0; i != passwordArray.length; i++){
            passString += passwordArray[i];
        }
        for(int i = 0; i != confirmationArray.length; i++){
            confString += confirmationArray[i];
        }
        
        return (passString.equals(confString));
    }
    
    /**
     * Permet de set les textes des champs 
     */
    private void setField(){
        this.loginField.setText(this.user.getLogin());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        login = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        loginField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        homeBtn = new javax.swing.JButton();
        confirmBtn = new javax.swing.JButton();
        confirmationField = new javax.swing.JPasswordField();
        password1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Your profile");
        setMaximumSize(new java.awt.Dimension(100000, 1000000));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 450));

        MainPanel.setBackground(new java.awt.Color(46, 48, 47));
        MainPanel.setPreferredSize(new java.awt.Dimension(750, 350));

        title.setFont(new java.awt.Font("Gill Sans MT", 1, 48)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Profile");

        login.setFont(new java.awt.Font("Gill Sans MT", 1, 36)); // NOI18N
        login.setForeground(new java.awt.Color(255, 255, 255));
        login.setText("Login :");

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/progiciel/hmi/images/logo.png"))); // NOI18N

        password.setFont(new java.awt.Font("Gill Sans MT", 1, 36)); // NOI18N
        password.setForeground(new java.awt.Color(255, 255, 255));
        password.setText("Password :");

        loginField.setFont(new java.awt.Font("Gill Sans MT", 1, 36)); // NOI18N
        loginField.setText("PlaceHolderLogin");

        passwordField.setFont(new java.awt.Font("Gill Sans MT", 1, 36)); // NOI18N
        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        homeBtn.setBackground(new java.awt.Color(255, 102, 0));
        homeBtn.setFont(new java.awt.Font("Gill Sans MT", 1, 24)); // NOI18N
        homeBtn.setForeground(new java.awt.Color(255, 255, 255));
        homeBtn.setText("Home");
        homeBtn.setBorderPainted(false);
        homeBtn.setFocusPainted(false);
        homeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeBtnActionPerformed(evt);
            }
        });

        confirmBtn.setBackground(new java.awt.Color(0, 255, 0));
        confirmBtn.setFont(new java.awt.Font("Gill Sans MT", 1, 24)); // NOI18N
        confirmBtn.setForeground(new java.awt.Color(255, 255, 255));
        confirmBtn.setText("Confirm");
        confirmBtn.setBorderPainted(false);
        confirmBtn.setFocusPainted(false);
        confirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBtnActionPerformed(evt);
            }
        });

        confirmationField.setFont(new java.awt.Font("Gill Sans MT", 1, 36)); // NOI18N
        confirmationField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmationFieldActionPerformed(evt);
            }
        });

        password1.setFont(new java.awt.Font("Gill Sans MT", 1, 18)); // NOI18N
        password1.setForeground(new java.awt.Color(255, 255, 255));
        password1.setText("Password confirmation:");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("At least 8 characters, one capital and one digit");

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(login, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(password1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(password, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 25, Short.MAX_VALUE)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(loginField, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                            .addComponent(homeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(confirmBtn))
                                        .addComponent(confirmationField, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(222, 222, 222)
                                .addComponent(title)))
                        .addContainerGap(21, Short.MAX_VALUE))
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(title)
                        .addGap(34, 34, 34)))
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(login))
                .addGap(18, 18, 18)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(homeBtn)
                    .addComponent(confirmBtn))
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBtnActionPerformed
        MainWindow mainwindow = new MainWindow(this.user);
        mainwindow.setVisible(true);
        dispose();
    }//GEN-LAST:event_homeBtnActionPerformed

    private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtnActionPerformed
        this.validateChange();
    }//GEN-LAST:event_confirmBtnActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void confirmationFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmationFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmationFieldActionPerformed

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
            java.util.logging.Logger.getLogger(ProfileWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfileWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfileWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfileWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProfileWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanel;
    private javax.swing.JButton confirmBtn;
    private javax.swing.JPasswordField confirmationField;
    private javax.swing.JButton homeBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel login;
    private javax.swing.JTextField loginField;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel password;
    private javax.swing.JLabel password1;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
