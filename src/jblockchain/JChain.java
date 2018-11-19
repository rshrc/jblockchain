package jblockchain;

import chainframework.JBlockchain;

import java.security.Security;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class JChain extends JBlockchain {


    public static HashMap<String, TransactionOutput> UTXOs = new HashMap<>();
    private static int numberOfTransactions;
    private static ArrayList<Block> blockchain = new ArrayList<>();
    private static Transaction genesisTransaction;

    JChain() {
        super(4, 0.1f);
        numberOfTransactions = 0;
    }

    public static void main(String[] args) {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

        Wallet coinbase = new Wallet("Coinbase");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 1st Wallet Name : ");
        Wallet sender = new Wallet(scanner.next());
        System.out.println("Enter 2nd Waller Name : ");
        Wallet receiver = new Wallet(scanner.next());


        genesisTransaction = new Transaction(coinbase.publicKey, sender.publicKey, 1000f, null);
        genesisTransaction.generateSignature(coinbase.privateKey);     //manually sign the genesis transaction
        genesisTransaction.transactionId = "0"; //manually set the transaction id
        genesisTransaction.outputs.add(new TransactionOutput(genesisTransaction.reciepient, genesisTransaction.value, genesisTransaction.transactionId)); //manually add the Transactions Output
        UTXOs.put(genesisTransaction.outputs.get(0).id, genesisTransaction.outputs.get(0)); //its important to store our first transaction in the UTXOs list.

        System.out.println("Creating and Mining Genesis block... ");
        Block genesis = new Block("0");
        genesis.addTransaction(genesisTransaction);
        addBlock(genesis);

        System.out.println("\nNew Transaction ");

        Block blockOne = makeTransaction(sender, receiver, 500, genesis);
        numberOfTransactions++;
        Block SecondBlock = makeTransaction(receiver, sender, 300, blockOne);
        numberOfTransactions++;
        Block thirdBlock = makeTransaction(receiver, sender, 2.5f, SecondBlock);
        numberOfTransactions++;

        displayBlockDetails();
        System.out.println("Number of Transactions : " + numberOfTransactions);


    }

    private static Block makeTransaction(Wallet sender, Wallet receiver, float value, Block previousBlock) {
        Block currentBlock = new Block(previousBlock.hash);
        System.out.println(sender.walletName + " attempting to send funds " + value + " to " + receiver.walletName);
        currentBlock.addTransaction((sender.sendFunds(receiver.publicKey, value)));
        displayDetails(sender, receiver);
        return currentBlock;
    }


    private static void addBlock(Block newBlock) {
        newBlock.mineBlock(difficulty);
        blockchain.add(newBlock);
    }

    private static void displayDetails(Wallet sender, Wallet receiver) {
        System.out.println();
        System.out.println(sender.walletName + " balance is: " + sender.getBalance());
        System.out.println(receiver.walletName + " balance is: " + receiver.getBalance());
    }

    private static void displayBlockDetails() {
        for (Block blocks : blockchain) {
            System.out.println(blocks.hash);
        }
        System.out.println();
    }

    public static void genesisTransactionDetails() {
        System.out.println("Sender : " + genesisTransaction.sender);
    }

}