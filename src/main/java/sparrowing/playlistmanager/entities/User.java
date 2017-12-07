package sparrowing.playlistmanager.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users_test")
public class User {
	
	/*
	  int             id         Unique User id
	  String          username   Username of user
	  String          pwHash     The user's hashed password
	  Date            joined     Date and time that user joined
	  List<Playlist>  playlists  Playlists owned by user
	  List<Song>      songs      User's song entries
	 */
	
	// PROPERTIES --------------------------------------------------------
	
	@Id @GeneratedValue @NotNull
	@Column(name = "user_id", unique = true)
	private int id;
	
	@NotNull
	@Column(name = "username")
	private String username;
	
	@NotNull
	@Column(name = "pw_hash")
	private String pwHash;
	
	@Temporal(TemporalType.TIMESTAMP) @NotNull
	@Column(name = "joined")
	private Date joined;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "owner")
	private List<Playlist> playlists;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "creator")
	private List<Song> songs;
	
	// CONSTRUCTORS ------------------------------------------------------
	
	public User() { }
	
	// PRIVATE METHODS ---------------------------------------------------
	
	// PUBLIC STATIC METHODS ---------------------------------------------
	
	// PUBLIC INSTANCE METHODS -------------------------------------------
	
	// GETTERS AND SETTERS -----------------------------------------------
	
	public int getId()                   { return this.id; }
	public String getUsername()          { return this.username; }
	public String getPwHash()            { return this.pwHash; }
	public Date getJoined()              { return this.joined; }
	public List<Playlist> getPlaylists() { return this.playlists; }
	public List<Song> getSongs()         { return this.songs; }
	
	@SuppressWarnings("unused") private void setId(int id)                          { this.id = id; }
	@SuppressWarnings("unused") private void setUsername(String username)           { this.username = username; }
	@SuppressWarnings("unused") private void setPwHash(String pwHash)               { this.pwHash = pwHash; }
	@SuppressWarnings("unused") private void setJoined(Date joined)                 { this.joined = joined; }
	@SuppressWarnings("unused") private void setPlaylists(List<Playlist> playlists) { this.playlists = playlists; }
	@SuppressWarnings("unused") private void setSongs(List<Song> songs)             { this.songs = songs; }
	
}
