INSERT INTO restaurant ( name) VALUES ('Pizza Palace');
INSERT INTO restaurant (name) VALUES ('Burger Bistro');
INSERT INTO restaurant (name) VALUES ('Sushi Haven');
INSERT INTO restaurant (name) VALUES ('Pasta Point');
INSERT INTO restaurant (name) VALUES ('Biryani House');

INSERT INTO food (name, price, restaurant_id, category) VALUES
('Margherita Pizza', 250, 1, 'PIZZA'),
('Cheese Burst Burger', 300, 1, 'BURGERS'),
('Veg Supreme Pizza', 280, 1, 'PIZZA'),
('Grilled Chicken Platter', 350, 2, 'MAIN_COURSE'),
('Paneer Butter Masala', 320, 2, 'MAIN_COURSE'),
('Classic Cheeseburger', 270, 3, 'BURGERS'),
('Chicken Tikka Pizza', 340, 1, 'PIZZA'),
('Cold Coffee', 120, 4, 'BEVERAGES'),
('Veg Biryani', 290, 2, 'MAIN_COURSE'),
('Gulab Jamun', 90, 5, 'DESSERTS'),
('Choco Brownie Sundae', 150, 5, 'DESSERTS'),
('Pepsi Can', 60, 4, 'BEVERAGES'),
('Tandoori Chicken', 360, 2, 'MAIN_COURSE'),
('Mocha Frappe', 130, 4, 'BEVERAGES'),
('Garlic Bread', 140, 1, 'MAIN_COURSE');


INSERT INTO customer (customer_name,customer_password) VALUES
('Andrew Jackson','hash@123');