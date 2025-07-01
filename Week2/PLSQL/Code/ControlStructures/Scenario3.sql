
CREATE TABLE loans (
  loan_id NUMBER,
  customer_name VARCHAR2(50),
  due_date DATE
);


INSERT INTO loans VALUES (1, 'Alice', SYSDATE + 10);  
INSERT INTO loans VALUES (2, 'Bob', SYSDATE + 40);    
INSERT INTO loans VALUES (3, 'Charlie', SYSDATE + 25);


BEGIN
  FOR loan_rec IN (
    SELECT * FROM loans
    WHERE due_date BETWEEN SYSDATE AND SYSDATE + 30
  ) LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || loan_rec.loan_id ||
                         ' for ' || loan_rec.customer_name ||
                         ' is due on ' || TO_CHAR(loan_rec.due_date, 'DD-MON-YYYY'));
  END LOOP;
END;
/
