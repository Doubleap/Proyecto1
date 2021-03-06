package proyecto.app.proyecto1.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;

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
    private String[] tags;
    private Info info;
    private Stats stats;
    private Skins[] skins;
    private Pasiva passive;
    private Spell[] spells;

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

    public Skins[] getSkins() {
        return skins;
    }

    public void setSkins(Skins[] skins) {
        this.skins = skins;
    }

    public Pasiva getPassive() {
        return passive;
    }

    public void setPassive(Pasiva passive) {
        this.passive = passive;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public Spell[] getSpells() {
        return spells;
    }

    public void setSpells(Spell[] spells) {
        this.spells = spells;
    }
}
