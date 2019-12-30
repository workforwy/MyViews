package com.example.myviews;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import views.AttributesTool;
import views.BitmapBuffer;
import views.ShapeDrawer;
import views.SystemParams;
import views.drawer.CircleView;
import views.drawer.ImageView;
import views.drawer.LineDrawer;
import views.drawer.OvalDrawer;
import views.drawer.RectDrawer;
import views.drawer.TextDrawer;

public class MainActivity extends AppCompatActivity {
    private ImageView draw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        draw = (ImageView) findViewById(R.id.drawer);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        ShapeDrawer shapeDrawer = null;
        AttributesTool at = AttributesTool.getInstance();

        switch (item.getItemId()) {
            case R.id.redo:
                BitmapBuffer.getInstance().redo();
                SystemParams.isRedo = true;
                draw.invalidate();
                break;
            case R.id.line:
                shapeDrawer = new LineDrawer(draw);
                break;
            case R.id.rect:
                shapeDrawer = new RectDrawer(draw);
                break;
            case R.id.circle:
                shapeDrawer = new CircleView(draw);
                break;
            case R.id.oval:
                shapeDrawer = new OvalDrawer(draw);
                break;
            case R.id.text:
                Intent intent = new Intent(this, TextActivity.class);
                startActivityForResult(intent, 0x002);
                break;
            case R.id.gif:
                Intent intent1 = new Intent(this, GIFActivity.class);
                startActivityForResult(intent1, 0x002);
                break;
            case R.id.black:
                at.setColor(Color.BLACK);
                break;
            case R.id.red:
                at.setColor(Color.RED);
                break;
            case R.id.green:
                at.setColor(Color.GREEN);
                break;
            case R.id.yellow:
                at.setColor(Color.YELLOW);
                break;
            case R.id.blue:
                at.setColor(Color.BLUE);
                break;
            case R.id.b1:
            case R.id.b2:
            case R.id.b3:
            case R.id.b4:
            case R.id.b5:
                String title = item.getTitle().toString();
                int size = Integer.parseInt(title);
                at.setBorderWidth(size);
                break;
            case R.id.fill:
                at.setFill(true);
                break;
            case R.id.stroke:
                at.setFill(false);
                break;
            default:

                break;
        }

        if (shapeDrawer != null) {
            draw.setShapeDrawer(shapeDrawer);
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * 用于画文字
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0x002 && resultCode == 0x001) {
            String text = data.getStringExtra("activity_text");
            int size = Integer.parseInt(data.getStringExtra("size"));
            draw.setShapeDrawer(new TextDrawer(draw, text, size));
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
