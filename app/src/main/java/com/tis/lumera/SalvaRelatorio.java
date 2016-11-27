package com.tis.lumera;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by Tis on 27/11/2016.
 */
public class SalvaRelatorio {

    public void salva(Context ctx, View view) {
        Bitmap bm = getBitmapFromView(view);
        saveBitmap(ctx, bm, "relatorio_gerado.png");
    }

    public Bitmap getBitmapFromView(View view) {

        Bitmap returnedBitmap = Bitmap.createBitmap(view.getMeasuredWidth(),
                view.getMeasuredHeight() , Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(returnedBitmap);
        Drawable bgDrawable = view.getBackground();
        if (bgDrawable != null)
            bgDrawable.draw(canvas);
        else
            canvas.drawColor(Color.WHITE);
        view.draw(canvas);
        return returnedBitmap;
    }

    private static File saveBitmap(Context ctx, Bitmap bm, String fileName){
        MediaStore.Images.Media.insertImage(ctx.getContentResolver(), bm, "Relatorio" , "");

        File dir = ctx.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File file = new File(dir, fileName);
        try {
            FileOutputStream fOut = new FileOutputStream(file);
            bm.compress(Bitmap.CompressFormat.PNG, 90, fOut);
            fOut.flush();
            fOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }
}
