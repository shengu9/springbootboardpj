package org.spring.springbootboardpj.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.spring.springbootboardpj.dto.MemberDto;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "member_tb_03")
public class MemberEntity {     // member_entity


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // auto_increament
    @Column(name = "member_id")
    private Long id;
            // 칼럼명, not null
    @Column(name ="member_name", nullable = false)
    private String name;

    @Column(name ="member_email", nullable = false, unique = true)
    private String email;

    @CreationTimestamp
    @Column(updatable = false)     // 수정시 X
    private LocalDateTime createTime;

    @UpdateTimestamp  // 수정 시간 자동
    @Column(insertable = false) // 처음 생성 시간 X
    private LocalDateTime updateDateTime;

    // 1 : 다 , 1 : N
    // 연관 관계의 주인
    @OneToMany(mappedBy = "memberEntity")
    private List<BoardEntity> boardEntityList = new ArrayList<>();

    // Dto -> Entity
    // 회원 가입 -> 글쓰기
    public static MemberEntity toMemberEntity(MemberDto memberDto){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setName(memberDto.getName());
        memberEntity.setEmail(memberDto.getEmail());

        return memberEntity;
    }

    public static MemberEntity toMemberEntity2(MemberDto memberDto){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setId(memberDto.getId());
        return memberEntity;
    }


}
