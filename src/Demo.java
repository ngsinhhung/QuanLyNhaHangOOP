import java.awt.desktop.SystemSleepEvent;
import java.text.ParseException;
import java.util.*;

//them tieu de cho moi lan hienthi
public class Demo {
    public static void main(String[] args) throws ParseException {
        //thời điểm có sẵn
        var td3 = new ThoiDiemThue(CauHinh.f.parse("8/2/2023"), BuoiThue.SANG);
        var td4 = new ThoiDiemThue(CauHinh.f.parse("1/11/2022"), BuoiThue.TOI);
        var td5 = new ThoiDiemThue(CauHinh.f.parse("1/11/2011"), BuoiThue.TOI);
        var td6 = new ThoiDiemThue(CauHinh.f.parse("2/11/2011"), BuoiThue.TOI);
        var td7 = new ThoiDiemThue(CauHinh.f.parse("3/11/2011"), BuoiThue.TOI);

        //quy 4: gt1 gt2 4 * gt5
        var td1 = new ThoiDiemThue(CauHinh.f.parse("20/12/2023"), BuoiThue.CHIEU);
        var td2 = new ThoiDiemThue(CauHinh.f.parse("12/11/2023"), BuoiThue.SANG);
        var td8 = new ThoiDiemThue(CauHinh.f.parse("3/12/2023"), BuoiThue.TOI);
        var td9 = new ThoiDiemThue(CauHinh.f.parse("4/12/2023"), BuoiThue.TOI);
        var td10 = new ThoiDiemThue(CauHinh.f.parse("3/11/2023"), BuoiThue.TOI);
        var td11 = new ThoiDiemThue(CauHinh.f.parse("3/10/2023"), BuoiThue.TOI);

        //giá thuê sảnh có sẵn
        var gt1 = new GiaThueSanh(200, td1); //quy 4
        var gt2 = new GiaThueSanh(100, td2); //quy 4
        var gt3 = new GiaThueSanh(300, td3);
        var gt4 = new GiaThueSanh(500, td4);
        var gt5 = new GiaThueSanh(400, td5, td6, td7, td8, td9, td10, td11); //quy 4: 4 * gt5

        //sảnh cưới có sẵn
        SanhCuoi s1 = new SanhCuoi("Diamonds",ViTriSanh.TANG_1,50, gt1, gt2, gt5);
        SanhCuoi s2 = new SanhCuoi("Golden", ViTriSanh.TANG_1,40, gt1, gt3, gt4);
        SanhCuoi s3 = new SanhCuoi("Silver",ViTriSanh.TANG_2,30, gt2, gt4);
        SanhCuoi s4 = new SanhCuoi("Adora", ViTriSanh.TANG_2, 80, gt5);

        //thức ăn , thức uống
        DoAnUong ta0 = new ThucAn("Súp cua",50,false);
        DoAnUong ta1 = new ThucAn("Thịt luộc", 30,false);
        DoAnUong ta2 = new ThucAn("Tôm luộc", 35,false);
        DoAnUong ta3 = new ThucAn("Rau muốn xào", 30,true);
        DoAnUong ta4 = new ThucAn("Mực hấp",45,false);
        DoAnUong ta5 = new ThucAn("Lẩu gà lá é", 50,false);
        DoAnUong tu1 = new ThucUong("Pesi",10,"PesiCo");
        DoAnUong tu2 = new ThucUong("Coca-cola",10,"CoCa-cola");
        DoAnUong tu3 = new ThucUong("Sài gòn bạc", 10, "Sabeco");

        //dịch vụ
        DichVu dv1 = new DvKaraoke("KaraGold",100,30);
        DichVu dv2 = new DvThueCaSi("Thuê Ca Si", 500,"Sơn Tùng MTP", 5);
        DichVu dv3 = new DvTrangTri("Trang trí bữa tiệc",200);

        //menu có sẵn
        MenuBuoiTiec menu1 = new MenuBuoiTiec(ta0,ta1,ta2,ta4,tu1,tu2); //180
        MenuBuoiTiec menu2 = new MenuBuoiTiec(ta0,ta2,ta4,ta5,tu2,tu3); //200

        //cho thuê sảnh obj có sẵn
        var ct1 = new ChoThueSanh("abc", s1, td1, new MenuBuoiTiec[]{menu1}, dv2); //quy 4
        var ct3 = new ChoThueSanh("thoi noi", s1, td2, new MenuBuoiTiec[]{menu1}, dv2); //quy 4
        var ct4 = new ChoThueSanh("sinh nhat 1", s1, td8, new MenuBuoiTiec[]{menu1}, dv2); //quy 4
        var ct5 = new ChoThueSanh("sinh nhat 2", s1, td9, new MenuBuoiTiec[]{menu1}, dv2); //quy 4
        var ct6 = new ChoThueSanh("cuoi 1", s1, td10, new MenuBuoiTiec[]{menu1}, dv2); //quy 4
        var ct7 = new ChoThueSanh("cuoi 2", s1, td11, new MenuBuoiTiec[]{menu1}, dv2); //quy 4
        var ct2 = new ChoThueSanh("xyz", s2, td3, new MenuBuoiTiec[]{menu2}, dv3);

        var hd1 = new HoaDon(ct1);
        var hd2 = new HoaDon(ct2);
        var hd3 = new HoaDon(ct3);
        var hd4 = new HoaDon(ct4);
        var hd5 = new HoaDon(ct5);
        var hd6 = new HoaDon(ct6);
        var hd7 = new HoaDon(ct7);

        QuanLySanhCuoi qlySanhCuoi = new QuanLySanhCuoi();
        QuanLyDichVu qlyDichVu = new QuanLyDichVu();
        QuanLyAnUong qlyAnUong = new QuanLyAnUong();
        QuanLyMenu qlyMenu = new QuanLyMenu();
        QuanLyChoThue qlyChoThue = new QuanLyChoThue();
        QuanLyGiaThue qlGiaThue = new QuanLyGiaThue();
        BaoCaoDoanhThu baoCao = new BaoCaoDoanhThu();

        qlySanhCuoi.themSanh(s1,s2,s3, s4);
        qlyAnUong.themDoAnUong(ta0,ta1,ta2,ta3,ta4,ta5,tu1,tu2,tu3);
        qlyMenu.themMenu(menu1,menu2);
        qlyDichVu.themDVu(dv1,dv2,dv3);
        qlGiaThue.themGiaThue(gt1, gt2, gt3, gt4, gt5);
        qlyChoThue.themChoThue(ct1, ct2, ct3, ct4, ct5, ct6, ct7);
        baoCao.themHoaDon(hd1, hd2, hd3, hd4, hd5, hd6, hd7);

        int choose = 0;
        do{
            System.out.println("=============== CHỨC NĂNG ================");
            System.out.println("1. Quản lý thông tin sảnh cưới");
            System.out.println("2. Quản lý thông tin dịch vụ");
            System.out.println("3. Quản lý thông tin thức ăn, thức uống");
            System.out.println("4. Quản lý cho thuê sảnh");
            System.out.println("5. Quản lý menu");
            System.out.println("6. Quản lý giá thuê");
            System.out.println("7. Xuất hóa đơn");
            System.out.println("8. Báo cáo doanh thu");
            System.out.println("0. Thoát");
            System.out.println("==========================================");
            do {
                try{
                    System.out.print("\nNhập sự lựa chọn: ");
                    choose = Integer.parseInt(CauHinh.sc.nextLine());
                    break;
                }
                catch (NumberFormatException ex){
                    System.out.print("Lỗi nhập chữ");
                }
            }while (true);
            switch(choose){
                case 1:
                    int choose1;
                    do{
                        System.out.println("\n\n1. Thêm sảnh cưới");
                        System.out.println("2. Cập nhật thông tin sảnh cưới");
                        System.out.println("3. Xóa sảnh cưới");
                        System.out.println("4. Tra cứu theo tên sảnh");
                        System.out.println("5. Tra cứu theo sức chứa sảnh");
                        System.out.println("6. Tra cứu theo vị trí sảnh");
                        System.out.println("7. Hiển thị tất cả sảnh cưới");
                        System.out.println("8. Sắp xếp sảnh cưới theo tần số được thuê");
                        System.out.println("9. Hiển thị tên sảnh và tần số thuê tương ứng");
                        System.out.println("0. Thoát");
                        do {
                            try{
                                System.out.print("\nNhập sự lựa chọn: ");
                                choose1 = CauHinh.sc.nextInt();
                                break;
                            }
                            catch (NumberFormatException ex){
                                System.out.println("Lỗi nhập chữ!!!");
                            }
                        }while (true);
                        CauHinh.sc.nextLine();
                        switch(choose1) {
                            case 1: {
                                System.out.print("Nhập tên sảnh: ");
                                String ten = CauHinh.sc.nextLine();
                                do {
                                    try{
                                        System.out.print("Nhập vị trí sảnh(1/2): ");
                                        ViTriSanh tang = ViTriSanh.values()[Integer.parseInt(CauHinh.sc.nextLine())-1];
                                        System.out.print("Nhập vào sức chứa: ");
                                        int sucChua = Integer.parseInt(CauHinh.sc.nextLine());
                                        System.out.println("============== Danh sách giá thuê - thời điểm thuê của hệ thống ==============");
                                        qlGiaThue.hienThi();
                                        List<Integer> dsMaGia = new ArrayList<>();
                                        int maGia; boolean thoat = false;
                                        do {
                                            do {
                                                try {
                                                    System.out.print("\nNhập mã giá thuê của sảnh: ");
                                                    maGia = Integer.parseInt(CauHinh.sc.nextLine());
                                                    break;
                                                } catch (NumberFormatException ex) {
                                                    System.out.println("Lỗi nhập chữ");
                                                }
                                            } while (true);
                                            if (qlGiaThue.traCuuTheoMa(maGia) != null && !dsMaGia.contains(maGia)) {
                                                dsMaGia.add(maGia);
                                                do {
                                                    try {
                                                        System.out.print("Nhập thêm giá cho buổi tiệc? (0-Không / 1-Có): ");
                                                        thoat = Boolean.parseBoolean(Integer.parseInt(CauHinh.sc.nextLine()) == 0 ? "True" : "False");
                                                        break;
                                                    } catch (NumberFormatException ex) {
                                                        System.out.println("Lỗi nhập chữ");
                                                    }
                                                } while (true);
                                            }
                                            else {
                                                System.out.println("Lỗi nhập mã, kiểm tra lại");
                                            }
                                        }while(!thoat);
                                        qlySanhCuoi.themSanh(new SanhCuoi(ten, tang, sucChua, dsMaGia.stream().map(ma -> qlGiaThue.traCuuTheoMa(ma)).toList()));
                                        break;
                                    }
                                    catch (NumberFormatException ex){
                                        System.out.print("Lỗi nhập chữ");
                                    }
                                }while (true);
                                break;
                            }
                            case 2: {
                                System.out.println("============= DS sảnh cưới trong hệ thống ==========");
                                qlySanhCuoi.hienThi();
                                System.out.print("\n\nNhập mã sảnh để cập nhật: ");
                                String ma = CauHinh.sc.nextLine();
                                var sanh = qlySanhCuoi.traCuuSanhTheoMa(ma);
                                if (sanh == null) break;
                                System.out.println("Chọn thuộc tính để cập nhật: ");
                                System.out.print("1. Tên Sảnh\n2. Vị trí\n3. Sức chứa\n4. Cả 3\n");
                                System.out.print("Chọn: ");
                                int chon = Integer.parseInt(CauHinh.sc.nextLine());
                                switch (chon) {
                                    case 1:
                                        System.out.print("Tên sảnh mới: ");
                                        sanh.capNhat(CauHinh.sc.nextLine());
                                        break;
                                    case 2:
                                        do {
                                            try{
                                                System.out.print("Vị trí sảnh mới (1-2): ");
                                                sanh.capNhat(ViTriSanh.values()[Integer.parseInt(CauHinh.sc.nextLine())-1]);
                                                break;
                                            }
                                            catch (NumberFormatException ex){
                                                System.out.print("Lỗi nhập chữ");
                                            }
                                        }while (true);
                                        break;
                                    case 3:
                                        do {
                                            try{
                                                System.out.print("Sức chứa mới: ");
                                                sanh.capNhat(Integer.parseInt(CauHinh.sc.nextLine()));
                                                break;
                                            }
                                            catch (NumberFormatException ex){
                                                System.out.print("Lỗi nhập chữ");
                                            }
                                        }while (true);
                                        break;
                                    case 4:
                                        System.out.print("Tên sảnh mới: ");
                                        sanh.capNhat(CauHinh.sc.nextLine());
                                        do {
                                            try{
                                                System.out.print("Vị trí sảnh mới (1-2): ");
                                                sanh.capNhat(ViTriSanh.values()[Integer.parseInt(CauHinh.sc.nextLine())-1]);
                                                System.out.print("Sức chứa mới: ");
                                                sanh.capNhat(Integer.parseInt(CauHinh.sc.nextLine()));
                                                break;
                                            }
                                            catch (NumberFormatException ex){
                                                System.out.print("Lỗi nhập chữ");
                                            }
                                        }while (true);
                                        break;
                                    default:
                                        break;
                                }
                                break;
                            }
                            case 3: {
                                System.out.println("============= DS sảnh cưới trong hệ thống ==========");
                                qlySanhCuoi.hienThi();
                                System.out.print("\n\nNhập mã sãnh cần xóa: ");
                                qlySanhCuoi.xoaSanh(CauHinh.sc.nextLine().toUpperCase().trim());
                                break;
                            }
                            case 4: {
                                System.out.print("Nhập tên sảnh cần tra cứu: ");
                                var dsSanh = qlySanhCuoi.traCuuSanh(CauHinh.sc.nextLine());
                                if(!dsSanh.isEmpty()){
                                    System.out.printf("%-20s%-20s%-20s%-20s", "Mã sảnh", "Tên sảnh", "Vị trí", "Sức chứa");
                                    dsSanh.forEach(SanhCuoi::hienThi);
                                }
                                else{
                                    System.out.print("Không tìm thấy sảnh cần tìm");
                                }
                                break;
                            }
                            case 5: {
                                do {
                                    try{
                                        System.out.print("Nhập sức chứa sảnh cần tra cứu: ");
                                        var dsSanh = qlySanhCuoi.traCuuSanh(Integer.parseInt(CauHinh.sc.nextLine()));
                                        if(!dsSanh.isEmpty()){
                                            System.out.printf("%-20s%-20s%-20s%-20s", "Mã sảnh", "Tên sảnh", "Vị trí", "Sức chứa");
                                            dsSanh.forEach(SanhCuoi::hienThi);
                                        }
                                        else{
                                            System.out.print("Không tìm thấy sảnh cần tìm");
                                        }
                                        break;
                                    }
                                    catch (NumberFormatException ex){
                                        System.out.print("Lỗi nhập chữ");
                                    }
                                }while (true);
                                break;
                            }
                            case 6: {
                                try{
                                    do{
                                        try {
                                            System.out.print("Nhập vị trí sảnh cần tra cứu (1-2): ");
                                            var dsSanh = qlySanhCuoi.traCuuSanh(ViTriSanh.values()[Integer.parseInt(CauHinh.sc.nextLine())-1]);
                                            if(!dsSanh.isEmpty()){
                                                System.out.printf("%-20s%-20s%-20s%-20s", "Mã sảnh", "Tên sảnh", "Vị trí", "Sức chứa");
                                                dsSanh.forEach(SanhCuoi::hienThi);
                                            }
                                            else{
                                                System.out.print("Không tìm thấy sảnh cần tìm");
                                            }
                                            break;
                                        }catch (NumberFormatException ex){
                                            System.out.print("Lỗi nhập chữ");
                                        }
                                    }while (true);
                                }
                                catch (ArrayIndexOutOfBoundsException ex){
                                    System.out.print("Không tìm thấy sảnh cần tìm");
                                }

                                break;
                            }
                            case 7:
                                System.out.println("============= DS sảnh cưới trong hệ thống ==========");
                                qlySanhCuoi.hienThi();
                                break;
                            case 8:
                                qlySanhCuoi.setQuanLyChoThue(qlyChoThue);
                                qlySanhCuoi.sapXepTheoTanSoThue();
                                break;
                            case 9:
                                System.out.printf("%-40s%-20s","Danh sách tên sảnh","Tần số thuê");
                                qlySanhCuoi.hienThiTheoTanSo();
                                break;
                            case 0:
                                choose1 = 0;
                                break;
                            default:
                                System.out.println("Không có lựa chọn này!");
                                break;
                        }
                    }while(choose1 != 0);
                    break;
                case 2:
                    int choose2 = 0;
                    do{
                        System.out.println("\n\n1. Thêm dịch vụ");
                        System.out.println("2. Cập nhật dịch vụ");
                        System.out.println("3. Xóa dịch vụ");
                        System.out.println("4. Tra cứu theo tên dịch vụ");
                        System.out.println("5. Hiển thị tất cả dịch vụ");
                        System.out.println("0. Thoát");
                        do {
                            try{
                                System.out.print("\nNhập sự lựa chọn: ");
                                choose2 = Integer.parseInt(CauHinh.sc.nextLine());
                                break;
                            }
                            catch (NumberFormatException ex){
                                System.out.print("Lỗi nhập chữ");
                            }
                        }while (true);
                        switch(choose2) {
                            case 1: {
                                int option;
                                boolean flagExit = false;
                                do {
                                    System.out.println("\n\n=========== THÊM DỊCH VỤ MỚI ===========");
                                    System.out.print("Nhập tên dịch vụ: ");
                                    String ten = CauHinh.sc.nextLine();
                                    double gia = 0;
                                    do{
                                        try{
                                            System.out.print("Nhập giá dịch vụ: ");
                                            gia = Double.parseDouble(CauHinh.sc.nextLine());
                                            break;
                                        }
                                        catch (NumberFormatException ex){
                                            System.out.println("Lỗi nhập chữ");
                                        }
                                    }while (true);
                                    System.out.println("\nChọn loại dịch vụ: ");
                                    System.out.println("1. Dịch vụ Karaoke\n2. Dịch vụ thuê ca sĩ\n3. Dịch vụ trang trí");
                                    System.out.print("Chọn: ");
                                    option = Integer.parseInt(CauHinh.sc.nextLine());
                                    DichVu dv;
                                    switch (option) {
                                        case 1: {
                                            try{
                                                System.out.print("Thời gian thuê (phút): ");
                                                double tg = Double.parseDouble(CauHinh.sc.nextLine());
                                                dv = new DvKaraoke(ten, gia, tg);
                                                qlyDichVu.themDVu(dv);
                                            }
                                            catch(NumberFormatException ex){
                                                System.out.println("Lỗi nhập chữ");
                                            }
                                            break;
                                        }
                                        case 2: {
                                            System.out.print("Tên ca sĩ: ");
                                            String name = CauHinh.sc.nextLine();
                                            try{
                                                System.out.print("Số bài hát: ");
                                                int soBH = Integer.parseInt(CauHinh.sc.nextLine());
                                                dv = new DvThueCaSi(ten, gia, name, soBH);
                                                qlyDichVu.themDVu(dv);
                                            }
                                            catch (NumberFormatException ex){
                                                System.out.println("Lỗi nhập chữ");
                                            }
                                            break;
                                        }
                                        case 3: {
                                            dv = new DvTrangTri(ten, gia);
                                            qlyDichVu.themDVu(dv);

                                            break;
                                        }
                                        case 0: {
                                            option = 0;
                                            break;
                                        }
                                        default:
                                            System.out.println("Không có lựa chọn này!");
                                            break;
                                    }
                                    System.out.print("Bạn có muốn thoát (0:Không - 1:Có):");
                                    flagExit = Boolean.parseBoolean((Integer.parseInt(CauHinh.sc.nextLine())) == 0 ? "False" : "True");
                                } while (!flagExit);
                                break;
                            }
                            case 2: {
                                System.out.println("============= DS dịch vụ trong hệ thống ============");
                                CauHinh.hienTieuDeDichVu();
                                qlyDichVu.hienThi();
                                System.out.print("\n\nNhập mã dịch vụ để cập nhật: ");
                                String ma = CauHinh.sc.nextLine();
                                DichVu dv = qlyDichVu.traCuuTheoMa(ma);
                                if(dv != null){dv.capNhat();}
                                break;
                            }
                            case 3: {
                                System.out.println("============= DS dịch vụ trong hệ thống ============");
                                CauHinh.hienTieuDeDichVu();
                                qlyDichVu.hienThi();
                                System.out.print("\n\nNhập mã dịch vụ cần xoá: ");
                                qlyDichVu.xoaDVu(CauHinh.sc.nextLine());
                                break;
                            }
                            case 4: {
                                System.out.print("Nhập tên dịch vụ cần tra cứu: ");
                                var dsSanh = qlyDichVu.traCuuDichVu(CauHinh.sc.nextLine());
                                if(!dsSanh.isEmpty()){
                                    CauHinh.hienTieuDeDichVu();
                                    dsSanh.forEach(DichVu::hienThi);
                                }
                                else{
                                    System.out.println("Không tìm thấy ");
                                }
                                break;
                            }
                            case 5: {
                                System.out.println("============= DS dịch vụ trong hệ thống ============");
                                CauHinh.hienTieuDeDichVu();
                                qlyDichVu.hienThi();
                                break;
                            }
                            case 0:
                                choose2 = 0;
                                break;
                            default:
                                System.out.println("Không có lựa chọn này!");
                                break;
                        }
                    }while(choose2 != 0);
                    break;
                case 3:
                    int choose3;
                    do{
                        System.out.println("\n\n1. Thêm đồ ăn uống");
                        System.out.println("2. Cập nhật đồ ăn uống");
                        System.out.println("3. Xóa đồ ăn uống");
                        System.out.println("4. Tra cứu đồ ăn uống");
                        System.out.println("5. Hiển thị tất cả đồ ăn uống");
                        System.out.println("0. Thoát");
                        System.out.print("\nNhập sự lựa chọn: ");
                        choose3 = Integer.parseInt(CauHinh.sc.nextLine());
                        switch(choose3) {
                            case 1: {
                                int option;
                                boolean nhapTiep;
                                do {
                                    System.out.print("Nhập tên đồ ăn uống: ");
                                    //CauHinh.sc.nextLine();
                                    String ten = CauHinh.sc.nextLine();
                                    double gia = 0;
                                    do {
                                        try {
                                            System.out.print("Nhập giá đồ ăn uống: ");
                                            gia = Double.parseDouble(CauHinh.sc.nextLine());
                                            break;
                                        }catch(NumberFormatException ex){
                                            System.out.println("Lỗi nhập chữ");
                                        }
                                    }while(true);
                                    do {
                                        System.out.println("Chọn loại đồ ăn uống: ");
                                        System.out.print("1. Thức ăn\n2. Thức uống\n");
                                        do {
                                            try {
                                                System.out.print("Chọn: ");
                                                option = Integer.parseInt(CauHinh.sc.nextLine());
                                                break;
                                            } catch (NumberFormatException ex) {
                                                System.out.print("Lỗi nhập chữ");
                                            }
                                        } while (true);
                                        DoAnUong doAnUong;
                                        switch (option) {
                                            case 1: {
                                                boolean isAnChay;
                                                do{
                                                    try {
                                                        System.out.print("Ăn chay được không? (0-Không / 1-Có): ");
                                                        isAnChay = Boolean.parseBoolean((Integer.parseInt(CauHinh.sc.nextLine())) == 0 ? "False" : "True");
                                                        break;
                                                    }catch (NumberFormatException ex){
                                                        System.out.print("Lỗi nhập chữ\n");
                                                    }
                                                }while (true);
                                                doAnUong = new ThucAn(ten, gia, isAnChay);
                                                qlyAnUong.themDoAnUong(doAnUong);
                                                break;
                                            }
                                            case 2: {
                                                System.out.print("Hãng sản xuất: ");
                                                String name = CauHinh.sc.nextLine();
                                                doAnUong = new ThucUong(ten, gia, name);
                                                qlyAnUong.themDoAnUong(doAnUong);
                                                break;
                                            }
                                            default:
                                                System.out.println("Không có lựa chọn này!");
                                                break;
                                        }
                                    }while(option < 1 || option > 2);
                                    do{
                                        try {
                                            System.out.print("Bạn muốn nhập tiếp đồ ăn uống mới không (0-Không / 1-Có): ");
                                            nhapTiep = Boolean.parseBoolean((Integer.parseInt(CauHinh.sc.nextLine()) == 0) ? "False" : "True");
                                            break;
                                        }catch (NumberFormatException ex){
                                            System.out.print("Lỗi nhập chữ\n");
                                        }
                                    }while (true);
                                } while(nhapTiep);
                                break;
                            }
                            case 2: {
                                System.out.println("============= DS món ăn (uống) trong hệ thống ============");
                                qlyAnUong.hienThi();
                                int ma;
                                do{
                                    try{
                                        System.out.print("\n\nNhập mã đồ ăn (uống) để cập nhật: ");
                                        ma = Integer.parseInt(CauHinh.sc.nextLine());
                                        break;
                                    }
                                    catch (NumberFormatException ex){
                                        System.out.println("Lỗi nhập chữ\n");
                                    }
                                }while(true);
                                DoAnUong dau = qlyAnUong.traCuuAnUong(ma);
                                if(dau != null){dau.capNhat();}
                                break;
                            }
                            case 3: {
                                System.out.println("============= DS món ăn (uống) trong hệ thống ============");
                                qlyAnUong.hienThi();
                                do{
                                    try {
                                        System.out.print("\n\nNhập mã đồ ăn (uống) cần xoá: ");
                                        qlyAnUong.xoaDoAnUong(Integer.parseInt( CauHinh.sc.nextLine()));
                                        break;
                                    }
                                    catch(NumberFormatException ex){
                                        System.out.print("Lỗi nhâp chữ");
                                    }
                                }while(true);
                                break;
                            }
                            case 4: {
                                System.out.print("Nhập tên đồ ăn (uống) cần tra cứu: ");
                                var dsDAU = qlyAnUong.traCuuAnUong(CauHinh.sc.nextLine());
                                if(!dsDAU.isEmpty()){
                                    System.out.printf("%-20s%-20s%-20s", "Mã đồ ăn (uống): ", "Tên đồ ăn (uống): ", "Giá đồ ăn (uống): ");
                                    dsDAU.forEach(DoAnUong::hienThi);
                                }
                                else{
                                    System.out.println("Không tìm thấy");
                                }
                                break;
                            }
                            case 5: {
                                System.out.println("============= DS món ăn (uống) trong hệ thống ============");
                                qlyAnUong.hienThi();
                                break;
                            }
                            case 0:
                                choose3 = 0;
                                break;
                            default:
                                System.out.println("Không có lựa chọn này!");
                                break;
                        }
                    }while(choose3 != 0);
                    break;
                case 4:
                    int choose4;
                    do{
                        System.out.println("\n\n1. Cho thuê sảnh");
                        System.out.println("2. Hiển thị danh sách cho thuê");
                        System.out.println("0. Thoát");
                        do{
                            try{
                                System.out.print("\nNhập sự lựa chọn: ");
                                choose4 = Integer.parseInt(CauHinh.sc.nextLine());
                                break;
                            }
                            catch (NumberFormatException ex){
                                System.out.println("Lỗi nhập chữ");
                            }
                        }while(true);
                        switch(choose4) {
                            case 1: {
                                Boolean thoat = false;
                                do {
                                    System.out.println("================= Nhập thông tin cho thuê =================");
                                    System.out.print("Nhập tên bữa tiệc: ");
                                    String tenTiec = CauHinh.sc.nextLine();
                                    System.out.println("================ DS Sảnh trong hệ thống ================");
                                    qlySanhCuoi.hienThi();
                                    SanhCuoi sanh;
                                    do {
                                        System.out.print("\nNhập mã sảnh cần thuê: ");
                                        sanh = qlySanhCuoi.traCuuSanhTheoMa(CauHinh.sc.nextLine().toUpperCase().trim());
                                    }while(sanh == null);

                                    System.out.println("================ DS giá thuê của sảnh cần thuê ================");
                                    sanh.hienThiDSGiaThue();
                                    Date ngayThue;
                                    BuoiThue buoi;
                                    System.out.print("Giá thuê đi với thời điểm cần thuê có xuất hiện không? (0-Không 1-Có): ");
                                    if (Boolean.parseBoolean(Integer.parseInt(CauHinh.sc.nextLine()) == 0 ? "True" : "False")) {
                                        System.out.println("Nhập thêm giá thuê đi với thời điểm cần thuê!!!");
                                        break;
                                    }
                                    else {
                                        do {
                                            try {
                                                System.out.print("\nNhập buổi thuê (1-Sáng, 2-Chiều, 3-Tối): ");
                                                buoi = BuoiThue.values()[Integer.parseInt(CauHinh.sc.nextLine()) - 1];
                                                break;
                                            } catch (NumberFormatException ex) {
                                                System.out.println("Lỗi nhập chữ");
                                            } catch (ArrayIndexOutOfBoundsException ex) {
                                                System.out.println("Không có thời điểm này");
                                            }
                                        } while (true);
                                        do {
                                            try {
                                                System.out.print("\nNhập ngày thuê (dd/MM/yyyy): ");
                                                ngayThue = CauHinh.f.parse(CauHinh.sc.nextLine());
                                                break;
                                            } catch (ParseException ex) {
                                                System.out.println("Lỗi nhập chữ");
                                            }
                                        } while (true);
                                    }
                                    ThoiDiemThue thoiDiem = new ThoiDiemThue(ngayThue , buoi);
                                    System.out.println("============= DS menu trong hệ thống ============");
                                    qlyMenu.hienThi();
                                    List<Integer> maMenu = new ArrayList<>(); // để nhận nhiều menu
                                    Boolean thoatTrong = false;
                                    int tempMa;
                                    do {
                                        do{
                                            try{
                                                System.out.print("Nhập mã menu cần đặt chỉ nhập số: ");
                                                tempMa = Integer.parseInt(CauHinh.sc.nextLine());
                                                break;
                                            }catch(NumberFormatException ex){
                                                System.out.println("Lỗi nhập");
                                            }
                                        }while(true);
                                        var menu = qlyMenu.traCuuMenu(tempMa);
                                        if (menu != null && !maMenu.contains(tempMa)) { //nếu mã menu không tìm thấy trong danh sách menu đã chọn và có ds menu hệ thống
                                            maMenu.add(tempMa);
                                            do {
                                                try {
                                                    System.out.print("Đặt thêm menu cho buổi tiệc? (0-Không / 1-Có): ");
                                                    thoatTrong = Boolean.parseBoolean(Integer.parseInt(CauHinh.sc.nextLine()) == 0 ? "True" : "False");
                                                    break;
                                                } catch (NumberFormatException ex) {
                                                    System.out.println("Lỗi nhập chữ");
                                                }
                                            }while(true);
                                        }
                                        else {
                                            System.out.println("Lỗi! Vui lòng kiểm tra lại");
                                            thoatTrong = false;
                                        }
                                    } while (!thoatTrong);
                                    var dsMenu = maMenu.stream().map(qlyMenu::traCuuMenu).toList();
                                    System.out.println("============= DS dịch vụ trong hệ thống ============");
                                    CauHinh.hienTieuDeDichVu();
                                    qlyDichVu.hienThi();
                                    List<String> maDv = new ArrayList<>();
                                    do {
                                        System.out.print("Nhập mã dịch vụ cần đặt: ");
                                        var tempMaDv = CauHinh.sc.nextLine();
                                        var dv = qlyDichVu.traCuuTheoMa(tempMaDv);
                                        if (dv != null && !maDv.contains(tempMaDv)) {
                                            maDv.add(tempMaDv);
                                            do {
                                                try {
                                                    System.out.print("Đặt thêm dịch vụ cho buổi tiệc? (0-Không / 1-Có): ");
                                                    thoatTrong = Boolean.parseBoolean(Integer.parseInt(CauHinh.sc.nextLine()) == 0 ? "True" : "False");
                                                    break;
                                                } catch (NumberFormatException ex) {
                                                    System.out.println("Lỗi nhập chữ");
                                                }
                                            }while(true);
                                        }
                                        else {
                                            System.out.println("Lỗi!!!");
                                            thoatTrong = false;

                                        }
                                    } while (!thoatTrong);
                                    var dsDV = maDv.stream().map(qlyDichVu::traCuuTheoMa).toList();
                                    var tiecMoi = new ChoThueSanh(tenTiec, sanh, thoiDiem,dsMenu, dsDV);
                                    qlyChoThue.themChoThue(tiecMoi);
                                    HoaDon hd = new HoaDon(tiecMoi);
                                    baoCao.themHoaDon(hd);
                                    do{
                                        try{
                                            System.out.print("Nhập tiếp việc cho thuê? (0-Không / 1-Có): ");
                                            thoat = Boolean.parseBoolean(Integer.parseInt(CauHinh.sc.nextLine()) == 0 ? "True" : "False");
                                            break;
                                        }
                                        catch(NumberFormatException ex){
                                            System.out.println("Lỗi nhập chữ");
                                        }
                                    }while(true);
                                } while (!thoat);
                                break;
                            }
                            case 2: {
                                System.out.println("============= DS các bữa tiệc trong hệ thống ============");
                                qlyChoThue.hienThi();
                                break;
                            }
                            case 0:
                                choose4 = 0;
                                break;
                            default:
                                System.out.println("Không có lựa chọn này!");
                                break;
                        }
                    }while(choose4 != 0);
                    break;
                case 5: {
                    // thiếu chức năng hiển thị menu, sửa menu, xóa menu
                    int chon;
                    do {
                        System.out.println("1. Thêm menu mới");
                        System.out.println("2. Sửa menu");
                        System.out.println("3. Xóa menu");
                        System.out.println("4. Hiển thị danh sách menu");
                        System.out.println("0. Thoát");
                        do {
                            try {
                                System.out.print("Chọn: ");
                                chon = Integer.parseInt(CauHinh.sc.nextLine());
                                break;
                            } catch (NumberFormatException ex) {
                                System.out.println("Lỗi nhập chữ");
                            }
                        } while (true);
                        switch (chon) {
                            case 1: {
                                boolean thoat = false;
                                do {
                                    System.out.println("=========== Nhập menu mới ===========");
                                    boolean thoatTrong = false;
                                    List<Integer> dsMaAnUong = new ArrayList<>();
                                    System.out.println("============= DS món ăn (uống) trong hệ thống ============");
                                    qlyAnUong.hienThi();
                                    do {
                                        do {
                                            try {
                                                System.out.print("Nhập mã đồ ăn (uống) trong menu: ");
                                                dsMaAnUong.add(Integer.parseInt(CauHinh.sc.nextLine()));
                                                break;
                                            } catch (NumberFormatException ex) {
                                                System.out.print("\nLỗi nhập chữ");
                                            }
                                        } while (true);
                                        do {
                                            try {
                                                System.out.print("Nhập tiếp đồ ăn uống? (0-Không / 1-Có): ");
                                                thoatTrong = Boolean.parseBoolean(Integer.parseInt(CauHinh.sc.nextLine()) == 0 ? "True" : "False");
                                                break;
                                            } catch (NumberFormatException ex) {
                                                System.out.print("\nLỗi nhập chữ");
                                            }
                                        } while (true);
                                    } while (!thoatTrong);
                                    MenuBuoiTiec menu = new MenuBuoiTiec(dsMaAnUong.stream().map(ma -> qlyAnUong.traCuuAnUong(ma)).toList());
                                    qlyMenu.themMenu(menu);
                                    do {
                                        try {
                                            System.out.print("Nhập tiếp menu mới (0-Không / 1-Có): ");
                                            thoat = Boolean.parseBoolean(Integer.parseInt(CauHinh.sc.nextLine()) == 0 ? "True" : "False");
                                            break;
                                        } catch (NumberFormatException ex) {
                                            System.out.println("Lỗi nhập chữ");
                                        }
                                    } while (true);
                                } while (!thoat);
                                break;
                            }
                            case 2: {
                                System.out.println("============ Các memnu trong hệ thống ============");
                                qlyMenu.hienThi();
                                System.out.print("Nhập mã menu cần sửa: ");
                                int maMenuSua = Integer.parseInt(CauHinh.sc.nextLine());
                                var menuSua = qlyMenu.traCuuMenu(maMenuSua);
                                do {
                                    System.out.println("1. Xóa đồ an uống");
                                    System.out.println("2. Thêm đồ ăn uống");
                                    System.out.println("0. Thoát");
                                    System.out.print("Chọn: ");
                                    chon = Integer.parseInt(CauHinh.sc.nextLine());
                                    int maSua;
                                    switch (chon) {
                                        case 1: {
                                            System.out.println("============ Menu cần sửa ============");
                                            menuSua.hienThi();
                                            System.out.print("Nhập mã đồ ăn uống để xóa: ");
                                            maSua = Integer.parseInt(CauHinh.sc.nextLine());
                                            menuSua.xoaDoAnUong(maSua);
                                            break;
                                        }
                                        case 2: {
                                            System.out.println("============ Menu cần sửa ============");
                                            menuSua.hienThi();
                                            System.out.println("=========== Danh sách đồ ăn uống trong hệ thống ===========");
                                            qlyAnUong.hienThi();
                                            System.out.print("Nhập mã đồ ăn uống để thêm: ");
                                            maSua = Integer.parseInt(CauHinh.sc.nextLine());
                                            var dau = qlyAnUong.traCuuAnUong(maSua);
                                            menuSua.themDoAnUong(dau);
                                            break;
                                        }
                                        default:
                                            System.out.println("Không có lựa chọn này!");
                                            break;
                                    }
                                    break;
                                } while (chon != 0);
                                break;
                            }
                            case 3: {
                                System.out.println("============ Các menu trong hệ thống ============");
                                qlyMenu.hienThi();
                                System.out.print("Nhập mã menu cần xóa: ");
                                int maMenuXoa = Integer.parseInt(CauHinh.sc.nextLine());
                                qlyMenu.xoaMenu(maMenuXoa);
                                break;
                            }
                            case 4: {
                                System.out.println("============ Các menu trong hệ thống ============");
                                qlyMenu.hienThi();
                                break;
                            }
                            case 0: {
                                break;
                            }
                            default:
                                System.out.println("Không có lựa chọn này!");
                                break;
                        }
                    }while (chon != 0);
                    break;
                }
                case 6: {
                    int chon;
                    do {
                        System.out.println("1. Thêm giá thuê");
                        System.out.println("2. Hiển thị");
                        System.out.println("0. Thoát");
                        System.out.print("Chọn: ");
                        chon = Integer.parseInt(CauHinh.sc.nextLine());
                        switch (chon) {
                            case 1: {
                                System.out.print("Nhập giá: ");
                                double giaMoi = Double.parseDouble(CauHinh.sc.nextLine());
                                Boolean thoat = false;
                                List<ThoiDiemThue> dsThoiDiemMoi = new ArrayList<>();
                                do {
                                    System.out.print("Nhập ngày thuê: ");
                                    var ngayThueMoi = CauHinh.f.parse(CauHinh.sc.nextLine());
                                    System.out.print("Nhập buổi thuê (1-Sáng, 2-Chiều, 3-Tối): ");
                                    var buoiMoi = BuoiThue.values()[Integer.parseInt(CauHinh.sc.nextLine()) - 1];
                                    dsThoiDiemMoi.add(new ThoiDiemThue(ngayThueMoi, buoiMoi));
                                    System.out.print("Nhập tiếp thời điểm cho giá này? (0-Không 1-Có): ");
                                    thoat = Boolean.parseBoolean(Integer.parseInt(CauHinh.sc.nextLine()) == 0 ? "True" : "False");
                                }while (!thoat);
                                qlGiaThue.themGiaThue(new GiaThueSanh(giaMoi, dsThoiDiemMoi));
                                break;
                            }
                            case 2: {
                                System.out.println("============= DS giá thuê - thời điểm thuê trong hệ thống ============");
                                qlGiaThue.hienThi();
                                break;
                            }
                            case 0:
                                break;
                            default:
                                System.out.println("Không có lựa chọn này!!!");
                                break;
                        }
                    }while (chon != 0);
                    break;
                }
                case 7: {
                    System.out.println("============= DS bữa tiệc trong hệ thống ============");
                    qlyChoThue.hienThi();
                    System.out.print("\nNhập mã buổi tiệc cần xuất hóa đơn: ");
                    String id = CauHinh.sc.nextLine();
                    baoCao.getDsHoaDon().stream().filter(hoaDon -> hoaDon.getBuaTiec().getMaBuoiTiec().equals(id)).findFirst().get().xuatHoaDon();
                    break;
                }
                case 8: {
                    int choose7;
                    do {
                        System.out.println("Kiểm tra doanh thu theo: ");
                        System.out.println("1. Theo tháng.");
                        System.out.println("2. Theo quý.");
                        System.out.println("0. Thoát");
                        System.out.print("\nChọn: ");
                        choose7 = Integer.parseInt(CauHinh.sc.nextLine());
                        switch (choose7){
                            case 1:
                            {
                                int month, year;
                                System.out.print("Nhập vào tháng: ");
                                do{
                                    month = Integer.parseInt(CauHinh.sc.nextLine());
                                    if(month < 1 || month > 12)
                                        System.out.println("Lỗi! Vui lòng nhập lại");
                                }while(month < 1 || month > 12);
                                System.out.print("Nhập vào năm: ");
                                year = Integer.parseInt(CauHinh.sc.nextLine());
                                System.out.printf("\nDoanh thu theo tháng: %20.2f\n",baoCao.theoThang(month,year));
                                break;
                            }
                            case 2:
                            {
                                int quater, year;
                                System.out.print("Nhập vào quý: ");
                                do{
                                    quater = Integer.parseInt(CauHinh.sc.nextLine());
                                    if(quater < 1 || quater > 12)
                                        System.out.print("Lỗi! Vui lòng nhập lại\n");
                                }while(quater < 1 || quater > 12);
                                System.out.print("Nhập vào năm: ");
                                year = Integer.parseInt(CauHinh.sc.nextLine());
                                System.out.printf("\nDoah thu theo quý: %20.2f\n",baoCao.theoQuy(quater,year));
                                break;
                            }
                            case 0:
                                break;
                            default:
                                System.out.print("Lỗi.Vui lòng chọn lại!!!\n");
                                break;
                        }
                    }while(choose7 != 0);
                    break;
                }
                case 0:
                    break;
                default:
                    System.out.print("Lỗi.Vui lòng chọn lại!!!\n");
                    break;
            }
        }while(choose != 0);
    }
}