package org.adele.day13.collection.music.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManageMusic {
	private List<Music> mList;
	
	public ManageMusic() {
		mList = new ArrayList<>();
	}

	public void addMusicLast(Music music) {
		mList.add(music);
	}
	
	public void addMusicFirst(Music music) {
		mList.add(0, music);
	}
	
	public List<Music> getAllMusics() {
		return mList;
	}
	
	public Map<String, Object> getMusicByTitle(String title) {
		if(title != null) {
			for(int i=0;i<mList.size();i++) {
				if(title.equals(mList.get(i).getTitle())) {
					Map<String, Object> params = new HashMap<>();
					params.put("music", mList.get(i));
					params.put("index", i);
					return params;
				}
			}
		}
		return null;
	}
	
	public void deleteMusic(int index) {
		mList.remove(index);
	}

	public void modifyMusic(int index, Music music) {
		mList.set(index, music);
	}
	
	public List<Music> getSortedMusices(Comparator<Music> c) {
		mList.sort(c);
		return mList;
	}
}
