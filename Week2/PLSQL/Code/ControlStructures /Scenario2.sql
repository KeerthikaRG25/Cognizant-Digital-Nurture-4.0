
CREATE TABLE customers (
  customer_id NUMBER,
  name VARCHAR2(50),
  balance NUMBER,
  IsVIP VARCHAR2(5)
);

INSERT INTO customers VALUES (1, 'Alice', 15000, 'FALSE');
INSERT INTO customers VALUES (2, 'Bob', 5000, 'FALSE');
INSERT INTO customers VALUES (3, 'Charlie', 12000, 'FALSE');


BEGIN
  FOR cust IN (SELECT * FROM customers) LOOP
    IF cust.balance > 10000 THEN
      UPDATE customers
      SET IsVIP = 'TRUE'
      WHERE customer_id = cust.customer_id;

      DBMS_OUTPUT.PUT_LINE('Customer ID ' || cust.customer_id || ' promoted to VIP');
    END IF;
  END LOOP;
END;
/


SELECT * FROM customers;
