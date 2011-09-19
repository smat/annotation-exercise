package com.github.smat.annotations.exercise1;

import com.github.smat.annotations.PrettyErrorMessages;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.MethodRule;

import java.lang.annotation.*;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

/**
 * Intro to how to create annotations
 */
public class Exercise1Test {

    @Test
    public void create_an_annotation_named_MyAnnotation_in_this_package() throws Exception {
        Class<?> annotation = Class.forName("com.github.smat.annotations.exercise1.MyAnnotation");

        assertEquals("The class Rule should be an annotation", true, annotation.isAnnotation());
    }

    @Test
    public void the_annotation_should_be_marked_as_available_at_runtime() throws Exception {
        Class<?> annotation = Class.forName("com.github.smat.annotations.exercise1.MyAnnotation");

        assertEquals("The annotation should be marked to retain the annotation at runtime", true, annotation.isAnnotationPresent(Retention.class));
        RetentionPolicy policy = annotation.getAnnotation(Retention.class).value();
        assertEquals(RetentionPolicy.RUNTIME, policy);
    }

    @Test
    public void the_annotation_should_only_be_used_on_methods() throws Exception {
        Class<?> annotation = Class.forName("com.github.smat.annotations.exercise1.MyAnnotation");

        assertEquals("The annotation should only be available on methods", true, annotation.isAnnotationPresent(Target.class));
        ElementType[] elements = annotation.getAnnotation(Target.class).value();
        assertEquals(1, elements.length);
        assertEquals(ElementType.METHOD, elements[0]);
    }

    @Test
    public void the_annotation_should_have_a_text_input_field_called_value() throws Exception {
        Class<?> annotation = Class.forName("com.github.smat.annotations.exercise1.MyAnnotation");

        Method method = annotation.getMethod("value");
        assertEquals(String.class, method.getReturnType());
    }

    @Test
    public void annotate_this_method_with_your_annotation_and_set_the_text_to_success() throws Exception {
        Class<? extends Annotation> annotation = (Class<? extends Annotation>) Class.forName("com.github.smat.annotations.exercise1.MyAnnotation");
        Method annotationMethod = annotation.getMethod("value");
        Method method = this.getClass().getMethod("annotate_this_method_with_your_annotation_and_set_the_text_to_success");

        assertEquals("MyAnnotation not present on test", true, method.isAnnotationPresent(annotation));
        Annotation result = method.getAnnotation(annotation);
        assertEquals("success", annotationMethod.invoke(result));
    }

    @Rule
    public MethodRule prettyErrorMessages = new PrettyErrorMessages();
}
