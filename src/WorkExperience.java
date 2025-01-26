public class WorkExperience {
    private String CompanyName;
    private String Designation;

    @Override
    public String toString() {
        return "WorkExperience{" +
                "CompanyName='" + CompanyName + '\'' +
                ", Designation='" + Designation + '\'' +
                '}';
    }

    public WorkExperience(String CompanyName, String Designation){
        this.CompanyName=ValidateString(CompanyName,"Companyname");
        this.Designation=ValidateString(Designation,"Designation");
    }
    public String getDesignation(){
        return this.Designation;
    }
    public String getCompanyName(){
        return this.CompanyName;
    }
    private String ValidateString(String field,String fieldname){
        if(field == null || field.isEmpty() || !field.matches("[a-zA-z\\s]+")){
            throw new IllegalArgumentException(fieldname+"enter valid character");
        }
        return field;
    }




}
