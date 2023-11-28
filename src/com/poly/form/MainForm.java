package com.poly.form;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.util.UIScale;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.poly.Application;
import com.poly.entity.Login;
import com.poly.form.doihang.FormQuanLyDoiHang;
import com.poly.form.doihang.FormQuanLyDoiHangItem1;
import com.poly.form.doihang.FormQuanLyDoiHangItem2;
import com.poly.form.other.FormDashboard;
import com.poly.form.giaohang.FormQuanLyGiaoHang;
import com.poly.form.giaohang.FormQuanLyGiaoHangItem1;
import com.poly.form.giaohang.FormQuanLyGiaoHangItem2;
import com.poly.form.khachhang.FormQuanLyKhachHang;
import com.poly.form.khuyenmai.FormQuanLyKhuyenMai;
import com.poly.form.hoadon.FormQuanLyHoaDon;
import com.poly.form.hoadon.FormQuanLyHoaDonItem1;
import com.poly.form.hoadon.FormQuanLyHoaDonItem2;
import com.poly.form.khuyenmai.FormQuanLyKhuyenMaiItem1;
import com.poly.form.khuyenmai.FormQuanLyKhuyenMaiItem2;
import com.poly.form.nhanvien.FormQuanLyNhanViens;
import com.poly.form.sanpham.FormQuanLySanPham;
import com.poly.form.sanpham.FormSanPhamItem1;
import com.poly.form.sanpham.FormSanPhamItem2;
import com.poly.menu.Menu;
import com.poly.menu.MenuAction;
import com.poly.repository.NhanVienRepo;
import raven.toast.Notifications;

public class MainForm extends JLayeredPane {

    Login login = new Login();
    NhanVienRepo service = new NhanVienRepo();
    LoginForm loginForm = new LoginForm();
    private Login loggedInUser;

    public MainForm() {
        //login = new Login("Admin", "Admin", "Admin");
//        login = new Login("Nhanvien", "manhn");
        String username = login.getUsername();
        String password = login.getPassword();
        init();
    }

    public void setLoggedInUser(Login loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    //end
    public void init() {
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(new MainFormLayout());
        menu = new Menu();
        panelBody = new JPanel(new BorderLayout());
        initMenuArrowIcon();
        menuButton.putClientProperty(FlatClientProperties.STYLE, ""
                + "background:$Menu.button.background;"
                + "arc:999;"
                + "focusWidth:0;"
                + "borderWidth:0");
        menuButton.addActionListener((ActionEvent e) -> {
            setMenuFull(!menu.isMenuFull());
        });
//      System.out.println("role");
        initMenuEvent();
        setLayer(menuButton, JLayeredPane.POPUP_LAYER);
        add(menuButton);
        add(menu);
        add(panelBody);
    }

    @Override
    public void applyComponentOrientation(ComponentOrientation o) {
        super.applyComponentOrientation(o);
        initMenuArrowIcon();
    }

    private void initMenuArrowIcon() {
        if (menuButton == null) {
            menuButton = new JButton();
        }
        String icon = (getComponentOrientation().isLeftToRight()) ? "menu_left.svg" : "menu_right.svg";
        menuButton.setIcon(new FlatSVGIcon("raven/icon/svg/" + icon, 0.8f));
    }

    // Trong JPanel của bạn
    private void handleAdminMenu(int index, int subIndex, MenuAction action) {
        if (index == 0) {
            Application.showForm(new FormDashboard());
        } else if (index == 1) { // tương ứng với menu (Quản lý sản phẩm)
            if (subIndex == 1) { // tương ứng với menu item của (Quản lý sản phẩm)
                Application.showForm(new FormQuanLySanPham());
            } else if (subIndex == 2) {
                Application.showForm(new FormSanPhamItem1());
            } else if (subIndex == 3) {
                Application.showForm(new FormSanPhamItem2());
            } else {
                action.cancel();
            }
        } else if (index == 2) {
            if (subIndex == 1) {
                Application.showForm(new FormQuanLyHoaDon());
            } else if (subIndex == 2) {
                Application.showForm(new FormQuanLyHoaDonItem1());
            } else if (subIndex == 3) {
                Application.showForm(new FormQuanLyHoaDonItem2());
            }
        } else if (index == 3) {
            if (subIndex == 1) {
                Application.showForm(new FormQuanLyDoiHang());
            } else if (subIndex == 2) {
                Application.showForm(new FormQuanLyDoiHangItem1());
            } else if (subIndex == 3) {
                Application.showForm(new FormQuanLyDoiHangItem2());
            }
        } else if (index == 4) {
            if (subIndex == 1) {
                Application.showForm(new FormQuanLyNhanViens());
            } else if (subIndex == 2) {
                Application.showForm(new FormQuanLyKhachHang());
            } else if (subIndex == 3) {
                Application.showForm(new FormQuanLyNhanViens());
            }
        } else if (index == 5) {
            if (subIndex == 1) {
                Application.showForm(new FormQuanLyKhachHang());
            } else if (subIndex == 2) {
                Application.showForm(new FormQuanLyKhachHang());
            } else if (subIndex == 3) {
                Application.showForm(new FormQuanLyKhachHang());
            }
        } else if (index == 6) {
            if (subIndex == 1) {
                Application.showForm(new FormQuanLyKhuyenMai());
            } else if (subIndex == 2) {
                Application.showForm(new FormQuanLyKhuyenMaiItem1());
            } else if (subIndex == 3) {
                Application.showForm(new FormQuanLyKhuyenMaiItem2());
            }
        } else if (index == 7) {
            if (subIndex == 1) {
                Application.showForm(new FormQuanLyGiaoHang());
            } else if (subIndex == 2) {
                Application.showForm(new FormQuanLyGiaoHangItem1());
            } else if (subIndex == 3) {
                Application.showForm(new FormQuanLyGiaoHangItem2());
            }
        } else if (index == 8) {
            Application.logout();
        } else {
            action.cancel();
        }
        // Thêm các menu và form khác nếu cần
    }

    private void handleNhanvienMenu(int index, int subIndex, MenuAction action) {
        // Logic cho quyền Nhân viên
        if (index == 0) {
            Application.showForm(new FormDashboard());
        } else if (index == 1) { // tương ứng với menu (Quản lý sản phẩm)
            if (subIndex == 1) { // tương ứng với menu item của (Quản lý sản phẩm)
                Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "Không Có Quyền Truy Cập");
            } else if (subIndex == 2) {
                Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "Không Có Quyền Truy Cập");
            } else if (subIndex == 3) {
                Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "Không Có Quyền Truy Cập");
            } else {
                action.cancel();
            }
        } else if (index == 2) {
            if (subIndex == 1) {
                Application.showForm(new FormQuanLyHoaDon());
            } else if (subIndex == 2) {
                Application.showForm(new FormQuanLyHoaDonItem1());
            } else if (subIndex == 3) {
                Application.showForm(new FormQuanLyHoaDonItem2());
            }
        } else if (index == 3) {
            if (subIndex == 1) {
                Application.showForm(new FormQuanLyDoiHang());
            } else if (subIndex == 2) {
                Application.showForm(new FormQuanLyDoiHangItem1());
            } else if (subIndex == 3) {
                Application.showForm(new FormQuanLyDoiHangItem2());
            }
        } else if (index == 4) {
            if (subIndex == 1) {
                Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "Không Có Quyền Truy Cập");
            } else if (subIndex == 2) {
                Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "Không Có Quyền Truy Cập");
            } else if (subIndex == 3) {
                Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "Không Có Quyền Truy Cập");
            }
        } else if (index == 5) {
            if (subIndex == 1) {
                Application.showForm(new FormQuanLyKhachHang());
            } else if (subIndex == 2) {
                Application.showForm(new FormQuanLyKhachHang());
            } else if (subIndex == 3) {
                Application.showForm(new FormQuanLyKhachHang());
            }
        } else if (index == 6) {
            if (subIndex == 1) {
                Application.showForm(new FormQuanLyKhuyenMai());
            } else if (subIndex == 2) {
                Application.showForm(new FormQuanLyKhuyenMaiItem1());
            } else if (subIndex == 3) {
                Application.showForm(new FormQuanLyKhuyenMaiItem2());
            }
        } else if (index == 7) {
            if (subIndex == 1) {
                Application.showForm(new FormQuanLyGiaoHang());
            } else if (subIndex == 2) {
                Application.showForm(new FormQuanLyGiaoHangItem1());
            } else if (subIndex == 3) {
                Application.showForm(new FormQuanLyGiaoHangItem2());
            }
        } else if (index == 8) {
            System.out.println("aaaaaaaaaaaaa");
            Application.logout();
        } else if (index == 9) {
            Application.logout();
        } else {
            action.cancel();
        }
    }

// Gọi trong phương thức initMenuEvent của JPanel
    private void initMenuEvent() {
        System.out.println("role init");
        //System.out.println(service.getUserRole(login.getUsername(), login.getPassword()));
        menu.addMenuEvent((int index, int subIndex, MenuAction action) -> {
//            List<Login> userLogins = service.getAllLogins();
            if (loggedInUser != null) {
                String role = loggedInUser.getRole();
                System.out.println("danh sách role: " + role);
                if (role.equalsIgnoreCase("Admin")) {
                    handleAdminMenu(index, subIndex, action);
                } else if (role.equalsIgnoreCase("Nhanvien")) {
                    handleNhanvienMenu(index, subIndex, action);
                } else {
                    action.cancel();
                }
            } else {
                System.out.println("Lỗi");
                action.cancel();

            }
        });
    }

    //Xác định hành động khi menu được kích hoạt
//    private void initMenuEvent() {
//        menu.addMenuEvent((int index, int subIndex, MenuAction action) -> {
//            String user = login.getUsername();
//                if (index == 0) {
//                    Application.showForm(new FormDashboard());
//                } else if (index == 1) { // tương ứng với menu (Quản lý sản phẩm)
//                    if (subIndex == 1) { // tương ứng với menu item của (Quản lý sản phẩm)
//                        Application.showForm(new FormQuanLySanPham());
//                    } else if (subIndex == 2) {
//                        Application.showForm(new FormSanPhamItem1());
//                    } else if (subIndex == 3) {
//                        Application.showForm(new FormSanPhamItem2());
//                    } else {
//                        action.cancel();
//                    }
//                }
//             else if (index == 2) {
//                if (subIndex == 1) {
//                    Application.showForm(new FormQuanLyHoaDon());
//                } else if (subIndex == 2) {
//                    Application.showForm(new FormQuanLyHoaDonItem1());
//                } else if (subIndex == 3) {
//                    Application.showForm(new FormQuanLyHoaDonItem2());
//                }
//            } else if (index == 3) {
//                if (subIndex == 1) {
//                    Application.showForm(new FormQuanLyNhanViens());
//                } else if (subIndex == 2) {
//                    Application.showForm(new FormQuanLyNVDaXoa());
//                } else if (subIndex == 3) {
//                    Application.showForm(new FormKHDaThem());
//                }
//            } else if (index == 4) {
//                if (subIndex == 1) {
//                    Application.showForm(new FormQuanLyNhanViens());
//                } else if (subIndex == 2) {
//                    Application.showForm(new FormKHDaThem());
//                } else if (subIndex == 3) {
//                    Application.showForm(new FormQuanLyNVDaXoa());
//                }
//            } else if (index == 5) {
//                if (subIndex == 1) {
//                    Application.showForm(new FormQuanLyKhachHang());
//                }
//            } else if (index == 6) {
//                if (subIndex == 1) {
//                    Application.showForm(new FormQuanLyKhuyenMai());
//                } else if (subIndex == 2) {
//                    Application.showForm(new FormQuanLyKhuyenMaiItem1());
//                } else if (subIndex == 3) {
//                    Application.showForm(new FormQuanLyKhuyenMaiItem2());
//                }
//            } else if (index == 7) {
//                if (subIndex == 1) {
//                    Application.showForm(new FormQuanLyGiaoHang());
//                } else if (subIndex == 2) {
//                    Application.showForm(new FormQuanLyGiaoHangItem1());
//                } else if (subIndex == 3) {
//                    Application.showForm(new FormQuanLyGiaoHangItem2());
//                }
//            } else if (index == 9) {
////                Application.logout();
//            } else {
//                action.cancel();
//            }
//        });
//    }
    private void setMenuFull(boolean full) {
        String icon;
        if (getComponentOrientation().isLeftToRight()) {
            icon = (full) ? "menu_left.svg" : "menu_right.svg";
        } else {
            icon = (full) ? "menu_right.svg" : "menu_left.svg";
        }
        menuButton.setIcon(new FlatSVGIcon("raven/icon/svg/" + icon, 0.8f));
        menu.setMenuFull(full);
        revalidate();
    }

    public void hideMenu() {
        menu.hideMenuItem();
    }

    public void showForm(Component component) {
        panelBody.removeAll();
        panelBody.add(component);
        panelBody.repaint();
        panelBody.revalidate();
    }

    public void setSelectedMenu(int index, int subIndex) {
        menu.setSelectedMenu(index, subIndex);
    }

    private Menu menu;
    private JPanel panelBody;
    private JButton menuButton;

    private class MainFormLayout implements LayoutManager {

        @Override
        public void addLayoutComponent(String name, Component comp) {
        }

        @Override
        public void removeLayoutComponent(Component comp) {
        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            synchronized (parent.getTreeLock()) {
                return new Dimension(5, 5);
            }
        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {
            synchronized (parent.getTreeLock()) {
                return new Dimension(0, 0);
            }
        }

        @Override
        public void layoutContainer(Container parent) {
            synchronized (parent.getTreeLock()) {
                boolean ltr = parent.getComponentOrientation().isLeftToRight();
                Insets insets = UIScale.scale(parent.getInsets());
                int x = insets.left;
                int y = insets.top;
                int width = parent.getWidth() - (insets.left + insets.right);
                int height = parent.getHeight() - (insets.top + insets.bottom);
                int menuWidth = UIScale.scale(menu.isMenuFull() ? menu.getMenuMaxWidth() : menu.getMenuMinWidth());
                int menuX = ltr ? x : x + width - menuWidth;
                menu.setBounds(menuX, y, menuWidth, height);
                int menuButtonWidth = menuButton.getPreferredSize().width;
                int menuButtonHeight = menuButton.getPreferredSize().height;
                int menubX;
                if (ltr) {
                    menubX = (int) (x + menuWidth - (menuButtonWidth * (menu.isMenuFull() ? 0.5f : 0.3f)));
                } else {
                    menubX = (int) (menuX - (menuButtonWidth * (menu.isMenuFull() ? 0.5f : 0.7f)));
                }
                menuButton.setBounds(menubX, UIScale.scale(30), menuButtonWidth, menuButtonHeight);
                int gap = UIScale.scale(5);
                int bodyWidth = width - menuWidth - gap;
                int bodyHeight = height;
                int bodyx = ltr ? (x + menuWidth + gap) : x;
                int bodyy = y;
                panelBody.setBounds(bodyx, bodyy, bodyWidth, bodyHeight);
            }
        }
    }
}
