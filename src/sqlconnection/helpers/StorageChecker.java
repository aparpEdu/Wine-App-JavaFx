package sqlconnection.helpers;

import java.util.ArrayList;

import Grape.Grape;
import Wine.Bottle;
import enums.BottleSize;
import enums.Variety;
import javafx.scene.control.Alert;

public class StorageChecker {

	public StorageChecker() {
		// TODO Auto-generated constructor stub
	}
	public static void criticalMinimum(ArrayList<Bottle> bottles)
	{
		int sizeA=0;
		int sizeB=0;
		int sizeC=0;
		int sizeD=0;
		for(Bottle b:bottles)
		{
			if(b.getSize().equals(BottleSize.LARGE.toString().concat(BottleSize.LARGE.getSize())))
			{
				sizeA++;
			}
			if(b.getSize().equals(BottleSize.MEDIUM.toString().concat(BottleSize.MEDIUM.getSize())))
			{
				sizeB++;
			}
			if(b.getSize().equals(BottleSize.SMALL.toString().concat(BottleSize.SMALL.getSize())))
			{
				sizeC++;
			}
			if(b.getSize().equals(BottleSize.TINY.toString().concat(BottleSize.TINY.getSize())))
			{
				sizeD++;
			}
		}
			if(sizeA<5||sizeB<5||sizeC<5||sizeD<5)
			{
				String msg="You are at critical minimum for:\n";
				StringBuilder sb=new StringBuilder(" ");
				if(sizeA<5)
				{
					sb.append("You are low for "+BottleSize.LARGE+ " Bottles\n");
				}
				if(sizeB<5)
				{
					sb.append("You are low for "+BottleSize.MEDIUM+ " Bottles \n");
				}
				if(sizeC<5)
				{
					sb.append("You are low for "+BottleSize.SMALL+ " Bottles \n");
				}
				if(sizeD<5)
				{
					sb.append("You are low for "+BottleSize.TINY+ " Bottles ");
				}
				
				msg+=sb.toString();
				Alert alert = new Alert(Alert.AlertType.WARNING);
				alert.setTitle("Warning Dialog");
				alert.setHeaderText(null);
				alert.setContentText(msg);
				alert.showAndWait();
			}
	}
	public static void criticalMinimumGrapes(ArrayList<Grape> grapes)
	{
		int var1=0;
		int var2=0;
		int var3=0;
		int var4=0;
		int var5=0;
		int var6=0;
		int var7=0;
		int var8=0;
		int var9=0;
		int var10=0;
		int var11=0;
		int var12=0;
		int var13=0;
		int var14=0;
		int var15=0;
		for(Grape g:grapes)
		{
			if(g.getGrapeVariety().equals(Variety.Cabernet.name()))
			{
				var1++;
			}
			if(g.getGrapeVariety().equals(Variety.Merlot.name()))
			{
				var2++;
			}
			if(g.getGrapeVariety().equals(Variety.Barbera.name()))
			{
				var3++;
			}
			if(g.getGrapeVariety().equals(Variety.Garganega.name()))
			{
				var4++;
			}
			if(g.getGrapeVariety().equals(Variety.Molinara.name()))
			{
				var5++;
			}
			
			if(g.getGrapeVariety().equals(Variety.Tannat.name()))
			{
				var6++;
			}
			if(g.getGrapeVariety().equals(Variety.Sangiovese.name()))
			{
				var7++;
			}
			if(g.getGrapeVariety().equals(Variety.Marsanne.name()))
			{
				var8++;
			}
			if(g.getGrapeVariety().equals(Variety.Marselan.name()))
			{
				var9++;
			}
			if(g.getGrapeVariety().equals(Variety.Furmint.name()))
			{
				var10++;
			}
			if(g.getGrapeVariety().equals(Variety.Silvaner.name()))
			{
				var11++;
			}
			if(g.getGrapeVariety().equals(Variety.Palomino.name()))
			{
				var12++;
			}
			if(g.getGrapeVariety().equals(Variety.Pinotage.name()))
			{
				var13++;
			}
			if(g.getGrapeVariety().equals(Variety.Cinsaut.name()))
			{
				var14++;
			}
			if(g.getGrapeVariety().equals(Variety.Viognier.name()))
			{
				var15++;
			}
		}
			if(var1<5||var2<5||var3<5||var4<5||var5<5||var6<5||var7<5||var8<5||var9<5||var10<5||var11<5||var12<5||var13<5||var14<5||var15<5)
			{
				String msg="You are at critical minimum for:\n";
				StringBuilder sb=new StringBuilder(" ");
				if(var1<5)
				{
					sb.append("You are low for "+Variety.Cabernet+ " grapes\n");
				}
				if(var2<5)
				{
					sb.append("You are low for "+Variety.Merlot+ " grapes \n");
				}
				if(var3<5)
				{
					sb.append("You are low for "+Variety.Barbera+ " grapes \n");
				}
				if(var4<5)
				{
					sb.append("You are low for "+Variety.Garganega+ " grapes ");
				}
				if(var5<5)
				{
					sb.append("You are low for "+Variety.Molinara+ " grapes\n");
				}
				if(var6<5)
				{
					sb.append("You are low for "+Variety.Tannat+ " grapes \n");
				}
				if(var7<5)
				{
					sb.append("You are low for "+Variety.Sangiovese+ " grapes \n");
				}
				if(var8<5)
				{
					sb.append("You are low for "+Variety.Marsanne+ " grapes ");
				}
				if(var9<5)
				{
					sb.append("You are low for "+Variety.Marselan+ " grapes\n");
				}
				if(var10<5)
				{
					sb.append("You are low for "+Variety.Furmint+ " grapes \n");
				}
				if(var11<5)
				{
					sb.append("You are low for "+Variety.Silvaner+ " grapes \n");
				}
				if(var12<5)
				{
					sb.append("You are low for "+Variety.Palomino+ " grapes ");
				}
				if(var13<5)
				{
					sb.append("You are low for "+Variety.Pinotage+ " grapes \n");
				}
				if(var14<5)
				{
					sb.append("You are low for "+Variety.Cinsaut+ " grapes ");
				}
				if(var15<5)
				{
					sb.append("You are low for "+Variety.Viognier+ " grapes ");
				}
				
				msg+=sb.toString();
				Alert alert = new Alert(Alert.AlertType.WARNING);
				alert.setTitle("Warning Dialog");
				alert.setHeaderText(null);
				alert.setContentText(msg);
				alert.showAndWait();
			}
			
		
		
	}
}
