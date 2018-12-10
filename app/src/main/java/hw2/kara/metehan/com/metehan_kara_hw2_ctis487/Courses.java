package hw2.kara.metehan.com.metehan_kara_hw2_ctis487;

public class Courses {
    private String courseName;
    private int imgID;

    public Courses(String courseName, int imgID) {
        this.courseName = courseName;
        this.imgID = imgID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }

    @Override
    public String toString() {
        return "courseName='" + courseName +
                " imgID=" + imgID;
    }
}
