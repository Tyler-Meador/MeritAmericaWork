package Adapter;

import java.util.ArrayList;


public class Playlist implements IComponent {

	public String playlistName;
	public ArrayList<IComponent> playlist = new ArrayList<IComponent>();

	public Playlist(String playlistName) {
		this.playlistName = playlistName;
	}

	@Override
	public void play() {
		System.out.println("Now playing: " + playlistName + " playlist");
		
	}

	@Override
	public void setPlaybackSpeed(float speed) {
		for(int i = 0; i < playlist.size(); i++)
			{
				playlist.get(i).setPlaybackSpeed(speed);
			}
	}

	@Override
	public String getName() {
		return playlistName;
	}
	
	public void add(IComponent component) {
		playlist.add(component);
	}
	
	public void remove(IComponent component) {
		playlist.remove(component);
	}



}