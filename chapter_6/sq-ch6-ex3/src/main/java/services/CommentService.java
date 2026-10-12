package services;


import model.Comment;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CommentService {

    private Logger logger = Logger.getLogger(Comment.class.getName());


    public String publishComment(Comment comment){

        logger.info("The comment published is: " + comment.getContent());

        return "SUCCESS";
    }

}
