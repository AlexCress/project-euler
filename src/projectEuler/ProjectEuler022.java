package projectEuler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeSet;

public class ProjectEuler022 {
	
	public long solve(){
		
		long nameScoreSum = 0;
		
		TreeSet<String> nameSet = parseNames("challenge022.txt");
		
		Iterator<String> iterator = nameSet.iterator();
		int i = 1;
		
		while(iterator.hasNext()){
			String name = iterator.next();

			nameScoreSum += getNameScore(name, i);
			i++;
		}
		
		return nameScoreSum;
	}
	
	private TreeSet<String> parseNames(String filename){
		
		TreeSet<String> nameSet = new TreeSet<String>();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(new File(filename)))){
			
			String line = reader.readLine();
			
			while(line != null){
				String[] names = line.split(",");
				for(int i = 0; i < names.length; i++){
					//Each name comes with quotations around the word, remove before adding
					String name = names[i].substring(1, names[i].length() - 1);
					nameSet.add(name);
					
				}
				line = reader.readLine();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return nameSet;
	}
	
	private int getNameScore(String name, int index){
		int nameScore = 0;
		
		for(int i = 0; i < name.length(); i++){
			nameScore += (int) name.charAt(i) - 64;
		}
		
		nameScore *= index;
		
		return nameScore;
	}
}
