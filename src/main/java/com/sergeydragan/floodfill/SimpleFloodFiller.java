package com.sergeydragan.floodfill;

import java.awt.*;
import java.util.List;

public class SimpleFloodFiller implements FloodFiller {

    private List<List<String>> field;

    @Override
    public List<List<String>> fillField(List<List<String>> field, Point startPoint) {
        this.field = field;
        visualiseFieldToConsole();
        fillCoords(startPoint.x, startPoint.y);
        visualiseFieldToConsole();
        return field;
    }

    private void fillCoords(int x, int y) {
        if (isOutsideField(x, y) || isWall(x, y) || isFilled(x, y)) {
            return;
        }
        setCell(x, y, "*");
        fillCoords(x-1, y);
        fillCoords(x+1, y);
        fillCoords(x, y-1);
        fillCoords(x, y+1);
    }

    private boolean isFilled(int x, int y) {
        return getCellAt(x, y).equals("*");
    }

    private boolean isWall(int x, int y) {
        return getCellAt(x, y).equals("1");
    }

    private boolean isOutsideField(int x, int y) {
        return y < 0 || y >= field.size() || x < 0 || x >= field.get(y).size();
    }

    private void setCell(int x, int y, String value) {
        field.get(y).set(x, value);
    }

    private void visualiseFieldToConsole() {
        String visualisation = "";
        for (List<String> row : field) {
            for (String cell : row) {
                visualisation = visualisation.concat(cellToChar(cell)).concat(" ");
            }
            visualisation = visualisation.concat("\n");
        }
        System.out.println(visualisation);
    }

    private String getCellAt(int x, int y) {
        return field.get(y).get(x);
    }

    private String cellToChar(String cellValue) {
        switch (cellValue) {
            case "0":
                return "*";
            case "1":
                return "▓";
            case "*":
                return "░";
        }
        return "?";
    }
}
