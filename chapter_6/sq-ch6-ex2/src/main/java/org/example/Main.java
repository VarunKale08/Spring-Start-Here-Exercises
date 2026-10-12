package org.example;

import comment.Comment;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

import java.util.logging.Logger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {



    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Main.class.getName());
        Comment comment = new Comment();

        comment.setAuthor("varun kale");
        comment.setContent("hello world!");


        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var service = context.getBean(CommentService.class);


        String getResult = service.publishComment(comment);

        logger.info(getResult);

    }
}