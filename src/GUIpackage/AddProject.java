
package GUIpackage;

//import controllerpackage.ProjectDetailsTableJpaController;
import entityClassesPackage.ProjectDetailsTable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author erwin
 */
public class AddProject extends javax.swing.JFrame {

    /**
     * Creates new form AddProject
     */
    public AddProject() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pAddProjectBanner = new javax.swing.JPanel();
        lAddProjectBanner = new javax.swing.JLabel();
        lAddProjectMain = new javax.swing.JPanel();
        lProjectName = new javax.swing.JLabel();
        tfProjectName = new javax.swing.JTextField();
        lProjectDescription = new javax.swing.JLabel();
        spDescription = new javax.swing.JScrollPane();
        jaProjectDescription = new javax.swing.JTextArea();
        cbStatus = new javax.swing.JComboBox();
        lStatus = new javax.swing.JLabel();
        lTag = new javax.swing.JLabel();
        cbTag = new javax.swing.JComboBox();
        lProjectDesiredOutcome = new javax.swing.JLabel();
        tfProjectDesiredOutcome = new javax.swing.JTextField();
        lStartDate = new javax.swing.JLabel();
        dcStartDate = new com.toedter.calendar.JDateChooser();
        lEndDate = new javax.swing.JLabel();
        dcEndDate = new com.toedter.calendar.JDateChooser();
        pAddProjectButtons = new javax.swing.JPanel();
        bAddProject = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1248, 600));

        pAddProjectBanner.setBackground(new java.awt.Color(255, 255, 255));
        pAddProjectBanner.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0), 4));
        pAddProjectBanner.setPreferredSize(new java.awt.Dimension(1248, 95));

        lAddProjectBanner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fil-3squares-02.jpg"))); // NOI18N
        lAddProjectBanner.setPreferredSize(new java.awt.Dimension(1248, 86));

        javax.swing.GroupLayout pAddProjectBannerLayout = new javax.swing.GroupLayout(pAddProjectBanner);
        pAddProjectBanner.setLayout(pAddProjectBannerLayout);
        pAddProjectBannerLayout.setHorizontalGroup(
            pAddProjectBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAddProjectBannerLayout.createSequentialGroup()
                .addComponent(lAddProjectBanner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pAddProjectBannerLayout.setVerticalGroup(
            pAddProjectBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAddProjectBannerLayout.createSequentialGroup()
                .addComponent(lAddProjectBanner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        lAddProjectMain.setBackground(new java.awt.Color(255, 255, 255));
        lAddProjectMain.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
        lAddProjectMain.setPreferredSize(new java.awt.Dimension(1248, 200));

        lProjectName.setText("Project Name");

        lProjectDescription.setText("Description");

        jaProjectDescription.setColumns(20);
        jaProjectDescription.setRows(5);
        spDescription.setViewportView(jaProjectDescription);

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "On Time", "Late", "Not Yet Started", "Completed/Closed" }));

        lStatus.setText("Status");

        lTag.setText("Tag");

        cbTag.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lProjectDesiredOutcome.setText("Project Desired Outcome");

        lStartDate.setText("Start Date");

        lEndDate.setText("End Date");

        pAddProjectButtons.setBackground(new java.awt.Color(255, 255, 255));
        pAddProjectButtons.setPreferredSize(new java.awt.Dimension(600, 100));

        bAddProject.setBackground(new java.awt.Color(255, 102, 0));
        bAddProject.setText("Add Project");
        bAddProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddProjectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pAddProjectButtonsLayout = new javax.swing.GroupLayout(pAddProjectButtons);
        pAddProjectButtons.setLayout(pAddProjectButtonsLayout);
        pAddProjectButtonsLayout.setHorizontalGroup(
            pAddProjectButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAddProjectButtonsLayout.createSequentialGroup()
                .addComponent(bAddProject)
                .addGap(0, 501, Short.MAX_VALUE))
        );
        pAddProjectButtonsLayout.setVerticalGroup(
            pAddProjectButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pAddProjectButtonsLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(bAddProject)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout lAddProjectMainLayout = new javax.swing.GroupLayout(lAddProjectMain);
        lAddProjectMain.setLayout(lAddProjectMainLayout);
        lAddProjectMainLayout.setHorizontalGroup(
            lAddProjectMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lAddProjectMainLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(lAddProjectMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lProjectDesiredOutcome)
                    .addComponent(lTag)
                    .addComponent(lProjectDescription)
                    .addGroup(lAddProjectMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lProjectName)
                        .addGroup(lAddProjectMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lStatus)
                            .addComponent(lStartDate))))
                .addGap(41, 41, 41)
                .addGroup(lAddProjectMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pAddProjectButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(lAddProjectMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(tfProjectDesiredOutcome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
                        .addComponent(tfProjectName, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(lAddProjectMainLayout.createSequentialGroup()
                        .addComponent(dcStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lEndDate)
                        .addGap(18, 18, 18)
                        .addComponent(dcEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(390, Short.MAX_VALUE))
        );
        lAddProjectMainLayout.setVerticalGroup(
            lAddProjectMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lAddProjectMainLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(lAddProjectMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfProjectName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lProjectName))
                .addGap(18, 18, 18)
                .addGroup(lAddProjectMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lProjectDescription)
                    .addComponent(spDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(lAddProjectMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lAddProjectMainLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lStartDate))
                    .addGroup(lAddProjectMainLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(lAddProjectMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lEndDate)
                            .addComponent(dcStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dcEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26)
                .addGroup(lAddProjectMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lStatus)
                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(lAddProjectMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lTag)
                    .addComponent(cbTag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(lAddProjectMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lProjectDesiredOutcome)
                    .addComponent(tfProjectDesiredOutcome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(pAddProjectButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pAddProjectBanner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lAddProjectMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pAddProjectBanner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lAddProjectMain, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addGap(76, 76, 76))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAddProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddProjectActionPerformed
         ProjectDetailsTable t1 = new ProjectDetailsTable();
         
        t1.setProjectName(tfProjectName.getText());
        t1.setProjectDescription(jaProjectDescription.getText());
        t1.setProjectStartDate(dcStartDate.getDate().toString());
        t1.setProjectEndDate(dcEndDate.getDate().toString());
        t1.setProjectStatus((String) cbStatus.getSelectedItem());
        t1.setProjectTag((String) cbTag.getSelectedItem());
        t1.setProjectOutcome(tfProjectDesiredOutcome.getText());
        //t1.setProjectId(uniqueCurrentTimeMS());
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FrugalProjectPU");
        //ProjectDetailsTableJpaController pjc = new ProjectDetailsTableJpaController(emf);
         try {
            //pjc.create(t1);
        } catch (Exception ex) {
            Logger.getLogger(AddProject.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         ProjectGUI gui = new ProjectGUI();
         gui.setVisible(true);
         
         this.setVisible(false);
    }//GEN-LAST:event_bAddProjectActionPerformed

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
            java.util.logging.Logger.getLogger(AddProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddProject().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAddProject;
    private javax.swing.JComboBox cbStatus;
    private javax.swing.JComboBox cbTag;
    private com.toedter.calendar.JDateChooser dcEndDate;
    private com.toedter.calendar.JDateChooser dcStartDate;
    private javax.swing.JTextArea jaProjectDescription;
    private javax.swing.JLabel lAddProjectBanner;
    private javax.swing.JPanel lAddProjectMain;
    private javax.swing.JLabel lEndDate;
    private javax.swing.JLabel lProjectDescription;
    private javax.swing.JLabel lProjectDesiredOutcome;
    private javax.swing.JLabel lProjectName;
    private javax.swing.JLabel lStartDate;
    private javax.swing.JLabel lStatus;
    private javax.swing.JLabel lTag;
    private javax.swing.JPanel pAddProjectBanner;
    private javax.swing.JPanel pAddProjectButtons;
    private javax.swing.JScrollPane spDescription;
    private javax.swing.JTextField tfProjectDesiredOutcome;
    private javax.swing.JTextField tfProjectName;
    // End of variables declaration//GEN-END:variables
}