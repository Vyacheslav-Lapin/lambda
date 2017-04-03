package lambda.part1.exercise;

import com.google.common.base.Optional;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import data.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.fail;

class Lambdas02Exercise {
    @Test
    void sortPersonsByAge() {
        Person[] persons = {
                new Person("name 3", "lastName 3", 20),
                new Person("name 1", "lastName 2", 40),
                new Person("name 2", "lastName 1", 30)
        };

        Arrays.sort(persons, (o1, o2) -> {
            if (o1.getAge() > o2.getAge())
                return 1;
            else if (o1.getAge() < o2.getAge())
                return -1;
            else
                return 0;
        });


        assertThat(persons, is(new Person[]{
                new Person("name 3", "lastName 3", 20),
                new Person("name 2", "lastName 1", 30),
                new Person("name 1", "lastName 2", 40),
        }));
    }

    @Test
    void findFirstWithAge30() {
        List<Person> persons = ImmutableList.of(
                new Person("name 3", "lastName 3", 20),
                new Person("name 1", "lastName 2", 30),
                new Person("name 2", "lastName 1", 30)
        );

        final Optional<Person> personOptional =
                FluentIterable.from(persons)
                        .firstMatch(p -> p.getAge() == 30);


        if (personOptional.isPresent())
            assertThat(personOptional.get(), is(new Person("name 1", "lastName 2", 30)));
        else
            fail("");
    }
}