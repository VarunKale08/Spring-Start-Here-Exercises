package model;

public class Comment {

    private String author;
    private String content;


    public String getAuthor(){
        return this.author;
    }

    public String getContent(){
        return this.content;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void setContent(String content){
        this.content = content;
    }

    @Override
    public String toString(){
        return "Author: " + this.getAuthor() + " Content: " + this.getContent();
    }


}
