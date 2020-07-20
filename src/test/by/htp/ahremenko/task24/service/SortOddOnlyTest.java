package by.htp.ahremenko.task24.service;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SortOddOnlyTest {

    @Test
    public void handle() {
        List<Integer> list = new ArrayList<>(Arrays.asList(5, 3, 2, 8, 1, 4));
        List<Integer> actualList = SortOddOnly.handle(list);
        List<Integer> expectedList = Arrays.asList(1, 3, 2, 8, 5, 4);
        assertEquals(expectedList, actualList);
    }
}