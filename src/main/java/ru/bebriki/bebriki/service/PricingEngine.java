package ru.bebriki.bebriki.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.bebriki.bebriki.dtos.TaskDTO;
import ru.bebriki.bebriki.dtos.WorkerDTO;
import ru.bebriki.bebriki.models.Worker;

//import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
@Service
public class PricingEngine {
    @Autowired
    TaskServiceImpl taskService;
    @Autowired
    WorkerServiceImpl workerService;

    //@Scheduled(fixedDelayString = "${interval}")
    //@Scheduled(cron = "@hourly")
    @Scheduled(cron = "* * * * * 1")
    public void getDayNumberOld() throws InterruptedException {
        System.out.println("adsadadadadadada");
        List<TaskDTO> taskDTOS=  taskService.getTasks();
        for(TaskDTO w:taskDTOS){
            if(Objects.isNull(w)) continue;
            LocalDate date = w.getDate();
            if(date!=LocalDate.now()){
                 taskService.changeBalance(workerService.getWorkerById(w.getWorkerId()));
            }
        }
        System.out.println("end");

    }


}
