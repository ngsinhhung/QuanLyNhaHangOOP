import java.util.GregorianCalendar;

public class HoaDon {
    private String maHoaDon;
    private double tongTien;
    private ChoThueSanh buaTiec;

    {
        maHoaDon = String.format("HD%03d",++dem);
    }
    private static int dem = 0;
    public HoaDon(ChoThueSanh buaTiec){
        this.setBuaTiec(buaTiec);
    }
    public double tinhTongTien(){
        return this.buaTiec.getGiaThueSanh().getGia() + this.buaTiec.tinhGiaDVu() + this.buaTiec.tinhGiaMenu();
    }
    public void xuatHoaDon(){
        System.out.println("************** HOÁ ĐƠN **************");
        System.out.printf("|%s: %s|\n","Mã hóa đơn",this.maHoaDon);
        System.out.printf("|%s: %s|\n","Mã sãnh thuê",this.buaTiec.getSanhThue().getMaSanh());
        System.out.printf("|%s: %s|\n","Tên sãnh thuê",this.buaTiec.getSanhThue().getTenSanh());
        System.out.printf("|Ngày thuê: %s|\n",CauHinh.f.format(this.buaTiec.getThoiDiemThue().getNgayThue()));
        System.out.printf("%-20s%-20s%-20s\n","Mã","Tên","Đơn giá");
        System.out.printf("%-20s%-20s%-20.2f\n", this.buaTiec.getSanhThue().getMaSanh(), this.buaTiec.getSanhThue().getTenSanh(), this.buaTiec.getGiaThueSanh().getGia());
        this.buaTiec.getListMenu().forEach(item ->{
            System.out.printf("%-20s%-20s%-20s\n",item.getMaMenu(),"Menu" + item.getMaMenu(),item.tinhGia());
        });
        this.buaTiec.getListDV().forEach(item -> {
            System.out.printf("%-20s%-20s%-20s\n",item.getMaDV(),item.getTenDV(),item.getGiaDV());
        });
        System.out.printf("Thành tiền: %-20.2f\n", this.tinhTongTien());
        System.out.println("*************************************\n\n\n");

    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public ChoThueSanh getBuaTiec() {
        return buaTiec;
    }

    public void setBuaTiec(ChoThueSanh buaTiec) {
        this.buaTiec = buaTiec;
    }

}
