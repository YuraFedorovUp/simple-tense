package ru.vtb.expertconclusions.outletcreateapi.service.workservice.impl;

import org.springframework.stereotype.Component;
import ru.vtb.expertconclusions.outletcreateapi.service.workservice.WorkService;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WorkServiceImpl implements WorkService {
    @Override
    public List<String> getSPrint(List<String> lines) {
        return lines.stream().map(world -> getWorld(world)).collect(Collectors.toList());
    }

    private String getWorld(String world) {
        return world.substring(0, 1).toUpperCase() + world.substring(1, world.length());
    }
}
