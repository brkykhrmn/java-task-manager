public class Task {
    private String description;
    private String status;

    public Task(String description){
        this.description = description;
        this.status = "UNDONE";
    }

    public String getDescription(){
        return description;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }
}
