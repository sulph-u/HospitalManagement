package Architecture;

import java.util.ArrayList;

public class Building {
    private int BuildingNum;
    private String BuildName;
    ArrayList<Room>rooms=new ArrayList<>();

    public Building(int buildingNum, String buildName) {
        this.BuildingNum = buildingNum;
        this.BuildName = buildName;
    }
    public void addRoom(Room r){
        rooms.add(r);
    }

    public ArrayList<Room> getRooms() {
        return this.rooms;
    }

    public int getBuildingNum() {
        return BuildingNum;
    }

    public String getBuildName() {
        return BuildName;
    }

    public Room FindRoom(int RoomNum){
        for(int i=0;i<rooms.size();i++){
            if(rooms.get(i).getRoomNum()==RoomNum){
                return rooms.get(i);
            }

        }
        return null;
    }


    public void Printroom(){
        for(int i=0;i<rooms.size();i++){
            System.out.println(rooms.get(i).getRoomName());
        }
    }
}
