package com.epam.interview.main;

import com.epam.interview.entity.Person;
import com.epam.interview.util.ListMerger;
import org.junit.Test;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * Created by Luka_Chapukhin on 6/9/2018.
 */
public class ListMergerTest {

    @Test
    public void mergeFirstNullLists() {
        List<String> resultStringList = ListMerger.merge(null, Arrays.asList("b", "d"));
        assertEquals(Arrays.asList("b", "d"), resultStringList);
    }


    @Test
    public void mergeNullLists() {
        List resultStringList = ListMerger.merge(null, null);
        assertEquals(Collections.emptyList(), resultStringList);
    }

    @Test
    public void mergeEmptyLists() {
        List resultStringList = ListMerger.merge(Collections.<String>emptyList(),Collections.emptyList());
        assertEquals(Collections.emptyList(), resultStringList);
    }

    @Test
    public void mergeSortedStringLists() {
        List<String> resultStringList = ListMerger.merge(Arrays.asList("a", "c"), Arrays.asList("b", "d"));
        assertEquals(Arrays.asList("a", "b", "c", "d"), resultStringList);
    }

    @Test
    public void mergeUnSortedStringLists() {
        List<String> resultStringList = ListMerger.merge(Arrays.asList("z", "e", "x"), Arrays.asList("f", "a"));
        assertEquals(Arrays.asList("a", "e", "f", "x", "z"), resultStringList);
    }

    @Test
    public void mergeUnSortedDoubleLists() {
        List<Double> resultStringList = ListMerger.merge(Arrays.asList(22.5, 77.1, 0.4),
                Arrays.asList(-5.0, -7.3, -7.32));
        assertEquals(Arrays.asList(-7.32, -7.3, -5.0, 0.4, 22.5, 77.1), resultStringList);
    }

    @Test
    public void mergeUnSortedPersonsLists() {
        List<Person> resultStringList = ListMerger.merge(
                Arrays.asList(new Person("Ivan","Ivanov",24),
                              new Person("Ivan","Sidorov",48)),
                Arrays.asList(new Person("Piotr","Petrov",19),
                              new Person("Bart","Simpson",14)));
        assertEquals(Arrays.asList(new Person("Bart","Simpson",14),
                                   new Person("Ivan","Ivanov",24),
                                   new Person("Ivan","Sidorov",48),
                                   new Person("Piotr","Petrov",19)
                                   ), resultStringList);
    }


}
