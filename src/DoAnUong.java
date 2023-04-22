public abstract class DoAnUong {
    private int maAnUong = ++dem;
    private String ten;
    private double gia;
    private static int dem = 0;
    public DoAnUong(String ten, double gia){
        this.setTen(ten);
        this.setGia(gia);
    }
    public void capNhat(){
        System.out.print("Nhập tên: ");
        this.setTen(CauHinh.sc.nextLine());
        do{
            try{
                System.out.print("Nhập giá: ");
                this.setGia(Double.parseDouble(CauHinh.sc.nextLine()));
                break;
            }
            catch (NumberFormatException ex){
                System.out.println("Lỗi nhập chữ");
            }
        }while(true);
    }
    public void hienThi(){
        System.out.printf("%-20s%-20s%-20.2f",this.maAnUong, this.ten, this.gia);
    }
    public int getMaAnUong() {
        return maAnUong;
    }

    public void setMaAnUong(int maAnUong) {
        this.maAnUong = maAnUong;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }
}
