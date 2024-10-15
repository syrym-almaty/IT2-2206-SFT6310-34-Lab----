@WebMvcTest(StudentController.class)
public class student_testing {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Test
    public void updateStudent_success() throws Exception {
        Student updatedStudent = new Student(1L, "John Doe", "john.doe@example.com", 25);

        Mockito.when(studentService.updateStudent(Mockito.anyLong(), Mockito.any(Student.class)))
                .thenReturn(updatedStudent);

        mockMvc.perform(put("/api/students/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"John Doe\", \"email\":\"john.doe@example.com\", \"age\":25}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("John Doe")))
                .andExpect(jsonPath("$.email", is("john.doe@example.com")))
                .andExpect(jsonPath("$.age", is(25)));
    }

    @Test
    public void updateStudent_notFound() throws Exception {
        Mockito.when(studentService.updateStudent(Mockito.anyLong(), Mockito.any(Student.class)))
                .thenThrow(new ResourceNotFoundException("Student not found"));

        mockMvc.perform(put("/api/students/999")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"John Doe\", \"email\":\"john.doe@example.com\", \"age\":25}"))
                .andExpect(status().isNotFound());
    }
}
