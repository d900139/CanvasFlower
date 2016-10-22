package yzuic.kevinchang.canvasflower;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by user on 2016/10/20.
 */
public class MyView extends View {
    float X = 0;
    float Y = 0;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.RED); //顏色
        paint.setAntiAlias(true); //平滑
        paint.setStrokeWidth(5); //線寬
        paint.setTextSize(50); //字體大小
        paint.setTextAlign(Paint.Align.CENTER); //置中

        float R = 50; //大園半徑
        float r = R * 3 / 5; //小圓半徑
        float high = 3 * R; //花梗長
        float sqrt3 = (float) Math.sqrt(3);

        float width = getWidth();
        float height = getHeight();

        canvas.drawText("X=" + X + " , " + "Y=" + Y, width / 2, height / 8, paint); // 顯示點擊處 x,y 座標

        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL); //填滿;
        canvas.drawCircle(X, Y, R, paint); //中
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE); //空心
        canvas.drawCircle(X - (R + r) / 2, Y - (R + r) / 2 * sqrt3, r, paint); //左上
        canvas.drawCircle(X + (R + r) / 2, Y - (R + r) / 2 * sqrt3, r, paint); //右上
        canvas.drawCircle(X + (R + r), Y, r, paint); //右
        canvas.drawCircle(X + (R + r) / 2, Y + (R + r) / 2 * sqrt3, r, paint); //右下
        canvas.drawCircle(X - (R + r) / 2, Y + (R + r) / 2 * sqrt3, r, paint); //左下
        canvas.drawCircle(X - (R + r), Y, r, paint); //左
        paint.setColor(Color.rgb(138, 54, 15)); //棕色
        canvas.drawLine(X, Y + R, X, Y + R + high, paint); //花梗

        //葉子 - 弧線 : drawArc(float left, float top, float right, float bottom, float startAngle, float sweepAngle, boolean useCenter, Paint paint)
        canvas.drawArc(X - R * 2, Y + high, X, Y + R * 2 + high, 270, 90, false, paint); //左葉上弧
        canvas.drawArc(X - R, Y + R + high - R * 2, X + R, Y + R + high, 90, 90, false, paint); //左葉下弧
        canvas.drawArc(X, Y + high, X + R * 2, Y + R * 2 + high, 180, 90, false, paint); //右葉上弧
        canvas.drawArc(X - R, Y + R + high - R * 2, X + R, Y + R + high, 0, 90, false, paint); //右葉下弧

        paint.setColor(Color.GRAY);
        canvas.drawText("YZUIC 1022059", width / 2, height * 7 / 8, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        X = event.getX();
        Y = event.getY();
        invalidate();
        return super.onTouchEvent(event);
    }

    public MyView(Context context) {
        super(context);
    }
}