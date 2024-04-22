package testing.survivalgamesplugin1.Commands.PlaceChestSpawnpoint;

import org.bukkit.Location;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import testing.survivalgamesplugin1.GlobalVariables.gameVariableHolder;

public class PlaceChestSpawnpoint{

    gameVariableHolder gameVariables;
    public PlaceChestSpawnpoint(gameVariableHolder gameVariables) {
        this.gameVariables = gameVariables;
    }

    public void PlaceChestSpawnpointCommand(CommandSender sender, String[] args){

        if(sender instanceof Player){
            Player player = (Player) sender;
            Location playerLocation = player.getLocation();

            double x = playerLocation.getX();
            double y = playerLocation.getY();
            double z = playerLocation.getZ();
            float yaw = playerLocation.getYaw();
            float pitch = playerLocation.getPitch();

            gameVariables.getNewChestLoc(new ChestObject(x,y,z,yaw,pitch));

            sender.sendMessage("Chest location placed");
        }



    }
}
