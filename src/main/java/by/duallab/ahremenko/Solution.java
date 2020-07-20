package by.duallab.ahremenko;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * реализовать задачу поиска минимального числа переговорок для списка встреч
 *  (встреча - это пара значений "время начала" и "время окончания")
 */

public class Solution {

    public int getMaxRooms(List<Task> tasks) {
        MeetingRooms meetingRooms = new MeetingRooms();
        Collections.sort(tasks);
        tasks.forEach( t -> meetingRooms.putNewTask(t));
        return meetingRooms.getRooms().size();
    }

    // TODO: методы main и fillTasks следует оформить как unit-тест
    public static void main(String[] args) throws java.text.ParseException {
        List<Task> tasks = new ArrayList<>();
        Solution solution = new Solution();
        solution.fillTasks(tasks); // заполняем список встреч
        int maxRooms = solution.getMaxRooms(tasks); // ищем число митинг-румов
        System.out.println(maxRooms);
    }

    public void fillTasks(List<Task> tasks) throws java.text.ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDateTime = format.parse("2020-05-27 09:00:00");
        Date finishDateTime = format.parse("2020-05-27 11:00:00");
        tasks.add(new Task( startDateTime.getTime(), finishDateTime.getTime() ));

        startDateTime = format.parse("2020-05-27 10:00:00");
        finishDateTime = format.parse("2020-05-27 12:00:00");
        tasks.add(new Task( startDateTime.getTime(), finishDateTime.getTime() ));

        startDateTime = format.parse("2020-05-27 14:00:00");
        finishDateTime = format.parse("2020-05-27 17:00:00");
        tasks.add(new Task( startDateTime.getTime(), finishDateTime.getTime() ));

        startDateTime = format.parse("2020-05-27 09:00:00");
        finishDateTime = format.parse("2020-05-27 18:00:00");
        tasks.add(new Task( startDateTime.getTime(), finishDateTime.getTime() ));

        startDateTime = format.parse("2020-05-27 13:00:00");
        finishDateTime = format.parse("2020-05-27 14:00:00");
        tasks.add(new Task( startDateTime.getTime(), finishDateTime.getTime() ));
    }
}
