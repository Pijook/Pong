package pl.pijok.pong.gameobject.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import pl.pijok.pong.Settings;

public class Player extends Entity {

    private int upKey;
    private int downKey;
    private float speed;

    public Player(Vector2 location, Texture texture, float speed, int upKey, int downKey) {
        super(location, texture);
        this.speed = speed;
        this.upKey = upKey;
        this.downKey = downKey;
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if(Gdx.input.isKeyPressed(upKey)){
            if(getLocation().y < Settings.HEIGHT - getTexture().getHeight()){
                Vector2 direction = new Vector2(0, 1);
                direction = direction.scl(speed * delta);
                //getLocation().add(direction);
                move(getLocation().cpy().add(direction));
            }
        }
        if(Gdx.input.isKeyPressed(downKey)){
            if(getLocation().y > 0){
                Vector2 direction = new Vector2(0, -1);
                direction.scl(speed * delta);
                //getLocation().add(direction);
                move(getLocation().cpy().add(direction));
            }
        }
    }

    public int getUpKey() {
        return upKey;
    }

    public void setUpKey(int upKey) {
        this.upKey = upKey;
    }

    public int getDownKey() {
        return downKey;
    }

    public void setDownKey(int downKey) {
        this.downKey = downKey;
    }
}
