package org.example;

import config.ProjectConfig;
import model.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

import java.util.logging.Logger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {

        Logger logger = Logger.getLogger(Main.class.getName());
        Comment comment = new Comment();
        comment.setAuthor("Parth Kale");
        comment.setContent("Hello World");


        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var commentService = context.getBean(CommentService.class);

        String result = commentService.publishComment(comment);

        logger.info(result);
    }
}