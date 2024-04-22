package testing.survivalgamesplugin1.GlobalVariables;

import testing.survivalgamesplugin1.Commands.PlaceChestSpawnpoint.ChestObject;

public class gameVariableHolder{

    public ChestObject[] chestLocs = new ChestObject[20];

    public void getNewChestLoc(ChestObject chestLoc){
        for(int i = 0; i < chestLocs.length; i++){
            if(chestLocs[i] == null){
                chestLocs[i] = chestLoc;
                break;
            }
        }
    }

}

