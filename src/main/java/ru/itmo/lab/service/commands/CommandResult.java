package ru.itmo.lab.service.commands;

import ru.itmo.lab.service.CommandStatus;

import java.util.Date;


public class CommandResult {
    // what's happen?
    String message;
    // status of result(success or not) enum
    CommandStatus status;
    // data result
    Date dateOfCommand;

    CommandResult(String message, CommandStatus status) {
        this.message = message;
        this.status = status;
        dateOfCommand = new Date();
    }
}
