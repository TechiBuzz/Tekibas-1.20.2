package net.techibuzz.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class WeatherBlock extends Block {

    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final IntProperty WEATHER_SETTING = IntProperty.of("weather_setting", 1, 3);

    public WeatherBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(WEATHER_SETTING, 1));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient && hand.equals(Hand.MAIN_HAND)) {
            if (world.isThundering()) {
                // If already thundering
                if (state.get(WEATHER_SETTING).equals(3)) {
                    return ActionResult.PASS;
                }
                world.setBlockState(pos, state.with(WEATHER_SETTING, 3));
                playSuccessSound(world, pos);
                return ActionResult.SUCCESS;
            } else if (world.isRaining()) {
                // If already rainy
                if (state.get(WEATHER_SETTING).equals(2)) {
                    return ActionResult.PASS;
                }
                world.setBlockState(pos, state.with(WEATHER_SETTING, 2));
                playSuccessSound(world, pos);
                return ActionResult.SUCCESS;
            } else {
                // If already sunny
                if (state.get(WEATHER_SETTING).equals(1)) {
                    return ActionResult.PASS;
                }
                world.setBlockState(pos, state.with(WEATHER_SETTING, 1));
                playSuccessSound(world, pos);
                return ActionResult.SUCCESS;
            }

        }
        return ActionResult.PASS;
    }

    private void playSuccessSound(World world, BlockPos pos) {
        world.playSound(null, pos, SoundEvents.BLOCK_AMETHYST_BLOCK_RESONATE, SoundCategory.BLOCKS);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerLookDirection().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WEATHER_SETTING);
        builder.add(FACING);
    }
}
