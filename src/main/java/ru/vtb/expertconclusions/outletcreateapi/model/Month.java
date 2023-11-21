package ru.vtb.expertconclusions.outletcreateapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Month {
    private List<Integer> outletDays = new ArrayList<>();
    private String monthName;
    private Integer indexNumber;
}
