package com.ssafy.member.model.service;

import com.ssafy.member.model.MemberDto;

public interface MemberService {

	int idCheck() throws Exception; // ���̵� �ߺ��˻�
	void joinMember(MemberDto memberdto) throws Exception; // ȸ������
	MemberDto loginMember(String userId, String password) throws Exception; // �α���
	
}
