package ru.vtb.expertconclusions.outletcreateapi.service.printservice.impl;

// Использование текстовых полей JTextField

import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static ru.vtb.expertconclusions.outletcreateapi.util.ManagedConstant.shaffle;
import static ru.vtb.expertconclusions.outletcreateapi.util.ManagedConstant.timeToWait;

//@Component
public class TextFieldTest extends JFrame {
    // Текстовые поля
    JTextField smallField, bigField;

    public TextFieldTest(List<String> worlds) {
        super("sadf");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(500, 200, 500, 300);
        // Создание текстовых полей
//        smallField = new JTextField(15);
        while (true) {
            printMy(worlds);
            if (shaffle.name().equals("on")) {
                Collections.shuffle(worlds);
            }
        }
    }

    private void printMy(List<String> worlds) {
        for (String world : worlds) {
            String newWorld = getWorld(world);
            bigField = new JTextField(newWorld, 25);
            // Настройка шрифта
            bigField.setFont(new Font("Dialog", Font.PLAIN, 50));
//        bigField.setHorizontalAlignment(JTextField.LEFT);
            // Слушатель окончания ввода

            // Поле с паролем
//        JPasswordField password = new JPasswordField(12);
//        password.setEchoChar('*');
            // Создание панели с текстовыми полями

            try {
                Thread.sleep(timeToWait);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            JPanel contents = new JPanel(new FlowLayout(FlowLayout.LEFT));
//        contents.add(smallField);
            contents.add(bigField);
//        contents.add(password  );
            setContentPane(contents);
            // Определяем размер окна и выводим его на экран
            setSize(800, 300);
            setVisible(true);
        }
    }

    private String getWorld(String world) {
        return getPronoun() + "  " + world + " " + getTense()+"  "+getYesOrNo();
    }

    private String getYesOrNo() {
        Map<Integer, String> map = Map.of(0, "Да", 1, "Нет");
        return map.get(getRandom(2));
    }

    private String getTense() {
        Map<Integer, String> map = Map.of(0, "Настоящее", 1, "Прошедшее", 2, "Будущее");
        return map.get(getRandom(3));
    }

    private String getPronoun() {
        int y = getRandom(8);
        Map<Integer, String> map = Map.of(0, "Я", 1, "Мы", 2, "Ты", 3, "Вы", 4, "Он", 5, "Она", 6, "Оно", 7, "Они");
        return map.get(y);

    }

    private int getRandom(int i) {
        while (true) {
            int rand = (int) (Math.random() * 10);
            if (rand < i)
                return rand;
        }
    }
}