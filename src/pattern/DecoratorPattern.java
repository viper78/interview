package pattern;

import java.util.function.Function;
import java.util.stream.Stream;

public class DecoratorPattern {

    public static void main(String[] args) {

        DecoratorPattern pattern = new DecoratorPattern();
        pattern.execute();

    }

    private void execute() {
        //Image image = new Image(new Label(), new Mask());

    }

    class Image {

        private Function<Annotation, Annotation> function;

        protected Image(Function<Annotation, Annotation>... functions) {
            System.out.println("Creating image");
            setFunction(functions);
        }

        protected void setFunction(Function<Annotation, Annotation>... functions) {
            function = Stream.of(functions).
                    reduce((f1, f2) -> f1.andThen(f2)).
                    get();
        }

        protected Annotation apply(Annotation annotation) {
            return function.apply(annotation);
        }
    }

    class Jpeg extends Image {

    }

    class Png extends Image {

    }

    class Annotation {

        Annotation() {
            System.out.println("Apply Annotation");
        }
    }

    class Label extends Annotation {
        Label() {
            super();
            System.out.println("Apply Label");
        }
    }

    class Mask extends Annotation {
        Mask() {
            super();
            System.out.println("Apply mask");
        }
    }
}
