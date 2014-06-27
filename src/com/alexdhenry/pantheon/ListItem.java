package com.alexdhenry.pantheon;

public class ListItem {
	private String name;
	private int votes;
	
	ListItem(String inName, int inVotes) {
		name = inName;
		votes = inVotes;
	}
	
	public void increment() {
		votes++;
	}
	
	public void decrement() {
		votes--;
	}
	
	public String getName() {
		return name;
	}
	
	public int getVotes() {
		return votes;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(name);
		sb.append("   ");
		sb.append(votes);
		
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object o) {
		ListItem toCheck = (ListItem) o;
		
		if (name.equals(toCheck.name)) {
			return true;
		} else {
			return false;
		}
	}
}