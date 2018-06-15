package proyecto.app.proyecto1.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Campeon  implements Serializable {
    private Long id;
    private String name;
    private String key;
    private String lore;
    private String title;
    private String partype;
    private String[] allytips;
    private String[] enemytips;
    private Info info;
    private Stats stats;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getKey() { return key; }
    public void setKey(String key) { this.key = key; }
    public String getLore() {
        return lore;
    }

    public void setLore(String lore) {
        this.lore = lore;
    }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getPartype() { return partype; }
    public void setPartype(String partype) { this.partype = partype; }

    public String[] getAllytips() {
        return allytips;
    }

    public void setAllytips(String[] allytips) {
        this.allytips = allytips;
    }

    public String[] getEnemytips() {
        return enemytips;
    }

    public void setEnemytips(String[] enemytips) {
        this.enemytips = enemytips;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }
}
