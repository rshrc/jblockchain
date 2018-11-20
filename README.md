
# jblockchain - OpenSource Java Blockchain Framework

One stop Java Framework for making small and scalable blockchain platforms, with minimal dependencies.

## Directory Structure
![dir](https://i.imgur.com/mNzksOm.png)

## Project
The Project jblockchain has two packages, the chainframework and jblockchain.
jblockchain has classes that implement the interfaces and inherits properties from classes in the chainframework package to make a single class JChain which allows a developer to make custom blockchains with minimum hassle. All encryption, mining algorithms and transaction logic is readily available in the jblockchain package. 

## Dependencies
Bounceycastle and GSON.

## Interfaces

#### BlockInterface
A Simple Block Interface which declares what functions a Block Class must have and implement

#### TransactionInterface
A Transaction Interface which declares what functions a Transaction Class must have and implement

#### TransactionInputInterface and TranscationOutputInterface
Two simple interfaces that declare the logic layout of transactions between two entities

#### WalletInterface
Interface to structure how a Wallet should behave like

## Classes

#### JBlockchain
A Class which declares all the attriutes that a blockchain should have and implements the logic of chain validity

#### Block
This class implements the BlockInterface methods

#### StringUtil
Class Utility which has the implementations of SHA256 Algorithms which is required for generating hashes

#### Transaction, TransactionInput and TransactionOutput
Classes that implement their respective interfaces

#### Wallet
This class implements the Wallet Interface

#### JChain
This class uses the JBlockchain class as a superclass and makes a mock Blockchain which does three transactions between 2 Wallets having their instances running on the same machine.

