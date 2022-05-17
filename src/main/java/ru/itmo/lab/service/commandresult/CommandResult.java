package ru.itmo.lab.service.commandresult;

import ru.itmo.lab.entity.Dragon;
import ru.itmo.lab.service.OutputMessage;
import ru.itmo.lab.service.commands.Command;

import java.util.Date;
import java.util.Deque;
import java.util.List;
import java.util.Map;


public class CommandResult {
    // what's happen?
    protected String message;
    // status of result(success or not) enum
    protected CommandStatus status;
    // data result
    protected Date dateOfCommand;
    // result
    protected List<Dragon> listOfDragons;
    protected List<Integer> list;
    protected Map<String, Command> mapOfCommand;
    protected Deque<String> deque;
    protected String data;
    protected Dragon dragon;
    protected boolean isExit = false;

    public void showCommandResult(){
        if(status.equals(CommandStatus.SUCCESSFUL) ) {
            OutputMessage.printSuccessfulMessage(message);
        } else {
            OutputMessage.printErrorMessage(message);
        }

        if(listOfDragons != null) {
            for(Dragon dragon: listOfDragons) {
                System.out.println(dragon);
            }
        }
        if(list != null) {
            for(Integer i: list) {
                System.out.println(i);
            }
        }
        if(mapOfCommand != null) {
            for(Command command: mapOfCommand.values()) {
                System.out.println(command);
            }
        }
        if(deque != null) {
            for(String string: deque) {
                System.out.println(string);
            }
        }
        if(data != null) {
            System.out.println(data);
        }
        if(dragon != null) {
            System.out.println(dragon);
        }
        if(isExit) {
            System.exit(0);
        }
    }


}
