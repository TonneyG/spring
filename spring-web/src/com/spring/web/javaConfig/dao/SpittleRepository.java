package com.spring.web.javaConfig.dao;

import java.util.List;

import com.spring.web.javaConfig.pojo.Spittle;

public interface SpittleRepository {
	List<Spittle> findSpittles(long max,int count);
}
