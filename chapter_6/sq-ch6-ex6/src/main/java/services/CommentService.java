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

    @ToLog
    public String publishComment(Comment comment){
        logger.info("Publishing Comment: " + comment.getContent());
        return "SUCCESS";
    }
}
