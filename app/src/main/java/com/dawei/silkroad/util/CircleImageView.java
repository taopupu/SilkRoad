package com.dawei.silkroad.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.widget.ImageView;

public class CircleImageView extends ImageView {
    public CircleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        int radius = height > width ? width / 2 : height / 2;
        Paint mPaint = new Paint();
        mPaint.setAntiAlias(true);
        Bitmap bitmap = Bitmap.createBitmap(width, height,
                Bitmap.Config.ARGB_4444);
        Canvas bitmapCanvas = new Canvas(bitmap);
        super.onDraw(bitmapCanvas);
        Bitmap cB = Bitmap.createBitmap(width, height,
                Bitmap.Config.ARGB_4444);
        Canvas cCanv = new Canvas(cB);
        cCanv.drawCircle(width / 2, height / 2, radius,
                mPaint);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, mPaint);
        mPaint.setXfermode(new PorterDuffXfermode(
                PorterDuff.Mode.DST_IN));
        //一定要用之前的画布，不然会出现边角是黑色
        bitmapCanvas.drawBitmap(cB, 0.0f, 0.0f, mPaint);


    }
}
