package pelanggan;

import pelaggan_koneksi.Koneksi;
import pelanggan_model.Pelanggan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import editpelanggan.Edit_Form;

public class Menu_Form implements Edit_Form {

    Connection connection;
    final String insert = "INSERT INTO transactions (id_trans,nama_barang, nama_kasir, qty, price_per_qty, discount, price_total) VALUES (?,?,?,?,?,?,?);";
    final String update = "UPDATE transactions set nama_barang=?, nama_kasir=?, qty=?, price_per_qty=?, discount=?, price_total=? WHERE id_trans=? ;";
    final String delete = "DELETE FROM transactions where id_trans=? ;";
    final String select = "SELECT * FROM transactions;";
    final String carinama = "SELECT * FROM transactions where nama_barang like ?";
    
    public Menu_Form() {
        connection = Koneksi.connection();
    }
    
    @Override   //dilakukan override
    public void insert(Pelanggan b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, b.getId());
            statement.setString(2, b.getNama_barang());
            statement.setString(3, b.getNama_kasir());
            statement.setString(4, b.getQty());
            statement.setString(5, b.getPrice_per_qty());
            statement.setString(6, b.getDiscount());
            statement.setString(7, b.getPrice_total());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()) {
                b.setId(rs.getString(1));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(Pelanggan b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, b.getNama_barang());
            statement.setString(2, b.getNama_kasir());
            statement.setString(3, b.getQty());
            statement.setString(4, b.getPrice_per_qty());
            statement.setString(5, b.getDiscount());
            statement.setString(6, b.getPrice_total());
            statement.setString(7, b.getId());
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(String id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);

            statement.setString(1, id);
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<Pelanggan> getALL() {
        List<Pelanggan> lb = null;
        try {
            lb = new ArrayList<Pelanggan>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                Pelanggan b = new Pelanggan();
                b.setId(rs.getString("id_trans"));
                b.setNama_barang(rs.getString("nama_barang"));
                b.setNama_kasir(rs.getString("nama_kasir"));
                b.setQty(rs.getString("qty"));
                b.setPrice_per_qty(rs.getString("price_per_qty"));
                b.setDiscount(rs.getString("discount"));
                b.setPrice_total(rs.getString("price_total"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Menu_Form.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lb;
    }

    @Override
    public List<Pelanggan> getCariNama(String nama) {
        List<Pelanggan> lb = null;
        try {
            lb = new ArrayList<Pelanggan>();
            PreparedStatement st = connection.prepareStatement(carinama);
            st.setString(1, "%" + nama + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Pelanggan b = new Pelanggan();
                b.setId(rs.getString("id_trans"));
                b.setNama_barang(rs.getString("nama_barang"));
                b.setNama_kasir(rs.getString("nama_kasir"));
                b.setQty(rs.getString("qty"));
                b.setPrice_per_qty(rs.getString("price_per_qty"));
                b.setDiscount(rs.getString("discount"));
                b.setPrice_total(rs.getString("price_total"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Menu_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;
    }
    
}
