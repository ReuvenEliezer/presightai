package com.presight.ai.consumer.services;

import com.presight.ai.consumer.entities.Call;
import com.presight.ai.consumer.entities.Phone;
import com.presight.ai.consumer.entities.RegineTypeEnum;
import com.presight.ai.consumer.repositories.CallRepository;
import com.presight.ai.consumer.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class OnAppReadyEvent implements ApplicationListener<ApplicationReadyEvent> {


    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private CallRepository callRepository;


    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Phone phoneFrom = new Phone("+972501234567");
//        phoneRepository.save(phoneFrom);
        Phone phoneTo = new Phone("+972500000000");
//        phoneRepository.save(phoneTo);
        Call call = new Call(phoneFrom.getPhoneNumber(), phoneTo.getPhoneNumber(), LocalDateTime.now(), Duration.ofHours(1), RegineTypeEnum.ISRAEL, RegineTypeEnum.US);
        Call callSaved = callRepository.save(call);

        phoneRepository.createReportRelationship(callSaved.getFromPhoneNum(), callSaved.getId());

//        Phone phone = new Phone("+972501234567");
//        phone.addPhoneDestination(new Phone("+972500000000"));

        List<Call> all1 = callRepository.findAll();
        List<Phone> all = phoneRepository.findAll();
    }
}
