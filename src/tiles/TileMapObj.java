package tiles;

import render.Sprite;
import tiles.blocks.Block;
import tiles.blocks.ObjBlock;
import utils.Vector2f;

import java.awt.*;
import java.util.HashMap;

public class TileMapObj extends TileMap {

    public static HashMap<String, Block> tmo_blocks;

    public TileMapObj(String data, Sprite sprite, int width, int height, int tileWidth, int tileHeight, int tileColumn) {
        Block tempBlock;
        tmo_blocks = new HashMap<String, Block>();

        String[] block = data.split(",");
        for (int i = 0; i < width * height; i++) {
            int temp = Integer.parseInt(block[i].replaceAll("\\s+", ""));
            if (temp != 0) {
                //Creates a solid object for anything except 0 - modify once created player map...
                tempBlock = new ObjBlock(sprite.getSprite((int) ((temp - 1) % tileColumn), (int) ((temp - 1) / tileColumn)), new Vector2f((int) (i % width) * tileWidth, (int) (i / height) * tileHeight), tileWidth, tileHeight);
                tmo_blocks.put(String.valueOf((int) (i % width)) + "," + String.valueOf((int) (i / height)), tempBlock);
            }
        }
    }

    public void render(Graphics2D g) {
        //loop each block for tmo_block
        for (Block block : tmo_blocks.values()) {
            block.render(g);
        }
    }

}
