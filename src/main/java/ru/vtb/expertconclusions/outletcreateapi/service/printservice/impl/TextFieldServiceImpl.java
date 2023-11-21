package ru.vtb.expertconclusions.outletcreateapi.service.printservice.impl;

import org.springframework.stereotype.Service;
import ru.vtb.expertconclusions.outletcreateapi.service.printservice.TextFieldService;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

@Service
public class TextFieldServiceImpl implements TextFieldService {
    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration

    @Override
    public void printWorld(String world) {
        System.out.println(world);
        List<String> list = Arrays.asList("Мама мыла раму.", "Долго и скучала.", "Вечер уж настал");
        SwingUtilities.invokeLater(() ->
        {
            StringBuilder stringBuilder = new StringBuilder();
            for (String s : list) {
                stringBuilder.append(s).append("\n");
            }
            JTextArea textArea = new JTextArea(stringBuilder.toString());
            JFrame frame = new JFrame("_________");
            frame.add(new JScrollPane(textArea));
            frame.setSize(1000, 600);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }


}
