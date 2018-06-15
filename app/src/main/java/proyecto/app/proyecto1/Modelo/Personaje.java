package proyecto.app.proyecto1.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Personaje {
    private Long id;
    private String name;
    private String description;
    private Thumbnail thumbnail;
    private Comics comics;
    private Series series;
    private Stories stories;
    private Events events;
    private Urls[] urls;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Thumbnail getThumbnail() { return thumbnail; }
    public void setThumbnail(Thumbnail thumbnail) { this.thumbnail = thumbnail; }
    public Comics getComics() { return comics; }
    public void setComics(Comics comics) { this.comics = comics; }
    public Series getSeries() { return series; }
    public void setSeries(Series series) { this.series = series; }
    public Stories getStories() { return stories; }
    public void setStories(Stories stories) { this.stories = stories; }
    public Events getEvents() { return events; }
    public void setEvents(Events events) { this.events = events; }
    public Urls[] getUrls() { return urls; }
    public void setUrls(Urls[] events) { this.urls = urls; }
}

