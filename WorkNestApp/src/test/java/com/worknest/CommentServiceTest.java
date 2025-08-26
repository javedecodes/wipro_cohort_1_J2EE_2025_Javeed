package com.worknest;



import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.worknest.dao.CommentDao;
import com.worknest.model.Comment;
import com.worknest.service.impl.CommentServiceImpl;

class CommentServiceTest {

    @InjectMocks
    private CommentServiceImpl commentService;

    @Mock
    private CommentDao commentDao;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddComment() {
        Comment comment = new Comment();
        comment.setContent("Great work!");
        commentService.addComment(comment);
        verify(commentDao, times(1)).save(comment);
    }

    @Test
    void testGetCommentsByTaskId() {
        // Arrange
        Comment c1 = new Comment();
        Comment c2 = new Comment();
        when(commentDao.findByTaskId(1)).thenReturn(Arrays.asList(c1, c2));

        // Act
        List<Comment> comments = commentService.getCommentsByTaskId(1);

        // Assert
        assertEquals(2, comments.size());
        verify(commentDao, times(1)).findByTaskId(1);
    }
}