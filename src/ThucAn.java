import javax.swing.text.StyledEditorKit;

public class ThucAn extends DoAnUong {
    private boolean isChay;
    public ThucAn(String ten , double gia, boolean isChay){
        super(ten, gia);
        this.isChay = isChay;
    }
    @Override
    public void hienThi(){
        super.hienThi();
        System.out.printf("%-20s\n", (getIsChay()) ? "Chay" : "Khong Chay");
    }

    public boolean getIsChay() {
        return isChay;
    }

    @Override
    public void capNhat(){
        super.capNhat();
        do{
            try {
                System.out.print("Ăn chay được không? (0-Không / 1-Có): ");
                this.isChay = Boolean.parseBoolean((Integer.parseInt(CauHinh.sc.nextLine())) == 0 ? "False" : "True");
                break;
            }catch (NumberFormatException ex){
                System.out.print("Lỗi nhập chữ\n");
            }
        }while (true);
    }

    public void setChay(boolean chay) {
        isChay = chay;
    }
}
