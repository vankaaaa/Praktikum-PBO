package pelanggan_model;

public class Pelanggan {
    
    private String id;
    private String nama_barang;
    private String nama_kasir;
    private String qty;
    private String price_per_qty;
    private String discount;
    private String price_total;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public String getNama_kasir() {
        return nama_kasir;
    }

    public void setNama_kasir(String nama_kasir) {
        this.nama_kasir = nama_kasir;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getPrice_per_qty() {
        return price_per_qty;
    }

    public void setPrice_per_qty(String price_per_qty) {
        this.price_per_qty = price_per_qty;
    }
    
    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getPrice_total() {
        return price_total;
    }

    public void setPrice_total(String price_total) {
        this.price_total = price_total;
    }
    
}
