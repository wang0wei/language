package com.bjsxt.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.bjsxt.pojo.Account;
import com.bjsxt.pojo.Log;
import com.bjsxt.service.AccountService;

public class AccountServiceImpl implements AccountService {

	@SuppressWarnings("deprecation")
	@Override
	public int transfer(Account accIn, Account accOut) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		//���ж��˻��������Ƿ�ƥ��
		Account accOutSelect = session.selectOne("com.bjsxt.mapper.AccountMapper.selByAccnoPwd",accOut);
		if(accOutSelect!=null) {
			if(accOutSelect.getBalance()>=accOut.getBalance()) {
				Account accInSelect  = session.selectOne("com.bjsxt.mapper.AccountMapper.selByAccnoName",accIn);
				if(accInSelect!=null) {
					accIn.setBalance(accOut.getBalance());
				    accOut.setBalance(-accOut.getBalance());
					int index = session.update("com.bjsxt.mapper.AccountMapper.updBalanceByAccno",accOut);				
					index+=session.update("com.bjsxt.mapper.AccountMapper.updBalanceByAccno",accIn);
					if(index==2) {
						//��־����¼
						Log log=new Log();
						log.setAccIn(accIn.getAccNo());
						log.setAccOut(accOut.getAccNo());
						log.setMoney(accIn.getBalance());
						session.insert("com.bjsxt.mapper.LogMapper.insLog",log);
						//��־�ļ���¼
						Logger logger=Logger.getLogger(AccountServiceImpl.class);
						logger.info(log.getAccOut()+" �� "+log.getAccIn()+" �� "+new Date().toLocaleString()+" ת�� "+log.getMoney());
						session.commit();
						session.close();
						return SUCCESS;
					}else {
						session.rollback();
						session.close();
						return ERROR;
					}
				}else {
					//�˻���������ƥ��
					return ACCOUNT_NAME_NOT_MATH;
				}
			}else {
				//����
				return ACCOUNT_BALANCE_NOT_ENOUGH;
			}
		}else {
			//�˺ź����벻ƥ��
			return ACCOUNT_PASSWORD_NOT_MATCH;
		}
		
	}

}