package me.phuc;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class StackBlock128 extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info("StackBlock128 enabled!");
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getCurrentItem() == null) return;
        if (e.getCurrentItem().getType() == Material.AIR) return;

        Material mat = e.getCurrentItem().getType();

        // Chỉ áp dụng cho block có stack mặc định là 64
        if (!mat.isBlock()) return;
        if (mat.getMaxStackSize() != 64) return;

        e.getCurrentItem().setAmount(
                Math.min(128, e.getCurrentItem().getAmount())
        );
    }
}
