package com.example.nutech.dto.request;

import com.example.nutech.dto.response.TransactionHistoryResponse;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionHistoryWrapper {
    private int offset;
    private int limit;
    private List<TransactionHistoryResponse> records;
}
