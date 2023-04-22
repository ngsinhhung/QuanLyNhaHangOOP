public class  DvThueCaSi extends DichVu{
    private String tenCaSi;
    private int soBaiHat;
    public DvThueCaSi(String ten, double gia, String tenCaSi, int soLuongBaiHat){
        super(ten,gia);
        this.setTenCaSi(tenCaSi);
        this.setSoBaiHat(soLuongBaiHat);
    }

    @Override
    public void capNhatKhac() {
        System.out.print("Nhap ten ca si: ");
        this.setTenCaSi(CauHinh.sc.nextLine());
        System.out.print("Nhap so bai hat: ");
        this.setSoBaiHat(Integer.parseInt(CauHinh.sc.nextLine()));
    }

    @Override
    public void hienThi(){
        super.hienThi();
        System.out.printf("%-20s%-20s%-20d\n","", this.getTenCaSi(), this.getSoBaiHat());

    }

    public String getTenCaSi() {
        return tenCaSi;
    }

    public void setTenCaSi(String tenCaSi) {
        this.tenCaSi = tenCaSi;
    }

    public int getSoBaiHat() {
        return soBaiHat;
    }

    public void setSoBaiHat(int soBaiHat) {
        this.soBaiHat = soBaiHat;
    }
}
