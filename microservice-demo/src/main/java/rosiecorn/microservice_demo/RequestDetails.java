package rosiecorn.microservice_demo;

public class RequestDetails {

	private String companyID;
	private String companyName;
	private String candidateID;
	private String candidateName;
	private String companyEmail;
	private String candidateEmail;

	public String getCompanyID() {
		return companyID;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
	public String getCandidateName() {
		return candidateName;
	}
	
	public String getCompanyEmail() {
		return companyEmail;
	}
	
	public String getCandidateID() {
		return candidateID;
	}
	
	public String getCandidateEmail() {
		return candidateEmail;
	}
	
	public void setCompanyID(String compID) {
		this.companyID = compID;
	}
	

	public void setCompanyName(String compName) {
		this.companyName = compName;
	}
	public void setCompanyEmail(String compEmail) {
		this.companyEmail = compEmail;
	}	

	public void setCandidateID(String candId) {
		this.candidateID = candId;
	}

	public void setCandidateName(String candName) {
		this.candidateName = candName;
	}
	
	public void setCandidateEmail(String candEmail) {
		this.candidateEmail = candEmail;
	}
}