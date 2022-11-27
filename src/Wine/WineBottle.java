package Wine;

import enums.BottleSize;

public class WineBottle {
private BottleSize size;
private int spaceLeft;
private Wine wine;

public WineBottle(BottleSize size)
{
	this.size=size;
	this.spaceLeft=size.getValue();
	this.wine=null;
	
	}
public void fill(Wine fillWine,int quantity)
{
	this.wine=fillWine;
	if(quantity<this.spaceLeft)
	{
	this.spaceLeft=this.spaceLeft-quantity;
	}
	}
}
