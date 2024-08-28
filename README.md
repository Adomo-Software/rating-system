<!DOCTYPE html>
<html class="mozilla"><head>

</head>


This program uses first column as a hash key (must be String).

And compares and rates other (non first) column elements in ascending order.

then sums up the ratings and sorts every row based on the sum of rating

Note: Columns elements must all be same type, Rows can be different type



<body>

### Example: 
#### Usage:
```
RateValueTable t = new RateValueTable();

t.setColumn("Emily", "1992-05-22", 15000, 8, 0.3);
t.setColumn("Carlos", "1978-08-11", 25000, 16, 0.65);
t.setColumn("Aisha", "1995-03-09", 8000, 5, 0.2);
t.setColumn("David", "1986-11-28", 13000, 12, 0.4);
t.setColumn("Maria", "1970-06-17", 60000, 25, 0.7);

t.rate();
t.printTable()

```
Note: Could replace `"1992-05-22"` to `LocalDate.parse("1992-05-22")`, but the results will be the same.

#### Input:

<div class="table-wrap">
<table class="confluenceTable"><tbody>
<td class="confluenceTd">Emily</td>
<td class="confluenceTd">1992-05-22</td>
<td class="confluenceTd">15000</td>
<td class="confluenceTd">8</td>
<td class="confluenceTd">0.3</td>
<tr>
<td class="confluenceTd">Carlos</td>
<td class="confluenceTd">1978-08-11</td>
<td class="confluenceTd">25000</td>
<td class="confluenceTd">16</td>
<td class="confluenceTd">0.65</td>
</tr>
<tr>
<td class="confluenceTd">Aisha</td>
<td class="confluenceTd">1995-03-09</td>
<td class="confluenceTd">8000</td>
<td class="confluenceTd">5</td>
<td class="confluenceTd">0.2</td>
</tr>
<tr>
<td class="confluenceTd">David</td>
<td class="confluenceTd">1986-11-28</td>
<td class="confluenceTd">13000</td>
<td class="confluenceTd">12</td>
<td class="confluenceTd">0.4</td>
</tr>
<tr>
<td class="confluenceTd">Maria</td>
<td class="confluenceTd">1970-06-17</td>
<td class="confluenceTd">60000</td>
<td class="confluenceTd">25</td>
<td class="confluenceTd">0.7</td>
</tr>
</tbody></table>
</div>

#### output:

<div class="table-wrap">
<table class="confluenceTable"><tbody>
<td class="confluenceTd">Maria</td>
<td class="confluenceTd">1970-06-17(1)</td>
<td class="confluenceTd">60000(5)</td>
<td class="confluenceTd">25(5)</td>
<td class="confluenceTd">0.7(5)</td>
<td class="confluenceTd">Total: 16</td>
<tr>
<td class="confluenceTd">Carlos</td>
<td class="confluenceTd">1978-08-11(2)</td>
<td class="confluenceTd">25000(4)</td>
<td class="confluenceTd">16(4)</td>
<td class="confluenceTd">0.65(4)</td>
<td class="confluenceTd">Total: 14</td>
</tr>
<tr>
<td class="confluenceTd">David</td>
<td class="confluenceTd">1986-11-28(3)</td>
<td class="confluenceTd">13000(2)</td>
<td class="confluenceTd">12(3)</td>
<td class="confluenceTd">0.4(3)</td>
<td class="confluenceTd">Total: 11</td>
</tr>
<tr>
<td class="confluenceTd">Emily</td>
<td class="confluenceTd">1986-11-28(3)</td>
<td class="confluenceTd">13000(2)</td>
<td class="confluenceTd">8(2)</td>
<td class="confluenceTd">0.3(2)</td>
<td class="confluenceTd">Total: 11</td>
</tr>
<tr>
<td class="confluenceTd">Aisha(5)</td>
<td class="confluenceTd">1995-03-09(1)</td>
<td class="confluenceTd">8000(1)</td>
<td class="confluenceTd">5(1)</td>
<td class="confluenceTd">0.2(1)</td>
<td class="confluenceTd">Total: 8</td>
</tr>
</tbody></table>
</div>


</body></html>
