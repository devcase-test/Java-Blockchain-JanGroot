package io.sytac.syco;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class SytacBlockchain implements Blockchain {
    LinkedList<Block> chain;

    public SytacBlockchain() {
        this.chain = new LinkedList<>();
        chain.add(new Block(0,"", LocalDateTime.now(), null));
    }

    @Override
    public void addBlock(Block newBlock) {
        if (newBlock.transaction().amount() > 0 && newBlock.index() == length() && getLatestHash().equals(newBlock.previousHash())) {
               chain.add(newBlock);
        }
    }

    @Override
    public String getLatestHash() {
      return chain.getLast().hash();
    }

    @Override
    public int length() {
        return chain.size();
    }
}
