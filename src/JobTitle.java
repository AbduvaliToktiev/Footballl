public enum JobTitle {
    JOB_TITLE_PLAYER("�����"),
    JOB_TITLE_COACH("������" ),
    JOB_TITLE_OWNER("�������� �������");

    private final String nameTitle;

    JobTitle(String nameTitle) {
        this.nameTitle = nameTitle;
    }

    public String getNameTitle() {
        return nameTitle;
    }

    @Override
    public String toString() {
        return "JobTitle{" +
                "nameTitle='" + nameTitle + '\'' +
                '}';
    }


}
