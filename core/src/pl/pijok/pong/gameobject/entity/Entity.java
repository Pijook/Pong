package pl.pijok.pong.gameobject.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import pl.pijok.pong.gameobject.GameObject;

public abstract class Entity extends GameObject {

    public Entity(Vector2 location, Texture texture) {
        super(location, texture);
    }

    public void act(float delta){

    }
}
