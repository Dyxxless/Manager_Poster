package ru.netology.poster;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PosterManagerTest {
    PosterManager manager = new PosterManager();

    @Test //на добавление фильмов
    public void shouldAddFilm() {
        manager.addFilm("Film1");
        manager.addFilm("Film2");
        manager.addFilm("Film3");

        String[] expected = {"Film1", "Film2", "Film3"};
        String[] actual = manager.getFilm();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test //на добавление фильмов с конструктором с лимитом
    public void shouldWithLimit() {
        PosterManager manager = new PosterManager(3);
        manager.addFilm("Film1");
        manager.addFilm("Film2");
        manager.addFilm("Film3");
        manager.addFilm("Film4");

        String[] expected = {"Film4", "Film3", "Film2"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test //на показ фильмов от нового к старому при превышении 10шт (с конструктором без параметров)
    public void shouldAddFilmOverLimit() {
        manager.addFilm("Film1");
        manager.addFilm("Film2");
        manager.addFilm("Film3");
        manager.addFilm("Film4");
        manager.addFilm("Film5");
        manager.addFilm("Film6");
        manager.addFilm("Film7");
        manager.addFilm("Film8");
        manager.addFilm("Film9");
        manager.addFilm("Film10");
        manager.addFilm("Film11");
        manager.addFilm("Film12");

        String[] expected = {"Film12", "Film11", "Film10", "Film9", "Film8", "Film7", "Film6", "Film5", "Film4", "Film3"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test //на показ всех введённых фильмов
    public void shouldShowAll() {
        manager.addFilm("Film1");
        manager.addFilm("Film2");
        manager.addFilm("Film3");
        manager.findAll();

        String[] expected = {"Film1", "Film2", "Film3"};
        String[] actual = manager.getFilm();

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test //на показ от нового к старому при добавлении 5 фильмов
    public void shouldShowLastFilmsIfLessLimit() {
        PosterManager manager = new PosterManager(5);
        manager.addFilm("Film1");
        manager.addFilm("Film2");
        manager.addFilm("Film3");
        manager.addFilm("Film4");
        manager.addFilm("Film5");

        String[] expected = {"Film5", "Film4", "Film3", "Film2", "Film1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test //на показ от нового к старому при добавлении более 10 фильмов (12) с конструктором с параметрами
    public void shouldAddFilmOverLimitWithArray() {
        PosterManager manager = new PosterManager(12);
        manager.addFilm("Film1");
        manager.addFilm("Film2");
        manager.addFilm("Film3");
        manager.addFilm("Film4");
        manager.addFilm("Film5");
        manager.addFilm("Film6");
        manager.addFilm("Film7");
        manager.addFilm("Film8");
        manager.addFilm("Film9");
        manager.addFilm("Film10");
        manager.addFilm("Film11");
        manager.addFilm("Film12");

        String[] expected = {"Film12", "Film11", "Film10", "Film9", "Film8", "Film7", "Film6", "Film5", "Film4", "Film3", "Film2", "Film1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}