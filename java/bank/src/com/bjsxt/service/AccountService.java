package com.bjsxt.service;

import java.io.IOException;

import com.bjsxt.pojo.Account;

public interface AccountService {
	//�˺ź����벻ƥ��״̬��
	int ACCOUNT_PASSWORD_NOT_MATCH=1;
	//����
	int ACCOUNT_BALANCE_NOT_ENOUGH=2;
	//�˻���������ƥ��
	int ACCOUNT_NAME_NOT_MATH=3;
	//ת��ʧ��
	int ERROR=4;
	//ת�˳ɹ�
	int SUCCESS=5;
	int transfer(Account accIn,Account accOut) throws IOException ;
}
