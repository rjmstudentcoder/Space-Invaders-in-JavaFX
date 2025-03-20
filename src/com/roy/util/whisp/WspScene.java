package com.roy.util.whisp;

import java.util.ArrayList;
import java.util.LinkedList;

import com.roy.util.whisp.objects.Collider2D;

import java.util.Iterator;

public class WspScene {
	
	private LinkedList<Collider2D> colliders = new LinkedList<Collider2D>();
	
	public static boolean isPointOnLine(float point, float lineWidthA, float lineWidthB) {
		return point < (lineWidthA + lineWidthB) / 2;
	}
	
	public static boolean isBothOverlappingInCollider2D(Collider2D a, Collider2D b) {
		Vector2 offset = Vector2.sub(a.position, b.position);
		return isPointOnLine(offset.x, a.size.x, b.size.x) &&  isPointOnLine(offset.y, a.size.y, b.size.y);
	}
	
	public ArrayList<Collider2D> getOverlappingInCollider2D(Collider2D collider) {
		ArrayList<Collider2D> overlapColliders = new ArrayList<Collider2D>();
		Iterator<Collider2D> iterator = colliders.iterator();
		while (iterator.hasNext()) {
			 Collider2D element = iterator.next();
			 if (isBothOverlappingInCollider2D(collider, element)) {
				 overlapColliders.add(element);
			 }
		}
		return overlapColliders;
	}
	
	public Collider2D getFirstOverlappingCollider2D(Collider2D collider) {
		 Iterator<Collider2D> iterator = this.colliders.iterator();
		 while (iterator.hasNext()) {
			 Collider2D element = iterator.next();
			 if (isBothOverlappingInCollider2D(collider, element)) {
				 return element;
			 }
		}
		 return null;
	}
	
	private void clean() {
		 Iterator<Collider2D> iterator = this.colliders.iterator();
		 while (iterator.hasNext()) {
			 Collider2D element = iterator.next();
			 if (element.isDestroyed()) {
				 this.colliders.remove(element);
			 }
		}
	}
	
	public void update(double deltaTime) {
		clean();
	}
	
	void draw(WspStencil canvas) {
		
	}
	
}
