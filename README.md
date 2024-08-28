<!DOCTYPE html>
<html class="mozilla"><head>

</head>
  <p>The candidates: </p>

<div class="table-wrap">
<table class="confluenceTable"><tbody>
<tr>
<td class="confluenceTd">Name</td>
<td class="confluenceTd">Birth Day</td>
<td class="confluenceTd">Incomes</td>
<td class="confluenceTd">Work Experience (Years)</td>
<td class="confluenceTd">Debt Risk Ratio</td>
</tr>
<tr>
<td class="confluenceTd">Emily</td>
<td class="confluenceTd">1992-05-22</td>
<td class="confluenceTd">15000</td>
<td class="confluenceTd">8</td>
<td class="confluenceTd">0.3</td>
</tr>
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


<p>Your task is to implement a rating system for provided data collection.</p>

<p>The concept: every column should be <b>ordered ascending from smallest to largest and get a rate depends on a place in the table.</b>
 For example the biggest work experience  is for 25 year.  When smallest
 is for 5 years. So, the  first position will get a rate 1. The smallest
 will get the rate 5 as only 5 rows in the table.  Such a rule must be 
applied to every column. All ratings sum should be in a new  column and 
ordered by <b>ascending</b>.</p>

<div class="table-wrap">
<table class="confluenceTable"><tbody>
<tr>
<td class="confluenceTd">Emily (2)</td>
<td class="confluenceTd">1992-05-22 (2)</td>
<td class="confluenceTd">15000 (2)</td>
<td class="confluenceTd">8 (1)</td>
<td class="confluenceTd">0.3(1)</td>
<td class="confluenceTd">8</td>
</tr>
<tr>
<td class="confluenceTd">Carlos (1)</td>
<td class="confluenceTd">1978-08-11 (1)</td>
<td class="confluenceTd">25000  (1)</td>
<td class="confluenceTd">16 (2)</td>
<td class="confluenceTd">0.65 (2)</td>
<td class="confluenceTd">7</td>
</tr>
</tbody></table>
</div>


<p>Requirements: <b>NO if/else in any way!!!</b></p>

<p>The documentati:</p>

<p><a href="https://docs.oracle.com/javase/tutorial/collections/interfaces/index.html" title="smart-link" class="external-link" rel="nofollow noreferrer">https://docs.oracle.com/javase/tutorial/collections/interfaces/index.html</a> </p>

</body></html>
