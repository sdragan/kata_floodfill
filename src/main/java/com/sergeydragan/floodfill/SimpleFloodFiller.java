package com.sergeydragan.floodfill;

import java.awt.*;
import java.util.List;

public class SimpleFloodFiller implements FloodFiller {

    @Override
    public List<List<String>> fillField(List<List<String>> field, Point startPoint) {
        String visualisation = "";
        for (List<String> aField : field) {
            for (String anAField : aField) {
                visualisation = visualisation.concat(cellToChar(anAField)).concat(" ");
            }
            visualisation = visualisation.concat("\n");
        }
        System.out.println(visualisation);

        return field;
    }

    private String cellToChar(String cellValue) {
        switch (cellValue) {
            case "0":
                return "░";
            case "1":
                return "▓";
            case "*":
                return "*";
        }
        return "?";
    }
}
