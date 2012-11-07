package edu.unca.smmattic.FlatLands;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;

public class FlatLandsGenerator extends ChunkGenerator {

	private FlatLands plugin;

	public FlatLandsGenerator(FlatLands instance) {
		this.plugin = instance;
	}

	public List<BlockPopulator> getDefaultPopulators(World world) {
		ArrayList<BlockPopulator> populators = new ArrayList<BlockPopulator>();
		
		populators.add(new FlatLandsTreePopulator());
		
		return populators;
	}

	public Location getFixedSpawnLocation(World world, Random random) {
		return new Location(world, 0, 5, 0);
	}

	private int coordsToInt(int x, int y, int z) {
		return (x * 16 + z) * 128 + y;
	}

	public byte[] generate(World world, Random random, int chunkX, int chunkZ) {
		byte[] blocks = new byte[32768];
		int x, y, z;

		for (x = 0; x < 16; ++x) {
			for (z = 0; z < 16; ++z) {
				blocks[this.coordsToInt(x, 0, z)] = (byte) Material.BEDROCK
						.getId();

				for (y = 1; y < 20; ++y) {
					if (y == 1) {
						blocks[this.coordsToInt(x, y, z)] = (byte) Material.DIAMOND_ORE.getId();
					} else if (y == 2) {
						blocks[this.coordsToInt(x, y, z)] = (byte) Material.EMERALD_ORE.getId();
					} else if (3 == y || y == 4) {
						blocks[this.coordsToInt(x, y, z)] = (byte) Material.GLOWSTONE.getId();
					} else if (5 == y) {
						blocks[this.coordsToInt(x, y, z)] = (byte) Material.IRON_ORE.getId();
					} else if (6 == y) {
						blocks[this.coordsToInt(x, y, z)] = (byte) Material.COAL.getId();
					} else if (7 == y || y == 8) {
						blocks[this.coordsToInt(x, y, z)] = (byte) Material.STONE.getId();
					} else if (9 == y || y == 10) {
						blocks[this.coordsToInt(x, y, z)] = (byte) Material.IRON_ORE.getId();
					} else if (11 == y || y == 12) {
						blocks[this.coordsToInt(x, y, z)] = (byte) Material.COAL.getId();
					} else if (13 == y || y == 14) {
						blocks[this.coordsToInt(x, y, z)] = (byte) Material.STONE.getId();
					} else if (15 <= y || y >= 18) {
						blocks[this.coordsToInt(x, y, z)] = (byte) Material.DIRT.getId();
					} else if (y == 19) {
						blocks[this.coordsToInt(x, 19, z)] = (byte) Material.SAND.getId();
					}
				}
				blocks[this.coordsToInt(x, 20, z)] = (byte) Material.WATER.getId();
			}
		}
		return blocks;
	}
}
