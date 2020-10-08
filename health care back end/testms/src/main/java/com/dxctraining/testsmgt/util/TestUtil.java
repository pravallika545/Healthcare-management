package com.dxctraining.testsmgt.util;

import com.dxctraining.testsmgt.dto.TestDto;
import com.dxctraining.testsmgt.entities.Test;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class TestUtil {
    public List<TestDto> testDtos(Collection<Test> tests) {
        List<TestDto> list = new ArrayList<>();
        for (Test test : tests) {
            TestDto testDto = toDto(test);
            list.add(testDto);
        }
        return list;
    }

    public TestDto toDto(Test test) {
        TestDto dto = new TestDto();
        dto.setId(test.getId());
        dto.setName(test.getName());
        dto.setCenterId(test.getCenterId());
        return dto;
    }
}
