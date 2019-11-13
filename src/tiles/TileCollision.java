package tiles;

import image_source.Entity;
import tiles.TileMapObj;
import utils.Vector2f;

public class TileCollision {

    private Vector2f pos;
    private float xOffset = 0;
    private float yOffset = 0;
    private float w;
    private float h;
    private float r;
    private int size;
    private Entity e;

    public TileCollision(Vector2f pos, int w, int h) {
        this.pos = pos;
        this.w = w;
        this.h = h;

        size = Math.max(w, h);
    }

    public TileCollision(Vector2f pos, int r, Entity e) {
        this.pos = pos;
        this.r = r;
        this.e = e;

        size = r;
    }

    public float getWidth() {
        return w;
    }

    public void setWidth(float f) {
        w = f;
    }

    public float getHeight() {
        return h;
    }

    public void setHeight(float f) {
        h = f;
    }

    public float getXOffsett() {
        return xOffset;
    }

    public float getYOffset() {
        return yOffset;
    }

    public void setYOffset(float f) {
        yOffset = f;
    }

    public void setXOffset(float f) {
        xOffset = f;
    }

    public boolean collisionTile(float ax, float ay) {
        for (int c = 0; c < 4; c++) {
            int xt = (int) ((pos.x + ax) + (c % 2) * w + xOffset) / 64;
            int yt = (int) ((pos.y + ay) + c / 2 * h + yOffset) / 64;

            if (TileMapObj.tmo_blocks.containsKey(String.valueOf(xt) + "," +String.valueOf(yt))) {
                return TileMapObj.tmo_blocks.get(String.valueOf(xt) + "," + String.valueOf(yt)).update(this);
            }
        }
        return false;
    }
}
