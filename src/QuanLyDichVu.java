import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class QuanLyDichVu {
    private List<DichVu> dsDVu = new ArrayList<>();
    public void themDVu(DichVu ...a){
        this.getDsDVu().addAll(Arrays.asList(a));
    }
    public void xoaDVu(String maDv){
        if(this.dsDVu.removeIf(d->d.getMaDV().equals(maDv))){
            System.out.println("Xóa thành công");
        }
        else
            System.out.println("Không tìm thấy để xóa");
    }

    public DichVu traCuuTheoMa(String ma) {
        try {
            return this.dsDVu.stream().filter(dv -> dv.getMaDV().equals(ma)).findFirst().get();
        }
        catch (NoSuchElementException ex){
            System.out.print("Không tìm thấy dịch vụ. Vui lòng kiểm tra lại");
        }
        return null;
    }
    public List<DichVu> traCuuDichVu(String tenDv){
        return this.dsDVu.stream().filter(d->d.getTenDV().equals(tenDv)).collect(Collectors.toList());
    }
    public void hienThi(){
        this.dsDVu.forEach(d->d.hienThi());
    }

    public List<DichVu> getDsDVu() {
        return dsDVu;
    }

    public void setDsDVu(List<DichVu> dsDVu) {
        this.dsDVu = dsDVu;
    }
}
