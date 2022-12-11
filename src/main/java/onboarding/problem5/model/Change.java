package onboarding.problem5.model;

public class Change {

    private int change;

    public Change(int change){
        this.change = change;
    }

    private void updateChange(int change){
        this.change = change;
    }

    public int getChangeForUnit(int unit){
        int result  = change / unit;
        updateChange(change % unit);
        return result;
    }
}
