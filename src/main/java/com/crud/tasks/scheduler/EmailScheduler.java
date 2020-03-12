package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class EmailScheduler {

    public static final String SUBJECT = "Tasks: Once a day email";

    @Autowired
    private SimpleEmailService simpleEmailService;


    //@Scheduled(fixedDelay = 10000)
    @Scheduled(cron = "0 0 10 * * *")
    public void sendInformationEmail() {
        long size = taskRepository.count();
        String taskAndTasks = size == 1 ? " task" : " tasks";
        simpleEmailService.send(new Mail(
                adminConfig.getAdminMail(),
                "",
                SUBJECT,
                "Currently in database you got " + size + taskAndTasks
        ));
    }

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AdminConfig adminConfig;
}
