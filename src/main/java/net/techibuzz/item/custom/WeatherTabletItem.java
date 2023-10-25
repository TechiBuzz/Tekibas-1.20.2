package net.techibuzz.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class WeatherTabletItem extends Item {

    public WeatherTabletItem(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!stack.hasNbt()) {
            NbtCompound nbtData = new NbtCompound();
            nbtData.putInt("tekibas.weather_tablet.weather", 1);
            stack.setNbt(nbtData);
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    /*
    * Change NBT based on weather
    * 1 for Sunny Weather
    * 2 for Rainy Weather
    * 3 for Thunder
    */
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        NbtCompound newNbtData = new NbtCompound();

        if (!world.isClient) {
            // Weather Check
            if (world.isThundering()) {
                newNbtData.putInt("tekibas.weather_tablet.weather", 3);
            } else if (world.isRaining()) {
                newNbtData.putInt("tekibas.weather_tablet.weather", 2);
            } else {
                newNbtData.putInt("tekibas.weather_tablet.weather", 1);
            }
            stack.setNbt(newNbtData);
        }

        return super.use(world, user, hand);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (stack.hasNbt()) {
            int weatherNbt = stack.getNbt().getInt("tekibas.weather_tablet.weather");
            switch (weatherNbt) {
                case 1:
                    tooltip.clear();
                    tooltip.add(Text.translatable("tooltip.weather_tablet_sunny"));
                case 2:
                    tooltip.clear();
                    tooltip.add(Text.translatable("tooltip.weather_tablet_rainy"));
                case 3:
                    tooltip.clear();
                    tooltip.add(Text.translatable("tooltip.weather_tablet_thundering"));
            }
        }
        super.appendTooltip(stack, world, tooltip, context);
    }
}
