package lambda.part1.exercise;

import com.google.common.base.Optional;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import data.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Lambdas02Exercise {
    @Test
    void sortPersonsByAge() {
        Person[] persons = {
                new Person("name 3", "lastName 3", 20),
                new Person("name 1", "lastName 2", 40),
                new Person("name 2", "lastName 1", 30)
        };

        // TODO use Arrays.sort
        Arrays.sort(persons, (o1, o2) -> o1.getAge()-o2.getAge());
//        Arrays.sort(persons, Comparator.comparing(p->p.getAge()));
//        Arrays.sort(persons, Comparator.comparing(Person::getAge));

        assertArrayEquals(persons, new Person[]{
                new Person("name 3", "lastName 3", 20),
                new Person("name 2", "lastName 1", 30),
                new Person("name 1", "lastName 2", 40),
        });
    }

    @Test
    void findFirstWithAge30() {
        List<Person> persons = ImmutableList.of(
                new Person("name 3", "lastName 3", 20),
                new Person("name 1", "lastName 2", 30),
                new Person("name 2", "lastName 1", 30)
        );

        Person person = null;

        // TODO use FluentIterable
        final Optional<Person> personOptional =
                FluentIterable.from(persons)
                        .firstMatch(p -> p.getAge()==30);
        person = personOptional.get();

        assertEquals(person, new Person("name 1", "lastName 2", 30));
    }
}
