package ru.vtb.expertconclusions.outletcreateapi.data;

import lombok.Builder;
import lombok.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static ru.vtb.expertconclusions.outletcreateapi.util.ManagedConstant.timeToSwitch;

@Component
@lombok.Data
public class Data {
    private Long startTime;
    //    private int count;
    private int count = 1;
    private int pronounCount;
    private int tenseCount;

    @PostConstruct
    public void init() {
        startTime = System.currentTimeMillis();
        count = 1;
    }

}
