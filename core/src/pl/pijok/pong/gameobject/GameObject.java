package pl.pijok.pong.gameobject;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class GameObject {

    private Vector2 location;
    private Texture texture;
    private Rectangle rectangle;

    public GameObject(Vector2 location, Texture texture) {
        this.location = location;
        this.texture = texture;
        this.rectangle = new Rectangle(location.x, location.y, texture.getWidth(), texture.getHeight());
    }

    public void move(Vector2 vector2){
        location.x = vector2.x;
        location.y = vector2.y;
        rectangle.x = vector2.x;
        rectangle.y = vector2.y;
    }

    public Vector2 getLocation() {
        return location;
    }

    public void setLocation(Vector2 location) {
        this.location = location;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public Vector2 getCenter(){
        return new Vector2(getLocation().x + texture.getWidth() / 2, getLocation().y + texture.getHeight() / 2);
    }
}
