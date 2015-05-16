

/**
 * Created by Punjasin on 5/12/2015.
 */
package wat.entity;


        import org.hibernate.annotations.*;
        import org.hibernate.annotations.CascadeType;

        import javax.persistence.*;
        import javax.persistence.Entity;

        import java.sql.Time;
        import java.util.Date;
        import java.util.HashSet;
        import java.util.Set;

/**
 * Created by Dto on 2/7/2015.
 */
@Entity
public class Activity implements Comparable {
    @Id
    @GeneratedValue
    Long Id;
    String name;
    String description;
    String lang;
    Date date;
    Time time;

    String venue;
    @OneToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    Set<Image> images = new HashSet<>();
    public Activity(String name, String description, Date date,String venue,Time time,Image image) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.venue=venue;
        this.time=time;
        images.add(image);

    }

    public Activity(String name, String description, String lang, Date date, Time time, String venue, Image images) {
        this.name = name;
        this.description = description;
        this.lang = null;
        this.date = date;
        this.time = time;
        this.venue = venue;
        this.images.add(images);
    }

    public Activity(String name, String description, Date date, Time time, String venue, Set<Image> images) {
        this.name = name;
        this.description = description;
        this.lang = null;
        this.date = date;
        this.time = time;
        this.venue = venue;
        this.images = images;
    }

    public Activity(String name, String description, String lang, Date date, Set<Image> images) {
        this.name = name;
        this.description = description;
        this.lang = lang;
        this.date = date;
        this.venue="";
        this.images = images;
    }

    public Activity(String name, String description, String lang, Date date, String venue, Set<Image> images) {
        this.name = name;
        this.description = description;
        this.lang = lang;
        this.date = date;

        this.venue = venue;
        this.images = images;
    }

    public Activity(Long id,String aname, String adescription, String lang, Set<Image> images) {
        this.Id=id;
        this.name = aname;
        this.description = adescription;
        this.lang = lang;
        this.images = images;
    }

    public Activity(Long id,String aname, String adescription, String lang, Image images) {
        this.Id=id;
        this.name = aname;
        this.description = adescription;
        this.lang = lang;
        this.images.add(images);
    }

    public Activity() {

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Activity activity = (Activity) o;

        if (Id != null ? !Id.equals(activity.Id) : activity.Id != null) return false;
        if (name != null ? !name.equals(activity.name) : activity.name != null) return false;
        if (description != null ? !description.equals(activity.description) : activity.description != null)
            return false;
        if (lang != null ? !lang.equals(activity.lang) : activity.lang != null) return false;
        return !(images != null ? !images.equals(activity.images) : activity.images != null);

    }

    @Override
    public int hashCode() {
        int result = Id != null ? Id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (lang != null ? lang.hashCode() : 0);
        result = 31 * result + (images != null ? images.hashCode() : 0);
        return result;
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

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}