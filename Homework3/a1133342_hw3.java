import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class a1133342_hw2 extends JFrame {

    
    JComboBox<String> typeBox;

    
    JTextField inputField;
    JTextField resultField;

    JComboBox<String> fromBox;
    JComboBox<String> toBox;

    JButton convertButton;

   
    String[] lengthUnits = {"公尺", "公分", "英吋", "英尺"};
    String[] weightUnits = {"公斤", "公克", "磅", "盎司"};
    String[] temperatureUnits = {"攝氏", "華氏", "克氏"};

    public a1133342_hw2() {

        
        setTitle("單位換算器");

       
        setSize(480, 280);

        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        // =========================
        // NORTH：換算類型
        // =========================

        typeBox = new JComboBox<>(
            new String[]{"長度", "重量", "溫度"}
        );

        JPanel northPanel = new JPanel();
        northPanel.add(typeBox);

        add(northPanel, BorderLayout.NORTH);


        // =========================
        // CENTER：兩列輸入
        // =========================

        JPanel centerPanel = new JPanel();

        // 2列1行
        centerPanel.setLayout(new GridLayout(2, 1, 10, 10));

        
        JPanel row1 = new JPanel();

        inputField = new JTextField(10);

        fromBox = new JComboBox<>(lengthUnits);

        row1.add(inputField);
        row1.add(fromBox);


        
        JPanel row2 = new JPanel();

        resultField = new JTextField(10);

        
        resultField.setEditable(false);

        toBox = new JComboBox<>(lengthUnits);

        row2.add(resultField);
        row2.add(toBox);


        centerPanel.add(row1);
        centerPanel.add(row2);

        add(centerPanel, BorderLayout.CENTER);


        // =========================
        // SOUTH：換算按鈕
        // =========================

        convertButton = new JButton("換算");

        JPanel southPanel = new JPanel();

        southPanel.add(convertButton);

        add(southPanel, BorderLayout.SOUTH);


        // =========================
        // 上方類型改變時
        // =========================

        typeBox.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                updateUnits();

            }

        });


        // =========================
        // 按下換算
        // =========================

        convertButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                convert();

            }

        });


       
        setLocationRelativeTo(null);

       
        setVisible(true);
    }


    // =====================================
    // 根據類型更新兩個 JComboBox
    // =====================================

    void updateUnits() {

        String type = (String) typeBox.getSelectedItem();

        fromBox.removeAllItems();
        toBox.removeAllItems();


        if (type.equals("長度")) {

            for (String unit : lengthUnits) {
                fromBox.addItem(unit);
                toBox.addItem(unit);
            }

        }
        else if (type.equals("重量")) {

            for (String unit : weightUnits) {
                fromBox.addItem(unit);
                toBox.addItem(unit);
            }

        }
        else if (type.equals("溫度")) {

            for (String unit : temperatureUnits) {
                fromBox.addItem(unit);
                toBox.addItem(unit);
            }
        }
    }


    // =====================================
    // 執行換算
    // =====================================

    void convert() {

        try {

            // 取得輸入數字
            double value = Double.parseDouble(
                inputField.getText()
            );

            String type = (String) typeBox.getSelectedItem();

            String from = (String) fromBox.getSelectedItem();

            String to = (String) toBox.getSelectedItem();

            double result = 0;


            // =========================
            // 長度
            // =========================

            if (type.equals("長度")) {

                double meter = 0;

                // 先全部換成公尺

                if (from.equals("公尺")) {
                    meter = value;
                }
                else if (from.equals("公分")) {
                    meter = value / 100;
                }
                else if (from.equals("英吋")) {
                    meter = value * 0.0254;
                }
                else if (from.equals("英尺")) {
                    meter = value * 0.3048;
                }


                // 公尺再換成目標單位

                if (to.equals("公尺")) {
                    result = meter;
                }
                else if (to.equals("公分")) {
                    result = meter * 100;
                }
                else if (to.equals("英吋")) {
                    result = meter / 0.0254;
                }
                else if (to.equals("英尺")) {
                    result = meter / 0.3048;
                }
            }


            // =========================
            // 重量
            // =========================

            else if (type.equals("重量")) {

                double kg = 0;

                // 先全部換成公斤

                if (from.equals("公斤")) {
                    kg = value;
                }
                else if (from.equals("公克")) {
                    kg = value / 1000;
                }
                else if (from.equals("磅")) {
                    kg = value * 0.453592;
                }
                else if (from.equals("盎司")) {
                    kg = value * 0.0283495;
                }


                // 公斤再換成目標單位

                if (to.equals("公斤")) {
                    result = kg;
                }
                else if (to.equals("公克")) {
                    result = kg * 1000;
                }
                else if (to.equals("磅")) {
                    result = kg / 0.453592;
                }
                else if (to.equals("盎司")) {
                    result = kg / 0.0283495;
                }
            }


            // =========================
            // 溫度
            // =========================

            else if (type.equals("溫度")) {

                double celsius = 0;

                

                if (from.equals("攝氏")) {
                    celsius = value;
                }
                else if (from.equals("華氏")) {
                    celsius = (value - 32) * 5 / 9;
                }
                else if (from.equals("克氏")) {
                    celsius = value - 273.15;
                }


              

                if (to.equals("攝氏")) {
                    result = celsius;
                }
                else if (to.equals("華氏")) {
                    result = celsius * 9 / 5 + 32;
                }
                else if (to.equals("克氏")) {
                    result = celsius + 273.15;
                }
            }


            
            resultField.setText(
                String.format("%.2f", result)
            );

        }
        catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                this,
                "請輸入數字！"
            );

        }
    }


    // =====================================
    // main
    // =====================================

    public static void main(String[] args) {

        new a1133342_hw2();

    }
}
