public abstract class DichVu {
    private String maDV;
    private String tenDV;
    private double giaDV;
    private static int dem = 0;
    {
        setMaDV(String.format("DV%03d", ++dem));
    }
    public DichVu(String ten, double gia){
        this.setTenDV(ten);
        this.setGiaDV(gia);
    }
    public void capNhat() {
        int choose;
        do {
            System.out.println("\nChọn thuộc tính để cập nhật: ");
            System.out.print("1. Tên dịch vụ\n2. Giá dịch vụ\n3. Khác\n0. Thoát\n");
            System.out.print("Chọn: ");
            choose = Integer.parseInt(CauHinh.sc.nextLine());
            switch (choose) {
                case 1:
                    System.out.print("Nhập tên dịch vụ mới: ");
                    this.tenDV = CauHinh.sc.nextLine();
                    break;
                case 2:
                    System.out.print("Nhập giá dịch vụ mới: ");
                    this.giaDV = Double.parseDouble(CauHinh.sc.nextLine());

                    break;
                case 3:
                    this.capNhatKhac();
                    break;
                case 0:
                    choose = 0;
                    break;
                default:
                    System.out.println("Không có lựa chọn này!");
                    break;
            }
        }while (choose != 0);
    }
    public abstract void capNhatKhac();
    public void hienThi(){
        System.out.printf("%-20s%-20s%-20.2f",this.maDV,this.tenDV,this.giaDV);
    }
    public String getMaDV() {
        return maDV;
    }

    public void setMaDV(String maDV) {
        this.maDV = maDV;
    }

    public String getTenDV() {
        return tenDV;
    }

    public void setTenDV(String tenDV) {
        this.tenDV = tenDV;
    }

    public double getGiaDV() {
        return giaDV;
    }

    public void setGiaDV(double giaDV) {
        this.giaDV = giaDV;
    }
}
