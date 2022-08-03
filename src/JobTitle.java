public enum JobTitle {
    JOB_TITLE_PLAYER("Игрок"),
    JOB_TITLE_COACH("Тренер"),
    JOB_TITLE_OWNER("Владелец команды");

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
