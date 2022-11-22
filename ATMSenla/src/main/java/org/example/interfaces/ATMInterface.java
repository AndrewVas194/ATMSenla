package org.example.interfaces;

import org.example.entity.ATM;

public interface ATMInterface {
    ATMInterface setBalance(long balance);
    ATM build();
}
