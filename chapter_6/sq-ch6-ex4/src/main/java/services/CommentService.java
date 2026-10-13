package services;

import aspects.ToLog;
import model.Comment;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CommentService {

    Logger logger = Logger.getLogger(CommentService.class.getName());

    public void setLogger(Logger logger){
        this.logger = logger;
    }


    public void editComment(Comment comment){
        logger.info("Editing Comment: " + comment.getContent());
    }

    @ToLog
    public void deleteComment(Comment comment){
        logger.info("Deleteing Comment: " + comment.getContent());
    }

    public void publishComment(Comment comment){

        logger.info("Publishing Comment: " + comment.getContent());

    }

}
