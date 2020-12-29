package org.denamyte.hyperskill.algorithms.edit_distance_alignment;

public class Alignment {
    public int editDistance;
    public String source;
    public String target;

    public Alignment(int editDist, String source, String target) {
        this.editDistance = editDist;
        this.source = source;
        this.target = target;
    }

    @Override
    public String toString() {
        return String.format("%d%n%s%n%s", editDistance, source, target);
    }
}
