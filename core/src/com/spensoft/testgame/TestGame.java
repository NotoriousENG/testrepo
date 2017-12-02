package com.spensoft.testgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TestGame extends ApplicationAdapter {
	SpriteBatch batch;
	DeckOfCards popo;
	Card card;
	Card [] cardz = new Card[12];


	@Override
	public void create () {
		batch = new SpriteBatch();
		popo = new DeckOfCards();
		popo.shuffle(50);
		for (int i = 0; i < 12; i++) {
			cardz[i] = popo.deal();
		}
	}

	@Override
	public void render () {
		if (Gdx.input.isKeyPressed(Input.Keys.A)) {
			Gdx.gl.glClearColor(0, 0, 1, 1);
		}
		else {
			Gdx.gl.glClearColor(0, 1, 0, 1);
		}
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		int x = 0;
		for (Card element : cardz) {
			if (element != null) {
				batch.draw(element.getFace(), x, 0);
				x = x + 73;
			}
		}
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}

