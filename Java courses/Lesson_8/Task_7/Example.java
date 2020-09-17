package Lesson_8.Task_7;

import java.util.Objects;

public class Example {

    private final String first, last;

    public Example(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public String getStringFirst () {
        return this.first;
    }
    public String getStringLast () {
        return this.last;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) return false;
        if (object == this) return true;
        if (!(object instanceof Example)) return false;
        Example exp = (Example) object;
        return this.first.equals(exp.getStringFirst()) && this.last.equals(exp.getStringLast());
    }

    @Override
    public int hashCode() {
        return 444 * Objects.hashCode(first) + Objects.hashCode(last) * 99;
    }
}
