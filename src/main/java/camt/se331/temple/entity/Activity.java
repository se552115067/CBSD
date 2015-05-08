package camt.se331.temple.entity;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dto on 2/7/2015.
 */
@Entity
public class Activity implements Comparable{
    @Id
    @GeneratedValue
    Long id;
    String name;
    String description;
    String lang;

    @OneToMany(fetch= FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    Set<Image> images = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Activity(){

    };

    public Activity(Long id, String name, String description, String lang, Image image) {
        this.name = name;
        this.description = description;
        this.lang = lang;
        this.id = id;
        this.getImages().add(image);
    }


    public Activity(Long id, String name, String description, String lang) {
        this.name = name;
        this.description = description;
        this.lang = lang;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @Override
    public int compareTo(Object o) {

        return (int) (this.getId() - ((Activity)o).getId());
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Activity activity = (Activity) o;

        if (description != null ? !description.equals(activity.description) : activity.description != null)
            return false;
        if (id != null ? !id.equals(activity.id) : activity.id != null) return false;
        if (images != null ? !images.equals(activity.images) : activity.images != null) return false;
        if (lang != null ? !lang.equals(activity.lang) : activity.lang != null) return false;
        if (name != null ? !name.equals(activity.name) : activity.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (lang != null ? lang.hashCode() : 0);
        result = 31 * result + (images != null ? images.hashCode() : 0);
        return result;
    }
}
