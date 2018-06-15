package proyecto.app.proyecto1.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Items  implements Serializable {
    public String resourceURI;
    public String name;
    public String type;

    public String getResourceURI() { return resourceURI; }
    public void setResourceURI(String resourceURI) { this.resourceURI = resourceURI; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}
