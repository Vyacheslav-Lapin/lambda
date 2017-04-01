package lambda.part1.exercise;

import com.google.common.base.Optional;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import data.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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

        Arrays.sort(persons, (o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName()) * (-1));



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

        final Optional<Person> personOptional =
                FluentIterable.from(persons)
                        .firstMatch(p -> p.getFirstName().equals("name 1"));

        if (personOptional.isPresent()) person = personOptional.get();

        assertEquals(person, new Person("name 1", "lastName 2", 30));
    }
}
