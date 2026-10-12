package services;

import comment.Comment;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CommentService {


    private Logger logger = Logger.getLogger(Comment.class.getName());


    public String publishComment(Comment comment){

        logger.info("Publishing Comment: " + comment.getContent());
        return "SUCESS";
    }

    public void setLogger(Logger logger){
        this.logger = logger;
    }
}
