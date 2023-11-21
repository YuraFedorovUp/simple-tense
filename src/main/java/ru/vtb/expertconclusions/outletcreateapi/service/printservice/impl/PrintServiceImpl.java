package ru.vtb.expertconclusions.outletcreateapi.service.printservice.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vtb.expertconclusions.outletcreateapi.enams.QuestionEnum;
import ru.vtb.expertconclusions.outletcreateapi.service.printservice.PrintService;
import ru.vtb.expertconclusions.outletcreateapi.service.printservice.world.WorldService;
import ru.vtb.expertconclusions.outletcreateapi.service.printservice.world.impl.QuestionWordsImpl;
import ru.vtb.expertconclusions.outletcreateapi.service.printservice.world.impl.WorldServiceImpl;

import java.util.List;

import static ru.vtb.expertconclusions.outletcreateapi.util.ManagedConstant.question;

@Service
@RequiredArgsConstructor
public class PrintServiceImpl implements PrintService {
    private final QuestionWordsImpl questionWordsImpl;
    private final WorldServiceImpl worldServiceImpl;
    private WorldService worldService;

    @Override
    public void print(List<String> worlds) {
//        new TextFieldTest(worlds);
        worldService = question.equals(QuestionEnum.yes) ? questionWordsImpl : worldServiceImpl;
        TextFieldTestWithTime textFieldTest = new TextFieldTestWithTime(worldService);
        textFieldTest.job(worlds);

    }
}
