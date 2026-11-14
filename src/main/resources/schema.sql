CREATE TABLE category (
    category_id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE task (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    detail VARCHAR(250),
    category_id BIGINT,
    due_date DATE NOT NULL,
    status BOOLEAN DEFAULT FALSE,

    FOREIGN KEY (category_id)
        REFERENCES category(category_id)
);