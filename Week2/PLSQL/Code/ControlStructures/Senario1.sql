
CREATE TABLE customers (
  customer_id NUMBER,
  name VARCHAR2(50),
  age NUMBER,
  loan_interest_rate NUMBER
);


INSERT INTO customers VALUES (1, 'Alice', 62, 9.5);
INSERT INTO customers VALUES (2, 'Bob', 45, 10.0);
INSERT INTO customers VALUES (3, 'Charlie', 70, 8.5);


BEGIN
  FOR cust IN (SELECT * FROM customers) LOOP
    IF cust.age > 60 THEN
      UPDATE customers
      SET loan_interest_rate = loan_interest_rate - 1
      WHERE customer_id = cust.customer_id;
      DBMS_OUTPUT.PUT_LINE('Discount applied to Customer ID: ' || cust.customer_id);
    END IF;
  END LOOP;
END;
/
