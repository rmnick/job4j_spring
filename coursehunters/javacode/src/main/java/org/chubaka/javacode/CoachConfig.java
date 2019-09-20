package org.chubaka.javacode;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("org.chubaka.javacode")
@PropertySource("classpath:app.properties")
public class CoachConfig {

    @Bean
    public IBag handBag() {
        IBag handBag = new HandBag();
        return handBag;
    }

    @Bean
    public IBag heavyBag() {
        IBag heavyBag = new HeavyBag();
        return heavyBag;
    }

    @Bean ICoach runCoach() {
        ICoach runCoach = new RunCoach(handBag());
        return runCoach;
    }

    @Bean ICoach swimCoach() {
        ICoach swimCoach = new SwimCoach();
        return swimCoach;
    }
}
