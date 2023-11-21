package ru.vtb.expertconclusions.outletcreateapi.service.inputservice.impl;

import org.springframework.stereotype.Component;
import ru.vtb.expertconclusions.outletcreateapi.service.inputservice.InputService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static ru.vtb.expertconclusions.outletcreateapi.util.Constant.*;

@Component
public class InputServiceImpl implements InputService {
    @Override
    public List<String> input(String path,String fileName) {
        String fileNameFull = rootPath+path+fileName+fileExtension;
        File file = new File(fileNameFull);
        List<String> lines=new ArrayList<>();
        try {


            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
               lines.add(line.trim());
            }
            br.close();
            fr.close();
        } catch (Exception ex) {
            System.out.println(ex.getStackTrace());
            throw new RuntimeException("Ошибка в классе InputServiceImpl"+fileNameFull);
        }
        return lines;
    }
}

