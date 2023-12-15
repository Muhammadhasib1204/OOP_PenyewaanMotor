/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package PenyewaanMotor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author lilis
 */
public class GUIPenyewaan extends javax.swing.JFrame {

    /**
     * Creates new form GUIPenyewaan
     */
    public GUIPenyewaan() {
        initComponents();
        tampil();
    }
    public void clear(){
        TxtNama.setText("");
        TxtKTP.setText("");
        TxtUmur.setText("");
        TxtAlamat.setText("");
        ButtonJenis.clearSelection();
        ButtonWarna.clearSelection();
        TxtHarga.setText("");
        TxtDurasi.setText("");
        TxtPembayaran.setText("");
    }
    public Connection conn;
    String nama1, NOktp1, umur1, alamat1, jm1, warna1,harga1,durasi1,pembayaran1;
    public void koneksi() throws SQLException {
        try {
            conn = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/oop_2218017_penyewaan?user=root&password=");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUIPenyewaan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(GUIPenyewaan.class.getName()).log(Level.SEVERE, null, e);
        } catch (Exception es) {
            Logger.getLogger(GUIPenyewaan.class.getName()).log(Level.SEVERE, null, es);
        }
    }
    public void tampil() {
        DefaultTableModel tabelhead = new DefaultTableModel();
        tabelhead.addColumn("Nama");
        tabelhead.addColumn("No KTP");
        tabelhead.addColumn("Umur");
        tabelhead.addColumn("Alamat");
        tabelhead.addColumn("Jenis Motor");
        tabelhead.addColumn("Warna Motor");
        tabelhead.addColumn("Harga Sewa");
        tabelhead.addColumn("Durasi Penyewaan");
        tabelhead.addColumn("Metode Pembayaran");
        try {
            koneksi();
            String sql = "SELECT * FROM tb_formpenyewaan";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while (res.next()) {
                tabelhead.addRow(new Object[]{res.getString(2), res.getString(3), res.getString(4), res.getString(5),res.getString(6),res.getString(7),res.getString(8),res.getString(9),res.getString(10)});
            }
            tableForm.setModel(tabelhead);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "BELUM TERKONEKSI");
        }
    }
    public void refresh() {
        new GUIPenyewaan().setVisible(true);
        this.setVisible(false);
    }
    public void insert() {
        String Nama = TxtNama.getText();
        String NOKTP = TxtKTP.getText();
        String Umur = TxtUmur.getText();
        String Alamat = TxtAlamat.getText();
        String jm;
        if (TxtHonda.isSelected()) {
            jm = "Honda";
        } else if (TxtYamaha.isSelected()) {
            jm = "Yamaha";
        } else {
            jm = "Suzuki";
        }
        String Warna;
        if (TxtMerah.isSelected()){
            Warna = "Merah";
        } else if(TxtHitam.isSelected()){
            Warna = "Hitam";
        } else {
            Warna = "Biru";
        }
        String Harga = TxtHarga.getText();
        String Durasi = TxtDurasi.getText();
        String Metode = TxtPembayaran.getText();
        try {
            koneksi();
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO tb_formpenyewaan (id,Nama, no_ktp, Umur, Alamat, Jenis_Motor, Warna_Motor, Harga_Sewa, Durasi_Penyewaan, Metode_Pembayaran)"
                    + "VALUES(null,'" + Nama + "','" + NOKTP + "','" + Umur + "','" + Alamat + "','" + jm + "','" + Warna + "','" + Harga + "','" + Durasi + "','" + Metode + "')");
            statement.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diinput");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Input!");
        }
        refresh();
    }
    public void itempilih() {
        TxtNama.setText(nama1);
        TxtKTP.setText(NOktp1);
        TxtUmur.setText(umur1);
        TxtAlamat.setText(alamat1);
        if (jm1.equalsIgnoreCase("Honda")) {
            TxtHonda.setSelected(true);
        } else if(jm1.equalsIgnoreCase("Yamaha")){
            TxtYamaha.setSelected(true);
        } else {
            TxtSuzuki.setSelected(true);
        }
        if(warna1.equalsIgnoreCase("Merah")){
            TxtMerah.setSelected(true);
        } else if(warna1.equalsIgnoreCase("Hitam")){
            TxtHitam.setSelected(true);
        } else {
            TxtBiru.setSelected(true);
        }
        TxtHarga.setText(harga1);
        TxtDurasi.setText(durasi1);
        TxtPembayaran.setText(pembayaran1);
    }


    public void delete() {
        int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin akan menghapus data ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            try {
                String sql = "DELETE FROM tb_formpenyewaan WHERE Nama='" + TxtNama.getText() + "'";
                java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil di hapus");
                clear();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data gagal di hapus");
            }
        }
        refresh();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonJenis = new javax.swing.ButtonGroup();
        ButtonWarna = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TxtNama = new javax.swing.JTextField();
        TxtUmur = new javax.swing.JTextField();
        TxtAlamat = new javax.swing.JTextField();
        TxtHonda = new javax.swing.JRadioButton();
        TxtYamaha = new javax.swing.JRadioButton();
        TxtSuzuki = new javax.swing.JRadioButton();
        TxtMerah = new javax.swing.JRadioButton();
        TxtHitam = new javax.swing.JRadioButton();
        TxtBiru = new javax.swing.JRadioButton();
        TxtDurasi = new javax.swing.JTextField();
        BTNCetak = new javax.swing.JButton();
        BTNBatal = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        TxtPembayaran = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        TxtHarga = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableForm = new javax.swing.JTable();
        BtnHps = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        TxtKTP = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("ISIKAN FORM PENYEWAAN");

        jLabel2.setText("Nama :");

        jLabel3.setText("Umur :");

        jLabel4.setText("Alamat :");

        jLabel5.setText("Jenis Motor :");

        jLabel6.setText("Warna Motor :");

        jLabel7.setText("Durasi Penyewaan :");

        TxtUmur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtUmurActionPerformed(evt);
            }
        });

        TxtHonda.setText("Honda");

        TxtYamaha.setText("Yamaha");

        TxtSuzuki.setText("Suzuki");

        TxtMerah.setText("Merah");

        TxtHitam.setText("Hitam");

        TxtBiru.setText("Biru");

        TxtDurasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtDurasiActionPerformed(evt);
            }
        });

        BTNCetak.setText("Simpan");
        BTNCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNCetakActionPerformed(evt);
            }
        });

        BTNBatal.setText("Close");
        BTNBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNBatalActionPerformed(evt);
            }
        });

        jLabel8.setText("Metode Pembayaran :");

        jLabel9.setText("Harga Sewa/ Motor :");

        tableForm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nama", "No KTP", "Umur", "Alamat", "Jenis Motor", "Warna Motor", "Harga Sewa", "Durasi Sewa", "Metode Pembayaran"
            }
        ));
        tableForm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableFormMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableForm);

        BtnHps.setText("Hapus");
        BtnHps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHpsActionPerformed(evt);
            }
        });

        jLabel11.setText("No KTP :");

        jButton1.setText("Form Data");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(TxtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(TxtSuzuki)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(TxtHonda)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(TxtYamaha))))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(TxtBiru)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(TxtMerah)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(TxtHitam))))
                                .addComponent(TxtHarga, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TxtUmur, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(TxtNama))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 993, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TxtKTP, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(BTNCetak)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BtnHps)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BTNBatal)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton1))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(TxtDurasi, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TxtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(TxtKTP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(TxtUmur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(TxtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(TxtHonda)
                            .addComponent(TxtYamaha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtSuzuki)
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(TxtMerah)
                            .addComponent(TxtHitam))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtBiru)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(TxtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(TxtDurasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(TxtPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BTNCetak)
                            .addComponent(BtnHps)
                            .addComponent(BTNBatal)
                            .addComponent(jButton1))))
                .addContainerGap(428, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtUmurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtUmurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtUmurActionPerformed

    private void BTNBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNBatalActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_BTNBatalActionPerformed

    private void BTNCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNCetakActionPerformed
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_BTNCetakActionPerformed

    private void TxtDurasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtDurasiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtDurasiActionPerformed

    private void BtnHpsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHpsActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_BtnHpsActionPerformed

    private void tableFormMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableFormMouseClicked
        // TODO add your handling code here:
        int tabel = tableForm.getSelectedRow();
        nama1 = tableForm.getValueAt(tabel, 0).toString();
        NOktp1 = tableForm.getValueAt(tabel, 1).toString();
        umur1 = tableForm.getValueAt(tabel, 2).toString();
        alamat1 = tableForm.getValueAt(tabel, 3).toString();
        jm1 = tableForm.getValueAt(tabel, 4).toString();
        warna1 = tableForm.getValueAt(tabel, 5).toString();
        harga1 = tableForm.getValueAt(tabel, 6).toString();
        durasi1 = tableForm.getValueAt(tabel, 7).toString();
        pembayaran1 = tableForm.getValueAt(tabel, 8).toString(); 
        itempilih();
    }//GEN-LAST:event_tableFormMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new PenyewaMotor().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(GUIPenyewaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIPenyewaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIPenyewaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIPenyewaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIPenyewaan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNBatal;
    private javax.swing.JButton BTNCetak;
    private javax.swing.JButton BtnHps;
    private javax.swing.ButtonGroup ButtonJenis;
    private javax.swing.ButtonGroup ButtonWarna;
    private javax.swing.JTextField TxtAlamat;
    private javax.swing.JRadioButton TxtBiru;
    private javax.swing.JTextField TxtDurasi;
    private javax.swing.JTextField TxtHarga;
    private javax.swing.JRadioButton TxtHitam;
    private javax.swing.JRadioButton TxtHonda;
    private javax.swing.JTextField TxtKTP;
    private javax.swing.JRadioButton TxtMerah;
    private javax.swing.JTextField TxtNama;
    private javax.swing.JTextField TxtPembayaran;
    private javax.swing.JRadioButton TxtSuzuki;
    private javax.swing.JTextField TxtUmur;
    private javax.swing.JRadioButton TxtYamaha;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableForm;
    // End of variables declaration//GEN-END:variables
}
