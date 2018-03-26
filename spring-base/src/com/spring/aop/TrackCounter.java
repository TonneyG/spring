package com.spring.aop;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TrackCounter {
	private static Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	
	@Pointcut("execution(* com.spring.aop.CDPlayer.play(int)) && args(traceNumber)")
	public void trackPlayed(int traceNumber){}
	
	@Before("trackPlayed(traceNumber)")
	public void countTrack(int traceNumber){
		int currentCount = getPlayCount(traceNumber);
		map.put(traceNumber, currentCount+1);
		System.out.println(traceNumber);
	}
	
	public int getPlayCount(int traceNumber){
		return map.containsKey(traceNumber)?map.get(traceNumber):0;
	}
}
