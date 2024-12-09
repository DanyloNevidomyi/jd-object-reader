package learning.java;

import org.junit.jupiter.api.*;
import java.io.*;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class ObjectFileReaderTest {
    private static final String TEST_FILE = "src/test/resources/test_user_data.ser";
    private ObjectWriter writer;
    private ObjectFileReader reader;

    @BeforeAll
    static void setUp() throws IOException {
        File file = new File(TEST_FILE);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (file.exists()) {
            file.delete();
        }
    }

    @AfterAll
    static void tearDown() throws IOException {
        File file = new File(TEST_FILE);
        if (file.exists()) {
            file.delete();
        }
    }

    @BeforeEach
    void init() {
        writer = new ObjectWriter();
        reader = new ObjectFileReader();
    }

    @Test
    @DisplayName("Test object saving to file and reading back")
    void testSaveAndReadObject() {
        // Створення тестового об'єкта
        User testUser = new User("John", 25, "user123");

        // Збереження об'єкта
        writer.saveObjectToFile(TEST_FILE, testUser);

        // Зчитування об'єкта назад
        User readUser = reader.readObjectFromFile(TEST_FILE);

        // Перевірка, чи об'єкти рівні
        assertNotNull(readUser);
        assertEquals(testUser, readUser);
    }

}