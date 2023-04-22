import java.util.*;
import java.util.stream.Collectors;

public class QuanLyAnUong {
    private List<DoAnUong> dsAnUong = new ArrayList<>();
    public void themDoAnUong(DoAnUong ...a){
        this.getDsAnUong().addAll(Arrays.asList(a));
    }

    public void xoaDoAnUong(int id){
        if(this.getDsAnUong().removeIf(x -> (x.getMaAnUong() == id))){
            System.out.println("Xóa thành công");
        }
        else{
            System.out.print("Không tìm thấy để xóa");
        }
    }
    public DoAnUong traCuuAnUong(int ma){
        try{
            return this.dsAnUong.stream().filter(dau -> dau.getMaAnUong() == ma).findFirst().get();
        }
        catch (NoSuchElementException ex){
            System.out.println("Không tìm thấy");
        }
        return null;
    }
    public List<DoAnUong> traCuuAnUong(String ten){
        return this.dsAnUong.stream().filter(dau -> dau.getTen().equals(ten)).collect(Collectors.toList());
    }
    public void hienThi(){
        CauHinh.hienTieuDeDoAnUong();
        this.getDsAnUong().forEach(a ->a.hienThi());
    }

    public List<DoAnUong> getDsAnUong() {
        return dsAnUong;
    }

    public void setDsAnUong(List<DoAnUong> dsAnUong) {
        this.dsAnUong = dsAnUong;
    }
}
