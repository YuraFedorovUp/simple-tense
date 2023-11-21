package ru.vtb.expertconclusions.outletcreateapi.job.impl;

import org.springframework.stereotype.Component;
import ru.vtb.expertconclusions.outletcreateapi.job.Job;
import ru.vtb.expertconclusions.outletcreateapi.service.inputservice.InputService;
import ru.vtb.expertconclusions.outletcreateapi.service.printservice.PrintService;
import ru.vtb.expertconclusions.outletcreateapi.service.workservice.WorkService;

import java.util.List;

import static ru.vtb.expertconclusions.outletcreateapi.util.Constant.*;
import static ru.vtb.expertconclusions.outletcreateapi.util.ManagedConstant.nameFile;

@Component
public class JobImpl implements Job {
    private final InputService inputService;
    private final WorkService workService;
    private final PrintService printService;

    public JobImpl(InputService inputService, WorkService workService, PrintService printService) {
        this.inputService = inputService;
        this.workService = workService;
        this.printService = printService;
    }

    public void job() {
        System.out.println("job.job");
        List<String> lines = inputService.input(pathInput, nameFile.name());
        System.out.println(lines);
        lines = workService.getSPrint(lines);
        System.out.println(lines);
        printService.print(lines);
    }
}
