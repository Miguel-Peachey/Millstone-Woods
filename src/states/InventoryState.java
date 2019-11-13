package states;

import render.Font;
import render.Sprite;
import input.KeyHandler;
import input.MouseHandler;
import utils.Vector2f;

import java.awt.*;

public class InventoryState extends GameState {

    private Font font;

    public InventoryState(GameStateManager gsm) {
        super(gsm);

        font = new Font("tile_font/pixelFont.png", 16, 16);
    }

    @Override
    public void update() {
    }

    @Override
    public void input(MouseHandler mouse, KeyHandler key) {
    }

    @Override
    public void render(Graphics2D g) {
        Sprite.drawArray(g, font, "New Text", new Vector2f(70, 500), 24, 24, 16, 0);
        render(g);
    }
}
