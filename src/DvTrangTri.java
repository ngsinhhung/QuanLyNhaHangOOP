public class DvTrangTri extends DichVu{
    public DvTrangTri(String ten,double gia){
        super(ten, gia);
    }
    public void capNhatKhac(){
        System.out.print("Không có thuộc tính khác để cập nhật");
    }

    @Override
    public void hienThi() {
        super.hienThi() ;
        System.out.println();
    }
}
