 package com.example.demo.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.example.demo.entity.Ii;

@Mapper
public interface IiMapper {

	@Select("select * from ii")
     List<Ii> Select();
	
	@Insert("insert into ii (id1,id2,id3) values(#{id1},#{id2},#{id3})")
    void insert(Ii i);
	
	@Delete("delete  from ii where id1=#{id} ")
	void delete(@Param("id") String id);
}
