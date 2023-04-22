import java.util.Arrays;
import java.util.List;

public class GiaThueSanh {

    private static int dem = 0;

    private int ma = ++dem;
    private double gia;
    private List<ThoiDiemThue> dsThoiDiem;

    public GiaThueSanh(double gia, ThoiDiemThue... dsThoiDiem) {
        this.gia = gia;
        this.dsThoiDiem = Arrays.asList(dsThoiDiem);
    }
    public GiaThueSanh(double gia, List<ThoiDiemThue> dsThoiDiem) {
        this.gia = gia;
        this.dsThoiDiem = dsThoiDiem;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public void hienThi(){
        System.out.printf("%-20s%-20s",this.ma, this.gia);
        for (int i = 0; i < dsThoiDiem.size(); i++) {
            if (i == 0)
                dsThoiDiem.get(i).hienThi();
            else
                dsThoiDiem.get(i).hienThiCachHang();
        }
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public List<ThoiDiemThue> getDsThoiDiem() {
        return dsThoiDiem;
    }

    public void setDsThoiDiem(List<ThoiDiemThue> dsThoiDiem) {
        this.dsThoiDiem = dsThoiDiem;
    }
}
