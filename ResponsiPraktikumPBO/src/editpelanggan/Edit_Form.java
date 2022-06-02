package editpelanggan;

import pelanggan_model.Pelanggan;
import java.util.List;

public interface Edit_Form {
    public void insert(Pelanggan b);

    public void update(Pelanggan b);

    public void delete(String id);

    public List<Pelanggan> getALL();

    public List<Pelanggan> getCariNama(String nama);
}
