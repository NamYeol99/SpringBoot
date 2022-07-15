package org.zerock.mrerview.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.zerock.mrerview.entity.Member;

import javax.transaction.Transactional;
import java.util.stream.IntStream;


@SpringBootTest
public class MemberRepositoryTests {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired ReviewRepository reviewRepository;
    @Test
    public void insertMembers(){
        IntStream.rangeClosed(1,100).forEach(i->{
            Member member = Member.builder()
                    .email("r"+i + "@zerock.org")
                    .pw("1111")
                    .nickname("reviewer"+i).build();
            memberRepository.save(member);
        });
    }
    @Commit
    @Transactional
    @Test
    public void testDeleteMember(){
        Long mid = 2L; //Member의 mid
        Member member = Member.builder().mid(mid).build();
        //기존
//        memberRepository.deleteById(mid);
//        reviewRepository.deleteByMember(member);

        //순서주의(Fk쪽 먼저 삭제)
        reviewRepository.deleteByMember(member);
        memberRepository.deleteById(mid);
    }

}