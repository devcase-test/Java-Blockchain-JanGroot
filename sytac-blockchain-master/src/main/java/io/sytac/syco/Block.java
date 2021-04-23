package io.sytac.syco;

import org.apache.commons.codec.digest.DigestUtils;

import java.time.LocalDateTime;

record Block(int index, String previousHash, LocalDateTime timeStamp, Transaction transaction, String hash) {

    Block(int index, String previousHash, LocalDateTime timeStamp, Transaction transaction) {
        this(index, previousHash, timeStamp, transaction, digest.digestAsHex("" + index + timeStamp + transaction + previousHash));
    }

    static DigestUtils digest = new DigestUtils("SHA3-256");
}