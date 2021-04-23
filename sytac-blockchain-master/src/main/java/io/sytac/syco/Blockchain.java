package io.sytac.syco;

public interface Blockchain {
    void addBlock(Block newBlock);

    String getLatestHash();

    int length();
}
