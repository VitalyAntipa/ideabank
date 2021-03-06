package com.dataart.fastforward.app.services;

import com.dataart.fastforward.app.dto.CommentDTO;
import com.dataart.fastforward.app.model.Comment;

import java.util.List;

/**
 * Created by logariett on 29.11.2016.
 */
public interface CommentService {

    void add(CommentDTO commentDTO, String username, long ideaId);
    Comment edit(CommentDTO commentDTO);
    void delete(long commentId);
    Comment getCommentById(long commentId);
    List<Comment> getAll();
}
