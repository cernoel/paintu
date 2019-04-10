package com.example.paintu;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;

import org.junit.Assert;
import org.junit.Before;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

public class DrawRectangleTest {
    Canvas mockCanvas;
    Paint mockPaint;
    MotionEvent mockMotion;
    DrawRectangle drawRectangle;

    @Before
    public void setUp() throws Exception{
        mockCanvas =  Mockito.mock(Canvas.class);
        mockPaint = Mockito.mock(Paint.class);
        mockMotion  = Mockito.mock(MotionEvent.class);
        drawRectangle = new DrawRectangle(mockCanvas, mockPaint);
    }

    public void testDrawRectangle(){
        when(mockMotion.getAction()).thenReturn(MotionEvent.ACTION_DOWN);
        when(mockMotion.getX()).thenReturn(4f);
        when(mockMotion.getY()).thenReturn(4f);

        DrawRectangle.Rectangle rectangle = drawRectangle.draw(mockMotion);
        Assert.assertEquals(rectangle.getLeft(), 4f ,0.00000001f);
        Assert.assertEquals(rectangle.getTop(), 4f ,0.00000001f);


        when(mockMotion.getAction()).thenReturn(MotionEvent.ACTION_MOVE);
        when(mockMotion.getX()).thenReturn(8f);
        when(mockMotion.getY()).thenReturn(8f);
        rectangle = drawRectangle.draw(mockMotion);

        Assert.assertEquals(rectangle.getLeft(), 4f ,0.00000001f);
        Assert.assertEquals(rectangle.getTop(), 4f ,0.00000001f);
        Assert.assertEquals(rectangle.getRight(), 8f ,0.00000001f);
        Assert.assertEquals(rectangle.getBottom(), 8f ,0.00000001f);


        when(mockMotion.getAction()).thenReturn(MotionEvent.ACTION_UP);
        when(mockMotion.getX()).thenReturn(10f);
        when(mockMotion.getY()).thenReturn(10f);
        rectangle = drawRectangle.draw(mockMotion);

        Assert.assertEquals(rectangle.getLeft(), 4f ,0.00000001f);
        Assert.assertEquals(rectangle.getTop(), 4f ,0.00000001f);
        Assert.assertEquals(rectangle.getRight(), 10f ,0.00000001f);
        Assert.assertEquals(rectangle.getBottom(), 10f ,0.00000001f);
    }
}