import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class QuanLyGiaThue {
    private List<GiaThueSanh> dsGiaThue = new ArrayList<>();

    public void themGiaThue(GiaThueSanh... dsGiaThue) {
        this.dsGiaThue.addAll(Arrays.asList(dsGiaThue));
    }

    public GiaThueSanh traCuuTheoMa(int ma) {
        try {
            return dsGiaThue.stream().filter(gia -> gia.getMa() == ma).findFirst().get();

        } catch (NoSuchElementException ex) {
            System.out.println("Không có giá với mã này");
        }
        return null;
    }
    public void hienThi(){
        CauHinh.hienTieuDeGiaThue();
        this.dsGiaThue.forEach(GiaThueSanh::hienThi);
    }

    public List<GiaThueSanh> getDsGiaThue() {
        return dsGiaThue;
    }

    public void setDsGiaThue(List<GiaThueSanh> dsGiaThue) {
        this.dsGiaThue = dsGiaThue;
    }
}
