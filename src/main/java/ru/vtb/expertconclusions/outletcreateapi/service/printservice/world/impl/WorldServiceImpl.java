package ru.vtb.expertconclusions.outletcreateapi.service.printservice.world.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.vtb.expertconclusions.outletcreateapi.data.Data;
import ru.vtb.expertconclusions.outletcreateapi.service.printservice.world.WorldService;

import java.util.Map;

import static ru.vtb.expertconclusions.outletcreateapi.util.ManagedConstant.timeToSwitch;

@Component
public class WorldServiceImpl implements WorldService {
    @Autowired
    Data data;

    int x = 0;
    private boolean isNo;

    @Override
    public String getWorld(String world) {
        isNo = false;
        return getWorldit(world);
    }

    private String getWorldit(String world) {
        //он 56 будущее?
//        if (0 == 0)
//            return getPronoun() + "  " + String.valueOf(getRandom(300, 1000)) + " " + getTense() + "  "
//                    +  getIsQustion()
//                    ;
        return getPronoun() + "  " + world + " " + getTense() + "  "
                + getYesOrNo()
                + getIsQustion();
//                +getContiniousOrUsually();
//                + (isNo ? "" : getIsQustion());

    }

    private String getContiniousOrUsually() {
        return "    Продолженное";
    }

    private String getIsQustion() {
        Map<Integer, String> map = Map.of(0, "", 1, "?");
        return map.get(getRandom(2));
//        return "  ?";
//        return "";
    }

    private String getYesOrNo() {
        Map<Integer, String> map = Map.of(0, "Да", 1, "Нет");
//        int rand = getRandom(2);
//        if (rand == 1) {
//            isNo = true;
//        }
        return map.get(getRandom(2));
//        return "нет";
    }

    private String getTense() {
        Map<Integer, String> map = Map.of(0, "Настоящее", 1, "Прошедшее", 2, "Будущее");
//        return map.get(getRandom(3));
//        return map.get(2);
        return map.get(data.getTenseCount());
//        return map.get(0);
    }

    private String getPronoun() {
        getPronounCount();
        Map<Integer, String> map = Map.of(0, "Я", 1, "Мы", 2, "Ты", 3, "Вы", 4, "Он", 5, "Она", 6, "Оно", 7, "Они");
        return map.get(getRandom(8));
//        return map.get(getPronounCount());
//        return map.get(2);

    }


    private int getRandom(int i) {
        while (true) {
            int rand = (int) (Math.random() * 10);
            if (rand < i)
                return rand;
        }
    }

    private int getRandom(int i, int max) {
        while (true) {
            int rand = (int) (Math.random() * 1000);
//            if (rand < i)
            return rand;
        }
    }

    private int getPronounCount() {
        int pronounCount = data.getPronounCount();
        int tenseCount = data.getTenseCount();
        if (isNeedSwitch(pronounCount)) {
            data.setCount(data.getCount() + 1);
            if (++pronounCount >= 8) {
                pronounCount = 0;
                if (++tenseCount >= 3) {
                    tenseCount = 0;
                }
            }
        }
        data.setPronounCount(pronounCount);
        data.setTenseCount(tenseCount);
        return pronounCount;
    }

    private boolean isNeedSwitch(int pronounCount) {
        return (data.getCount() * timeToSwitch + data.getStartTime() >= System.currentTimeMillis());

    }
}
