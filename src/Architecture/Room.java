package Architecture;

import java.util.ArrayList;

public class Room {
    private int RoomNum;
    private String RoomName;
    ArrayList<Ward>wards=new ArrayList<>();

    public void Addward(Ward w){
      wards.add(w);
    }

    public Room(int roomNum, String roomName) {
        this.RoomNum = roomNum;
        this.RoomName = roomName;

    }

    public int getRoomNum() {
        return RoomNum;
    }

    public String getRoomName() {
        return RoomName;
    }

    public void PrintWard(){
        for(int i=0;i<wards.size();i++){
            System.out.println(wards.get(i).getWardNum());
        }
    }


}
