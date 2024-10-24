package com.example.demo.events;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EnrollmentListener {

    @EventListener
    public void handleEnrollmentEvent(EnrollmentEvent event) {
        // Отправить уведомление
        System.out.println("Student " + event.getStudent().getName() + " enrolled in course " + event.getCourse().getName());
    }
}
