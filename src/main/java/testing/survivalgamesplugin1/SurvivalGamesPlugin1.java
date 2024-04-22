package testing.survivalgamesplugin1;
import org.bukkit.plugin.java.JavaPlugin;
import testing.survivalgamesplugin1.values.lobbyVariableHolder;

public final class SurvivalGamesPlugin1 extends JavaPlugin {


    @Override
    public void onEnable() {

        try{

            //lobby
            lobbyVariableHolder lobbyVariables = new lobbyVariableHolder();
            getCommand("playSG").setExecutor(new SurvivalGamesLobbyCommandExecutor(lobbyVariables));
            getLogger().info("playSG command registered and can be used");

            //startup

            while(true)
            {
                if(lobbyVariables.getPlayers() >= lobbyVariables.getMinPlayers_to_start()){
                    //game
                }
                Thread.sleep(2000);
            }
        }
        catch(Exception e){
            getLogger().severe("Error occurred during enabling SurvivalGamesPlugin");
            getLogger().severe(e.toString());
        };
    }

    @Override
    public void onDisable() {

    }
}
