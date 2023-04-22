import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuanLyChoThue {
    private List<ChoThueSanh> dsChoThue = new ArrayList<>();

    public void themChoThue(ChoThueSanh... choThueSanh) {
        getDsChoThue().addAll(Arrays.asList(choThueSanh));
    }

    public long tinhTanSo(SanhCuoi sanhCuoi) {
        return getDsChoThue().stream().filter(s -> s.getSanhThue().equals(sanhCuoi)).count();
    }

    public void hienThi(){
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s", "Mã buổi tiệc", "Tên buổi tiệc", "Mã sảnh",
                "Tên sảnh", "Vị trí sảnh", "Sức chứa", "Ngày thuê","Buổi thuê");
        this.getDsChoThue().forEach(sanh -> sanh.hienThi());
    }
    public List<SanhCuoi> traCuuSanh (int nam) {
        return getDsChoThue().stream().filter(choThue -> choThue.getThoiDiemThue().getNgayThue().getYear() == nam).map(ChoThueSanh::getSanhThue).toList();
    }
    public ChoThueSanh traCuuTiec(String id){
        return this.dsChoThue.stream().filter(tiec -> tiec.getMaBuoiTiec().equals(id)).findFirst().get();
    }

    public List<ChoThueSanh> getDsChoThue() {
        return dsChoThue;
    }

    public void setDsChoThue(List<ChoThueSanh> dsChoThue) {
        this.dsChoThue = dsChoThue;
    }
}
