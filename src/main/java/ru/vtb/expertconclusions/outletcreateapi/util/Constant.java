package ru.vtb.expertconclusions.outletcreateapi.util;

import lombok.experimental.UtilityClass;
import ru.vtb.expertconclusions.outletcreateapi.enams.LanguageEnam;
import ru.vtb.expertconclusions.outletcreateapi.enams.ShaffleEnam;

import java.util.Map;

@UtilityClass
public class Constant {
    public final static String rootPath = "";
    public final static String fileExtension = ".xlsx";

    public final static Map<LanguageEnam, Integer> mapsLanguage = Map.of(LanguageEnam.English, 1, LanguageEnam.Russian, 3);

    public final static String pathInput = "input/";
    public final static String pathOutput = "output/";


}