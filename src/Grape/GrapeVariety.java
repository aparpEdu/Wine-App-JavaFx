package Grape;

import java.util.ArrayList;
import java.util.List;

import enums.Color;

public class GrapeVariety {
	private List<Grape> grapeVariety=new ArrayList<Grape>();
	
	public GrapeVariety(){
		this.grapeVariety.add(new Grape(Color.BLACK,"Cabernet"));
		this.grapeVariety.add(new Grape(Color.BLACK,"Merlot"));
		this.grapeVariety.add(new Grape(Color.BLACK,"Barbera"));
		this.grapeVariety.add(new Grape(Color.WHITE,"Garganega"));
		this.grapeVariety.add(new Grape(Color.BLACK,"Molinara"));
		this.grapeVariety.add(new Grape(Color.RED,"Tannat"));
		this.grapeVariety.add(new Grape(Color.RED,"Sangiovese"));
		this.grapeVariety.add(new Grape(Color.WHITE,"Marsanne"));
		this.grapeVariety.add(new Grape(Color.RED,"Marselan"));
		this.grapeVariety.add(new Grape(Color.WHITE,"Furmint"));
		this.grapeVariety.add(new Grape(Color.WHITE,"Silvaner"));
		this.grapeVariety.add(new Grape(Color.WHITE,"Palomino"));
		this.grapeVariety.add(new Grape(Color.RED,"Pinotage"));
		this.grapeVariety.add(new Grape(Color.RED,"Cinsaut"));
		this.grapeVariety.add(new Grape(Color.WHITE,"Viognier"));
		
		
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
