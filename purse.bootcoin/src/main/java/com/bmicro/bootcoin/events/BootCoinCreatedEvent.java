package com.bmicro.bootcoin.events;

import com.bmicro.bootcoin.entity.BootCoin;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BootCoinCreatedEvent extends Event<BootCoin> {
}
