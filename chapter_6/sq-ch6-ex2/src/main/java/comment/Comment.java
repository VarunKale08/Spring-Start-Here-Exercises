package comment;

public class Comment {

    private String author;
    private String content;

    public void setAuthor(String author){
        this.author = author;
    }

    public String getAuthor(){
        return this.author;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getContent(){
        return this.content;
    }

    @Override
    public String toString(){
        return "Author: " + this.getAuthor() + " content: " + this.getContent();
    }
}
