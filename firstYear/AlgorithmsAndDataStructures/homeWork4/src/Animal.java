public class Animal <T extends Comparable<T>> implements Comparable<Animal<T>> {
    private T param1;
    private T param2;
    private T param3;
    private T param4;
    private T param5;

    public T getParam1() {
        return param1;
    }

    public void setParam1(T param1) {
        this.param1 = param1;
    }

    public T getParam2() {
        return param2;
    }

    public void setParam2(T param2) {
        this.param2 = param2;
    }

    public T getParam3() {
        return param3;
    }

    public void setParam3(T param3) {
        this.param3 = param3;
    }

    public T getParam4() {
        return param4;
    }

    public void setParam4(T param4) {
        this.param4 = param4;
    }

    public T getParam5() {
        return param5;
    }

    public void setParam5(T param5) {
        this.param5 = param5;
    }

    @Override
    public int compareTo(Animal<T> another) {
        int breedComparison = this.getParam1().compareTo(another.getParam1());
        if (breedComparison != 0) {
            return breedComparison;
        }

        int sizeComparison = this.getParam2().compareTo(another.getParam2());
        if (sizeComparison != 0) {
            return sizeComparison;
        }

        int familyComparison = this.getParam3().compareTo(another.getParam3());
        if (familyComparison != 0) {
            return familyComparison;
        }

        int colorComparison = this.getParam4().compareTo(another.getParam4());
        if (colorComparison != 0) {
            return colorComparison;
        }

        return this.getParam5().compareTo(another.getParam5());
    }
}
