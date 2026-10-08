import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class a1133342_hw1_2 extends JFrame {

    // 顯示目前點數的文字
    JLabel numberLabel;

    // 顯示擲骰子的次數、總和、平均
    JLabel infoLabel;

    // 擲骰子按鈕
    JButton rollButton;

    // 骰子顯示區
    DicePanel dicePanel;

    // 擲骰子次數
    int count = 0;

    // 所有骰子的總和
    int sum = 0;


    public a1133342_hw1_2() {

        // =========================
        // 視窗設定
        // =========================

        setTitle("骰子模擬器");

        setSize(400, 320);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());


        // =========================
        // 上方：次數、總和、平均
        // =========================

        infoLabel = new JLabel(
            "已擲 0 次，總和 0，平均 0.00",
            JLabel.CENTER
        );

        infoLabel.setFont(
            new Font("微軟正黑體", Font.PLAIN, 16)
        );

        add(infoLabel, BorderLayout.NORTH);


        // =========================
        // 中間：骰子
        // =========================

        JPanel centerPanel = new JPanel();

        centerPanel.setLayout(
            new BoxLayout(centerPanel, BoxLayout.Y_AXIS)
        );

        // 目前點數
        numberLabel = new JLabel(
            "0",
            JLabel.CENTER
        );

        numberLabel.setFont(
            new Font("Arial", Font.BOLD, 60)
        );

        numberLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // 骰子圖案
        dicePanel = new DicePanel();

        dicePanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        centerPanel.add(numberLabel);
        centerPanel.add(dicePanel);

        add(centerPanel, BorderLayout.CENTER);


        // =========================
        // 下方：擲骰子按鈕
        // =========================

        rollButton = new JButton("擲骰子");

        JPanel southPanel = new JPanel();

        southPanel.add(rollButton);

        add(southPanel, BorderLayout.SOUTH);


        // =========================
        // 按鈕事件
        // =========================

        rollButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                rollDice();

            }
        });


        // 視窗置中
        setLocationRelativeTo(null);

        // 顯示視窗
        setVisible(true);
    }


    // =========================
    // 擲骰子的方法
    // =========================

    void rollDice() {

        // 隨機產生 1～6
        int number = (int)(Math.random() * 6) + 1;


        // 更新次數
        count++;

        // 更新總和
        sum += number;


        // 計算平均
        double average = (double) sum / count;


        // 更新上方資訊
        infoLabel.setText(
            String.format(
                "已擲 %d 次，總和 %d，平均 %.2f",
                count,
                sum,
                average
            )
        );


        // 更新目前點數
        numberLabel.setText(
            String.valueOf(number)
        );


        // 根據點數改變文字顏色
        if (number == 6) {

            numberLabel.setForeground(Color.GREEN);

        }
        else if (number == 1) {

            numberLabel.setForeground(Color.RED);

        }
        else {

            numberLabel.setForeground(Color.BLACK);

        }


        // 更新骰子圖案
        dicePanel.setNumber(number);
    }


    // =========================
    // main
    // =========================

    public static void main(String[] args) {

        new a1133342_hw1();

    }
}


// ========================================
// 骰子圖案
// ========================================

class DicePanel extends JPanel {

    // 目前骰子點數
    int number = 0;


    public DicePanel() {

        setPreferredSize(
            new Dimension(120, 120)
        );

        setBackground(Color.WHITE);
    }


    // 設定骰子點數
    public void setNumber(int number) {

        this.number = number;

        // 重新繪製
        repaint();
    }


    // 繪製骰子
    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // 開啟反鋸齒
        g2.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        );


        // =========================
        // 骰子外框
        // =========================

        g2.setColor(Color.BLACK);

        g2.fillRoundRect(
            10, 10,
            100, 100,
            15, 15
        );


        // 骰子白色區域
        g2.setColor(Color.WHITE);

        g2.fillRoundRect(
            15, 15,
            90, 90,
            12, 12
        );


        // 如果還沒有擲骰子，不畫點
        if (number == 0) {
            return;
        }


        // =========================
        // 設定點的顏色
        // =========================

        if (number == 6) {

            g2.setColor(Color.GREEN);

        }
        else if (number == 1) {

            g2.setColor(Color.RED);

        }
        else {

            g2.setColor(Color.BLACK);

        }


        // 點的大小
        int size = 14;


        // 骰子上的位置
        int left = 35;
        int center = 60;
        int right = 85;

        int top = 35;
        int middle = 60;
        int bottom = 85;


        // =========================
        // 1
        // =========================

        if (number == 1) {

            drawDot(g2, center, middle, size);

        }


        // =========================
        // 2
        // =========================

        else if (number == 2) {

            drawDot(g2, left, top, size);
            drawDot(g2, right, bottom, size);

        }


        // =========================
        // 3
        // =========================

        else if (number == 3) {

            drawDot(g2, left, top, size);
            drawDot(g2, center, middle, size);
            drawDot(g2, right, bottom, size);

        }


        // =========================
        // 4
        // =========================

        else if (number == 4) {

            drawDot(g2, left, top, size);
            drawDot(g2, right, top, size);
            drawDot(g2, left, bottom, size);
            drawDot(g2, right, bottom, size);

        }


        // =========================
        // 5
        // =========================

        else if (number == 5) {

            drawDot(g2, left, top, size);
            drawDot(g2, right, top, size);
            drawDot(g2, center, middle, size);
            drawDot(g2, left, bottom, size);
            drawDot(g2, right, bottom, size);

        }


        // =========================
        // 6
        // =========================

        else if (number == 6) {

            drawDot(g2, left, top, size);
            drawDot(g2, right, top, size);

            drawDot(g2, left, middle, size);
            drawDot(g2, right, middle, size);

            drawDot(g2, left, bottom, size);
            drawDot(g2, right, bottom, size);

        }
    }


    // 畫一個圓點
    void drawDot(
        Graphics2D g2,
        int x,
        int y,
        int size
    ) {

        g2.fillOval(
            x - size / 2,
            y - size / 2,
            size,
            size
        );
    }
}
