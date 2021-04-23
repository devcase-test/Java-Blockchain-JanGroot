package io.sytac.syco;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class BlockchainTests {

    private final Blockchain chain = new SytacBlockchain();

    @Test
    @DisplayName("When blockchain is created, should create a Genesis block")
    public void testCreateGenesisBlock() {
        assertThat(chain.length()).isEqualTo(1);
    }

    @Test
    @DisplayName("If I attempt to add a block with an invalid hash, it should not be added")
    public void testBlockWithInvalidHash() {
        chain.addBlock(new Block(1, "invalidHash", LocalDateTime.now(), new Transaction("", "", 50D)));
        assertThat(chain.length()).isEqualTo(1);
    }

    @Test
    @DisplayName("Test Legitimate blocks")
    public void testLegitimateBlocks() {
        chain.addBlock(new Block(chain.length(), chain.getLatestHash(), LocalDateTime.now(), new Transaction(UUID.randomUUID().toString(), UUID.randomUUID().toString(), 50D)));
        chain.addBlock(new Block(chain.length(), chain.getLatestHash(), LocalDateTime.now(), new Transaction(UUID.randomUUID().toString(), UUID.randomUUID().toString(), 40D)));

        assertThat(chain.length()).isEqualTo(3);
    }
}