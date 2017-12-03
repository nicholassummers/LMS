package hiber;
// Generated Dec 2, 2017 12:13:47 AM by Hibernate Tools 4.3.1



/**
 * UserAssignment generated by hbm2java
 */
public class UserAssignment  implements java.io.Serializable {


     private UserAssignmentId id;
     private String userAssignmentSubmission;
     private Integer score;
     private Integer isSubmitted;
     private Integer isLate;

    public UserAssignment() {
    }

	
    public UserAssignment(UserAssignmentId id, String userAssignmentSubmission) {
        this.id = id;
        this.userAssignmentSubmission = userAssignmentSubmission;
    }
    public UserAssignment(UserAssignmentId id, String userAssignmentSubmission, Integer score, Integer isSubmitted, Integer isLate) {
       this.id = id;
       this.userAssignmentSubmission = userAssignmentSubmission;
       this.score = score;
       this.isSubmitted = isSubmitted;
       this.isLate = isLate;
    }
   
    public UserAssignmentId getId() {
        return this.id;
    }
    
    public void setId(UserAssignmentId id) {
        this.id = id;
    }
    public String getUserAssignmentSubmission() {
        return this.userAssignmentSubmission;
    }
    
    public void setUserAssignmentSubmission(String userAssignmentSubmission) {
        this.userAssignmentSubmission = userAssignmentSubmission;
    }
    public Integer getScore() {
        return this.score;
    }
    
    public void setScore(Integer score) {
        this.score = score;
    }
    public Integer getIsSubmitted() {
        return this.isSubmitted;
    }
    
    public void setIsSubmitted(Integer isSubmitted) {
        this.isSubmitted = isSubmitted;
    }
    public Integer getIsLate() {
        return this.isLate;
    }
    
    public void setIsLate(Integer isLate) {
        this.isLate = isLate;
    }




}


