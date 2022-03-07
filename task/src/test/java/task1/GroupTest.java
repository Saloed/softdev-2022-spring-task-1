package task1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс выглядит вот так:
 * ---------------Math-IT-Physics-English
 * Слиман Х.С------2---2-----3-------3---
 * Корж М.А--------4---2-----5-------3---
 * Борецкий С.О----2---4-----3-------5---
 * Шторм С.С-------3---2-----4-------5---
 * Брык Д.Д--------2---3-----5-------2---
 * Басов. С.А------4---4-----5-------5---
 */

class GroupTest {

    @Test
    void delName() {
        Group group = new Group(12,
                new ArrayList<>(Arrays.asList ("Слиман Х.С","Корж М.А","Борецкий С.О","Шторм С.С","Брык Д.Д","Басов. С.А")),
                new ArrayList<>(Arrays.asList ("Math","IT","Physics","English")),
                new ArrayList<>(Arrays.asList (2,2,3,3,4,2,5,3,2,4,3,5,3,2,4,5,2,3,5,2,4,4,5,5)));
        assertEquals(new ArrayList<>(Arrays.asList ("Корж М.А","Борецкий С.О","Шторм С.С","Брык Д.Д","Басов. С.А")),group.delName("Слиман Х.С"));
    }

    @Test
    void addName() {
        Group group = new Group(12,
                new ArrayList<>(Arrays.asList ("Слиман Х.С","Корж М.А","Борецкий С.О","Шторм С.С","Брык Д.Д","Басов. С.А")),
                new ArrayList<>(Arrays.asList ("Math","IT","Physics","English")),
                new ArrayList<>(Arrays.asList (2,2,3,3,4,2,5,3,2,4,3,5,3,2,4,5,2,3,5,2,4,4,5,5)));
        assertEquals(new ArrayList<>(Arrays.asList ("Слиман Х.С","Корж М.А","Борецкий С.О","Шторм С.С","Брык Д.Д","Басов. С.А","Ким Ж.Ч")),
                group.addName("Ким Ж.Ч"));
    }

    @Test
    void addSubject() {
        Group group = new Group(12,
                new ArrayList<>(Arrays.asList ("Слиман Х.С","Корж М.А","Борецкий С.О","Шторм С.С","Брык Д.Д","Басов. С.А")),
                new ArrayList<>(Arrays.asList ("Math","IT","Physics","English")),
                new ArrayList<>(Arrays.asList (2,2,3,3,4,2,5,3,2,4,3,5,3,2,4,5,2,3,5,2,4,4,5,5)));
        assertEquals(new ArrayList<>(Arrays.asList ("Math","IT","Physics","English","History")),group.addSubject("History"));
    }

    @Test
    void dellSubject() {
        Group group = new Group(12,
                new ArrayList<>(Arrays.asList ("Слиман Х.С","Корж М.А","Борецкий С.О","Шторм С.С","Брык Д.Д","Басов. С.А")),
                new ArrayList<>(Arrays.asList ("Math","IT","Physics","English")),
                new ArrayList<>(Arrays.asList (2,2,3,3,4,2,5,3,2,4,3,5,3,2,4,5,2,3,5,2,4,4,5,5)));
        assertEquals(new ArrayList<>(Arrays.asList ("Math","IT","English")),group.dellSubject("Physics"));
    }

    @Test
    void dellmark() {
        Group group = new Group(12,
                new ArrayList<>(Arrays.asList ("Слиман Х.С","Корж М.А","Борецкий С.О","Шторм С.С","Брык Д.Д","Басов. С.А")),
                new ArrayList<>(Arrays.asList ("Math","IT","Physics","English")),
                new ArrayList<>(Arrays.asList (2,2,3,3,4,2,5,3,2,4,3,5,3,2,4,5,2,3,5,2,4,4,5,5)));
        assertEquals(new ArrayList<>(Arrays.asList (4,null,5,3)),group.dellmark("Корж М.А","IT"));
        assertEquals(new ArrayList<>(Arrays.asList (2,2,3,null)),group.dellmark("Слиман Х.С","English"));
        assertEquals(new ArrayList<>(Arrays.asList (2,3,null,2)),group.dellmark("Брык Д.Д","Physics"));
    }

    @Test
    void changemark() {
        Group group = new Group(12,
                new ArrayList<>(Arrays.asList ("Слиман Х.С","Корж М.А","Борецкий С.О","Шторм С.С","Брык Д.Д","Басов. С.А")),
                new ArrayList<>(Arrays.asList ("Math","IT","Physics","English")),
                new ArrayList<>(Arrays.asList (2,2,3,3,4,2,5,3,2,4,3,5,3,2,4,5,2,3,5,2,4,4,5,5)));
        assertEquals(new ArrayList<>(Arrays.asList (4,3,5,3)),group.changemark(3,"Корж М.А","IT"));
        assertEquals(new ArrayList<>(Arrays.asList (2,2,3,5)),group.changemark(5,"Слиман Х.С","English"));
        assertEquals(new ArrayList<>(Arrays.asList (2,3,2,2)),group.changemark(2,"Брык Д.Д","Physics"));
    }
}