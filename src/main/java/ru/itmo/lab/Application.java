package ru.itmo.lab;

import ru.itmo.lab.entity.Dragon;
import ru.itmo.lab.repository.DragonTreeMapStorage;
import ru.itmo.lab.repository.comparators.DragonAgeComparator;
import ru.itmo.lab.repository.exceptions.EntityNotFoundException;
import ru.itmo.lab.service.commands.ClearCommand;
import ru.itmo.lab.service.commands.Command;

import java.util.*;

public class Application {
    public static void main(String[] args) throws EntityNotFoundException {
        /*
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        List<? super Number> nums = Collections.singletonList(ints);
        nums.add(1);
        System.out.println(nums);
        */
        /*
        Map<Integer, Dragon> map = new TreeMap<>();
        map.put(1,new Dragon("pum", 1));
        map.put(2,new Dragon("piu", 100));
        map.put(4,new Dragon("bi", 30));
        Map<String, String> arg = new HashMap<>();
        DragonAgeComparator comparator = new DragonAgeComparator();
        */

        Deque<Integer> dequeue = new ArrayDeque<>();
        dequeue.addLast(1);
        dequeue.addLast(2);
        dequeue.addLast(3);
        dequeue.addLast(7);
        System.out.println(dequeue);
        System.out.println(dequeue.size());
    }

}
