package pl.pijok.pong;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import pl.pijok.pong.gameobject.GameObject;
import pl.pijok.pong.gameobject.entity.Ball;
import pl.pijok.pong.gameobject.entity.Entity;
import pl.pijok.pong.gameobject.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Pong extends ApplicationAdapter {

	public static boolean end;
	public static boolean pause;
	public static int score;

	private SpriteBatch batch;

	private AssetsManager assetsManager;
	private Ball ball;
	private Player player1;
	private Player player2;

	private List<GameObject> gameObjects;
	private BitmapFont font;

	@Override
	public void create () {
		//Creating controllers
		assetsManager = new AssetsManager();

		pause = true;
		end = false;
		score = 0;

		batch = new SpriteBatch();
		gameObjects = new ArrayList<>();

		assetsManager.loadAssets();
		font = new BitmapFont();

		ball = new Ball(new Vector2(320, 240), assetsManager.getBallTexture(), 250, gameObjects);
		player1 = new Player(new Vector2(0, 240), assetsManager.getRacket(), 250, Input.Keys.W, Input.Keys.S);
		player2 = new Player(new Vector2(Settings.WIDTH - assetsManager.getRacket().getWidth(), 240), assetsManager.getRacket(), 250, Input.Keys.UP, Input.Keys.DOWN);

		gameObjects.add(ball);
		gameObjects.add(player1);
		gameObjects.add(player2);

	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();

		for(GameObject gameObject : gameObjects){
			batch.draw(gameObject.getTexture(), gameObject.getLocation().x, gameObject.getLocation().y);

			if(!pause && !end){
				if(gameObject instanceof Entity){
					((Entity) gameObject).act(Gdx.graphics.getDeltaTime());
				}
			}
		}

		if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
			if(pause){
				pause = false;
			}
			else{
				pause = true;
			}
		}

		font.getData().setScale(2f);
		font.draw(batch, "Score: " + score, 245, 480);

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();

		assetsManager.disposeAssets();
	}
}
