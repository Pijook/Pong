package pl.pijok.pong;

import com.badlogic.gdx.graphics.Texture;

public class AssetsManager {

    private Texture ballTexture;
    private Texture racket;

    public void loadAssets(){
        loadTextures();
        loadSounds();
    }

    public void disposeAssets(){
        disposeTextures();
        disposeSounds();
    }

    private void loadTextures(){
        ballTexture = new Texture("ball.png");
        racket = new Texture("racket.png");
    }

    private void loadSounds(){

    }

    private void disposeTextures(){
        ballTexture.dispose();
        racket.dispose();
    }

    private void disposeSounds(){

    }

    public Texture getBallTexture() {
        return ballTexture;
    }

    public Texture getRacket() {
        return racket;
    }
}
