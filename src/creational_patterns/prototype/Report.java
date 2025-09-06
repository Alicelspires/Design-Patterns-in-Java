package creational_patterns.prototype;

public class Report extends Document{
    private String title;
    private String content;

    public Report(String name, String title, String content){
        super(name);
        this.title = title;
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public Report clone(){
        Report copy = new Report(this.name, this.title, this.content);
        copy.version = this.version;
        return copy;
    }

    @Override
    public void show(){
        System.out.println("\nReport ================================");
        generalInfo();
        System.out.println("Title: " + title);
        System.out.println("Content: " + content);
    }
}
