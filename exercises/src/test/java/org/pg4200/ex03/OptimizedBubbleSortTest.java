package org.pg4200.ex03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OptimizedBubbleSortTest {
    String array[];

    @BeforeEach
    void runBeforeAll() {
        array = new String[] {"c", "b", "a", "d", "e", "f"};
    }
    @Test
    void shouldSortUnOptimizedArray() {
        OptimizedBubbleSort<String> sort = new OptimizedBubbleSort<>();
        MyComparator<String> comparator = new MyComparator<>();
        String array[] = {"c", "b", "a", "d", "e", "f"};
        assertEquals(15, sort.sort(array,comparator,false));
    }
    @Test
    void shouldSortOptimizedArray() {
        OptimizedBubbleSort<String> sort = new OptimizedBubbleSort<>();
        MyComparator<String> comparator = new MyComparator<>();
        String array[] = {"c", "b", "a", "d", "e", "f"};
        assertEquals(6, sort.sort(array,comparator,true));
    }

    @Test
    void shouldSortGameUsers() {
        OptimizedBubbleSort<String> sort = new OptimizedBubbleSort<>();
        GameUser a = new GameUser("a",1);
        GameUser b = new GameUser("b",2);
        GameUser c = new GameUser("c",3);
        GameUser d = new GameUser("d",4);

        MyComparator<GameUser> comparator = new MyComparator<GameUser>();
        GameUser[] gameUsers = {a,b,c,d};

        int resultOfSort = sort.sort(gameUsers, comparator,true);
        assertEquals(3, resultOfSort);
        assertArrayEquals(new GameUser[]{a,b,c,d}, gameUsers);
    }
}
