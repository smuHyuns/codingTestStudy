SELECT b.category, sum(bs.sales) as TOTAL_SALES
FROM book_sales as bs
JOIN book as b
ON b.book_id = bs.book_id
WHERE bs.sales_date like '2022-01%'
GROUP BY b.category
ORDER BY b.category

