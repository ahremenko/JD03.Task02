package by.duallab.ahremenko;

import java.util.ArrayList;
import java.util.List;

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