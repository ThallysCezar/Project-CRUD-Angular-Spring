CREATE TABLE IF NOT EXISTS t_courses (
    id SERIAL PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    category VARCHAR(10) NOT NULL,
    -- Outros campos da tabela t_courses, se houver
);

CREATE TABLE IF NOT EXISTS t_lessons (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    youtubeURL VARCHAR(11) NOT NULL,
    course_id BIGINT NOT NULL,
    -- Outros campos da tabela t_lessons, se houver
    CONSTRAINT fk_course
        FOREIGN KEY (course_id)
        REFERENCES t_courses (id)
);