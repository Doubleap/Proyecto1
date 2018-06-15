package proyecto.app.proyecto1.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Stories{
    private String available;
    private String collectionURI;
    private Items[] items;

    public String getAvailable() { return available; }
    public void setAvailable(String available) { this.available = available; }
    public String getCollectionURI() { return collectionURI; }
    public void setCollectionURI(String collectionURI) { this.collectionURI = collectionURI; }
    public Items[] getItems() { return items; }
    public void setItems(Items[] items) { this.items = items; }
}
