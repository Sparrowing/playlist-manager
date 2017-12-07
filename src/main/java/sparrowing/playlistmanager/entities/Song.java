package sparrowing.playlistmanager.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "songs_test")
public class Song {
	
	/*
	  int     id              Unique Song id
	  String  name            Display name of song
	  String  artist          Display artist of song
	  String  youtubeVideoId  Corresponding YouTube video id
	  User    user            User that created this song entry
	  Group   group           Parent group that this song is in
	 */
	
	// PROPERTIES --------------------------------------------------------
	
	@Id @GeneratedValue @NotNull
	@Column(name = "song_id", unique = true)
	private int id;
	
	@NotNull
	@Column(name = "name")
	private String name;
	
	@NotNull
	@Column(name = "artist")
	private String artist;
	
	@NotNull
	@Column(name = "youtubeVideoId")
	private String youtubeVideoId;
	
	@ManyToOne(fetch = FetchType.LAZY) @NotNull
	@JoinColumn(name = "creator_id")
	private User creator;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "group_id")
	private Group group;
	
	// CONSTRUCTORS ------------------------------------------------------
	
	public Song() { }
	
	// PRIVATE METHODS ---------------------------------------------------
	
	// PUBLIC STATIC METHODS ---------------------------------------------
	
	// PUBLIC INSTANCE METHODS -------------------------------------------
	
	// GETTERS AND SETTERS -----------------------------------------------
	
	public int getId()                { return this.id; }
	public String getName()           { return this.name; }
	public String getArtist()         { return this.artist; }
	public String getYoutubeVideoId() { return this.youtubeVideoId; }
	public User getCreator()          { return this.creator; }
	public Group getGroup()           { return this.group; }
	
	@SuppressWarnings("unused") private void setId(int id)            { this.id = id; }
	@SuppressWarnings("unused") private void setName(String name)     { this.name = name; }
	@SuppressWarnings("unused") private void setArtist(String artist) { this.artist = artist; }
	@SuppressWarnings("unused") private void setYoutubeVideoId(String youtubeVideoId) 
																	 { this.youtubeVideoId = youtubeVideoId; }
	@SuppressWarnings("unused") private void setCreator(User creator) { this.creator = creator; }
	@SuppressWarnings("unused") private void setGroup(Group group)    { this.group = group; }
}
