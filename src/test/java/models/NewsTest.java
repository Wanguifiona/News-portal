package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class NewsTest {
    @Test
    public void news_instantiatesCorrectly_true() {
        News testnews = new News("Natural disaster strikes", "Weather");
        assertEquals(true, testnews instanceof News);
    }


    @Test
    public void title_returnsTitle_title(){
        News testnews = new News("Natural disaster strikes", "Weather");
        assertEquals("Weather", testnews.getTitle());
    }

    @Test
    public void description_returnsDescription() {
        News testnews = new News("Natural disaster strikes", "Weather");
        assertEquals("Natural disaster strikes", testnews.getDescription());
    }

    @Test
    public void description_returnsType() {
        News testnews = new News("Natural disaster strikes", "Weather");
        assertEquals("General", testnews.getType());
    }

    @Test
    public void description_setsType() {
        News testnews = new News("Natural disaster strikes", "Weather");
        testnews.setType("Department");
        assertEquals("Department", testnews.getType());
    }

    @Test
    public void description_returnsId() {
        News testnews = new News("Natural disaster strikes", "Weather");
        testnews.setId(5);
        assertEquals(5, testnews.getId());
    }

    @Test
    public void title_setsTitle() {
        News testnews = new News("Natural disaster strikes", "Weather");
        testnews.setTitle("Eruption");
        assertEquals("Eruption", testnews.getTitle());
    }

    @Test
    public void title_setsDescription() {
        News testnews = new News("Natural disaster strikes", "Weather");
        testnews.setDescription("Volcano spews lava");
        assertEquals("Volcano spews lava", testnews.getDescription());
    }

    @Test
    public void news_titleAndDescriptionAreTheSame_true() {
        News firstnews = new News("Natural disaster strikes", "Weather");
        News secondnews = new News("Natural disaster strikes", "Weather");
        assertEquals(true, firstnews.equals(secondnews));
    }

    public News createNews(){
        return new News("Natural disaster strikes","Weather");
    }
}