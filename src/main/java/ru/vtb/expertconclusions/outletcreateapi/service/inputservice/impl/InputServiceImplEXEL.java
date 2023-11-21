package ru.vtb.expertconclusions.outletcreateapi.service.inputservice.impl;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import ru.vtb.expertconclusions.outletcreateapi.service.inputservice.InputService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static ru.vtb.expertconclusions.outletcreateapi.util.Constant.*;
import static ru.vtb.expertconclusions.outletcreateapi.util.ManagedConstant.language;


@Primary
@Component
public class InputServiceImplEXEL implements InputService {
    @Override
    public List<String> input(String path, String fileName) {


        FileInputStream inputStream = null;
        Workbook workbook = null;
        try {
            // Read XSL file
            inputStream = new FileInputStream(new File(rootPath + path + fileName + fileExtension));
            // Get the workbook instance for XLS file
//            workbook = new HSSFWorkbook(inputStream);
            workbook = WorkbookFactory.create(new File(rootPath + path + fileName + fileExtension));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }

        // Get first sheet from the workbook
        Sheet sheet = workbook.getSheetAt(0);

        // Get iterator to all the rows in current sheet
        Iterator<Row> rowIterator = sheet.iterator();
        List<String> worlds = new ArrayList<>();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            // Get iterator to all cells of current row
            Iterator<Cell> cellIterator = row.cellIterator();
            Cell cell = getCell(cellIterator);
            if (cell == null)
                continue;

            // Change to getCellType() if using POI 4.x
            CellType cellType = cell.getCellTypeEnum();
            if (!cellType.name().equals("STRING")) {
                continue;
            }
            String world = cell.getStringCellValue();
            if (world.equals("stop")) {
                break;
            }
            worlds.add(world);
        }
        System.out.println(worlds);
        return worlds;
    }

    private Cell getCell(Iterator<Cell> cellIterator) {
        int i = 0;
        Cell cell = null;
        try {
            int numberOfColomn = mapsLanguage.get(language);
            for (; i < numberOfColomn; i++) {
                cell = cellIterator.next();
                if (cell.getStringCellValue().isEmpty())
                    return null;
            }
        } catch (Exception e) {
            System.out.println(i);
            throw e;
        }
        return cell;
    }

}
