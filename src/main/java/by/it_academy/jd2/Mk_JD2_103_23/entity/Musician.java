package by.it_academy.jd2.Mk_JD2_103_23.entity;

public class Musician implements Comparable<Musician> {
    private int point;
    private String name;

    public Musician(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Musician musician = (Musician) o;

        if (point != musician.point) return false;
        return name != null ? name.equals(musician.name) : musician.name == null;
    }

    @Override
    public int hashCode() {
        int result = point;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Musician o) {
        int result = o.point - this.point;
        if (result == 0) {
            this.name.compareTo(o.name);
        }
        return result;
    }

    @Override
    public String toString() {
        return name + " (" + point + ")";
    }
}
