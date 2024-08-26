package me.qbitcomputer.discordchatbridge;

import io.github.cdimascio.dotenv.Dotenv;
import me.qbitcomputer.discordchatbridge.Listeners.onMessageDiscord;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import javax.security.auth.login.LoginException;

public final class Main extends JavaPlugin {

    private ShardManager shardManager;

    public Main() throws LoginException, InterruptedException {
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault("");
        builder.setStatus(OnlineStatus.DO_NOT_DISTURB);
        builder.setActivity(Activity.watching("Kaas"));
        builder.enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_MESSAGES, GatewayIntent.DIRECT_MESSAGES, GatewayIntent.MESSAGE_CONTENT);
        shardManager = builder.build();
        shardManager.addEventListener(
                new onMessageDiscord()
        );


    }
    @Override
    public void onEnable() {
        Bukkit.getLogger().info("starting bridge");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("closing bridge");
    }
}
