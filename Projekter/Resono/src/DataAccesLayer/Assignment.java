package src.DataAccesLayer;

public class Assignment {
    private Integer assignmentID;
    private String assignmentTitle, assignmentCreatorFN, assignmentCreatorLN, assignmentDescription;

    public Assignment(Integer assignmentID, String assignmentTitle, String assignmentCreatorFN, String assignmentCreatorLN, String assignmentDescription) {
        this.assignmentID = assignmentID;
        this.assignmentTitle = assignmentTitle;
        this.assignmentCreatorFN = assignmentCreatorFN;
        this.assignmentCreatorLN = assignmentCreatorLN;
        this.assignmentDescription = assignmentDescription;
    }

    public Integer getAssignmentID() {
        return assignmentID;
    }

    public void setAssignmentID(Integer assignmentID) {
        this.assignmentID = assignmentID;
    }

    public String getAssignmentTitle() {
        return assignmentTitle;
    }

    public void setAssignmentTitle(String assignmentTitle) {
        this.assignmentTitle = assignmentTitle;
    }

    public String getAssignmentCreatorFN() {
        return assignmentCreatorFN;
    }

    public void setAssignmentCreatorFN(String assignmentCreatorFN) {
        this.assignmentCreatorFN = assignmentCreatorFN;
    }

    public String getAssignmentCreatorLN() {
        return assignmentCreatorLN;
    }

    public void setAssignmentCreatorLN(String assignmentCreatorLN) {
        this.assignmentCreatorLN = assignmentCreatorLN;
    }

    public String getAssignmentDescription() {
        return assignmentDescription;
    }

    public void setAssignmentDescription(String assignmentDescription) {
        this.assignmentDescription = assignmentDescription;
    }
}
