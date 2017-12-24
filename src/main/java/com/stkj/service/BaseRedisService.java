package com.stkj.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public  class BaseRedisService extends RedisGeneratorService<String, String>  {
  
	
	 public boolean add(final String key,final String value) { 
        boolean result = txRedisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = getRedisSerializer();  
                byte[] keyId  = serializer.serialize(key);  
                byte[] valyeId = serializer.serialize(value);
                connection.set(keyId, valyeId);
                return true;
			}  
        });
        return result;  
	 }  
	      
	    
	    public boolean add(final List<String> list) {  
	        Assert.notEmpty(list);  
	        boolean result = txRedisTemplate.execute(new RedisCallback<Boolean>() {  
	            public Boolean doInRedis(RedisConnection connection)  
	                    throws DataAccessException {  
	                RedisSerializer<String> serializer = getRedisSerializer();  
	                for (String user : list) {  
	                    byte[] key  = serializer.serialize(user);  
	                    byte[] name = serializer.serialize(user);  
	                    connection.setNX(key,name);  
	                }  
	                return true;  
	            }  
	        }, false, true);  
	        return result;  
	    }  
	      
	   
	    public void delete(String key) {  
	        List<String> list = new ArrayList<String>();  
	        list.add(key);  
	        delete(list);  
	    }  
	  
	  
	    public void delete(List<String> keys) {  
	    	txRedisTemplate.delete(keys);  
	    }  
	  
	    public String get(final String keyId) {  
	        String result = txRedisTemplate.execute(new RedisCallback<String>() {  
	            public String doInRedis(RedisConnection connection)  
	                    throws DataAccessException {  
	                RedisSerializer<String> serializer = getRedisSerializer();  
	                byte[] key = serializer.serialize(keyId);  
	                byte[] value = connection.get(key);  
	                if (value == null) {  
	                    return null;  
	                }  
	                String name = serializer.deserialize(value);  
	                return name;
	            }  
	        });  
	        return result;  
	    } 
}