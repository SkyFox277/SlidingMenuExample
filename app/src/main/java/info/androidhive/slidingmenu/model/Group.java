


        package info.androidhive.slidingmenu.model;


        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;
        import com.google.gson.annotations.Expose;

public class Group {

    @Expose
    private String id;
    @Expose
    private String name;
    @Expose
    private String description;
    @Expose
    private String owner;
    @SerializedName("_links")
    @Expose
    private info.androidhive.slidingmenu.model.Links Links;

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     * The owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     *
     * @param owner
     * The owner
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     *
     * @return
     * The Links
     */
    public info.androidhive.slidingmenu.model.Links getLinks() {
        return Links;
    }

    /**
     *
     * @param Links
     * The _links
     */
    public void setLinks(info.androidhive.slidingmenu.model.Links Links) {
        this.Links = Links;
    }

}

