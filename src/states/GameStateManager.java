package states;

import launch.GamePanel;
import input.KeyHandler;
import input.MouseHandler;
import utils.Vector2f;

import java.awt.Graphics2D;

public class GameStateManager {

    private GameState states[];

    public static Vector2f map;

    public static final int PLAY = 0;
    public static final int INVENTORY = 1;
    public static final int PAUSE = 2;
    public static final int GAMEOVER = 3;

    public GameStateManager() {
        map = new Vector2f(GamePanel.width, GamePanel.height);
        Vector2f.setWorldVar(map.x, map.y);
        states = new GameState[5];

        states[PLAY] = new PlayState(this);
    }

    public void pop(int state) {
        states[state] = null;
    }

    public void add(int state) {
        if (states[state] != null)
            return;

        if (state == PLAY) {
            states[PLAY] = new PlayState(this);
        } else if (state == INVENTORY) {
            states[INVENTORY] = new MenuState(this);
        } else if (state == PAUSE) {
            states[PAUSE] = new PauseState(this);
        }
    }

    public void addAndpop(int state) {
    }

    public boolean isStateActive(int state) {
        return states[state] != null;
    }

    public void update() {
        Vector2f.setWorldVar(map.x, map.y);
        for (int i = 0; i < states.length; i++) {
            if (states[i] != null) {
                states[i].update();
            }
        }
    }

    public void input(MouseHandler mouse, KeyHandler key) {
        for (int i = 0; i < states.length; i++) {
            if (states[i] != null) {
                states[i].input(mouse, key);
            }
        }
    }

    public void render(Graphics2D g) {
        for (int i = 0; i < states.length; i++) {
            if (states[i] != null) {
                states[i].render(g);
            }
        }
    }
}
