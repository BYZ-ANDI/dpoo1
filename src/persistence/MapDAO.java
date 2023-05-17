package persistence;

import Business.entities.Room;
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;


public class MapDAO {
    public List<Room> loadRooms(String filePath) {
        List<Room> rooms = new ArrayList<>();

        try (FileReader reader = new FileReader(filePath)) {
            Gson gson = new Gson();
            MapData mapData = gson.fromJson(reader, MapData.class);
            for (RoomData roomData : mapData.rooms) {
                Room room = new Room(roomData.id, roomData.color,
                        roomData.exits.length > 1 ? roomData.exits[0].direction : null,
                        roomData.exits.length > 1 ? roomData.exits[0].room_id : null,
                        roomData.exits.length > 1 ? roomData.exits[1].direction : null,
                        roomData.exits.length > 1 ? roomData.exits[1].room_id : null,
                        roomData.exits.length > 2 ? roomData.exits[2].direction : null,
                        roomData.exits.length > 2 ? roomData.exits[2].room_id : null,
                        roomData.vent);
                rooms.add(room);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rooms;
    }

    private static class MapData {
        RoomData[] rooms;
        String starting_room;
    }

    private static class RoomData {
        String id;
        String color;
        ExitData[] exits;
        String vent;
    }

    private static class ExitData {
        String direction;
        String room_id;
    }
}