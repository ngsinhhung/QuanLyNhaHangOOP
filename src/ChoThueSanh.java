import java.util.*;

public class ChoThueSanh {
    private String maBuoiTiec;
    private String tenBuoiTiec;
    private SanhCuoi sanhThue;
    private GiaThueSanh giaThueSanh;
    private ThoiDiemThue thoiDiemThue;
    private List<MenuBuoiTiec> listMenu;
    private double giaMenu;
    private List<DichVu> listDV;
    private double giaDV;
    private static int dem = 0;
    {
        setMaBuoiTiec(String.format("ChoThue%03d",++dem));
    }
    private GiaThueSanh timGiaThue() {
//        Class classThoiDiemThue = thoiDiemThue.getClass();
        return this.sanhThue.getDsGiaThue().stream().filter(giaThue -> {
            if (giaThue.getDsThoiDiem().contains(this.thoiDiemThue))
                return true;
            return false;
        }).findFirst().get();
    }

    public ChoThueSanh(String tenBuoiTiec, SanhCuoi sanhThue, ThoiDiemThue thoiDiemThue,
                       List<MenuBuoiTiec> listMenu, List<DichVu> listDV) {
        this.tenBuoiTiec = tenBuoiTiec;
        this.sanhThue = sanhThue;
        this.thoiDiemThue = thoiDiemThue;
        this.giaThueSanh = timGiaThue();
        this.listMenu = listMenu;
        this.listDV = listDV;
    }

    public ChoThueSanh(String tenBuoiTiec, SanhCuoi sanhThue, ThoiDiemThue thoiDiemThue,
                       MenuBuoiTiec[] listMenu, DichVu... listDV) {
        this.tenBuoiTiec = tenBuoiTiec;
        this.sanhThue = sanhThue;
        this.thoiDiemThue = thoiDiemThue;
        this.giaThueSanh = timGiaThue();
        this.listMenu = Arrays.asList(listMenu);
        this.listDV = Arrays.asList(listDV);
    }

    public void themMenu(MenuBuoiTiec... menus) {
        listMenu.addAll(Arrays.asList(menus));
    }
    public double tinhGiaMenu(){
        this.giaMenu = this.listMenu.stream().map(menu -> menu.tinhGia()).reduce(Double.valueOf(0.0), (giaListMenu, giaMenu) -> giaListMenu += giaMenu);
        return this.giaMenu;
    }

    public void themDV(DichVu... dichVus) {
        listDV.addAll((Arrays.asList(dichVus)));
    }
    public double tinhGiaDVu(){
        this.giaDV = this.listDV.stream().map(dichVu -> dichVu.getGiaDV()).reduce(Double.valueOf(0.0), (giaListDV, giaDV) -> giaListDV += giaDV);
        return this.giaDV;
    }
    public void hienThi(){
        System.out.printf("\n%-20s%-20s", this.getMaBuoiTiec(), this.tenBuoiTiec);
        sanhThue.hienThiChoThue();
        thoiDiemThue.hienThiChoThue();
    }

    public String getTenBuoiTiec() {
        return tenBuoiTiec;
    }

    public void setTenBuoiTiec(String tenBuoiTiec) {
        this.tenBuoiTiec = tenBuoiTiec;
    }

    public SanhCuoi getSanhThue() {
        return sanhThue;
    }

    public void setSanhThue(SanhCuoi sanhThue) {
        this.sanhThue = sanhThue;
    }

    public ThoiDiemThue getThoiDiemThue() {
        return thoiDiemThue;
    }

    public void setThoiDiemThue(ThoiDiemThue thoiDiemThue) {
        this.thoiDiemThue = thoiDiemThue;
    }

    public List<MenuBuoiTiec> getListMenu() {
        return listMenu;
    }

    public void setListMenu(List<MenuBuoiTiec> listMenu) {
        this.listMenu = listMenu;
    }

    public double getGiaMenu() {
        return giaMenu;
    }

    public void setGiaMenu(double giaMenu) {
        this.giaMenu = giaMenu;
    }

    public List<DichVu> getListDV() {
        return listDV;
    }

    public void setListDV(List<DichVu> listDV) {
        this.listDV = listDV;
    }

    public double getGiaDV() {
        return giaDV;
    }

    public void setGiaDV(double giaDV) {
        this.giaDV = giaDV;
    }

    public String getMaBuoiTiec() {
        return maBuoiTiec;
    }

    public void setMaBuoiTiec(String maBuoiTiec) {
        this.maBuoiTiec = maBuoiTiec;
    }

    public GiaThueSanh getGiaThueSanh() {
        return giaThueSanh;
    }

    public void setGiaThueSanh(GiaThueSanh giaThueSanh) {
        this.giaThueSanh = giaThueSanh;
    }
}
