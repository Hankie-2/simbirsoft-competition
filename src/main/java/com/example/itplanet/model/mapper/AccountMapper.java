package com.example.itplanet.model.mapper;

import com.example.itplanet.model.entity.Account;
import com.example.itplanet.model.response.AccountResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper extends BaseMapper<Account, AccountResponse> {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);
}
