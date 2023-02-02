package com.bmicro.bootcoin.web;

import com.bmicro.bootcoin.entity.BootCoin;
import com.bmicro.bootcoin.service.BootCoinService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bootCoin")
public class BootCoinController {

    private final BootCoinService bootCoinService;

    public BootCoinController(BootCoinService bootCoinService) {
        super();
        this.bootCoinService = bootCoinService;
    }

    @PostMapping
    public BootCoin save(@RequestBody BootCoin bootCoin) {
        return this.bootCoinService.save(bootCoin);
    }

}
