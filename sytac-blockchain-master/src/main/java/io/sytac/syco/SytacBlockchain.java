package io.sytac.syco;

public class SytacBlockchain implements Blockchain {

    public SytacBlockchain() {
        // TODO: Create Genesis Block, index = 0. previous hash = ""
        // Use a simple collections object, no need to get fancy with merkle trees etc.
    }

    @Override
    public void addBlock(Block newBlock) {
        throw new UnsupportedOperationException("Check if chain is valid before adding block. If chain isn't valid do nothing");
        //TODO: Validate block transaction data. transaction values must be greater than 0
        //TODO: For each block on the chain currentBlock.hash must be equal to currentBlock.calculateHash()
        //TODO: For each block on the chain currentBlock.previousHash must be equal to previousBlock.hash
    }

    @Override
    public String getLatestHash() {
        throw new UnsupportedOperationException("Return latest hash from the blockchain");
    }

    @Override
    public int length() {
        throw new UnsupportedOperationException("Return length of blockchain");
    }
}
