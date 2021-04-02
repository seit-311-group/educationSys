package cn.sysu.circuitQA.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Student {
    private Long id;
    private String username;
    private String password;
    private String classAndGrade;
}
