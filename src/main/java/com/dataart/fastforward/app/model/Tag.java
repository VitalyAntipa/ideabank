package com.dataart.fastforward.app.model;

import com.dataart.fastforward.app.model.Idea;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by logariett on 22.11.2016.
 */

@Entity
@Table(name = "Tags")
public class Tag {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "tag_id", length = 6, nullable = false)
    private long tagId;

    @Column(name = "tag_name")
    private String tagName;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "tags")
    @JsonManagedReference
    private Set<Idea> ideasWithThisTag = new HashSet<>();

    public Tag() {}

    public long getTagId() {
        return tagId;
    }

    public void setTagId(long tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @JsonIgnore
    public Set<Idea> getIdeasWithThisTag() {
        return ideasWithThisTag;
    }

    public void setIdeasWithThisTag(Set<Idea> ideasWithThisTag) {
        this.ideasWithThisTag = ideasWithThisTag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tag tag = (Tag) o;

        if (tagId != tag.tagId) return false;
        return tagName != null ? tagName.equals(tag.tagName) : tag.tagName == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (tagId ^ (tagId >>> 32));
        result = 31 * result + (tagName != null ? tagName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tagId=" + tagId +
                ", tagName='" + tagName +
                '}';
    }
}
