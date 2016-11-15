package rittiner.damotamarques.pong;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by fabio on 15.11.2016.
 */

public class DrawView extends View {

    Paint paint = new Paint();

    private int screenWidth;
    private int screeHeight;

    private int playerWidth;
    private int playerHeight;

    private Rect player1;
    private Rect player2;

    private Point ball;

    public DrawView(Context context) {
        super(context);

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screenWidth = size.x;
        screeHeight = size.y;

        playerWidth = 400;
        playerHeight = 150;

        int left = (screenWidth/2) - (playerWidth/2);
        int right = (screenWidth/2) - (playerWidth/2) + playerWidth;

        int topPlayer1 = 0;
        int bottomPlayer1 = playerHeight;

        int topPlayer2 = screeHeight-playerHeight;
        int bottomPlayer2 = screeHeight;

        player1 = new Rect(left, topPlayer1, right, bottomPlayer1) ;
        player2 = new Rect(left, topPlayer2, right, bottomPlayer2 );

        ball = new Point(screenWidth/2, screeHeight/2);
    }

    @Override
    public void onDraw(Canvas canvas) {
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(50);
        canvas.drawRect(player1, paint);
        canvas.drawRect(player2, paint);
        canvas.drawCircle(ball.x, ball.y, 100, paint);
    }
}
