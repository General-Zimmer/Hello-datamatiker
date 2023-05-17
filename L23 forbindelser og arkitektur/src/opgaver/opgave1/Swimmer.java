package opgaver.opgave1;

import java.util.ArrayList;

public class Swimmer {
    private final String name;
    private final ArrayList<Double> lapTimes;
    private TrainingPlan plan = null;

    public Swimmer(String name, TrainingPlan plan, ArrayList<Double> lapTimes) {
        this.name = name;
        this.lapTimes = lapTimes;
        this.plan = plan;
    }

    public Swimmer(String name, ArrayList<Double> lapTimes) {
        this.name = name;
        this.lapTimes = lapTimes;
    }

    public double AllTrainingHours() {
        return plan.getWeeklyStrengthHours() + plan.getWeeklyWaterHours();
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Double> getLapTimes() {
        return lapTimes;
    }

    /** Return the fastest lap time. */
    public double bestLapTime() {
        double smallest = Double.MAX_VALUE;
        for (double time : lapTimes)
            if (time < smallest)
                smallest = time;


        return smallest;
    }

    public TrainingPlan getPlan() {
        return plan;
    }

    public void setPlan(TrainingPlan plan) {
        this.plan = plan;
    }
}
