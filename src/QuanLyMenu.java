import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class QuanLyMenu {
    private List<MenuBuoiTiec> dsMenu = new ArrayList<>();

    public void hienThi() {
        dsMenu.forEach(MenuBuoiTiec::hienThi);
    }

    public void themMenu(MenuBuoiTiec... menu)  {
        dsMenu.addAll(Arrays.asList(menu));
    }

    public MenuBuoiTiec traCuuMenu(int ma) {
        try{
            return dsMenu.stream().filter(menu -> menu.getMaMenu() == ma).findFirst().get();
        }
        catch (NoSuchElementException ex){
            System.out.print("Lỗi không tìm thấy menu !!!");
        }
        return null;
    }

    public void xoaMenu(int ma) {
        dsMenu.removeIf(menu -> menu.getMaMenu() == ma);
    }
}
