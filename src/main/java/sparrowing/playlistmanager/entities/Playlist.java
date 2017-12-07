package sparrowing.playlistmanager.entities;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "playlists_test")
public class Playlist {
	
	/*
	  int            id           Unique Playlist id
	  String         name         Display name of playlist
	  Date           created      Creation time of playlist
	  Date           updated      Last update time of playlist
	  Group          holderGroup  Base-level group of playlist
	  User           creator      User that created the playlist
	  List<Group>    groups       Groups contained by this playlist
	 */
	
	// PROPERTIES --------------------------------------------------------
	
	@Id @GeneratedValue @NotNull
	@Column(name = "playlist_id", unique = true)
	private int id;
	
	@NotNull
	@Column(name = "name")
	private String name;
	
	@Temporal(TemporalType.TIMESTAMP) @NotNull
	@Column(name = "created")
	private Date created;
	
	@Temporal(TemporalType.TIMESTAMP) @NotNull
	@Column(name = "updated")
	private Date updated;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "holder_group")
	private Group holderGroup;
	
	@ManyToOne @NotNull
	@JoinColumn(name = "owner_id")
	private User owner;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "playlist")
	private List<Group> groups;
	
	// CONSTRUCTORS ------------------------------------------------------
	
	public Playlist() { }
	
	// PRIVATE METHODS ---------------------------------------------------
	
	// PUBLIC STATIC METHODS ---------------------------------------------
	
	// PUBLIC INSTANCE METHODS -------------------------------------------
	
	// GETTERS AND SETTERS -----------------------------------------------
	
	public int getId()             { return this.id; }
	public Date getCreated()       { return this.created; }
	public Date getUpdated()       { return this.updated; }
	public Group getHolderGroup()  { return this.holderGroup; }
	public User getOwner()         { return this.owner; }
	public List<Group> getGroups() { return this.groups; }
	
	@SuppressWarnings("unused") private void setId(int id)                     { this.id = id; }
	@SuppressWarnings("unused") private void setCreated(Date created)          { this.created = created; }
	@SuppressWarnings("unused") private void setUpdated(Date updated)          { this.updated = updated; }
	@SuppressWarnings("unused") private void setHolderGroup(Group holderGroup) { this.holderGroup = holderGroup; }
	@SuppressWarnings("unused") private void setOwner(User owner)              { this.owner = owner; }
	@SuppressWarnings("unused") private void setGroups(List<Group> groups)     { this.groups = groups; }

}
