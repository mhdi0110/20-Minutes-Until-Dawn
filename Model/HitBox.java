package io.github.some_example_name.Model;

public class HitBox {
    float x, y;
    float width, height;

    public HitBox(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void move(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public boolean collidesWith(HitBox hitBox) {
        return x < hitBox.x + hitBox.width && y < hitBox.y + hitBox.height
            && x + width > hitBox.x && y + height > hitBox.y;
    }
}
