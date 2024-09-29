BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS state;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE recipes (
                         id SERIAL PRIMARY KEY,
                         title VARCHAR(255) NOT NULL,
                         description TEXT,
                         instructions TEXT,
                         servings INTEGER,
                         prep_time_minutes INTEGER,
                         cook_time_minutes INTEGER,
                         total_time_minutes INTEGER,
                         cuisine_type VARCHAR(100),
                         meal_type VARCHAR(100),
                         dish_type VARCHAR(100),
                         image_url VARCHAR(255),
                         source_url VARCHAR(255),
                         edamam_uri VARCHAR(255) UNIQUE,  -- Edamam's unique identifier for the recipe
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE ingredients (
                             id SERIAL PRIMARY KEY,
                             name VARCHAR(255) NOT NULL,
                             edamam_food_id VARCHAR(255) UNIQUE,  -- Edamam's food ID
                             category VARCHAR(100),
                             created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE measurements (
                              id SERIAL PRIMARY KEY,
                              name VARCHAR(50) NOT NULL,
                              edamam_measure_uri VARCHAR(255) UNIQUE,  -- Edamam's measure URI
                              created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                              updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE recipe_ingredients (
                                    id SERIAL PRIMARY KEY,
                                    recipe_id INTEGER REFERENCES recipes(id),
                                    ingredient_id INTEGER REFERENCES ingredients(id),
                                    measurement_id INTEGER REFERENCES measurements(id),
                                    quantity DECIMAL(10, 2),
                                    notes TEXT,
                                    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE tags (
                      id SERIAL PRIMARY KEY,
                      name VARCHAR(100) NOT NULL UNIQUE,
                      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                      updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE recipe_tags (
                             recipe_id INTEGER REFERENCES recipes(id),
                             tag_id INTEGER REFERENCES tags(id),
                             PRIMARY KEY (recipe_id, tag_id),
                             created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Nutritional_Info table (for caching purposes)
CREATE TABLE nutritional_info (
                                  id SERIAL PRIMARY KEY,
                                  recipe_id INTEGER REFERENCES recipes(id) UNIQUE,
                                  calories DECIMAL(10, 2),
                                  total_weight DECIMAL(10, 2),
                                  total_time INTEGER,
                                  diet_labels TEXT[],
                                  health_labels TEXT[],
                                  cautions TEXT[],
                                  comprehensive_nutrient_list JSONB,
                                  total_daily_value_percentages JSONB,
                                  last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
COMMIT TRANSACTION;
