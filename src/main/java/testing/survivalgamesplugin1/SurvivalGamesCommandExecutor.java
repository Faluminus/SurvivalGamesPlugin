package testing.survivalgamesplugin1;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import testing.survivalgamesplugin1.Commands.SGLobby;
import testing.survivalgamesplugin1.values.lobbyVariableHolder;


public class SurvivalGamesCommandExecutor implements CommandExecutor{

    lobbyVariableHolder variableHolder;
    public SurvivalGamesCommandExecutor(lobbyVariableHolder variableHolder) {
        this.variableHolder = variableHolder;
    }


    @Override
    public boolean onCommand(@NotNull CommandSender sender,@NotNull Command command,@NotNull String label, String[] args) {
        switch (command.toString()) {
            case "playSG":
                new SGLobby(variableHolder).PlaySGCommand(sender,args);
                return true;
            default:
                return false;
        }
    }
}
