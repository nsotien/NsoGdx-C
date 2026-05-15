package com.monkey.nso.lib;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class TextureService {

    public static TextureService instance = new TextureService();

    public Texture loadTextureAsync(String name){
        if(name.startsWith("/")){
            name = name.substring(1);
        }
        if (Thread.currentThread().getName().equals("Main")) {
            return loadTexture(name);
        } else {
            final AtomicReference<Texture> textureHolder = new AtomicReference<>();
            final CountDownLatch latch = new CountDownLatch(1);
            String sname = name;
            Gdx.app.postRunnable(() -> {
                textureHolder.set(loadTexture(sname));
                latch.countDown();
            });

            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return textureHolder.get();
        }
    }

    public Texture loadTexture(String name){
        return new Texture(Gdx.files.internal("Nso/"+name));
    }

    public Texture createTexuteAsync(byte[] bytes){
        if (Thread.currentThread().getName().equals("Main")) {
            return loadTexture(bytes);
        } else {
            final AtomicReference<Texture> textureHolder = new AtomicReference<>();
            final CountDownLatch latch = new CountDownLatch(1);
            Gdx.app.postRunnable(() -> {
                textureHolder.set(loadTexture(bytes));
                latch.countDown();
            });

            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return textureHolder.get();
        }
    }

    public Texture loadTexture(byte[] bytes){
        if(bytes == null){
            return null;
        }
        Pixmap pixmap = new Pixmap(bytes,0,bytes.length);
        return new Texture(pixmap);
    }

    public Pixmap createPixelMap(int w,int h){
        return new Pixmap(w,h, Pixmap.Format.RGBA8888);
    }
}
