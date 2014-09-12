__Note:__ d:swarm uses functions of the Metamorph framework for data transformation. You can find more detailed information about these functions at https://github.com/culturegraph/metafacture-core/wiki/Metamorph-functions.

<table>
<thead>
<tr>
<th>Function</th>
<th>Description</th>
<th>Parameter</th>
<th> Explanation</th>
<th>Example</th>
</tr>
</thead>
<tbody>
<tr>
<td rowspan="3">case</td>
<td rowspan="3">Letter characters are transformed to lower or upper case.</td>
<td>language</td>
<td><a class="external-link" href="http://docs.oracle.com/javase/7/docs/api/java/util/Locale.html" rel="nofollow"> locale</a></td>
<td>en (for English)</td>
</tr>
<tr>
<td>upper</td>
<td>lower case is converted to upper case</td>
<td>SLUB DRESDEN</td>
</tr>
<tr>
<td>lower</td>
<td>upper case is converted to lower case</td>
<td>slub desden</td>
</tr>
<tr>
<td colspan="5"></td>
</tr>
<tr>
<td rowspan="2">compose</td>
<td rowspan="2">Wraps the value in a prefix and postfix. Prefixing a mapping value &#8220;swarm&#8221; with &#8220;d:&#8221; will result in &#8220;d:swarm&#8221;.</td>
<td>prefix</td>
<td>prefix string</td>
<td>d:</td>
</tr>
<tr>
<td>postfix</td>
<td>postfix string</td>
<td></td>
</tr>
<tr>
<td colspan="5"></td>
</tr>
<tr>
<td rowspan="3">concat</td>
<td rowspan="3">Combines the values of several attributes into one element, adding option prefix and postfix strings, and passes result to output.</p>
<p>Value 1: &#8220;SLUB&#8221;</p>
<p>Value 2: &#8220;Dresden&#8221;</p>
<p>delimiter: &#8220;-&#8221;</p>
<p>prefix: &#8220;Pre&#8221;</p>
<p>postfix: &#8220;Post&#8221;</p>
<p>Result: &#8220;PreSLUB-DresdenPost&#8221;</td>
<td>delimiter</td>
<td>delimiter used to separate concatenated values</td>
<td></td>
</tr>
<tr>
<td>prefix</td>
<td>prefix string</td>
<td></td>
</tr>
<tr>
<td>postfix</td>
<td>postfix string</td>
<td></td>
</tr>
<!---  ---------------------------  -->
<tr>
<td>constant</td>
<td>Replaces the value with a constant string.</td>
<td>value</td>
<td>replace value</td>
<td></td>
</tr>
<tr>
<td colspan="5"></td>
</tr>
<tr>
<td>count</td>
<td>Counts occurrences of an attribute and passes result to output.</td>
<td>no parameter</td>
<td></td>
<td></td>
</tr>
<tr>
<td colspan="5"></td>
</tr>
<tr>
<td>equals</td>
<td>Filtering based on equality of the inpupt attribute and the function parameter. If the same, the input attribute is passed to output.</td>
<td>string</td>
<td>comparison value</td>
<td></td>
</tr>
</tbody>
</table>

<table>
<thead>
<tr>
<th>Function</th>
<th>Description</th>
<th>Parameter</th>
<th> Explanation</th>
<th>Example</th>
</tr>
</thead>
<tbody>
<tr>
<td rowspan="3">htmlanchor</td>
<td rowspan="3">Creates an HTML anchor tag with the following pattern (without "+" and spaces):

<p>&lt;a href=" + prefix + value + postfix + "&gt;title&lt;/a&gt;</p>

<p>Example to be mapped: "slub-dresden"<br />
Result: &lt;a href="http://www.slub-dresden.de/"&gt;Homepage SLUB Dresden&lt;/a&gt;</p>
</td>
<td>prefix</td>
<td>prefix string</td>
<td><span class="nolink">http://www.</td>
</tr>
<tr>
<td>postfix</td>
<td>postfix string</td>
<td>.de</td>
</tr>
<tr>
<td>title</td>
<td>link text</td>
<td>Homepage SLUB Dresden</td>
</tr>
<tr>
<td colspan="5"></td>
</tr>
<tr>
<td rowspan="4">isbn</td>
<td rowspan="4">ISBN cleaning, checkdigit verication and transformation between ISBN 10 and ISBN 13. Non-digit characters can be eliminated. ISBN can be validated.</td>
<td>isbn13</td>
<td>transformation to ISBN 13</td>
<td></td>
</tr>
<tr>
<td>isbn10</td>
<td>transformation to ISBN 10</td>
<td></td>
</tr>
<tr>
<td>clean</td>
<td>elimination of non-digit characters</td>
<td></td>
</tr>
<tr>
<td>verifyCheckDigit</td>
<td>validation</td>
<td></td>
</tr>
<tr>
<td colspan="5"></td>
</tr>
<tr>
<td>normalize-utf8</td>
<td>UTF-8 normalization. Transforms umlauts into canonical form.</td>
<td>no parameter</td>
<td></td>
<td></td>
</tr>
<tr>
<td colspan="5"></td>
</tr>
<tr>
<td>not-equals</td>
<td>Filtering based on inequality. If unequal, attribute value is passed to putput.</td>
<td>string</td>
<td>comparison value</td>
<td></td>
</tr>
<tr>
<td colspan="5"></td>
</tr>
<tr>
<td rowspan="2">occurence</td>
<td rowspan="2">Filtering based on occurrence.</p>
<p>Values to be mapped (e.g. result of split): &#8220;SLUB&#8221; &#8220;Dresden&#8221; &#8220;d:swarm&#8221; &#8220;Datenmanagement&#8221;</p>
<p>only: &#8220;moreThen 2&#8243;</p>
<p>sameEntity: &#8220;True&#8221;</p>
<p>Result: &#8220;d:swarm&#8221; &#8220;Datenmanagement&#8221;</td>
<td>only</td>
<td>Position of element</td>
<td>moreThen 2</p>
<p>3</p>
<p>lessThen</td>
</tr>
<tr>
<td>sameEntity</td>
<td></td>
<td>True</p>
<p>False</td>
</tr>
<tr>
<td colspan="5"></td>
</tr>
<tr>
<td rowspan="2">regexp</td>
<td rowspan="2">Regexp matching returning the first occurrence of a pattern. The pattern is a Java regex pattern.</td>
<td>format</td>
<td>order of the capturing groups</td>
<td>${1}</td>
</tr>
<tr>
<td>match</td>
<td>regex pattern</td>
<td>^isbn\d\d\-(\d{10,13})</td>
</tr>
<tr>
<td colspan="5"></td>
</tr>
<tr>
<td rowspan="2">replace</td>
<td rowspan="2">Replaces a pattern with a string. The pattern is a Java regex pattern.</td>
<td>pattern</td>
<td>regex pattern</td>
<td>^isbn\d\d\-(\d{10,13})</td>
</tr>
<tr>
<td>with</td>
<td>replace value</td>
<td></td>
</tr>
<tr>
<td colspan="5"></td>
</tr>
<tr>
<td>split</td>
<td>Splitting based on a regexp.</p>
<p>Value to be split: &#8220;SLUB-Dresden&#8221;</p>
<p>delimiter: &#8220;-&#8221;</p>
<p>Result: &#8220;SLUB&#8221; and &#8220;Dresden&#8221; are passed to output</td>
<td>delimiter</td>
<td>regex pattern</td>
<td></td>
</tr>
<tr>
<td colspan="5"></td>
</tr>
<tr>
<td rowspan="2">substring</td>
<td rowspan="2">Extracts a substring.</p>
<p>value: &#8220;SLUB Dresden&#8221; start=0, end=7, returns &#8220;SLUB Dr&#8221;</td>
<td>end</td>
<td>index position of the last character</td>
<td></td>
</tr>
<tr>
<td>start</td>
<td>index position of the first characte</td>
<td></td>
</tr>
<tr>
<td colspan="5"></td>
</tr>
<tr>
<td>trim</td>
<td>Trims all white spaces at the beginning and at the end of the attribute value.</td>
<td>no parameter</td>
<td></td>
<td></td>
</tr>
<tr>
<td colspan="5"></td>
</tr>
<tr>
<td>urlencode</td>
<td>Transforms all characters not allowed in a URL into URL-compatible characters.</td>
<td>no parameter</td>
<td></td>
<td></td>
</tr>
</tbody>
</table>