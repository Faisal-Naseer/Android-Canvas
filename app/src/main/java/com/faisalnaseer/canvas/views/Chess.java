package com.faisalnaseer.canvas.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.faisalnaseer.canvas.R;

public class Chess extends SurfaceView implements Runnable {
    Thread thread = null;
    Boolean canDraw = false;
    Bitmap chessBackground;
    Canvas canvas;
    SurfaceHolder surfaceHolder;
    public Chess(Context context) {
        super(context);
        chessBackground = BitmapFactory.decodeResource(getResources(),R.drawable.chess_back);
        surfaceHolder = getHolder();

    }

    @Override
    public void run() {
        while(canDraw){
            //Draw here
            if(!surfaceHolder.getSurface().isValid()){
                continue;
            }
            canvas = surfaceHolder.lockCanvas();
            canvas.drawBitmap(chessBackground,0,0,null);
            surfaceHolder.unlockCanvasAndPost(canvas);
        }

    }

    public void onResume(){
        canDraw = true;
        thread = new Thread(this);
        thread.start();
    }

    public void onPause(){
        canDraw = false;
        while(true){
            try{
                thread.join();
                break;
            }catch (Exception ex){
                ex.printStackTrace();
            }

        }
        thread = null;

    }
}
