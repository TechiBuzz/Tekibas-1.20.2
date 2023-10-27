package net.techibuzz.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class WeatherTabletItem extends Item {

    public WeatherTabletItem(Settings settings) {
        super(settings);
    }

    /*
    * Change NBT based on weather
    * 1 for Rainy Weather
    * 2 for Thunder
    */
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        NbtCompound newNbtData = new NbtCompound();

        if (!world.isClient) {
            // Weather Check
            if (world.isThundering()) {
                newNbtData.putInt("tekibas.weather_tablet.weather", 2);
            } else if (world.isRaining()) {
                newNbtData.putInt("tekibas.weather_tablet.weather", 1);
            } else {
                if (!stack.hasNbt()) {
                    return TypedActionResult.pass(user.getEquippedStack(EquipmentSlot.MAINHAND));
                }
            }
            stack.setNbt(newNbtData);
        }
        return super.use(world, user, hand);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (context.isCreative()) return;

        if (stack.hasNbt()) {
            int weatherNbt = stack.getNbt().getInt("tekibas.weather_tablet.weather");
            String updatedTooltip = weatherNbt == 1 ? "tooltip.weather_tablet_rainy" : "tooltip.weather_tablet_thundering";
            tooltip.set(0, Text.translatable(updatedTooltip));
        } else {
            tooltip.set(0, Text.translatable("tooltip.weather_tablet_sunny"));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }
}
