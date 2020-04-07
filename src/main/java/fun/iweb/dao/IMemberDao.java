package fun.iweb.dao;

import fun.iweb.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface IMemberDao {

    @Select("select * from member where id=#{id}")
    public Member findById(Integer id) throws Exception;
}
