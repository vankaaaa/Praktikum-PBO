package pelanggan_data;

import pelanggan.Menu_Form;
import pelanggan_model.Pelanggan;
import pelanggan_model.Model_Pelanggan;
import pelanggan_tampilan.Tampilan;
import java.util.List;
import javax.swing.JOptionPane;
import editpelanggan.Edit_Form;

public class Data {
    
    Tampilan frame_pelanggan;
    Edit_Form implement_pelanggan;
    List<Pelanggan> list_pelanggan;
    
    public Data(Tampilan frame_pelanggan) {
        this.frame_pelanggan = frame_pelanggan;
        implement_pelanggan = new Menu_Form();
        list_pelanggan = implement_pelanggan.getALL();
    }
    
    //Reset untuk mengkosongkan
    public void reset() {
        frame_pelanggan.getTxtID().setText("");
        frame_pelanggan.getTxtNamaBarang().setText("");
        frame_pelanggan.getTxtNamaKasir().setText("");
        frame_pelanggan.getTxtQty().setText("");
        frame_pelanggan.getTxtPrice_per_qty().setText("");
        frame_pelanggan.getTxtDiscount().setText("");
        frame_pelanggan.getTxtPrice_total().setText("");
    }
    
    //Menampilkan data ke tabel
    public void isiTable() {
        list_pelanggan = implement_pelanggan.getALL();
        Model_Pelanggan tmb = new Model_Pelanggan(list_pelanggan);
        frame_pelanggan.getTabelDataPelanggan().setModel(tmb);
    }
    
    //Menampilkan data yang dipilih, yang ada di tabel
    public void isiField(int row) {
        frame_pelanggan.getTxtID().setText(list_pelanggan.get(row).getId().toString());
        frame_pelanggan.getTxtNamaBarang().setText(list_pelanggan.get(row).getNama_barang());
        frame_pelanggan.getTxtNamaKasir().setText(list_pelanggan.get(row).getNama_kasir());
        frame_pelanggan.getTxtQty().setText(list_pelanggan.get(row).getQty().toString());
        frame_pelanggan.getTxtPrice_per_qty().setText(list_pelanggan.get(row).getPrice_per_qty().toString());
        frame_pelanggan.getTxtDiscount().setText(list_pelanggan.get(row).getDiscount().toString());
        frame_pelanggan.getTxtPrice_total().setText(list_pelanggan.get(row).getPrice_total().toString());
    }
    
    //Memasukkan data
    public void insert() {
        
        if (!frame_pelanggan.getTxtNamaBarang().getText().trim().isEmpty()& !frame_pelanggan.getTxtNamaKasir().getText().trim().isEmpty()& !frame_pelanggan.getTxtNamaKasir().getText().trim().isEmpty()) {
          
        Pelanggan b = new Pelanggan();
        b.setId(frame_pelanggan.getTxtID().getText());
        b.setNama_barang(frame_pelanggan.getTxtNamaBarang().getText());
        b.setNama_kasir(frame_pelanggan.getTxtNamaKasir().getText());
        b.setQty(frame_pelanggan.getTxtQty().getText().toString());
        b.setPrice_per_qty(frame_pelanggan.getTxtPrice_per_qty().getText().toString());
        b.setDiscount(frame_pelanggan.getTxtDiscount().getText().toString());
        b.setPrice_total(frame_pelanggan.getTxtPrice_total().getText().toString());

        implement_pelanggan.insert(b);
        JOptionPane.showMessageDialog(null, "Data Berhasil Di Simpan");
        
        } else {
            JOptionPane.showMessageDialog(frame_pelanggan, "Data Tidak Boleh Ada Yang Kosong !");
        }
    }
    
    //Update data untuk mengubah data pada database
    public void update() {
      
        if (!frame_pelanggan.getTxtID().getText().trim().isEmpty()) {
             
        Pelanggan b = new Pelanggan();
        b.setId(frame_pelanggan.getTxtID().getText());
        b.setNama_barang(frame_pelanggan.getTxtNamaBarang().getText());
        b.setNama_kasir(frame_pelanggan.getTxtNamaKasir().getText());
        b.setQty(frame_pelanggan.getTxtQty().getText().toString());
        b.setPrice_per_qty(frame_pelanggan.getTxtPrice_per_qty().getText().toString());
        b.setDiscount(frame_pelanggan.getTxtDiscount().getText().toString());
        b.setPrice_total(frame_pelanggan.getTxtPrice_total().getText().toString());
        implement_pelanggan.update(b);
        
        JOptionPane.showMessageDialog(null, "Data Berhasil Di Update");
        } else {
            JOptionPane.showMessageDialog(frame_pelanggan, "Silahkan Pilih Data Yang Akan Di Ubah !");
        }
    }
    
    //Hapus data dari database
    public void delete() {
        if (!frame_pelanggan.getTxtID().getText().trim().isEmpty()) {
            String id = (frame_pelanggan.getTxtID().getText());
            implement_pelanggan.delete(id);
            
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Hapus");
        } else {
            JOptionPane.showMessageDialog(frame_pelanggan, "Silahkan Pilih Data Yang Akan Di Hapus !");
        }
    }
    
    public void isiTableCariNama() {
        list_pelanggan = implement_pelanggan.getCariNama(frame_pelanggan.getTxtCariNamaPelanggan().getText());
        Model_Pelanggan tmb = new Model_Pelanggan(list_pelanggan);
        frame_pelanggan.getTabelDataPelanggan().setModel(tmb);
    }

    public void carinama() {
        if (!frame_pelanggan.getTxtCariNamaPelanggan().getText().trim().isEmpty()) {
            implement_pelanggan.getCariNama(frame_pelanggan.getTxtCariNamaPelanggan().getText());
            isiTableCariNama();
        } else {
            JOptionPane.showMessageDialog(frame_pelanggan, "SILAHKAN PILIH DATA !");
        }
    }
}
