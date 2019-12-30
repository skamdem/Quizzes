public @interface Author {
    String author();
    String date();
    int currentRevision() default 1;
    String lastModified() default "N/A";
}
