package Storage;

import java.util.TreeMap;

import Grape.Grape;
import Wine.WineBottle;
import enums.BottleSize;

public class WineSector {
	TreeMap<Integer,WineBottle> wines=new TreeMap<Integer,WineBottle>();

	public WineSector(TreeMap<Integer, WineBottle> wines) {
		
		this.wines = wines;
	}
	public void addWineBottle(BottleSize size)
	{
		wines.put(wines.size(), new WineBottle(size));
	}
	
}
