package br.edu.ifpr.foz.ifprstore.repositories;

import br.edu.ifpr.foz.ifprstore.models.Department;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DepartmentRepositoryTest {

    @Test
    public void deveExibirUmaListaDeDepartamentos() {
        DepartmentRepository repository = new DepartmentRepository();
        List<Department> departments = repository.getAll();
        for (Department d : departments) {
            System.out.println(d);
        }
    }

    @Test
    public void deveInserirUmRegistroNaTabelaDepartment() {
        DepartmentRepository repository = new DepartmentRepository();
        Department departmentFake = new Department();
        departmentFake.setName("New Department");
        Department department = repository.insert(departmentFake);
        System.out.println(department);
    }

    @Test
    public void deveAtualizarUmDepartment() {
        DepartmentRepository repository = new DepartmentRepository();
        Department department = repository.getById(1);
        department.setName("Updated Department");
        repository.update(department);
    }

    @Test
    public void deveDeletarUmDepartment() {
        DepartmentRepository repository = new DepartmentRepository();
        repository.delete(2);
    }

    @Test
    public void deveRetornarUmDepartmentPeloId() {
        DepartmentRepository repository = new DepartmentRepository();
        Department department = repository.getById(1);
        System.out.println(department);
    }

    @Test
    public void deveRetornarUmaListaDeDepartmentsPeloNome() {
        DepartmentRepository repository = new DepartmentRepository();
        List<Department> departments = repository.getByNameContaining("book");
        for (Department department : departments) {
            System.out.println(department);
        }
    }

    @Test
    public void deveRetornarUmaListaDeDepartmentsSemVendedores() {
        DepartmentRepository repository = new DepartmentRepository();
        List<Department> departments = repository.getDepartmentsWithoutSellers();
        for (Department department : departments) {
            System.out.println(department);
        }
    }
}
