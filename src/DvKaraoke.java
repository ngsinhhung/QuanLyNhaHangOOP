public class DvKaraoke extends DichVu{
    private double thoiGianThue;
    public DvKaraoke(String ten, double gia, double thoiGian){
        super(ten, gia);
        this.setThoiGianThue(thoiGian);
    }

    @Override
    public void capNhatKhac() {
        System.out.print("Nhập thời gian thuê: ");
        this.thoiGianThue = Double.parseDouble(CauHinh.sc.nextLine());
    }

    @Override
    public void hienThi(){
        super.hienThi();
        System.out.printf("%-20.2f\n", this.getThoiGianThue());
    }

    public double getThoiGianThue() {
        return thoiGianThue;
    }

    public void setThoiGianThue(double thoiGianThue) {
        this.thoiGianThue = thoiGianThue;
    }
}
