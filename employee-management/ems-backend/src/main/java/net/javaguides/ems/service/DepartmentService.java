package net.javaguides.ems.service;
import java.util.List;
import net.javaguides.ems.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto createDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentBtId(Long departmentId);

    List<DepartmentDto>getAllDepartments();
}
