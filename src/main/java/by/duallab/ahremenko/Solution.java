package by.duallab.ahremenko;

import java.text.SimpleDateFormat;
import java.util.*;

public class Solution {

    public class Task  implements Comparable<Task>{
        private long startTime;
        private long finishTime;

        public Task(long startTime, long finishTime) {
            this.startTime = startTime;
            this.finishTime = finishTime;
        }

        public long getStartTime() {
            return startTime;
        }

        public long getFinishTime() {
            return finishTime;
        }

        @Override
        public int compareTo(Task another) {
            if (this.getStartTime()<another.getStartTime()){
                return -1;
            } else {
                return 1;
            }
        }
    }

    public class MeetingRooms {

        private List<Double> rooms = new ArrayList<>();  // необходимые переговорки, элементы содержат время окончания митингов

        public void putNewTask(Task task) {
            Integer freeRoomFound = null;
            for (int i = 0; i < rooms.size(); i++) {
                if (task.getStartTime() >= rooms.get(i))
                    freeRoomFound = i;
                break;
            }
            if (freeRoomFound == null) {
                rooms.add((double)task.getFinishTime());
            } else {
                rooms.set(freeRoomFound, (double)task.getFinishTime());
            }
        }

        public List<Double> getRooms() {
            return rooms;
        }
    }

    public int getMaxRooms(List<Task> tasks) {
        MeetingRooms meetingRooms = new MeetingRooms();
        tasks.forEach( t -> meetingRooms.putNewTask(t));
        return meetingRooms.getRooms().size();
    }

    public static void main(String[] args) throws java.text.ParseException {

        List<Task> tasks = new ArrayList<>();
        Solution solution = new Solution();
        solution.fillTasks(tasks); // заполняем список встреч
        Collections.sort(tasks);
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
