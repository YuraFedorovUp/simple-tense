package ru.vtb.expertconclusions.outletcreateapi.service.workservice;

import ru.vtb.expertconclusions.outletcreateapi.model.Month;

import java.util.List;

public interface WorkService {

    List<String> getSPrint(List<String> lines);
}
