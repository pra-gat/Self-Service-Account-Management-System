package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.AccountStatusLog;
import com.examly.springapp.repository.AccountStatusLogRepo;

@Service
public class AccountStatusLogServiceImpl implements AccountStatusLogService{
  @Autowired
  private AccountStatusLogRepo repoObj;

  @Override
  public AccountStatusLog addAccountStatusLog(AccountStatusLog accountStatusLog) {
    return repoObj.save(accountStatusLog);
  }

  @Override
  public List<AccountStatusLog> getAllAccountStatusLog() {
    return repoObj.findAll();
  }

  @Override
  public AccountStatusLog getAccountStatusLog(long id) {
    return repoObj.findById(id).orElse(null);
  }

  @Override
  public AccountStatusLog putAccountStatusLog(long id, AccountStatusLog accountStatusLog) {
    accountStatusLog.setId(id);
    return repoObj.save(accountStatusLog);
  }

  @Override
  public boolean deleteAccountStatusLog(long id) {
    if (!repoObj.existsById(id)) {
      return false;
    }
    repoObj.deleteById(id);
    return true;
  }
  
}

