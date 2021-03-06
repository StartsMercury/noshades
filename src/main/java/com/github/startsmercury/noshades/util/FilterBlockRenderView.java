package com.github.startsmercury.noshades.util;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.BlockStateRaycastContext;
import net.minecraft.world.LightType;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.chunk.light.LightingProvider;
import net.minecraft.world.level.ColorResolver;

public class FilterBlockRenderView implements AutoCloseable, BlockRenderView {
	private BlockRenderView delegate;

	protected FilterBlockRenderView(final BlockRenderView delegate) {
		this.delegate = delegate;
	}

	@Override
	public void close() throws Exception {
		this.delegate = null;
	}

	@Override
	public int countVerticalSections() {
		return this.delegate.countVerticalSections();
	}

	@Override
	public int getBaseLightLevel(final BlockPos pos, final int ambientDarkness) {
		return this.delegate.getBaseLightLevel(pos, ambientDarkness);
	}

	@Override
	public BlockEntity getBlockEntity(final BlockPos pos) {
		return this.delegate.getBlockEntity(pos);
	}

	@Override
	public <T extends BlockEntity> Optional<T> getBlockEntity(final BlockPos pos, final BlockEntityType<T> type) {
		return this.delegate.getBlockEntity(pos, type);
	}

	@Override
	public BlockState getBlockState(final BlockPos pos) {
		return this.delegate.getBlockState(pos);
	}

	@Override
	public int getBottomSectionCoord() {
		return this.delegate.getBottomSectionCoord();
	}

	@Override
	public int getBottomY() {
		return this.delegate.getBottomY();
	}

	@Override
	public float getBrightness(final Direction direction, final boolean shaded) {
		return this.delegate.getBrightness(direction, shaded);
	}

	@Override
	public int getColor(final BlockPos pos, final ColorResolver colorResolver) {
		return this.delegate.getColor(pos, colorResolver);
	}

	@Override
	public double getDismountHeight(final BlockPos pos) {
		return this.delegate.getDismountHeight(pos);
	}

	@Override
	public double getDismountHeight(final VoxelShape blockCollisionShape,
			final Supplier<VoxelShape> belowBlockCollisionShapeGetter) {
		return this.delegate.getDismountHeight(blockCollisionShape, belowBlockCollisionShapeGetter);
	}

	@Override
	public FluidState getFluidState(final BlockPos pos) {
		return this.delegate.getFluidState(pos);
	}

	@Override
	public int getHeight() {
		return this.delegate.getHeight();
	}

	@Override
	public LightingProvider getLightingProvider() {
		return this.delegate.getLightingProvider();
	}

	@Override
	public int getLightLevel(final LightType type, final BlockPos pos) {
		return this.delegate.getLightLevel(type, pos);
	}

	@Override
	public int getLuminance(final BlockPos pos) {
		return this.delegate.getLuminance(pos);
	}

	@Override
	public int getMaxLightLevel() {
		return this.delegate.getMaxLightLevel();
	}

	@Override
	public int getSectionIndex(final int y) {
		return this.delegate.getSectionIndex(y);
	}

	@Override
	public Stream<BlockState> getStatesInBox(final Box box) {
		return this.delegate.getStatesInBox(box);
	}

	@Override
	public int getTopSectionCoord() {
		return this.delegate.getTopSectionCoord();
	}

	@Override
	public int getTopY() {
		return this.delegate.getTopY();
	}

	@Override
	public boolean isOutOfHeightLimit(final BlockPos pos) {
		return this.delegate.isOutOfHeightLimit(pos);
	}

	@Override
	public boolean isOutOfHeightLimit(final int y) {
		return this.delegate.isOutOfHeightLimit(y);
	}

	@Override
	public boolean isSkyVisible(final BlockPos pos) {
		return this.delegate.isSkyVisible(pos);
	}

	@Override
	public BlockHitResult raycast(final BlockStateRaycastContext context) {
		return this.delegate.raycast(context);
	}

	@Override
	public BlockHitResult raycast(final RaycastContext context) {
		return this.delegate.raycast(context);
	}

	@Override
	public BlockHitResult raycastBlock(final Vec3d start, final Vec3d end, final BlockPos pos, final VoxelShape shape,
			final BlockState state) {
		return this.delegate.raycastBlock(start, end, pos, shape, state);
	}

	@Override
	public int sectionCoordToIndex(final int coord) {
		return this.delegate.sectionCoordToIndex(coord);
	}

	@Override
	public int sectionIndexToCoord(final int index) {
		return this.delegate.sectionIndexToCoord(index);
	}
}
