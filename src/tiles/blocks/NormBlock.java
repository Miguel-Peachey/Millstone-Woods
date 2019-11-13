package tiles.blocks;

import tiles.TileCollision;
import utils.Vector2f;

import java.awt.*;
import java.awt.image.BufferedImage;

public class NormBlock extends Block{
    public NormBlock(BufferedImage img, Vector2f pos, int w, int h) {
        super(img, pos, w, h);
    }

    public boolean update(TileCollision p) {
        return false;
    }

    public void render(Graphics2D g) {
        super.render(g);
    }
}
