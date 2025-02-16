/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject;
import javax.swing.JOptionPane;
import java.awt.*;
import java.io.*;
import java.util.*;
import javax.print.attribute.standard.DocumentName;
import static miniproject.SearchBy.*;
import static miniproject.handlerClass.*;
import static miniproject.topicModify.oldname;
/**
 *
 * 
 */
public class documentModify extends javax.swing.JFrame {

    /**
     * Creates new form AddNew
     */
    static Document d1;
    static String oldTopicName;
    static String oldFileName;
    public documentModify(Document d) {
        initComponents();
        d1 = d;
        name.setText(d.getDocumentName());
        oldFileName = d.getDocumentName();
        topicName.setText(nameOfT(d.getTopicId()));
        categoryName.setText(nameOfC(d.getCategoryId()));
        oldTopicName = nameOfT(d.getTopicId());
        String tagsToDisplay = "";
        for(String s : d.getDocumentTags().tagList)
        {
            tagsToDisplay += s;
            tagsToDisplay += ",";
        }
        tagsToDisplay = tagsToDisplay.substring(0, tagsToDisplay.length()-1);
        tags.setText(tagsToDisplay);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    public static String nameOfT(int id)
    {
        for(Topic t:topicList)
        {
            if(t.getTopicId() == id) return t.getTopicName();
        }
        return null;
    }
    
    public static String nameOfC(int id)
    {
        for(Category t:categoryList)
        {
            if(t.getCategoryId() == id) return t.getCategoryName();
        }
        return null;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        name = new javax.swing.JTextField();
        categoryName = new javax.swing.JTextField();
        topicName = new javax.swing.JTextField();
        tags = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        name.setMinimumSize(new java.awt.Dimension(15, 32));

        jLabel1.setText("Name :");

        jLabel2.setText("Category Name :");

        jLabel3.setText("Topic Name : ");

        jLabel4.setText("Tags (Separated By Commas)  :");

        jButton1.setBackground(new java.awt.Color(51, 204, 0));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Modify");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(387, 387, 387)
                                        .addComponent(topicName, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(212, 212, 212)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tags)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(categoryName, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 9, Short.MAX_VALUE)))
                        .addGap(218, 218, 218))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoryName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(topicName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(jLabel4)
                .addGap(15, 15, 15)
                .addComponent(tags, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jButton1)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String topicname = topicName.getText().trim();
        String categoryname = categoryName.getText().trim();
        String nameofD = name.getText().trim();
        Runtime ob = Runtime.getRuntime();
        if(!containsTopic(topicname))
        {
            try
            {
                ob.exec("mkdir topics/"+topicname);
            }
            catch(Exception e)
            {
                System.out.println(e);
                return;
            }
            addNewTopic(getUniqueTopicId(), topicname, "topics/"+topicname);
        }
        if(!containsCategory(categoryname))
        {
            addNewCategory(getUniqueCategoryId(), categoryname);
        }
        System.out.println(d1.getDocumentName() + " "+nameofD);
        d1.setDocumentName(nameofD);
        String s = tags.getText().trim();
        Tag documentTag=new Tag();
        documentTag.tagList=new ArrayList<>(Arrays.asList(s.split(",")));
        tagSet.addAll(documentTag.tagList);
        d1.setDocumentTags(documentTag);
        d1.setTopicId(idOfT(topicname));
        try
        {
            ob.exec("mv topics/"+oldTopicName+"/"+oldFileName+" "+"topics/"+topicname+"/"+nameofD);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        exportData();
        importData();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    static public boolean containsTopic(String topicN)
    {
        for(Topic s: topicList)
        {
            if(s.getTopicName().equals(topicN)) return true;
        }
        return false;
    }
    
    static public boolean containsCategory(String categoryN)
    {
        for(Category s: categoryList)
        {
            if(s.getCategoryName().equals(categoryN)) return true;
        }
        return false;
    }
    
    static public int getUniqueTopicId()
    {
        boolean uni = false;
        for(int i=0;;i++)
        {
            uni = true;
            for(Topic t: topicList)
            {
                if(i == t.getTopicId())
                {
                    uni = false;
                    break;
                }
            }
            if(uni) return i;
        }
    }
    
    static public int getUniqueCategoryId()
    {
        boolean uni = false;
        for(int i=0;;i++)
        {
            uni = true;
            for(Category t: categoryList)
            {
                if(i == t.getCategoryId())
                {
                    uni = false;
                    break;
                }
            }
            if(uni) return i;
        }
    }
    
    static public int getUniqueDocumentId()
    {
        boolean uni = false;
        for(int i=0;;i++)
        {
            uni = true;
            for(Document t: documentList)
            {
                if(i == t.getDocumentId())
                {
                    uni = false;
                    break;
                }
            }
            if(uni) return i;
        }
    }
    
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
            java.util.logging.Logger.getLogger(documentModify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(documentModify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(documentModify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(documentModify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new documentModify().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField categoryName;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField name;
    private javax.swing.JTextField tags;
    private javax.swing.JTextField topicName;
    // End of variables declaration//GEN-END:variables
}
