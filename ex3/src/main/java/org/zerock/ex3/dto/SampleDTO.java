package org.zerock.ex3.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data // getter setter, toString 자동 생성
@Builder(toBuilder = true)
public class SampleDTO {
  private Long sno;
  private String first;
  private String last;
  private LocalDateTime regTime;
}