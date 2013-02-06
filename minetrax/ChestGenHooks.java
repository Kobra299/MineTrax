/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minetrax;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;

/**
 *
 * @author DarkSnake
 */
public class ChestGenHooks {

    public static void registerChestGenHooks(Item Item, int min, int max, int rarity) //For our non-custom records items/blocks(?)
    {
        net.minecraftforge.common.ChestGenHooks.getInfo(net.minecraftforge.common.ChestGenHooks.BONUS_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(Item), min, max, rarity));
        net.minecraftforge.common.ChestGenHooks.getInfo(net.minecraftforge.common.ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(Item), min, max, rarity));
        net.minecraftforge.common.ChestGenHooks.getInfo(net.minecraftforge.common.ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(Item), min, max, rarity));
        net.minecraftforge.common.ChestGenHooks.getInfo(net.minecraftforge.common.ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(Item), min, max, rarity));
        net.minecraftforge.common.ChestGenHooks.getInfo(net.minecraftforge.common.ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(Item), min, max, rarity));
        net.minecraftforge.common.ChestGenHooks.getInfo(net.minecraftforge.common.ChestGenHooks.PYRAMID_JUNGLE_DISPENSER).addItem(new WeightedRandomChestContent(new ItemStack(Item), min, max, rarity));
        net.minecraftforge.common.ChestGenHooks.getInfo(net.minecraftforge.common.ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(Item), min, max, rarity));
        net.minecraftforge.common.ChestGenHooks.getInfo(net.minecraftforge.common.ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(Item), min, max, rarity));
        net.minecraftforge.common.ChestGenHooks.getInfo(net.minecraftforge.common.ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(Item), min, max, rarity));
        net.minecraftforge.common.ChestGenHooks.getInfo(net.minecraftforge.common.ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(Item), min, max, rarity));

    }
}
