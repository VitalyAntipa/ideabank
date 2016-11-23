package com.dataart.fastforward.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by logariett on 22.11.2016.
 */

@Entity
@Table(name = "Ideas")
public class Idea {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "idea_id", length = 6, nullable = false)
    private long ideaId;

    @ManyToOne//(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "user_id", nullable = false)
    private UserDetail user;

    @Column(name = "idea_text")
    private String ideaText;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date")
    private Date creationDate;

/*    @ManyToMany(mappedBy = "bookmarkedIdeas")//,fetch = FetchType.EAGER)
    private Set<UserDetail> usersWhoBookmarked;*/

/*    @ManyToMany
    @JoinTable(name="Ideas_Tags",
            joinColumns = @JoinColumn(name="idea_id", referencedColumnName="idea_id"),
            inverseJoinColumns = @JoinColumn(name="tag_id", referencedColumnName="tag_id")
    )
    private Set<Tag> tags;*/

    public Idea() {}

    public long getIdeaId() {
        return ideaId;
    }

    public void setIdeaId(long ideaId) {
        this.ideaId = ideaId;
    }

    public UserDetail getUser() {
        return user;
    }

    public void setUser(UserDetail user) {
        this.user = user;
    }

    public String getIdeaText() {
        return ideaText;
    }

    public void setIdeaText(String ideaText) {
        this.ideaText = ideaText;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

/*    public Set<UserDetail> getUsers() {
        return usersWhoBookmarked;
    }

    public void setUsers(Set<UserDetail> users) {
        this.usersWhoBookmarked = users;
    }*/

/*    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }*/
}
