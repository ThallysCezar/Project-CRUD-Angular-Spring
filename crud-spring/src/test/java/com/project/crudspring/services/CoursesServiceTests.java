package com.project.crudspring.services;

import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.project.crudspring.converts.CoursesConverter;
import com.project.crudspring.domains.Courses;
import com.project.crudspring.dtos.CoursesDTO;
import com.project.crudspring.exceptions.RecordNotFoundException;
import com.project.crudspring.repositories.CoursesRepository;

@DisplayName("Service de Courses")
@ExtendWith(MockitoExtension.class)
public class CoursesServiceTests {

	
	private CoursesRepository coursesRepository;
	private CoursesService sut;
	private CoursesConverter coursesConverter;
	
	@BeforeEach
	void setup() {
		this.coursesRepository = Mockito.mock(CoursesRepository.class);
		this.coursesConverter = Mockito.mock(CoursesConverter.class);
		this.sut = new CoursesService(coursesRepository, coursesConverter);
	}
	
//	@Test
//	@DisplayName("Deve retornar todos os cursos listados")
//	void deveRetornarTodosCursosListados() {
//		List<Courses> coursesList = List.of(new Courses());
//        when(coursesRepository.findAll()).thenReturn(coursesList);
//        CoursesDTO coursesDTO = new CoursesDTO();
//        List<CoursesDTO> coursesDTOList = List.of(coursesDTO);
//
//        when(coursesConverter.entityListToDTOList(coursesList)).thenReturn(coursesDTOList);
//
//        List<CoursesDTO> result = sut.list();
//        Assertions.assertEquals(1, result.size());
//        Mockito.verify(coursesRepository, Mockito.times(1)).findAll();
//	}
	
	@Test
	@DisplayName("Deve retornar todos os cursos listados")
	void deveRetornarTodosCursosListados() {
	    List<Courses> coursesList = List.of(new Courses());
	    Page<Courses> coursesPage = new PageImpl<>(coursesList);

	    when(coursesRepository.findAll(Mockito.any(Pageable.class))).thenReturn(coursesPage);

	    CoursesDTO coursesDTO = new CoursesDTO();
	    List<CoursesDTO> coursesDTOList = List.of(coursesDTO);
	    when(coursesConverter.entityPageToDTOPage(coursesPage)).thenReturn(new PageImpl<>(coursesDTOList));

	    Page<CoursesDTO> result = sut.list(PageRequest.of(0, 10));
	    Assertions.assertEquals(1, result.getTotalElements());
	    Mockito.verify(coursesRepository, Mockito.times(1)).findAll(Mockito.any(Pageable.class));
	}
	
	@Test
	@DisplayName("Deve retornar curso por id")
	void deveRetornarCursoPorId() {
		// Arrange
		final var idValid = 1L;
		final var courses = new Courses();
		courses.setId(idValid);
		final var dto = new CoursesDTO();
		dto.set_id(idValid);
		
		when(coursesRepository.findById(idValid)).thenReturn(Optional.of(courses));
		when(coursesConverter.entityToDTO(courses)).thenReturn(dto);
        
		// Act
        CoursesDTO result = sut.findById(idValid);
		
        // Assert
		Assertions.assertEquals(dto, result);
		
		Mockito.verify(coursesRepository, Mockito.times(1)).findById(idValid);
	}
	
	@Test
    @DisplayName("deve lançar uma RecordNotFoundException quando um id for invalido ou inexistente")
    void DeveLancarRecordNotFoundExceptionQuandoIdInexistenteOuInvalido() {
        // Arrange
        Long idInvalido = 999L;

        when(coursesRepository.findById(idInvalido)).thenReturn(Optional.empty());

        // Act and Assert
        final var excecao = Assertions.assertThrows(RecordNotFoundException.class, () ->
        sut.findById(idInvalido));
        Mockito.verify(coursesRepository, Mockito.times(1)).findById(idInvalido);
        Assertions.assertEquals(String.format("Registro não encontrado com o id: %s", idInvalido), excecao.getMessage());
    }
	
	@Test
	@DisplayName("Deve criar cursos")
	void deveCriarCurso() {
		// Arrange
        CoursesDTO inputDTO = new CoursesDTO();
        Courses inputCourse = new Courses();
        CoursesDTO expectedDTO = new CoursesDTO();

        when(coursesConverter.dtoToEntity(inputDTO)).thenReturn(inputCourse);
        when(coursesRepository.save(inputCourse)).thenReturn(inputCourse);
        when(coursesConverter.entityToDTO(inputCourse)).thenReturn(expectedDTO);

        // Act
        CoursesDTO result = sut.create(inputDTO);

        // Assert
        Assertions.assertEquals(expectedDTO, result);
        Mockito.verify(coursesConverter).dtoToEntity(inputDTO);
        Mockito.verify(coursesRepository).save(inputCourse);
        Mockito.verify(coursesConverter).entityToDTO(inputCourse);
	}
	
	@Test
	@DisplayName("deve retornar um curso atualizado com o id desejado")
	void deveAtualizarCurso() {
		Long id = 1L;
        CoursesDTO inputDTO = new CoursesDTO();
        Courses inputCourse = new Courses();
        Courses updatedCourse = new Courses();
        CoursesDTO expectedDTO = new CoursesDTO();

        when(coursesRepository.findById(id)).thenReturn(Optional.of(inputCourse));
        when(coursesConverter.dtoToEntity(inputDTO)).thenReturn(updatedCourse);
        when(coursesConverter.entityToDTO(updatedCourse)).thenReturn(expectedDTO);
        when(coursesRepository.save(updatedCourse)).thenReturn(updatedCourse);

        // Act
        CoursesDTO result = sut.update(id, inputDTO);

        // Assert
        Assertions.assertEquals(expectedDTO, result);
        Mockito.verify(coursesRepository).findById(id);
        Mockito.verify(coursesConverter).dtoToEntity(inputDTO);
        Mockito.verify(coursesRepository).save(updatedCourse);
        Mockito.verify(coursesConverter).entityToDTO(updatedCourse);
	}
	
	@Test
    @DisplayName("deve lançar uma RecordNotFoundException quando um id for invalido ou inexistente ao atualizar um curso")
    void DeveLancarRecordNotFoundExceptionQuandoIdInexistenteOuInvalidoAoAtualizarCurso() {
        // Arrange
        Long idInvalido = 999L;
        CoursesDTO dto = new CoursesDTO();

        when(coursesRepository.findById(idInvalido)).thenReturn(Optional.empty());

        // Act and Assert
        final var excecao = Assertions.assertThrows(RecordNotFoundException.class, () ->
        sut.update(idInvalido, dto));
        Mockito.verify(coursesRepository, Mockito.times(1)).findById(idInvalido);
        Assertions.assertEquals(String.format("Registro não encontrado com o id: %s", idInvalido), excecao.getMessage());
    }
	
	@Test
	@DisplayName("deve retornar um curso deletado com o id desejado")
	void deveDeletarCurso() {
		Long id = 1L;
		Courses courses = new Courses();
		
		when(coursesRepository.findById(id)).thenReturn(Optional.of(courses));
		sut.delete(id);
        Mockito.verify(coursesRepository, Mockito.times(1)).findById(id);
		Mockito.verify(coursesRepository, Mockito.times(1)).delete(courses);
	}
	
	@Test
    @DisplayName("deve lançar uma RecordNotFoundException quando um id for invalido ou inexistente ao deletar um curso")
    void DeveLancarRecordNotFoundExceptionQuandoIdInexistenteOuInvalidoAoDeletarCurso() {
        // Arrange
        Long idInvalido = 999L;

        when(coursesRepository.findById(idInvalido)).thenReturn(Optional.empty());

        // Act and Assert
        final var excecao = Assertions.assertThrows(RecordNotFoundException.class, () ->
        sut.delete(idInvalido));
        Mockito.verify(coursesRepository, Mockito.times(1)).findById(idInvalido);
        Assertions.assertEquals(String.format("Registro não encontrado com o id: %s", idInvalido), excecao.getMessage());
    }
	
}
