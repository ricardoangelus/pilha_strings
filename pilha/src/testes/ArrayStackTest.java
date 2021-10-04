package testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pilha.ArrayStack;
import pilha.EmptyStackException;
import pilha.FullStackException;

class ArrayStackTest {
    static final ArrayStack<String> a = new ArrayStack<String>(3);
    @Test
    void pilhaString() {
        a.push("R");
        assertEquals("[R]", a.toString(), "Deve imprimir [R]");
        a.push("I");
        assertEquals("[R, I]", a.toString(), "Deve imprimir [R, I]");
        a.push("C");
        assertEquals("[R, I, C]", a.toString(), "Deve imprimir [R, I, C]");

        Assertions.assertThrows(FullStackException.class, () -> { a.push(""); });

        assertEquals("C", a.pop(), "Deve ter desempilhado C");
        assertEquals("[R, I]", a.toString(), "Deve imprimir [R, I]");
        assertEquals("I", a.pop(), "Deve ter desempilhado I");
        assertEquals("[R]", a.toString(), "Deve imprimir [R]");
        assertEquals("R", a.pop(), "Deve ter desempilhado R");
        assertEquals("[]", a.toString(), "Deve imprimir []");

        assertTrue(a.isEmpty());

        Assertions.assertThrows(EmptyStackException.class, () -> { a.pop(); });
    }

}
