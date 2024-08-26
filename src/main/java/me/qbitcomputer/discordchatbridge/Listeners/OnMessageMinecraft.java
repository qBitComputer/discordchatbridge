package me.qbitcomputer.discordchatbridge.Listeners;


import me.qbitcomputer.discordchatbridge.Main;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class OnMessageMinecraft implements Listener {
    private final JDA api;

    public OnMessageMinecraft(JDA api, long channelId, String content) {
        this.api = api;
    }

    @EventHandler
    public void onMessage(AsyncPlayerChatEvent event) {
        TextChannel channel = api.getTextChannelById("1275517417681977397");
        if (channel != null) {
            channel.sendMessage(event.getMessage()).queue();


        }

    }
}

