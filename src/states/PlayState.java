package states;

import image_source.Player;
import render.Font;
import render.Sprite;
import launch.GamePanel;
import tiles.TileManager;
import input.KeyHandler;
import input.MouseHandler;
import utils.Vector2f;

import javax.swing.*;
import java.awt.*;

public class PlayState extends GameState {

    private Font font;
    private GameStateManager gsm;
    private Player player;
    private TileManager tm;

    public static Vector2f map;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        map = new Vector2f();
        Vector2f.setWorldVar(map.x, map.y);
        tm = new TileManager("tile_map/playerRoomMap.xml");


        font = new Font("tile_font/pixelFont.png", 16, 16);
        player = new Player(new Sprite("image_source/test.png"), new Vector2f((GamePanel.width / 2) - 128, (GamePanel.height / 2) - 128), 135);
    }

    public void update() {
        Vector2f.setWorldVar(map.x, map.y);
        player.update();
    }

    public void input(MouseHandler mouse, KeyHandler key) {
        key.menu.tick();

        if (key.menu.clicked) {
            JOptionPane.showMessageDialog(null, "Inventory opened");
        }

        player.input(mouse, key);

    }

    public void render(Graphics2D g) {
        tm.render(g);
        Sprite.drawArray(g, font, "Press E to open inventory", new Vector2f(70,650), 24, 24, 16, 0);
        player.render(g);
    }
}
