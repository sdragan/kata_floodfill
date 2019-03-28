package com.sergeydragan.floodfill;

import java.awt.*;
import java.util.List;

public interface FloodFiller {
    List<List<String>> fillField(List<List<String>> field, Point startPoint);
}
