package cn.sysu.circuitQA.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Record {
    private Integer id;
    private String question;
    private String time;
    private Integer studentid;
}
