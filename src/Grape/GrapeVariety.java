package Grape;

import java.util.ArrayList;
import java.util.List;

import enums.Color;
import enums.Variety;

public class GrapeVariety {
	private List<Grape> grapeVariety=new ArrayList<Grape>();
	
	public GrapeVariety(){
		this.grapeVariety.add(new Grape(Color.RED,Variety.Cabernet));
		this.grapeVariety.add(new Grape(Color.RED,Variety.Merlot));
		this.grapeVariety.add(new Grape(Color.RED,Variety.Barbera));
		this.grapeVariety.add(new Grape(Color.WHITE,Variety.Garganega));
		this.grapeVariety.add(new Grape(Color.RED,Variety.Molinara));
		this.grapeVariety.add(new Grape(Color.RED,Variety.Tannat));
		this.grapeVariety.add(new Grape(Color.RED,Variety.Sangiovese));
		this.grapeVariety.add(new Grape(Color.WHITE,Variety.Marsanne));
		this.grapeVariety.add(new Grape(Color.RED,Variety.Marselan));
		this.grapeVariety.add(new Grape(Color.WHITE,Variety.Furmint));
		this.grapeVariety.add(new Grape(Color.WHITE,Variety.Silvaner));
		this.grapeVariety.add(new Grape(Color.WHITE,Variety.Palomino));
		this.grapeVariety.add(new Grape(Color.RED,Variety.Pinotage));
		this.grapeVariety.add(new Grape(Color.RED,Variety.Cinsaut));
		this.grapeVariety.add(new Grape(Color.WHITE,Variety.Viognier));
		
		
	}
	public Grape searchGrape(String searchVariety)
	{
		for(Grape a:this.grapeVariety)
		{
			if(searchVariety.equals(a.getGrapeVariety()))
			{
				return a;
			}
		}
		return null;
		
	}

}
