package com.github.smat.annotations.exercise1;

import com.github.smat.annotations.PrettyErrorMessages;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.MethodRule;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.junit.Assert.assertEquals;

/**
 * Intro to how to create annotations
 */
public class Exercise1Test {

    @Test
    public void create_an_annotation_named_MyAnnotation_in_this_package() throws Exception {
        Class<?> rule = Class.forName("com.github.smat.annotations.exercise1.MyAnnotation");

        assertEquals("The class Rule should be an annotation", true, rule.isAnnotation());
    }

    @Test
    public void the_annotation_should_be_marked_as_available_at_runtime() throws Exception {
        Class<?> rule = Class.forName("com.github.smat.annotations.exercise1.MyAnnotation");

        assertEquals("The annotation should be marked to retain the annotation at runtime", true, rule.isAnnotationPresent(Retention.class));
        RetentionPolicy policy = rule.getAnnotation(Retention.class).value();
        assertEquals(RetentionPolicy.RUNTIME, policy);
    }

    @Test
    public void the_annotation_should_only_be_used_on_methods() throws Exception {
        Class<?> rule = Class.forName("com.github.smat.annotations.exercise1.MyAnnotation");

        assertEquals("The annotation should only be available on methods", true, rule.isAnnotationPresent(Target.class));
        ElementType[] elements = rule.getAnnotation(Target.class).value();
        assertEquals(1, elements.length);
        assertEquals(ElementType.METHOD, elements[0]);
    }

    @Rule
    public MethodRule prettyErrorMessages = new PrettyErrorMessages();
}
