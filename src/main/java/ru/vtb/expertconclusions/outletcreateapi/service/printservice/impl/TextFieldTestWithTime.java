package ru.vtb.expertconclusions.outletcreateapi.service.printservice.impl;

// Использование текстовых полей JTextField

import lombok.RequiredArgsConstructor;
import ru.vtb.expertconclusions.outletcreateapi.enams.QuestionEnum;
import ru.vtb.expertconclusions.outletcreateapi.service.printservice.world.WorldService;
import ru.vtb.expertconclusions.outletcreateapi.service.printservice.world.impl.QuestionWordsImpl;
import ru.vtb.expertconclusions.outletcreateapi.service.printservice.world.impl.WorldServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static ru.vtb.expertconclusions.outletcreateapi.util.ManagedConstant.*;
@RequiredArgsConstructor
public class TextFieldTestWithTime extends JFrame {

    private WorldService worldService;
    // Текстовые поля
    JTextField smallField, bigField;

    public TextFieldTestWithTime(WorldService worldService) {
        super("sadf");
        this.worldService = worldService;
    }

    private void printMy(List<String> worlds) {

        for (String world : worlds) {
            String newWorld = worldService.getWorld(world);
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
            setSize(1300, 300);
            setVisible(true);
        }
    }

    private List<String> getUniqWorld(List<String> worlds) {
        return new ArrayList<>(new HashSet(worlds));
    }




    public void job(List<String> worlds) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(500, 200, 500, 300);

        worlds = getUniqWorld(worlds);
        while (true) {
            if (shaffle.name().equals("on")) {
                Collections.shuffle(worlds);
            }
            printMy(worlds);
        }
    }
}