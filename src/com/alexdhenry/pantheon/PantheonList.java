package com.alexdhenry.pantheon;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class PantheonList {
	private String listName;
	private ArrayList<ListItem> plist = new ArrayList<ListItem>();
	
	public PantheonList(String inName) {
		listName = inName;
	}

	public void addElement(String inName, int inVotes) {
		plist.add(new ListItem(inName, inVotes));
	}
	
	public int removeElement(String delName) {
		//Create a ListItem to see if it is in the list (because Collection.contains uses the equals() method)
		ListItem toCheck = new ListItem(delName, 0);
		
		int indexAt = plist.indexOf(toCheck);
		if (indexAt != -1) {
			//Delete the object from the list
			plist.remove(indexAt);
			return 0;
		} else {
			return -1;
		}
	}
	
	public int upvoteElement(String toUpvote) {
		//Create a ListItem to see if it is in the list (because Collection.contains uses the equals() method)
		ListItem toCheck = new ListItem(toUpvote, 0);
		
		int indexAt = plist.indexOf(toCheck);
		if (indexAt != -1) {
			//Increment the vote
			plist.get(indexAt).increment();
			
			return 0;
		} else {
			return -1;
		}
	}
	
	public int downvoteElement(String toDown) {
		//Create a ListItem to see if it is in the list (because Collection.contains uses the equals() method)
		ListItem toCheck = new ListItem(toDown, 0);
		
		int indexAt = plist.indexOf(toCheck);
		if (indexAt != -1) {
			//Decrement the vote
			plist.get(indexAt).decrement();
			
			return 0;
		} else {
			return -1;
		}
	}
	
	public String getName() {
		return listName;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Name: " + listName + "\n\n");
		for (ListItem li : plist) {
			sb.append(li);
		}
		
		return sb.toString();
	}
}
