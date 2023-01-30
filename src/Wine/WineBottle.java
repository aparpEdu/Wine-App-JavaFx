package Wine;

import enums.BottleSize;

public class WineBottle {
private BottleSize size;
private int spaceLeft;
private Wine wine;
private int id;

public WineBottle(BottleSize size)
{
	this.setSize(size);
	this.spaceLeft=size.getValue();
	this.setWine(null);
	
	}
public void fill(Wine fillWine,int quantity)
{
	this.setWine(fillWine);
	if(quantity<this.spaceLeft)
	{
	this.spaceLeft=this.spaceLeft-quantity;
	}
	}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Wine getWine() {
	return wine;
}
public void setWine(Wine wine) {
	this.wine = wine;
}
public BottleSize getSize() {
	return size;
}
public void setSize(BottleSize size) {
	this.size = size;
}
}
