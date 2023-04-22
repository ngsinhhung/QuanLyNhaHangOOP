import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuanLyThoiDiem {
    private List<ThoiDiemThue> dsThoiDiem = new ArrayList<>();

    public void themThoiDiem(ThoiDiemThue... ThoiDiem){
        this.dsThoiDiem.addAll(Arrays.asList(ThoiDiem));
    }
    public List<ThoiDiemThue> getDsThoiDiem() {
        return dsThoiDiem;
    }

    public void setDsThoiDiem(List<ThoiDiemThue> dsThoiDiem) {
        this.dsThoiDiem = dsThoiDiem;
    }
}
