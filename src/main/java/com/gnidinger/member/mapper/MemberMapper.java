package com.gnidinger.member.mapper;

import com.gnidinger.member.dto.MemberPatchDto;
import com.gnidinger.member.dto.MemberPostDto;
import com.gnidinger.member.dto.MemberResponseDto;
import com.gnidinger.member.entity.Member;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberPostDtoToMember(MemberPostDto memberPostDto);
    Member memberPatchDtoToMember(MemberPatchDto memberPatchDto);
    MemberResponseDto memberToMemberResponseDto(Member member);
    List<MemberResponseDto> membersToMemberResponseDtos(List<Member> members);
}
