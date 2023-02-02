package com.bmicro.bootcoin.service;

import com.bmicro.bootcoin.entity.BootCoin;
import org.springframework.stereotype.Service;

@Service
public class BootCoinService {

    private final BootCoinEventsService bootCoinEventsService;

    public BootCoinService(BootCoinEventsService bootCoinEventsService) {
        super();
        this.bootCoinEventsService = bootCoinEventsService;
    }

    public BootCoin save(BootCoin bootCoin) {
        System.out.println("Received " + bootCoin);
        this.bootCoinEventsService.publish(bootCoin);
        return bootCoin;

    }

}
