package net.azisaba.gamingsara;

import net.azisaba.azipluginmessaging.api.AziPluginMessaging;
import net.azisaba.azipluginmessaging.api.AziPluginMessagingProvider;
import net.azisaba.azipluginmessaging.api.protocol.Protocol;
import net.azisaba.azipluginmessaging.api.protocol.message.PlayerWithServerMessage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class GamingSara extends JavaPlugin {
    @Override
    public void onEnable() {
        Objects.requireNonNull(Bukkit.getPluginCommand("gamingsara")).setExecutor((sender, command, label, args) -> {
            AziPluginMessaging api = AziPluginMessagingProvider.get();
            Protocol.P_TOGGLE_GAMING_SARA.sendPacket(
                    api.getServer().getPacketSender(),
                    new PlayerWithServerMessage(api.getPlayerAdapter(Player.class).get((Player) sender)));
            return true;
        });
    }
}
