package tb.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tb.entity.Student;
import tb.mapper.StudentMapper;

import java.util.List;

/**
 * @author TB
 * @date 2019/3/9 - 16:00
 **/
@Service
public class studentService {
    @Autowired
    StudentMapper studentMapper;
    public Student get(String id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    public void add(Student student) {
        studentMapper.insert(student);
    }

    public void delete(String id) {
        studentMapper.deleteByPrimaryKey(id);
    }

    public void update(Student student) {
        studentMapper.updateByPrimaryKey(student);
    }

    public List<Student> getAll() {
        return studentMapper.selectAll();
    }
}
