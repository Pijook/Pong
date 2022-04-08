package pl.pijok.pong.gameobject.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import pl.pijok.pong.Pong;
import pl.pijok.pong.Settings;
import pl.pijok.pong.gameobject.GameObject;

import java.util.List;

public class Ball extends Entity{

    private Vector2 direction;
    private float speed;
    private List<GameObject> gameObjects;

    public Ball(Vector2 location, Texture texture, float speed, List<GameObject> gameObjects) {
        super(location, texture);
        this.direction = new Vector2(10, 10);
        this.speed = speed;
        this.gameObjects = gameObjects;
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        Vector2 directionTemp = direction.cpy();
        directionTemp = directionTemp.nor();
        Vector2 velocity = directionTemp.scl(speed * delta);

        move(getLocation().cpy().add(velocity));

        for(GameObject gameObject : gameObjects){
            if(gameObject instanceof Ball){
                continue;
            }

            if(getRectangle().overlaps(gameObject.getRectangle())){
                Pong.score++;
                speed = speed + 50;
                direction.x = direction.x * -1;
            }
        }

        if(getCenter().x >= Settings.WIDTH || getCenter().x <= 0){
            Pong.end = true;
        }

        if(getCenter().y <= 0 || getCenter().y >= Settings.HEIGHT){
            direction.y = direction.y * -1;
        }
    }

    public Vector2 getDirection() {
        return direction;
    }

    public void setDirection(Vector2 direction) {
        this.direction = direction;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
