package com.examly.springapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.AccountStatusLog;

@Service
public interface AccountStatusLogService {

  public AccountStatusLog addAccountStatusLog(AccountStatusLog accountStatusLog);
  public List<AccountStatusLog> getAllAccountStatusLog();
  public AccountStatusLog getAccountStatusLog(long id);
  public AccountStatusLog putAccountStatusLog(long id,AccountStatusLog accountStatusLog);
  public boolean deleteAccountStatusLog(long id);
}
