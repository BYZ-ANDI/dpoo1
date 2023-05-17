package persistence;

import Business.entities.Room;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapsDAO {
    public List<Room> loadRooms(String filePath) {
        List<Room> rooms = new ArrayList<>();

        try (FileReader reader = new FileReader(filePath)) {
            Gson gson = new Gson();
            MapData mapData = gson.fromJson(reader, MapData.class);
            for (RoomData roomData : mapData.rooms) {
                Room room = new Room(roomData.id, roomData.color,
                        roomData.direction1 != null ? roomData.direction1 : null,
                        roomData.room_id1 != null ? roomData.room_id1 : null,
                        roomData.direction2 != null ? roomData.direction2 : null,
                        roomData.room_id2 != null ? roomData.room_id2 : null,
                        roomData.direction3 != null ? roomData.direction3 : null,
                        roomData.room_id3 != null ? roomData.room_id3 : null,
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
        String direction1;
        String room_id1;
        String direction2;
        String room_id2;
        String direction3;
        String room_id3;
        String vent;
    }
}