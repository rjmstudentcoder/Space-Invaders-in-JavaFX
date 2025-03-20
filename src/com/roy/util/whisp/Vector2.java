package com.roy.util.whisp;

public class Vector2 {
	public float x;
	public float y;

	public Vector2(float newX, float newY) {
		this.x = newX;
		this.y = newY;
	}
	
	public Vector2(Vector2 b) {
		this.x = b.x;
		this.y = b.y;
	}

	public static Vector2 add(Vector2 a, Vector2 b) {
		return new Vector2(a.x + b.x, a.y + b.y);
	}

	public static Vector2 sub(Vector2 a, Vector2 b) {
		return new Vector2(a.x - b.x, a.y - b.y);
	}

	public static Vector2 mul(Vector2 a, Vector2 b) {
		return new Vector2(a.x * b.x, a.y * b.y);
	}

	public static Vector2 div(Vector2 a, Vector2 b) {
		return new Vector2(a.x / b.x, a.y / b.y);
	}

	public void tAdd(Vector2 b) {
		this.x += b.x;
		this.y += b.y;
	}

	public void tSub(Vector2 b) {
		this.x -= b.x;
		this.y -= b.y;
	}

	public void tMul(Vector2 b) {
		this.x *= b.x;
		this.y *= b.y;
	}

	public void tDiv(Vector2 b) {
		this.x /= b.x;
		this.y /= b.y;
	}

	public double distance(Vector2 b) {
		return Math.sqrt(Math.pow((this.x - b.x), 2.0) + Math.pow((this.y - b.y), 2.0));
	}
}
