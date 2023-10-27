package net.techibuzz.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.techibuzz.item.ModItems;
import net.techibuzz.sound.ModSounds;
import net.techibuzz.util.InventoryUtil;
import net.techibuzz.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MetalDetectorItem extends Item {

    public MetalDetectorItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (!context.getWorld().isClient) {
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;
            // Loop for every block below player
            for (int i = 0; i <= positionClicked.getY() + 64; i++) {
                BlockState blockState = context.getWorld().getBlockState(positionClicked.down(i));
                if (isValuable(blockState)) {
                    foundBlock = true;
                    outputValuableBlockCoords(positionClicked.down(i), player, blockState.getBlock());

                    if (InventoryUtil.hasPlayerStackInInventory(player, ModItems.DATA_TABLET)) {
                        addNbtDataToDataTablet(player, positionClicked.down(i), blockState.getBlock());
                    }

                    context.getWorld().playSound(null, positionClicked, ModSounds.METAl_DETECTOR_FOUND_ORE, SoundCategory.BLOCKS);

                    break; // Remove if you want all possible ores
                }
            }
            // Fail result
            if (!foundBlock) {
                player.sendMessage(Text.literal("No Valuable Found!"));
                return ActionResult.FAIL;
            } else {
                return ActionResult.SUCCESS;
            }

        }

        context.getStack().damage(1, context.getPlayer(),
                playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));

        return ActionResult.PASS;
    }

    private void addNbtDataToDataTablet(PlayerEntity player, BlockPos pos, Block block) {
        ItemStack dataTabletStack = player.getInventory().getStack(InventoryUtil.getFirstInventoryIndex(player, ModItems.DATA_TABLET));

        NbtCompound nbtData = new NbtCompound();
        nbtData.putString("tekibas.last_valuable_found", "Valuable Found: " + block.getName().getString() + " at (" +
                pos.getX() + ", " + pos.getY() + ", " + pos.getZ() + ")");

        dataTabletStack.setNbt(nbtData);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (!Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.metal_detector_shift"));
        } else {
            tooltip.add(Text.translatable("tooltip.metal_detector_1"));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }

    private void outputValuableBlockCoords(BlockPos pos, PlayerEntity player, Block block) {
        player.sendMessage(Text.literal("Valuable Found: " + block.getName().getString() + " at (" +
                pos.getX() + ", " + pos.getY() + ", " + pos.getZ() + ")"));
    }

    private boolean isValuable(BlockState blockState) {
        return blockState.isIn(ModTags.Blocks.METAL_DETECTOR_DETECTABLE_BLOCKS);
    }
}
