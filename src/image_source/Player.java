package image_source;

import render.Sprite;
import states.PlayState;
import input.KeyHandler;
import input.MouseHandler;
import utils.Vector2f;

import java.awt.*;

public class Player extends Entity {

    public Player(Sprite sprite, Vector2f origin, int size) {
        super(sprite, origin, size);
        acc = 2f;
        maxSpeed = 3f;
        bounds.setWidth(50);
        bounds.setHeight(48);
        bounds.setXOffset(50); //50
        bounds.setYOffset(96); //96
    }

    public void move() {

        if (up) {
            dy -= acc;
            if (dy < -maxSpeed) {
                dy = -maxSpeed;
            }
        } else {
            if (dy < 0) {
                dy += deacc;
                if (dy > 0) {
                    dy = 0;
                }
            }
        }
        if (down) {
            dy += acc;
            if (dy > maxSpeed) {
                dy = maxSpeed;
            }
        } else {
            if (dy > 0) {
                dy -= deacc;
                if (dy < 0) {
                    dy = 0;
                }
            }
        }
        if (left) {
            dx -= acc;
            if (dx < -maxSpeed) {
                dx = -maxSpeed;
            }
        } else {
            if (dx < 0) {
                dx += deacc;
                if (dx > 0) {
                    dx = 0;
                }
            }
        }
        if (right) {
            dx += acc;
            if (dx > maxSpeed) {
                dx = maxSpeed;
            }
        } else {
            if (dx > 0) {
                dx -= deacc;
                if (dx < 0) {
                    dx = 0;
                }
            }
        }
    }

    public void update() {
        super.update();
        move();

        if (!bounds.collisionTile(dx, 0)) {
            PlayState.map.x += dx;
            pos.x += dx;
        }
        if (!bounds.collisionTile(0, dy)) {
            PlayState.map.y += dy;
            pos.y += dy;
        }
    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(ani.getImage(), (int) (pos.getWorldVar().x), (int) (pos.getWorldVar().y), size, size, null);
    }

    public void input(MouseHandler mouse, KeyHandler key) {

        if (mouse.getButton() == 1) {
            System.out.println("Player: " + pos.x + ", " + pos.y);
        }

        if (key.menu.down) {
        }

        up = key.up.down;
        down = key.down.down;
        left = key.left.down;
        right = key.right.down;
        attack = key.attack.down;
    }
}
