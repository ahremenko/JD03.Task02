package by.htp.ahremenko.task21.service;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class DominantServiceTest {

    @Test
    public void handle() {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(9);
        list.add(9);
        list.add(10);
        list.add(9);
        int actual = DominantService.handle(list);
        int expected = 9;
        assertEquals(expected, actual);
    }

    @Test
    public void handle2() {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(2);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        int actual = DominantService.handle(list);
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void handleNoDominant() {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(2);
        list.add(1);
        list.add(1);
        list.add(3);
        list.add(3);
        Integer actual = DominantService.handle(list);
        assertNull(actual);
    }

}