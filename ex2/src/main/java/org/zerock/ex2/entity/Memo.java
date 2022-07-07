package org.zerock.ex2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tbl_memo")
@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Data
@Builder
public class Memo {
    @Id // primary key

    @GeneratedValue(strategy = GenerationType.IDENTITY) // pk를 자동으로 생성하고자할 때 사용 / autoincreament
    private long mno;

    @Column(length = 200, nullable = false)
    private String memoText;

}
