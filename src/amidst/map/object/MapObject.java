package amidst.map.object;

import java.awt.Point;
import java.awt.image.BufferedImage;

import amidst.map.Fragment;
import amidst.map.MapMarkers;
import amidst.map.layer.IconLayer;

public abstract class MapObject {
	// TODO: understand what happens and rename the method
	protected static int calc(int coordinate) {
		return calc1(coordinate) + coordinate % Fragment.SIZE;
	}

	// TODO: understand what happens and rename the method
	protected static int calc1(int coordinate) {
		if (coordinate < 0) {
			return Fragment.SIZE;
		} else {
			return 0;
		}
	}

	private MapMarkers type;
	private int x;
	private int y;

	private int rx;
	private int ry;
	private double localScale = 1.0;
	private IconLayer parentLayer;

	public MapObject(MapMarkers type, int x, int y) {
		this.type = type;
		this.x = x;
		this.y = y;
	}

	public void setParent(IconLayer parentLayer) {
		this.parentLayer = parentLayer;
	}

	protected void setX(int x) {
		this.x = x;
	}

	protected void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return (int) (type.getImage().getWidth() * localScale);
	}

	public int getHeight() {
		return (int) (type.getImage().getHeight() * localScale);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String getName() {
		return type.getName();
	}

	public BufferedImage getImage() {
		return type.getImage();
	}

	@Deprecated
	public Point getAsPoint() {
		return new Point(x, y);
	}

	protected MapMarkers getType() {
		return type;
	}

	public int getRx() {
		return rx;
	}

	public void setRx(int rx) {
		this.rx = rx;
	}

	public int getRy() {
		return ry;
	}

	public void setRy(int ry) {
		this.ry = ry;
	}

	protected double getLocalScale() {
		return localScale;
	}

	public void setLocalScale(double localScale) {
		this.localScale = localScale;
	}

	public IconLayer getParentLayer() {
		return parentLayer;
	}

	public void setParentLayer(IconLayer parentLayer) {
		this.parentLayer = parentLayer;
	}
}
