package sparrowing.playlistmanager.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "groups_test")
public class Group {
	
	/*
	  int          i          Unique Group id
	  Playlist     playlist   Playlist the group exists within
	  Group        parent     Immediate parent group (if applicable)
	  List<Group>  subgroups  Any IMMEDIATE child groups
	  List<Song>   songs      Any IMMEDIATE songs in this group
	 */
	
	// PROPERTIES --------------------------------------------------------
	
	@Id @GeneratedValue @NotNull
	@Column(name = "group_id", unique = true)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY) @NotNull
	@JoinColumn(name = "playlist_id")
	private Playlist playlist;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id")
	private Group parent;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "parent")
	private List<Group> subgroups;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "group")
	private List<Song> songs;
	
	@OneToOne(mappedBy = "holderGroup")
	private Playlist holderTo;
	
	// CONSTRUCTORS ------------------------------------------------------
	
	public Group() { }
	
	// PRIVATE METHODS ---------------------------------------------------
	
	// PUBLIC STATIC METHODS ---------------------------------------------
	
	// PUBLIC INSTANCE METHODS -------------------------------------------
	
	// GETTERS AND SETTERS -----------------------------------------------
	
	public int getId()                { return this.id; }
	public Playlist getPlaylist()     { return this.playlist; }
	public Group getParent()          { return this.parent; }
	public List<Group> getSubgroups() { return this.subgroups; }
	public List<Song> getSongs()      { return this.songs; }
	public Playlist getHolderTo()     { return this.holderTo; }
	
	@SuppressWarnings("unused") private void setId(int id)                       { this.id = id; }
	@SuppressWarnings("unused") private void setPlaylist(Playlist playlist)      { this.playlist = playlist; }
	@SuppressWarnings("unused") private void setParent(Group parent)             { this.parent = parent; }
	@SuppressWarnings("unused") private void setSubgroups(List<Group> subgroups) { this.subgroups = subgroups; }
	@SuppressWarnings("unused") private void setSongs(List<Song> songs)          { this.songs = songs; }
	@SuppressWarnings("unused") private void setHolderTo(Playlist holderTo)      { this.holderTo = holderTo; }

}
