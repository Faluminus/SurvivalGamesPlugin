package testing.survivalgamesplugin1;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import testing.survivalgamesplugin1.Commands.PlaceChestSpawnpoint.PlaceChestSpawnpoint;
import testing.survivalgamesplugin1.Commands.SGLobby;
import testing.survivalgamesplugin1.GlobalVariables.gameVariableHolder;
import testing.survivalgamesplugin1.GlobalVariables.lobbyVariableHolder;


public class SurvivalGamesCommandExecutor implements CommandExecutor{

    gameVariableHolder gameVariableHolder;
    lobbyVariableHolder lobbyVariableHolder;
    public SurvivalGamesCommandExecutor(lobbyVariableHolder variableHolder,gameVariableHolder gameVariableHolder) {
        this.lobbyVariableHolder = variableHolder;
        this.gameVariableHolder = gameVariableHolder;
    }


    @Override
    public boolean onCommand(@NotNull CommandSender sender,@NotNull Command command,@NotNull String label, String[] args) {
        switch (command.getUsage()) {
            case "/playSG":
                new SGLobby(lobbyVariableHolder).PlaySGCommand(sender,args);
                return true;
            case "/placeChest":
                new PlaceChestSpawnpoint(gameVariableHolder).PlaceChestSpawnpointCommand(sender,args);
            default:
                return false;
        }
    }
}
