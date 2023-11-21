package ru.vtb.expertconclusions.outletcreateapi.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;


@Builder
@Data
public class Days {
    private Integer numberDay;
}
