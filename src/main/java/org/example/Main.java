package org.example;

import org.example.Communication.Email;
import org.example.Communication.SMS;
import org.example.config.CompanyMessageSettings;
import org.example.models.*;
import org.example.models.Employee;
import org.example.models.Executive;
import org.example.models.Manager;
import org.example.service.BatchScheduler;
import org.example.service.MessageService;

import java.util.List;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            System.out.println("i = " + i);


        Email email = new Email();
        SMS sms = new SMS();

        Employee dev = new Developer("Dev A", "dev@example.com", "123456", List.of(email, sms), email);
        Employee mgr = new Manager("Mgr B", "mgr@example.com", "654321", List.of(email), email);
        Employee exec = new Executive("Exec C", "exec@example.com", "111111", List.of(sms), sms);

        CompanyMessageSettings settings = new CompanyMessageSettings();
        settings.setAllowedRoles(MessageType.SYS_OUT, Set.of("Developer", "Manager"));
        settings.setAllowedRoles(MessageType.GEN_CORR, Set.of("Executive", "Manager", "Developer"));
        settings.setSendImmediately(MessageType.SYS_OUT, true);
        settings.setSendImmediately(MessageType.GEN_CORR, false);

        Company entegral = new Company("XYZ", settings);
        entegral.addEmployee(dev);
        entegral.addEmployee(mgr);
        entegral.addEmployee(exec);

        MessageService messageService = new MessageService();
        messageService.sendMessage(entegral, new Message(MessageType.SYS_OUT, "System will be down at 2AM."));
        messageService.sendMessage(entegral, new Message(MessageType.GEN_CORR, "Company picnic this weekend!"));
        messageService.sendMessage(entegral, new Message(MessageType.GEN_CORR, "Don't forget to RSVP."));

        new BatchScheduler(messageService).runNightlyBatch();

    }
    }
