package minetrax;

import java.io.File;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

public class CreeperDiscDrops {
        @ForgeSubscribe
    public void entityDrops(LivingDropsEvent var1) {
        EntityLiving var2 = var1.entityLiving;
        DamageSource var3 = var1.source;
        boolean var4 = var1.recentlyHit;
        if (var4 && var3.getEntity() instanceof EntitySkeleton) {
            if (var2 instanceof EntityCreeper) {
var1.drops.add(new EntityItem(var2.worldObj, var2.posX, var2.posY, var2.posZ, new ItemStack(DataProxyMineTrax.blankDisc, 1))); //I don't know how to add the music discs to the creeper's drop table when killed by skeleton! :(
                    
            }

        }
    }
    
    
    
    
    
    
    
    
    
}