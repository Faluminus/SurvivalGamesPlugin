package testing.survivalgamesplugin1;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import testing.survivalgamesplugin1.GlobalVariables.gameVariableHolder;
import testing.survivalgamesplugin1.GlobalVariables.lobbyVariableHolder;

public final class SurvivalGamesPlugin1 extends JavaPlugin {


    @Override
    public void onEnable() {

        try{


            lobbyVariableHolder lobbyVariables = new lobbyVariableHolder();
            gameVariableHolder gameVariables = new gameVariableHolder();


            //commands init

            getCommand("playSG").setExecutor(new SurvivalGamesCommandExecutor(lobbyVariables,gameVariables));
            getLogger().info("playSG command registered and can be used");
            getCommand("placeChest").setExecutor(new SurvivalGamesCommandExecutor(lobbyVariables,gameVariables));
            getLogger().info( "placeChest command registered and can be used");

            //game startup
            while(true) {
                if (lobbyVariables.getPlayers() >= lobbyVariables.getMinPlayers_to_start()) {
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
