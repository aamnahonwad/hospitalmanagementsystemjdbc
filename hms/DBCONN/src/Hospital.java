public class Hospital {

    int patient_id;
    String name;
    int age;
    String disease;
    String doctor_assigned;
    double bill_amount;

   
    public Hospital(int patient_id,String name,int age,String disease,String doctor_assigned,double bill_amount) {
       this.patient_id=patient_id;
       this.name=name;
       this.age=age;
       this.disease=disease;
       this.doctor_assigned=doctor_assigned;
       this.bill_amount=bill_amount;
    }
}
