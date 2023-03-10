package com.mcmiddleearth.newplayerworldmaski.handler;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import com.mcmiddleearth.newplayerworldmaski.NewPlayerWorldMaski;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class handlerF {

    public static void execute(Player player, HandlerStates state){
        ItemStack clayHotbar = new ItemStack(Material.CLAY_BALL,1);
        ItemStack clayOffhand = new ItemStack(Material.CLAY_BALL,1);
        ItemMeta clayHotbarMeta = clayHotbar.getItemMeta();
        ItemMeta clayLefthandMeta = clayOffhand.getItemMeta();
        switch(state){
            case ONE:
                clayHotbarMeta.setCustomModelData(450);
                clayLefthandMeta.setCustomModelData(451);
                break;
            case TWO:
                clayHotbarMeta.setCustomModelData(452);
                clayLefthandMeta.setCustomModelData(451);
                break;
            case THREE:
                clayHotbarMeta.setCustomModelData(453);
                clayLefthandMeta.setCustomModelData(451);
                break;
            case FOUR:
                teleportToMain(player);
                player.getInventory().clear();
                return;
        }
        clayHotbar.setItemMeta(clayHotbarMeta);
        clayOffhand.setItemMeta(clayLefthandMeta);
        for(int i = 0; i < 9;i++)
            player.getInventory().setItem(i,clayHotbar);
        player.getInventory().setItem(EquipmentSlot.OFF_HAND,clayOffhand);
    }

    private static void teleportToMain(Player player){
        Plugin connectPlugin = Bukkit.getPluginManager().getPlugin("MCME-Connect");
        if(connectPlugin.isEnabled()){
            ByteArrayDataOutput out = ByteStreams.newDataOutput();
            out.writeUTF("Connect");
            out.writeUTF("main");
            out.writeUTF(player.getName());
            player.sendPluginMessage(NewPlayerWorldMaski.getInstance(),"mcme:connect", out.toByteArray());
        }
    }

    public static HandlerStates getNextStateByItem(Player player){
        int ModelData = player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData();
        switch(ModelData){
            case 450:
                return HandlerStates.TWO;
            case 452:
                return HandlerStates.THREE;
            case 453:
                return HandlerStates.FOUR;
            default:
                return null;
        }
    }
}
