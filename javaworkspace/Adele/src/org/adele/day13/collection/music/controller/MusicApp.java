package org.adele.day13.collection.music.controller;

import java.util.Comparator;
import java.util.Map;

import org.adele.day13.collection.music.model.ManageMusic;
import org.adele.day13.collection.music.model.Music;
import org.adele.day13.collection.music.view.ViewMusic;

public class MusicApp {
	public static void main(String[] args) {
		ManageMusic mng = new ManageMusic();
		ViewMusic view = new ViewMusic();
		끝:
		while(true) {
			int menuChoice = view.printMenu();
			Music music = null;
			String title = null;
			Map<String, Object> params = null;
			switch(menuChoice) {
			case 1:
				music = view.inputMusic();
				mng.addMusicLast(music);
				break;
			case 2:
				music = view.inputMusic();
				mng.addMusicFirst(music);
				break;
			case 3:
				view.printMusics(mng.getAllMusics());
				break;
			case 4:
				title = view.inputTitle("검색");
				params = mng.getMusicByTitle(title);
				if(params != null) {
					view.printMusic((Music)params.get("music"));
				} else {
					view.displayMsg("곡명에 해당하는 곡이 없습니다.");
				}
				break;
			case 5:
				title = view.inputTitle("삭제");
				params = mng.getMusicByTitle(title);
				if(params != null) {
					mng.deleteMusic((Integer)params.get("index"));
				} else {
					view.displayMsg("곡명에 해당하는 곡이 없습니다.");
				}
				break;
			case 6:
				title = view.inputTitle("수정");
				params = mng.getMusicByTitle(title);
				if(params != null) {
					music = view.modifyMusic((Music)params.get("music"));
					mng.modifyMusic((Integer)params.get("index"), music);
				} else {
					view.displayMsg("곡명에 해당하는 곡이 없습니다.");
				}
				break;
			case 7:
				view.printMusics(mng.getSortedMusices(new Comparator<Music>() {
					@Override
					public int compare(Music o1, Music o2) {
						return o1.getTitle().compareTo(o2.getTitle());
					}
				}));
				break;
			case 8:
				view.printMusics(mng.getSortedMusices(new Comparator<Music>() {
					@Override
					public int compare(Music o1, Music o2) {
						return o1.getTitle().compareTo(o2.getTitle());
					}
				}.reversed()));
				break;
			case 9:
				view.printMusics(mng.getSortedMusices(new Comparator<Music>() {
					@Override
					public int compare(Music o1, Music o2) {
						return o1.getSinger().compareTo(o2.getSinger());
					}
				}));
				break;
			case 10:
				view.printMusics(mng.getSortedMusices(new Comparator<Music>() {
					@Override
					public int compare(Music o1, Music o2) {
						return o1.getSinger().compareTo(o2.getSinger());
					}
				}.reversed()));
				break;
			case 0:
				break 끝;
			default:
				view.displayMsg("0 ~ 10 사이의 숫자를 입력해야 합니다.");
			}
		}
	}
}
