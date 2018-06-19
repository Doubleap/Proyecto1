package proyecto.app.proyecto1.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Items  implements Serializable {
    private	int	id	;
    //private	GoldDto	gold	;
    private	String	plaintext	;
    private	boolean	hideFromAll	;
    private	boolean	inStore	;
    private ArrayList<String> into	;
    //private	InventoryDataStatsDto	stats	;
    private	String	colloq	;
    //private	Map[string, boolean]	maps	;
    private	int	specialRecipe	;
    //private	ImageDto	image	;
    private	String	description	;
    private	ArrayList<String>	tags	;
    //private	Map[string, string]	effect	;
    private	String	requiredChampion	;
    private	ArrayList<String>	from	;
    private	String	group	;
    private	boolean	consumeOnFull	;
    private	String	name	;
    private	boolean	consumed	;
    private	String	sanitizedDescription	;
    private	int	depth	;
    private	int	stacks	;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaintext() {
        return plaintext;
    }

    public void setPlaintext(String plaintext) {
        this.plaintext = plaintext;
    }

    public boolean isHideFromAll() {
        return hideFromAll;
    }

    public void setHideFromAll(boolean hideFromAll) {
        this.hideFromAll = hideFromAll;
    }

    public boolean isInStore() {
        return inStore;
    }

    public void setInStore(boolean inStore) {
        this.inStore = inStore;
    }

    public ArrayList<String> getInto() {
        return into;
    }

    public void setInto(ArrayList<String> into) {
        this.into = into;
    }

    public String getColloq() {
        return colloq;
    }

    public void setColloq(String colloq) {
        this.colloq = colloq;
    }

    public int getSpecialRecipe() {
        return specialRecipe;
    }

    public void setSpecialRecipe(int specialRecipe) {
        this.specialRecipe = specialRecipe;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public String getRequiredChampion() {
        return requiredChampion;
    }

    public void setRequiredChampion(String requiredChampion) {
        this.requiredChampion = requiredChampion;
    }

    public ArrayList<String> getFrom() {
        return from;
    }

    public void setFrom(ArrayList<String> from) {
        this.from = from;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public boolean isConsumeOnFull() {
        return consumeOnFull;
    }

    public void setConsumeOnFull(boolean consumeOnFull) {
        this.consumeOnFull = consumeOnFull;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isConsumed() {
        return consumed;
    }

    public void setConsumed(boolean consumed) {
        this.consumed = consumed;
    }

    public String getSanitizedDescription() {
        return sanitizedDescription;
    }

    public void setSanitizedDescription(String sanitizedDescription) {
        this.sanitizedDescription = sanitizedDescription;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getStacks() {
        return stacks;
    }

    public void setStacks(int stacks) {
        this.stacks = stacks;
    }
}
