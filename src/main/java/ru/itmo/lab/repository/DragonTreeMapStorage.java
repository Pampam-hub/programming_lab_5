package ru.itmo.lab.repository;

import ru.itmo.lab.entity.Dragon;
import ru.itmo.lab.repository.exceptions.EntityNotFoundException;
import ru.itmo.lab.service.commands.Command;

import java.time.LocalDate;
import java.util.*;

public class DragonTreeMapStorage implements Storage<Dragon, Integer> {
    // подумать над айдишником
    private final Map< Integer, Dragon > dragonTreeMap;
    private final Map< String, Command > help = new HashMap<>();
    private final Deque<Command> history = new ArrayDeque<>();
    private LocalDate dateOfInitialization;

    public DragonTreeMapStorage() {
        dateOfInitialization = LocalDate.now();
        dragonTreeMap = new TreeMap<>();
    }


    /*
    public DragonTreeMapStorage(Command helpCommand,
                                Command infoCommand,
                                Command showCommand,
                                Command insertCommand,
                                Command updateCommand,
                                Command removeKeyCommand,
                                Command clearCommand,
                                Command saveCommand,
                                Command executeScriptCommand,
                                Command exitCommand,
                                Command removeLowerCommand,
                                Command historyCommand,
                                Command removeLowerKeyCommand,
                                Command minByAgeCommand,
                                Command filterGreaterThanTypeCommand,
                                Command printFieldDescendingCommand) {
        help.put(helpCommand.getName(), helpCommand);
        help.put(infoCommand.getName(), infoCommand);
        help.put(showCommand.getName(), showCommand);
        help.put(insertCommand.getName(), insertCommand);
        help.put(updateCommand.getName(), updateCommand);
        help.put(removeKeyCommand.getName(), removeKeyCommand);
        help.put(clearCommand.getName(), clearCommand);
        help.put(saveCommand.getName(), saveCommand);
        help.put(executeScriptCommand.getName(),
                executeScriptCommand);
        help.put(exitCommand.getName(), exitCommand);
        help.put(removeLowerCommand.getName(),
                removeLowerCommand);
        help.put(historyCommand.getName(), historyCommand);
        help.put(removeLowerKeyCommand.getName(),
                removeKeyCommand);
        help.put(minByAgeCommand.getName(), minByAgeCommand);
        help.put(filterGreaterThanTypeCommand.getName(),
                filterGreaterThanTypeCommand);
        help.put(printFieldDescendingCommand.getName(),
                printFieldDescendingCommand);
    }
    */

    @Override
    public Dragon save(Dragon entity) {
        dragonTreeMap.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Dragon read(Integer id)
            throws EntityNotFoundException {
        Dragon dragon = dragonTreeMap.get(id);
        if(dragon == null) {
            throw new EntityNotFoundException(Dragon.class, id);
        }
        return dragon;
    }

    @Override
    public Dragon update(Integer id, Dragon entity)
            throws EntityNotFoundException {
        if(!dragonTreeMap.containsKey(id)) {
            throw new EntityNotFoundException(Dragon.class, id);
        }
        dragonTreeMap.replace(id, entity);
        return dragonTreeMap.get(id);
    }

    @Override
    public boolean remove(Integer id)
            throws EntityNotFoundException{
        if(!dragonTreeMap.containsKey(id)) {
            throw new EntityNotFoundException(Dragon.class, id);
        }
        dragonTreeMap.remove(id);
        return true;
    }

    @Override
    public boolean removeLower(Integer id)
            throws EntityNotFoundException {
        if(!dragonTreeMap.containsKey(id)) {
            throw new EntityNotFoundException(Dragon.class, id);
        }
        for(Integer i=0; i < id; i++)
            dragonTreeMap.remove(i);
        return true;
    }

    @Override
    public boolean removeAll() {
        dragonTreeMap.clear();
        return false;
    }

    @Override
    public List<Dragon> readAll() {
        return new ArrayList<>(dragonTreeMap.values());
    }

    @Override
    public Dragon min(Comparator<Dragon> com) {
        List<Dragon> listHelper
                = new ArrayList<>(dragonTreeMap.values());
        listHelper.sort(com);
        return listHelper.get(listHelper.size()-1);
    }

    @Override
    public List<Dragon> sortDragons(Comparator<Dragon> com) {
        List<Dragon> listHelper
                = new ArrayList<>(dragonTreeMap.values());
        listHelper.sort(com);
        return listHelper;
    }

    @Override
    public void addHistory(Command command) {
        int numElements = 12;
        if(history.size() == numElements) {
            history.removeFirst();
        }
        history.offerLast(command);
    }

    public LocalDate getDateOfInitialization() {
        return dateOfInitialization;
    }

    public Map<Integer, Dragon> getDragonTreeMap() {
        return dragonTreeMap;
    }
}
