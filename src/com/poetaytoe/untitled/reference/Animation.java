package com.poetaytoe.untitled.reference;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

public class Animation {

	public int x;
	public int y;
	
	private int numFrames;
	private int frameWidth;
	private int frameHeight;
	private int currentFrame;
	private int FrameOffset;
	private int FrameEnd;
	
	private long startTime;
	private long stopTime;
	private long delayTime;
	private long beginDelay;
	private long Created;
	
	private boolean repeat;
	private boolean running;
	
	private BufferedImage picture;
	
	public Animation (BufferedImage image, int initX, int initY, int width, int height, int frames, long changeDelay, long startDelay, boolean doesRepeat)
	{
		picture = image;
		x = initX;
		y = initY;
		frameWidth = width;
		frameHeight = height;
		numFrames = frames;
		currentFrame = 0;
		delayTime = changeDelay;
		beginDelay = startDelay;
		repeat = doesRepeat;
		
		Created = System.currentTimeMillis();
		startTime = Created + beginDelay;
		stopTime = startTime + delayTime;
		
		FrameOffset = 0;
		FrameEnd = FrameOffset + width;
		
		running = true;
	}
	
	private void Update()
	{
		if(stopTime <= System.currentTimeMillis()) {
			currentFrame++;
			if (currentFrame >= numFrames) {
				if (repeat)
					running = true;
				else
					running = false;
				currentFrame = 0;
			}

			FrameOffset = frameWidth * currentFrame;
			FrameEnd = FrameOffset + frameWidth;
			startTime = System.currentTimeMillis();
			stopTime = startTime + delayTime;
		}
	}
	
	public void Make(Graphics2D screen)
    {
        Update();
        
        if(Created + beginDelay <= System.currentTimeMillis())
            screen.drawImage(picture, x, y, x + frameWidth, y + frameHeight, FrameOffset, 0, FrameEnd, frameHeight, null);
    }
	
	public void setPos(int newX, int newY)
	{
		x = newX;
		y = newY;
	}
}
