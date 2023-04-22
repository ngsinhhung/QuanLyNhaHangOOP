import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class QuanLySanhCuoi {
    private List<SanhCuoi> dsSanhCuoi = new ArrayList<>();
    private QuanLyChoThue quanLyChoThue;

    public void themSanh(SanhCuoi... sanhCuois) {
        dsSanhCuoi.addAll(Arrays.asList(sanhCuois));
    }
    public SanhCuoi traCuuSanhTheoMa(String maSanh) {
        try{
            return dsSanhCuoi.stream().filter(sanh -> sanh.getMaSanh().equals(maSanh)).findFirst().get();
        }
        catch (NoSuchElementException ex){
            System.out.println("Không có mã này. Vui lòng kiểm tra lại");
        }
        return null;
    }

    public List<SanhCuoi> traCuuSanh(String ten) {
        return dsSanhCuoi.stream().filter(sanh -> sanh.getTenSanh().equals(ten)).collect(Collectors.toList());
    }
    public List<SanhCuoi> traCuuSanh(int sucChua) {
        return this.dsSanhCuoi.stream().filter(sanh -> sanh.getSucChua() == sucChua).collect(Collectors.toList());
    }
    public List<SanhCuoi> traCuuSanh(ViTriSanh viTriSanh) {
        return this.dsSanhCuoi.stream().filter(sanh -> sanh.getViTriSanh() == viTriSanh).collect(Collectors.toList());
    }

    public void xoaSanh(String ma) {
        if(this.dsSanhCuoi.removeIf(s -> s.getMaSanh().equals(ma))){
            System.out.print("Sảnh đã được xóa thành công.");
        }
        else
            System.out.print("Không có mã này. Vui lòng kiểm tra lại");
    }

    public void sapXepTheoTanSoThue() {
        dsSanhCuoi.sort((sanhA, sanhB) -> - Math.toIntExact(quanLyChoThue.tinhTanSo(sanhA) - quanLyChoThue.tinhTanSo(sanhB)));
    }

    public void hienThi(){
        System.out.printf("%-20s%-20s%-20s%-20s","Mã sảnh", "Tên sảnh", "Vị trí", "Sức chứa");
        this.dsSanhCuoi.forEach(sanh -> sanh.hienThi());
    }

    public void hienThiTheoTanSo() {
        dsSanhCuoi.forEach(sanh -> {
            System.out.printf("\n%-40s%-20s", sanh.getTenSanh(), quanLyChoThue.tinhTanSo(sanh));
        });
    }

    public List<SanhCuoi> getDsSanhCuoi() {
        return dsSanhCuoi;
    }
    public void setDsSanhCuoi(List<SanhCuoi> dsSanhCuoi) {
        this.dsSanhCuoi = dsSanhCuoi;
    }

    public void setQuanLyChoThue(QuanLyChoThue quanLyChoThue) {
        this.quanLyChoThue = quanLyChoThue;
    }
}
