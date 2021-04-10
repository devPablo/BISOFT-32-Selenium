package framework;

public enum LanguageEnum {
    ENGLISH("en_US"),
    SPANISH("es_US"),
    PORTUGUESE("pt_BR"),
    CHINESE("zh_CN");

    private String element;

    LanguageEnum(String element) {
        this.element = element;
    }

    public String getElement() {
        return element;
    }
}
