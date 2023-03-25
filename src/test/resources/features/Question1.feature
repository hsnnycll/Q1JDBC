@db
  Feature: Homework execution

    Scenario Outline: Verify the Question1's answer with DB
      Given Verify <customer_id> "<first_name>" "<last_name>" "<city>" "<country>" "<total_spent>" query should match with the result

      Examples:
        | customer_id | first_name | last_name | city        | country | total_spent |
        | 148         | Eleanor    | Hunt      | Saint-Denis | Runion  | 211.55      |