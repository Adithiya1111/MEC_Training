package com.example.pokemon;

import com.example.pokemon.controller.PokemonController;
import com.example.pokemon.modal.Pokemon;
import com.example.pokemon.repository.PokemonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PokemonController.class)
class pokemonApplicationTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private PokemonRepository pokemonRepository;

	private final ObjectMapper mapper = new ObjectMapper();

	private Pokemon makePokemon(long id, String name, String rarity, String category, String region,
			String strongestAttack, String evolution) {
		Pokemon s = new Pokemon(name, rarity, category, region, strongestAttack, evolution);
		try {
			Pokemon.class.getMethod("setId", long.class).invoke(s, id);
		} catch (Exception ignore) {
			/* if no setter, ignore id asserts */ }
		return s;
	}

	// run command for testing: mvn test

	// ---------- GET /api/pokemon
	@Test
	@DisplayName("GET /api/pokemon -> 200 with list")
	void getAllPokemon_ok() throws Exception {
		List<Pokemon> data = Arrays.asList(
				makePokemon(1L, "Arceus", "Mythic", "Alpha", "Sinnoh", "Judgment", "None"),
				makePokemon(2L, "Dialga", "Legendary", "Temporal", "Sinnoh", "Roar of Time", "None"));
		given(pokemonRepository.findAll()).willReturn(data);

		mvc.perform(get("/api/pokemon"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].name").value("Arceus"))
				.andExpect(jsonPath("$[1].name").value("Dialga"));
	}

	// ---------- GET /api/pokemon/{id}
	@Test
	@DisplayName("GET /api/pokemon/{id} -> 200 when found")
	void getPokemonById_found() throws Exception {
		Pokemon p = makePokemon(1L, "Arceus", "Mythic", "Alpha", "Sinnoh", "Judgment", "None");
		given(pokemonRepository.findById(1L)).willReturn(Optional.of(p));

		mvc.perform(get("/api/pokemon/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value("Arceus"))
				.andExpect(jsonPath("$.rarity").value("Mythic"));
	}

	// ---------- POST /api/pokemon
	@Test
	@DisplayName("POST /api/pokemon -> 201 Created")
	void createPokemon_created() throws Exception {
		Pokemon request = new Pokemon("NewName", "NewRarity", "NewCategory", "NewRegion", "NewStrongestAttack",
				"NewEvolution");
		Pokemon saved = makePokemon(15L, "NewName", "NewRarity", "NewCategory",
				"NewRegion", "NewStrongestAttack", "NewEvolution");

		given(pokemonRepository.save(ArgumentMatchers.any(Pokemon.class))).willReturn(saved);

		mvc.perform(post("/api/pokemon")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(request)))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.name").value("NewName"))
				.andExpect(jsonPath("$.rarity").value("NewRarity"));

		// // ---------- PUT /api/pokemon/{id}
		// @Test
		// @DisplayName("PUT /api/pokemon/{id} -> 200 when found and updated")
		// void updatePokemon_ok() throws Exception {
		// Pokemon existing = makePokemon(5L, "OldName", "OldRarity", "OldCategory",
		// 		"OldRegion", "OldStrongestAttack", "OldEvolution");
		// Pokemon updated = makePokemon(5L, "NewName", "NewRarity", "NewCategory",
		// 		"NewRegion", "NewStrongestAttack", "NewEvolution");

		// given(pokemonRepository.findById(5L)).willReturn(Optional.of(existing));
		// given(pokemonRepository.save(any(Pokemon.class))).willReturn(updated);

		// mvc.perform(put("/api/pokemon/5")
		// .contentType(MediaType.APPLICATION_JSON)
		// .content(mapper.writeValueAsString(updateReq)))
		// .andExpect(status().isOk())
		// .andExpect(jsonPath("$.title").value("NewTitle"))
		// .andExpect(jsonPath("$.published").value(true));
		// }

		// @Test
		// @DisplayName("PUT /api/students/{id} -> 404 when not found")
		// void updateStudent_notFound() throws Exception {
		// given(studentRepository.findById(123L)).willReturn(Optional.empty());

		// Student req = new Student("T", "D", true);
		// mvc.perform(put("/api/students/123")
		// .contentType(MediaType.APPLICATION_JSON)
		// .content(mapper.writeValueAsString(req)))
		// .andExpect(status().isNotFound());
		// }

		// // ---------- DELETE /api/students/{id}
		// @Test
		// @DisplayName("DELETE /api/students/{id} -> 204")
		// void deleteStudent_ok() throws Exception {
		// doNothing().when(studentRepository).deleteById(7L);

		// mvc.perform(delete("/api/students/7"))
		// .andExpect(status().isNoContent());

		// verify(studentRepository, times(1)).deleteById(7L);
		// }

		// // ---------- DELETE /api/students
		// @Test
		// @DisplayName("DELETE /api/students -> 204")
		// void deleteAllStudents_ok() throws Exception {
		// doNothing().when(studentRepository).deleteAll();

		// mvc.perform(delete("/api/students"))
		// .andExpect(status().isNoContent());

		// verify(studentRepository, times(1)).deleteAll();
		// }

		// // ---------- GET /api/students/published
		// @Test
		// @DisplayName("GET /api/students/published -> 200 with list")
		// void findByPublished_ok() throws Exception {
		// List<Student> published = Arrays.asList(
		// makeStudent(1L, "P1", "D1", true),
		// makeStudent(2L, "P2", "D2", true));
		// given(studentRepository.findByPublished(true)).willReturn(published);

		// mvc.perform(get("/api/students/published"))
		// .andExpect(status().isOk())
		// .andExpect(jsonPath("$[0].published").value(true));
		// }

		// // ---------- GET /api/student?title=...
		// @Test
		// @DisplayName("GET /api/student?title=foo -> 200 with matches")
		// void getAllStudentsByTitle_ok() throws Exception {
		// List<Student> matches = Arrays.asList(
		// makeStudent(3L, "foo bar", "x", false));
		// given(studentRepository.findByTitleContaining("foo")).willReturn(matches);

		// mvc.perform(get("/api/student").param("title", "foo"))
		// .andExpect(status().isOk())
		// .andExpect(jsonPath("$[0].title").value("foo bar"));
		// }
	}
}