public class Milestone {
    int totalPoints = 0;
    int indexPoints = -1;
    String[][] milestonePointsRewards = new String[6][6];

    Milestone(){
        this.milestonePointsRewards[0][0] = "50";
        this.milestonePointsRewards[1][0] = "100";
        this.milestonePointsRewards[2][0] = "300";
        this.milestonePointsRewards[3][0] = "500";
        this.milestonePointsRewards[4][0] = "800";
        this.milestonePointsRewards[5][0] = "1000";
    }

    public String[][] getMilestonePointsRewards() {
        return milestonePointsRewards;
    }

    public void setReward(String reward, int milestoneIndex){
        String[][] milestonePointsRewards = getMilestonePointsRewards();
        milestonePointsRewards[milestoneIndex][1] = reward;
    }
}
