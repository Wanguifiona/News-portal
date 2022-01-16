package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class NewsTest {
    @Test
    public void news_instantiatesCorrectly_true() {
        News testnews = new News("Natural disaster strikes");
        assertEquals(true, testnews instanceof News);
    }


    @Test
    public void title_returnsTitle_title(){
        News testnews = new News("Natural disaster strikes");
        assertEquals("Natural disaster strikes", testnews.getPost());
    }


    @Test
    public void news_titleAndDescriptionAreTheSame_true() {
        News firstnews = new News("Natural disaster strikes");
        News secondnews = new News("Natural disaster strikes");
        assertEquals(true, firstnews.equals(secondnews));
    }

    public News createNews(){
        return new News("Natural disaster strikes");
    }
}