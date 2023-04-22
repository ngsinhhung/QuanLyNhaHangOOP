import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public class BaoCaoDoanhThu {
    private List<HoaDon> dsHoaDon = new ArrayList<>();
    public void themHoaDon(HoaDon...hoaDons){
        this.dsHoaDon.addAll(Arrays.asList(hoaDons));
    }
    public double theoThang(int thang, int nam) {
        List<HoaDon> listFilter = this.dsHoaDon.stream().filter(hoaDon ->
                hoaDon.getBuaTiec().getThoiDiemThue().getNgayThue().getMonth() == (thang - 1) && hoaDon.getBuaTiec().getThoiDiemThue().getNgayThue().getYear() == nam - 1900
        ).collect(Collectors.toList());
        return listFilter.stream().mapToDouble(HoaDon::tinhTongTien).sum();
    }
    public double theoQuy(int quy, int nam){
        Calendar calendar = Calendar.getInstance();
        List<HoaDon> listFilter = this.dsHoaDon.stream().filter(hoaDon -> {
            var ngayHoaDon = hoaDon.getBuaTiec().getThoiDiemThue().getNgayThue();
            if ((Math.ceil((ngayHoaDon.getMonth() + 1) / 3.0f) == quy && ngayHoaDon.getYear() == (nam - 1900)))
                return true;
            return false;
                }).collect(Collectors.toList());
        return listFilter.stream().mapToDouble(HoaDon::tinhTongTien).sum();
    }

    public List<HoaDon> getDsHoaDon() {
        return dsHoaDon;
    }

    public void setDsHoaDon(List<HoaDon> dsHoaDon) {
        this.dsHoaDon = dsHoaDon;
    }
}
