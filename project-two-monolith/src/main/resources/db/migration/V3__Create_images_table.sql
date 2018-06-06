create table IMAGES (
    ID serial,
    ORIGINAL_IMAGE text NOT NULL,
    COLORIZED_IMAGE text NOT NULL,
    NOTE varchar(100) NOT NULL
);