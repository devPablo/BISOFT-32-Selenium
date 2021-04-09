package framework;

public enum LanguageEnum {
    ENGLISH("en_US"),
    SPANISH("es_US");

    private String element;

    LanguageEnum(String element) {
        this.element = element;
    }

    public String getElement() {
        return element;
    }
}
