package com.neuedu.olssm.mapper;

import com.neuedu.olssm.po.Token;

public interface TokenMapper {
	public void add(Token token);
	
	public void update(Token token);
	
	public Token getTokenByTokenStr(String tokenStr);
	
	public Token getTokenByUserId(Long userId);
}
