package sqlconnection.helpers;

import java.util.ArrayList;
import java.util.TreeMap;

import Grape.Grape;
import Wine.Bottle;
import enums.BottleSize;
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
				if(sizeA == 0) {
					sb.append("You dont have any "+BottleSize.LARGE+ " Bottles\n");
				}
				else if(sizeA<5)
				{
					sb.append("You are low for "+BottleSize.LARGE+ " Bottles\n");
				}
				if(sizeB == 0) {
					sb.append("You dont have any "+BottleSize.MEDIUM+ " Bottles \n");
				}
				else if(sizeB<5)
				{
					sb.append("You are low for "+BottleSize.MEDIUM+ " Bottles \n");
				}
				if(sizeC == 0) {
					sb.append("You dont have any "+BottleSize.SMALL+ " Bottles \n");
				}
				else if(sizeC<5)
				{
					sb.append("You are low for "+BottleSize.SMALL+ " Bottles \n");
				}
				if(sizeD == 0) {
					sb.append("You dont have any "+BottleSize.TINY+ " Bottles ");
				}
				else if(sizeD<5)
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
	public static void criticalMinimumGrapes(TreeMap<Integer,Grape> grapes)
	{
		String msg="You Are low on:";
		StringBuilder sb=new StringBuilder(msg);
		for(Grape g:grapes.values())
		{
			if(g.getGrapeKg()<10)
		sb.append(g.getGrapeVariety()+",");		
		}
	sb.deleteCharAt(sb.length()-1);
		if(!sb.toString().equals(msg))
		{
		
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Warning Dialog");
			alert.setHeaderText(null);
			alert.setContentText(sb.toString());
			alert.showAndWait();
		}
			}
			
		
		
	
}
