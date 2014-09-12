__Note:__ d:swarm uses functions of the Metamorph framework for data transformation. You can find more detailed information about these functions at https://github.com/culturegraph/metafacture-core/wiki/Metamorph-functions.

<table class="confluenceTable">
<tbody>
<tr>
<th class="confluenceTh">Transformation</th>
<th class="confluenceTh" colspan="1">Description</th>
<th class="confluenceTh">Parameter</th>
<th class="confluenceTh"> Explanation</th>
<th class="confluenceTh">Example</th>
</tr>
<tr>
<td class="confluenceTd" rowspan="3">case</td>
<td class="confluenceTd" rowspan="3">Letter characters are transformed to lower or upper case.</td>
<td class="confluenceTd" colspan="1">language</td>
<td class="confluenceTd" colspan="1"><a class="external-link" href="http://docs.oracle.com/javase/7/docs/api/java/util/Locale.html" rel="nofollow"> locale</a></td>
<td class="confluenceTd" colspan="1">en (for English)</td>
</tr>
<tr>
<td class="confluenceTd" colspan="1">upper</td>
<td class="confluenceTd" colspan="1">lower case is converted to upper case</td>
<td class="confluenceTd" colspan="1">SLUB DRESDEN</td>
</tr>
<tr>
<td class="confluenceTd" colspan="1">lower</td>
<td class="confluenceTd" colspan="1">upper case is converted to lower case</td>
<td class="confluenceTd" colspan="1">slub desden</td>
</tr>
<tr>
<td class="highlight-grey confluenceTd" colspan="5" data-highlight-colour="grey"></td>
</tr>
<tr>
<td class="confluenceTd" rowspan="2">compose</td>
<td class="confluenceTd" rowspan="2">Wraps the value in a prefix and postfix. Prefixing a mapping value &#8220;swarm&#8221; with &#8220;d:&#8221; will result in &#8220;d:swarm&#8221;.</td>
<td class="confluenceTd" colspan="1">prefix</td>
<td class="confluenceTd" colspan="1">prefix string</td>
<td class="confluenceTd" colspan="1">d:</td>
</tr>
<tr>
<td class="confluenceTd" colspan="1">postfix</td>
<td class="confluenceTd" colspan="1">postfix string</td>
<td class="confluenceTd" colspan="1"></td>
</tr>
<tr>
<td class="highlight-grey confluenceTd" colspan="5" data-highlight-colour="grey"></td>
</tr>
<tr>
<td class="confluenceTd" rowspan="3">concat</td>
<td class="confluenceTd" rowspan="3">Combines the values of several attributes into one element, adding option prefix and postfix strings, and passes result to output.</p>
<p>Value 1: &#8220;SLUB&#8221;</p>
<p>Value 2: &#8220;Dresden&#8221;</p>
<p>delimiter: &#8220;-&#8221;</p>
<p>prefix: &#8220;Pre&#8221;</p>
<p>postfix: &#8220;Post&#8221;</p>
<p>Result: &#8220;PreSLUB-DresdenPost&#8221;</td>
<td class="confluenceTd" colspan="1">delimiter</td>
<td class="confluenceTd" colspan="1">delimiter used to separate concatenated values</td>
<td class="confluenceTd" colspan="1"></td>
</tr>
<tr>
<td class="confluenceTd" colspan="1">prefix</td>
<td class="confluenceTd" colspan="1">prefix string</td>
<td class="confluenceTd" colspan="1"></td>
</tr>
<tr>
<td class="confluenceTd" colspan="1">postfix</td>
<td class="confluenceTd" colspan="1">postfix string</td>
<td class="confluenceTd" colspan="1"></td>
</tr>
<tr>
<td class="highlight-grey confluenceTd" colspan="1" data-highlight-colour="grey"></td>
<td class="highlight-grey confluenceTd" colspan="1" data-highlight-colour="grey"></td>
<td class="highlight-grey confluenceTd" colspan="1" data-highlight-colour="grey"></td>
<td class="highlight-grey confluenceTd" colspan="1" data-highlight-colour="grey"></td>
<td class="highlight-grey confluenceTd" colspan="1" data-highlight-colour="grey"></td>
</tr>
<tr>
<td class="confluenceTd" colspan="1">constant</td>
<td class="confluenceTd" colspan="1">Replaces the value with a constant string.</td>
<td class="confluenceTd" colspan="1">value</td>
<td class="confluenceTd" colspan="1">replace value</td>
<td class="confluenceTd" colspan="1"></td>
</tr>
<tr>
<td class="highlight-grey confluenceTd" colspan="5" data-highlight-colour="grey"></td>
</tr>
<tr>
<td class="confluenceTd" colspan="1">count</td>
<td class="confluenceTd" colspan="1">Counts occurrences of an attribute and passes result to output.</td>
<td class="confluenceTd" colspan="1">no parameter</td>
<td class="confluenceTd" colspan="1"></td>
<td class="confluenceTd" colspan="1"></td>
</tr>
<tr>
<td class="highlight-grey confluenceTd" colspan="5" data-highlight-colour="grey"></td>
</tr>
<tr>
<td class="confluenceTd" colspan="1">equals</td>
<td class="confluenceTd" colspan="1">Filtering based on equality of the inpupt attribute and the function parameter. If the same, the input attribute is passed to output.</td>
<td class="confluenceTd" colspan="1">string</td>
<td class="confluenceTd" colspan="1">comparison value</td>
<td class="confluenceTd" colspan="1"></td>
</tr>
<tr>
<td class="highlight-grey confluenceTd" colspan="5" data-highlight-colour="grey"></td>
</tr>
<tr>
<td class="confluenceTd" rowspan="3">htmlanchor</td>
<td class="confluenceTd" rowspan="3">Creates an HTML anchor tag with the following pattern:


&lg;a href="prefix + wert + postfix"&gt;title&lg;/a&gt;

Example to be mapped: "slub-dresden"
Ergebnis (ohne "+"): &lt;a href="http://www.+slub-dresden+.de/"&gt;Homepage SLUB Dresden&lt;/a&gt;


</td>
<td class="confluenceTd" colspan="1">prefix</td>
<td class="confluenceTd" colspan="1">prefix string</td>
<td class="confluenceTd" colspan="1"><span class="nolink">http://www.</td>
</tr>
<tr>
<td class="confluenceTd" colspan="1">postfix</td>
<td class="confluenceTd" colspan="1">postfix string</td>
<td class="confluenceTd" colspan="1">.de</td>
</tr>
<tr>
<td class="confluenceTd" colspan="1">title</td>
<td class="confluenceTd" colspan="1">link text</td>
<td class="confluenceTd" colspan="1">Homepage SLUB Dresden</td>
</tr>
<tr>
<td class="highlight-grey confluenceTd" colspan="5" data-highlight-colour="grey"></td>
</tr>
<tr>
<td class="confluenceTd" rowspan="4">isbn</td>
<td class="confluenceTd" rowspan="4">ISBN cleaning, checkdigit verication and transformation between ISBN 10 and ISBN 13. Non-digit characters can be eliminated. ISBN can be validated.</td>
<td class="confluenceTd">isbn13</td>
<td class="confluenceTd">transformation to ISBN 13</td>
<td class="confluenceTd"></td>
</tr>
<tr>
<td class="confluenceTd">isbn10</td>
<td class="confluenceTd">transformation to ISBN 10</td>
<td class="confluenceTd"></td>
</tr>
<tr>
<td class="confluenceTd">clean</td>
<td class="confluenceTd">elimination of non-digit characters</td>
<td class="confluenceTd"></td>
</tr>
<tr>
<td class="confluenceTd" colspan="1">verifyCheckDigit</td>
<td class="confluenceTd" colspan="1">validation</td>
<td class="confluenceTd" colspan="1"></td>
</tr>
<tr>
<td class="highlight-grey confluenceTd" colspan="5" data-highlight-colour="grey"></td>
</tr>
<tr>
<td class="confluenceTd" colspan="1">normalize-utf8</td>
<td class="confluenceTd" colspan="1">UTF-8 normalization. Transforms umlauts into canonical form.</td>
<td class="confluenceTd" colspan="1">no parameter</td>
<td class="confluenceTd" colspan="1"></td>
<td class="confluenceTd" colspan="1"></td>
</tr>
<tr>
<td class="highlight-grey confluenceTd" colspan="5" data-highlight-colour="grey"></td>
</tr>
<tr>
<td class="confluenceTd" colspan="1">not-equals</td>
<td class="confluenceTd" colspan="1">Filtering based on inequality. If unequal, attribute value is passed to putput.</td>
<td class="confluenceTd" colspan="1">string</td>
<td class="confluenceTd" colspan="1">comparison value</td>
<td class="confluenceTd" colspan="1"></td>
</tr>
<tr>
<td class="highlight-grey confluenceTd" colspan="5" data-highlight-colour="grey"></td>
</tr>
<tr>
<td class="confluenceTd" rowspan="2">occurence</td>
<td class="confluenceTd" rowspan="2">Filtering based on occurrence.</p>
<p>Values to be mapped (e.g. result of split): &#8220;SLUB&#8221; &#8220;Dresden&#8221; &#8220;d:swarm&#8221; &#8220;Datenmanagement&#8221;</p>
<p>only: &#8220;moreThen 2&#8243;</p>
<p>sameEntity: &#8220;True&#8221;</p>
<p>Result: &#8220;d:swarm&#8221; &#8220;Datenmanagement&#8221;</td>
<td class="confluenceTd" colspan="1">only</td>
<td class="confluenceTd" colspan="1">Position of element</td>
<td class="confluenceTd" colspan="1">moreThen 2</p>
<p>3</p>
<p>lessThen</td>
</tr>
<tr>
<td class="confluenceTd" colspan="1">sameEntity</td>
<td class="confluenceTd" colspan="1"></td>
<td class="confluenceTd" colspan="1">True</p>
<p>False</td>
</tr>
<tr>
<td class="highlight-grey confluenceTd" colspan="5" data-highlight-colour="grey"></td>
</tr>
<tr>
<td class="confluenceTd" rowspan="2">regexp</td>
<td class="confluenceTd" rowspan="2">Regexp matching returning the first occurrence of a pattern. The pattern is a Java regex pattern.</td>
<td class="confluenceTd" colspan="1">format</td>
<td class="confluenceTd" colspan="1">order of the capturing groups</td>
<td class="confluenceTd" colspan="1">${1}</td>
</tr>
<tr>
<td class="confluenceTd" colspan="1">match</td>
<td class="confluenceTd" colspan="1">regex pattern</td>
<td class="confluenceTd" colspan="1">^isbn\d\d\-(\d{10,13})</td>
</tr>
<tr>
<td class="highlight-grey confluenceTd" colspan="5" data-highlight-colour="grey"></td>
</tr>
<tr>
<td class="confluenceTd" rowspan="2">replace</td>
<td class="confluenceTd" rowspan="2">Replaces a pattern with a string. The pattern is a Java regex pattern.</td>
<td class="confluenceTd" colspan="1">pattern</td>
<td class="confluenceTd" colspan="1">regex pattern</td>
<td class="confluenceTd" colspan="1">^isbn\d\d\-(\d{10,13})</td>
</tr>
<tr>
<td class="confluenceTd" colspan="1">with</td>
<td class="confluenceTd" colspan="1">replace value</td>
<td class="confluenceTd" colspan="1"></td>
</tr>
<tr>
<td class="highlight-grey confluenceTd" colspan="5" data-highlight-colour="grey"></td>
</tr>
<tr>
<td class="confluenceTd" colspan="1">split</td>
<td class="confluenceTd" colspan="1">Splitting based on a regexp.</p>
<p>Value to be split: &#8220;SLUB-Dresden&#8221;</p>
<p>delimiter: &#8220;-&#8221;</p>
<p>Result: &#8220;SLUB&#8221; and &#8220;Dresden&#8221; are passed to output</td>
<td class="confluenceTd" colspan="1">delimiter</td>
<td class="confluenceTd" colspan="1">regex pattern</td>
<td class="confluenceTd" colspan="1"></td>
</tr>
<tr>
<td class="highlight-grey confluenceTd" colspan="5" data-highlight-colour="grey"></td>
</tr>
<tr>
<td class="confluenceTd" rowspan="2">substring</td>
<td class="confluenceTd" rowspan="2">Extracts a substring.</p>
<p>value: &#8220;SLUB Dresden&#8221; start=0, end=7, returns &#8220;SLUB Dr&#8221;</td>
<td class="confluenceTd" colspan="1">end</td>
<td class="confluenceTd" colspan="1">index position of the last character</td>
<td class="confluenceTd" colspan="1"></td>
</tr>
<tr>
<td class="confluenceTd" colspan="1">start</td>
<td class="confluenceTd" colspan="1">index position of the first characte</td>
<td class="confluenceTd" colspan="1"></td>
</tr>
<tr>
<td class="highlight-grey confluenceTd" colspan="5" data-highlight-colour="grey"></td>
</tr>
<tr>
<td class="confluenceTd" colspan="1">trim</td>
<td class="confluenceTd" colspan="1">Trims all white spaces at the beginning and at the end of the attribute value.</td>
<td class="confluenceTd" colspan="1">no parameter</td>
<td class="confluenceTd" colspan="1"></td>
<td class="confluenceTd" colspan="1"></td>
</tr>
<tr>
<td class="highlight-grey confluenceTd" colspan="5" data-highlight-colour="grey"></td>
</tr>
<tr>
<td class="confluenceTd" colspan="1">urlencode</td>
<td class="confluenceTd" colspan="1">Transforms all characters not allowed in a URL into URL-compatible characters.</td>
<td class="confluenceTd" colspan="1">no parameter</td>
<td class="confluenceTd" colspan="1"></td>
<td class="confluenceTd" colspan="1"></td>
</tr>
</tbody>
</table>