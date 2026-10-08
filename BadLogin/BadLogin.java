import javax.swing.*;
import java.awt.*;

public class BadLogin extends JFrame {

    public BadLogin() {

        // 視窗設定
        setTitle("登入");
        setSize(300, 200);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 帳號
        JLabel l1 = new JLabel("帳號：");
        l1.setBounds(30, 30, 60, 30);

        JTextField t1 = new JTextField();
        t1.setBounds(90, 30, 150, 30);

        // 密碼
        JLabel l2 = new JLabel("密碼：");
        l2.setBounds(30, 70, 60, 30);

        JPasswordField t2 = new JPasswordField();
        t2.setBounds(90, 70, 150, 30);

        // 登入按鈕
        JButton btn = new JButton("登入");
        btn.setBounds(100, 115, 80, 30);

        // 把元件加入視窗
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(btn);

        // 按下登入
        btn.addActionListener(e -> {

            String account = t1.getText();
            String password = new String(t2.getPassword());

            if (account.equals("admin") && password.equals("admin")) {

                System.out.println("登入成功");

                JOptionPane.showMessageDialog(
                    this,
                    "登入成功"
                );

            } else {

                System.out.println("帳號或密碼錯誤");

                JOptionPane.showMessageDialog(
                    this,
                    "帳號或密碼錯誤"
                );
            }
        });

        // 視窗置中
        setLocationRelativeTo(null);

        // 顯示視窗
        setVisible(true);
    }

    public static void main(String[] args) {
        new BadLogin();
    }
}
