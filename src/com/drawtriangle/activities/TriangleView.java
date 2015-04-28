package com.drawtriangle.activities;

import java.text.DecimalFormat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Path.FillType;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

public class TriangleView extends View {
	private Point point1, point2, point3;
	private Path path;
	private double length1, length2, angle1, length3, angle2, angle3;
	private Paint paint;
	private int toggle;
	private double scalingFactor;
	private double ratioWidthPoint3X;

	public TriangleView(Context context) {
		super(context);
	
	}

	public int getToggle() {
		return toggle;
	}

	public void setToggle(int toggle) {
		this.toggle = toggle;
	}

	public double getLength1() {
		return length1;
	}

	public void setLength1(double length1) {
		this.length1 = length1;
	}

	public double getLength2() {
		return length2;
	}

	public void setLength2(double length2) {
		this.length2 = length2;
	}

	public double getAngle1() {
		return angle1;
	}

	public void setAngle1(double angle1) {
		this.angle1 = angle1;
	}

	public double getLength3() {
		return length3;
	}

	public void setLength3(double length3) {
		this.length3 = length3;
	}

	public double getAngle2() {
		return angle2;
	}

	public void setAngle2(double angle2) {
		this.angle2 = angle2;
	}

	public double getAngle3() {
		return angle3;
	}

	public void setAngle3(double angle3) {
		this.angle3 = angle3;
	}

	private int getPx(int length) {

		double value = length * scalingFactor;
		int scaleValue = (int) value;
		return scaleValue;
	}

	private void setScaling(double length) {
		scalingFactor = getWidth() - 40;

		scalingFactor = scalingFactor / length;
	}

	private double degreeToRadian(double degree) {
		double radianValue = 0.017;
		double radianAngle = degree * radianValue;
		return radianAngle;
	}

	private int drawX(int length) {
		int width = getWidth() - 40;
		double scaleLength1 = width - length1;
		scaleLength1 = scaleLength1 / 2;
		int scaledlength1 = (int) scaleLength1;
	
		return scaledlength1;
	}

	private void drawPoints(int length1, int length2, double angle1) {
		double maxLength = Math.max(this.length1, this.length2);
		maxLength = Math.max(maxLength, length3);
		setScaling(maxLength);
		length1 = getPx(length1);
		int scaledlength1 = drawX(length1);
		scaledlength1 = scaledlength1 / 2;
		length2 = getPx(length2);
		angle1 = degreeToRadian(angle1);
		int xCoordinate = (int) (scaledlength1 + 20);
		int yCoodinate = getHeight() / 2;
		int half = length2 / 2;

		if (toggle == 0) {
			yCoodinate = yCoodinate + half;
		} else {
			yCoodinate = yCoodinate + 0;
		}

		point1 = new Point(xCoordinate, yCoodinate);
		int sum = length1 + xCoordinate;
		point2 = new Point(sum, yCoodinate);

		double cos = 0;
		Log.d("cos value", cos + "");
		if (angle1 < 90) {
			cos = Math.cos(angle1);
		} else if (angle1 > 90) {
			cos = Math.acos(angle1);
		}
		cos = cos * length2;
		double xStart = length1 + xCoordinate;
		double cx = cos + xStart;
		double sin = Math.sin(angle1);
		sin = sin * length2;
		double yStart = yCoodinate;
		double cy = yStart - sin;
		int ccx = (int) cx;
		int ccy = (int) cy;
		point3 = new Point(ccx, ccy);
		}

	private void triangleCalculations() {
		if (this.toggle == 0) {
			int length1 = (int) this.length1;
			// int length1=(int) maxLength;
			int length2 = (int) this.length2;
			double angle1 = this.angle1;
			drawPoints(length1, length2, angle1);

		} else if (this.toggle == 1) {

			int length1 = (int) this.length1;
			int length2 = (int) this.length2;
			double angle1 = this.angle1;
			drawPoints(length1, length2, angle1);

		}
	}

	private double getFactor(int xPoint, int width) {
		double factor = width / xPoint;

		return factor;
	}

	private float pointsDifference(float p1, float p2) {
		float sum = p1 + p2;
		sum = sum / 2;
		return sum;
	}

	private float pointsDifferenc(int p1, int p2) {
		float sum = p1 + p2;
		sum = sum / 2;
		return sum;
	}

	private String numberFormatter(double length) {
		DecimalFormat numberFormat = new DecimalFormat("#.0");

		String formatLength = numberFormat.format(length) + "";
		return formatLength;
	}
	private void setPaintProperties(Canvas canvas){
		paint = new Paint();
		paint.setColor(android.graphics.Color.WHITE);
		canvas.drawPaint(paint);
		paint.setStrokeWidth(5);
		paint.setColor(android.graphics.Color.WHITE);
		paint.setStyle(Paint.Style.STROKE);
		paint.setAntiAlias(true);
		 path = new Path();
		path.setFillType(FillType.EVEN_ODD);
		paint.setColor(Color.RED);
		paint.setTextSize(40);
		paint.setAntiAlias(true);
	}

	private void ratioWidthPoint3()
	{
		double w = getWidth() + 0.0;
		double p = point3.x + 0.0;
		 ratioWidthPoint3X = w / p;
		 ratioWidthPoint3X = ratioWidthPoint3X - 0.2;
	}
	@SuppressLint("DrawAllocation")
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		setPaintProperties(canvas);
		triangleCalculations();
		ratioWidthPoint3();
		int checkWidth = getWidth();
		float point1XF = (float) (point1.x * ratioWidthPoint3X);
		point1XF = point1XF + 17;
		float point2XF = (float) (point2.x * ratioWidthPoint3X);
		float point3XF = (float) (point3.x * ratioWidthPoint3X);
		float sum1;
		float sum2 = pointsDifferenc(point2.y, point3.y);
		float sum3 = pointsDifferenc(point1.y, point3.y);
		String formatLength2 = numberFormatter(length2);
		String formatLength = numberFormatter(length3);
		String formatAngle1 = numberFormatter(angle1);
		String formatAngle2 = numberFormatter(angle2);
		String formatAngle3 = numberFormatter(angle3);
		int checkX = 100;
		if (point3.x > checkWidth || point2.x > checkWidth
				|| point1.x > checkWidth) {
			sum1 = pointsDifference(point1XF, point2XF);
			canvas.drawText("" + length1, sum1, point1.y, paint);
			canvas.drawText("" + formatLength2, (float) (point2XF), sum2, paint);
			canvas.drawText("" + formatLength, point1.x + 10, sum3, paint);
			if (toggle == 0) {
				canvas.drawText("" + formatAngle3, point3XF, point3.y, paint);
				canvas.drawText("" + formatAngle1, point1XF + checkX, point1.y,paint);
				canvas.drawText(" " + formatAngle2, point2XF, point2.y, paint);
			} else {
				canvas.drawText("" + formatAngle2, point3XF, point3.y, paint);
				canvas.drawText("" + formatAngle1, point1XF, point1.y, paint);
				canvas.drawText(" " + formatAngle3, point2XF, point2.y, paint);
			}
			point1.x = point1.x;// +17;
			float abc = (float) 1;
			path.moveTo(point1.x * abc, point1.y);
			Log.d("point1XF", point1XF + "");
			path.lineTo((float) (point2XF * abc), point2.y);
			path.moveTo((float) (point2XF * abc), point2.y);
			path.lineTo((float) (point3XF * abc), point3.y);

			path.lineTo(point1.x * abc, point1.y);
			path.close();
			canvas.drawPath(path, paint);

		} else {
			
			sum1 = pointsDifference(point1.x, point2.x);
			canvas.drawText("" + length1, sum1, point2.y + 40, paint);
			canvas.drawText("" + formatLength2, point2.x + 20, sum2, paint);
			canvas.drawText("" + formatLength, point1.x + 10, sum3, paint);
			canvas.drawText("" + formatAngle2, point1.x + 10, point1.y, paint);
			canvas.drawText("" + formatAngle1, point2.x + 10, point2.y, paint);
			canvas.drawText(" " + formatAngle3, point3.x + 10, point3.y, paint);
			path.moveTo(point1.x , point1.y);
			Log.d("point1.x", point1.x  + "");
			path.lineTo(point2.x , point2.y);
			path.moveTo(point2.x , point2.y);
			path.lineTo(point3.x , point3.y);
			path.lineTo(point1.x , point1.y);
			path.close();
			canvas.drawPath(path, paint);
		}
	}

}