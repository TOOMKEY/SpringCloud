package tb.mapper;


import org.springframework.stereotype.Repository;
import tb.entity.Student;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface StudentMapper extends Mapper<Student> {
}