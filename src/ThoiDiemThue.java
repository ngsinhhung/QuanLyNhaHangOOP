import java.util.Date;

public class ThoiDiemThue {
    private Date ngayThue;
    private BuoiThue buoiThue;

    public ThoiDiemThue(Date ngayThue, BuoiThue buoiThue) {
        this.ngayThue = ngayThue;
        this.buoiThue = buoiThue;
    }

    public void hienThi(){
        System.out.printf("%-20s%-20s\n", CauHinh.f.format(this.ngayThue),this.buoiThue);
    }

    public void hienThiCachHang(){
        System.out.printf("%-20s%-20s%-20s%-20s\n", "", "", CauHinh.f.format(this.ngayThue),this.buoiThue);
    }

    public void hienThiChoThue(){
        System.out.printf("%-20s%-20s",CauHinh.f.format(this.ngayThue),this.buoiThue);
    }
    @Override
    public boolean equals(Object obj) {
        ThoiDiemThue temp = (ThoiDiemThue) obj;
        return temp.ngayThue.equals(this.ngayThue) && this.buoiThue == temp.buoiThue;
    }
    public Date getNgayThue() {
        return ngayThue;
    }

    public void setNgayThue(Date ngayThue) {
        this.ngayThue = ngayThue;
    }

    public BuoiThue getBuoiThue() {
        return buoiThue;
    }

    public void setBuoiThue(BuoiThue buoiThue) {
        this.buoiThue = buoiThue;
    }

}
