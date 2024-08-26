package me.qbitcomputer.discordchatbridge.Listeners;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

public class onMessageDiscord extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (event.getChannel().equals(event.getGuild().getTextChannelById("1275517417681977397"))) {
            if (!event.getAuthor().isBot()) {
                String message = event.getMessage().getContentRaw();
                Bukkit.broadcastMessage(message);

            }
        }
    }
}

