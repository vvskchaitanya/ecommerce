INSERT INTO categories (category_name, parent_category_id)
VALUES ('SMARTPHONES', NULL), ('LAPTOPS', NULL), ('SOUNDBARS', NULL);

INSERT INTO products (product_name, description, price, stock_quantity, category_id)
VALUES ('Apple Iphone', 'Latest', 49.99, 100, 1), ('Samsung', 'Latest', 49.99, 100, 1);