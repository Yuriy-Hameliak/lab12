package lab12.task2;

public class Main {
    public static void main(String[] args) {
        Group<Integer> nestedGroup = new Group<>();
        nestedGroup.addTask(new Signature<>(System.out::println)).addTask(new Signature<>(x -> System.out.println(x * x)));
        Group<Integer> group = new Group<>();
        group.addTask(nestedGroup).addTask(new Signature<>(x -> System.out.println(x * x * x)));
        group.apply(10);
        for (Task<Integer> task : group.getTasks()) {
            System.out.println("UUID: " + task.getId());
            System.out.println("Group UUID: " + task.getHeader("groupId"));
        }
    }
}
