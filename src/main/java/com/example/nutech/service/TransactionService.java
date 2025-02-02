package com.example.nutech.service;

import com.example.nutech.dto.request.TopUpRequest;
import com.example.nutech.dto.request.TransactionHistoryWrapper;
import com.example.nutech.dto.request.TransactionRequest;
import com.example.nutech.dto.response.BalanceResponse;
import com.example.nutech.dto.response.ResponseDTO;
import com.example.nutech.dto.response.TransactionResponse;

public interface TransactionService {
    ResponseDTO<BalanceResponse> getBalance(String token);
    ResponseDTO<BalanceResponse> topUp(String token, TopUpRequest topUpRequest);
    ResponseDTO<TransactionResponse> createTransaction(String token, TransactionRequest transactionRequest);
    ResponseDTO<TransactionHistoryWrapper> getTransactionHistory(String token, Integer offSet , Integer limit);
}
