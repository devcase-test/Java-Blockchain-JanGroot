package io.sytac.syco;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class BlockTests {

    private final String from = UUID.randomUUID().toString();

    private final String to = UUID.randomUUID().toString();

    private final Blockchain chain = new SytacBlockchain();


    @Test
    @DisplayName("If a block with a null hash it should be dropped from the chain.")
    void nullHashInFirstBlock() {
        chain.addBlock(new Block(chain.length(), null, LocalDateTime.now(), new Transaction(from, to, 50D)));
        assertThat(chain.length()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("If a block with the wrong index is added, it should be dropped from the chain")
    void invalidIndexPassedInBlock(Integer index) {
        chain.addBlock(new Block(index, chain.getLatestHash(), LocalDateTime.now(), new Transaction(from, to, 50D)));
        assertThat(chain.length()).isEqualTo(1);
    }
}
