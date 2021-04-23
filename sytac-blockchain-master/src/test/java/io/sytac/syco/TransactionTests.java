package io.sytac.syco;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class TransactionTests {

    private final Blockchain chain = new SytacBlockchain();

    @Test
    @DisplayName("If a transaction is called with nullable addresses, then it should not be added to the chain")
    void checkNullTransactionValues() {
        chain.addBlock(new Block(chain.length(), chain.getLatestHash(), LocalDateTime.now(), new Transaction(null, null, 0D)));
        assertThat(chain.length()).isEqualTo(1);
    }
}