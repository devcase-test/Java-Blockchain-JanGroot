package io.sytac.syco;

import java.security.MessageDigest;
import java.time.LocalDateTime;

public class Block {

    private final int index;
    private final String previousHash;
    private final LocalDateTime timestamp;
    private final Transaction transaction;
    private String hash;
    private final MessageDigest digest = null; // Use SHA-256


    public Block(int index, String previousHash, LocalDateTime timestamp, Transaction transaction) {
        this.index = index;
        this.previousHash = previousHash;
        this.timestamp = timestamp;
        this.transaction = transaction;
        this.hash = calculateHash();
    }

    private String calculateHash() {
        throw new UnsupportedOperationException("Return hash of index, timestamp, transaction");
    }
}
