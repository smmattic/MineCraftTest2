package edu.unca.smmattic.FlatLands;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

public class FlatLandsTreePopulator extends BlockPopulator {


	public void populate(World world, Random random, Chunk chunk) {
		if (random.nextInt(100) <= 10) {
			TreeType type = (random.nextInt(100) <= 30) ? TreeType.BIG_TREE : TreeType.TREE;
			
		world.generateTree(chunk.getBlock(6 + random.nextInt(4), 21, 6 + random.nextInt(4)).getLocation(), TreeType.TREE);
		}
	}	

}
