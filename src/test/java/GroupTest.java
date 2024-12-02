import org.junit.jupiter.api.Test;

import lab12.task2.Group;
import lab12.task2.Signature;

import static org.junit.jupiter.api.Assertions.*;

class GroupTest {

    @Test
    void testGroupApply() {
        Group<Integer> group = new Group<>();
        group.addTask(new Signature<>(x -> assertEquals(10, x)))
             .addTask(new Signature<>(x -> assertEquals(100, x * x)));

        group.apply(10);  // Should pass without exceptions
    }

    @Test
    void testNestedGroupTasks() {
        Group<Integer> nestedGroup = new Group<>();
        nestedGroup.addTask(new Signature<>(System.out::println))
                   .addTask(new Signature<>(x -> System.out.println(x * x)));

        Group<Integer> group = new Group<>();
        group.addTask(nestedGroup).addTask(new Signature<>(x -> System.out.println(x * x * x)));

        assertDoesNotThrow(() -> group.apply(10));
    }

    @Test
    void testUUIDGeneration() {
        Group<Integer> group = new Group<>();
        group.addTask(new Signature<>(x -> {}));

        group.apply(5);
        assertNotNull(group.getTasks().get(0).getId());
    }
}
