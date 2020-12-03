package core.entity;

public class Snippet implements Comparable<Snippet> {

    private long id;

    private String title;

    private String language;

    private String framework;

    private String code;

    private String description;

    private String resource;

    public Snippet(long id, String title, String language, String framework, String code, String description,
            String resource) {
        this.id = id;
        this.title = title;
        this.language = language;
        this.framework = framework;
        this.code = code;
        this.description = description;
        this.resource = resource;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFramework() {
        return framework;
    }

    public void setFramework(String framework) {
        this.framework = framework;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    
    @Override
    public int compareTo(Snippet o) {
        return Long.compare(id, o.id);
    }

    @Override
    public String toString() {
        return "Snippet [code=" + code + ", description=" + description + ", framework=" + framework + ", id=" + id
                + ", language=" + language + ", resource=" + resource + ", title=" + title + "]";
    }

}
