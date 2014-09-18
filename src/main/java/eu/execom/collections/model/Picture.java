package eu.execom.collections.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "picture")
public class Picture {
    public enum pictureGenre {
        ABSTRACT, ALEGORICAL, ANIMAL, ARHITECTURE, BATTLE, CALLIGRAPHY, CARICATURE, DESING, GRAFITY, HISTORY, ILUSTRATION, LANDSCAPE, MOSAIC, MYTHOLOGICAL, PANORAMA, PHOTO, PORTRAIT, POSTER, SELFPORTRAIT
    }

    public enum pictureStyle {
        ABSTRACT, BAROQUE, CARTOGRAPHIC, CLASSICISM, CONCEPTUAL_ART, CUBISM, CYBER_ART, EXPRESSIONISM, RENAISSANCE, GOTHIC, GRAFFITI, IMPRESSINISM, LUMINISM, MODERNISMO, MUGHAL, MURALISM, NAIVE_ART, NEOCLASSICISM, POP_ART, PRIMITIVISM, REALISM, ROCOCO, STREET_ART, ZEN
    }

    public enum pictureTechnique {
        ACRILIC, BRONZE, BRUSH, OIL, WATERCOLOR, TEMPERA, PENCIL, PASTEL, INK, FRESCO, LITHOGRAPHY, PEN, GRAPHITE, PHOTOGRAPHY, WOOD, PRINT, GLASS, WAX
    }
   
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "artist")
    private String artist;
    
    @Column(name = "completion_date")
    private int completionDate;
    
    @Column(name = "style")
    @Enumerated(EnumType.STRING)
    private pictureStyle style;

    @Column(name = "genre")
    @Enumerated(EnumType.STRING)
    private pictureGenre genre;
    
    @Column (name = "technique")
    @Enumerated (EnumType.STRING)
    private pictureTechnique technique;
    
    @Column (name = "material")
    private String material;
    
    @Column (name = "dimensions" )
    private String dimensions;
    
    @Lob
    @Column(name = "image", columnDefinition = "MEDIUMTEXT")
    private String image;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getArtist(){
        return artist;
    }
    
    public void setArtist(String artist){
        this.artist = artist;
    }
    
    public int getCompletionDate(){
        return completionDate;
    }
    
    public void setCompletionDate(int completionDate){
        this.completionDate = completionDate;
    }
    
    public pictureStyle getStyle() {
        return style;
    }
    
    public void setStyle(pictureStyle style){
        this.style = style;
    }

    public pictureGenre getGenre(){
        return genre;
    }
    
    public void setGenre(pictureGenre genre){
        this.genre = genre;
    }
    
    public pictureTechnique getTechnique (){
        return technique;
    }
    
    public void pictureTechnique (pictureTechnique technique){
        this.technique = technique;
    }
    
    public String getMaterial(){
        return material;
    }

    public void setMaterial(String material){
        this.material = material;
    }
    
    public String getDimensions(){
        return dimensions;        
    }
 
    public void setDimensions(String dimensions){
        this.dimensions = dimensions;
    }
    
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

   
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((artist == null) ? 0 : artist.hashCode());
        result = prime * result + completionDate;
        result = prime * result + ((dimensions == null) ? 0 : dimensions.hashCode());
        result = prime * result + ((genre == null) ? 0 : genre.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((image == null) ? 0 : image.hashCode());
        result = prime * result + ((material == null) ? 0 : material.hashCode());
        result = prime * result + ((style == null) ? 0 : style.hashCode());
        result = prime * result + ((technique == null) ? 0 : technique.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        return result;
    }

  
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Picture other = (Picture) obj;
        if (artist == null) {
            if (other.artist != null)
                return false;
        } else if (!artist.equals(other.artist))
            return false;
        if (completionDate != other.completionDate)
            return false;
        if (dimensions == null) {
            if (other.dimensions != null)
                return false;
        } else if (!dimensions.equals(other.dimensions))
            return false;
        if (genre != other.genre)
            return false;
        if (id != other.id)
            return false;
        if (image == null) {
            if (other.image != null)
                return false;
        } else if (!image.equals(other.image))
            return false;
        if (material == null) {
            if (other.material != null)
                return false;
        } else if (!material.equals(other.material))
            return false;
        if (style != other.style)
            return false;
        if (technique != other.technique)
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (user == null) {
            if (other.user != null)
                return false;
        } else if (!user.equals(other.user))
            return false;
        return true;
    }
}