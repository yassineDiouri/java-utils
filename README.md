# java-utils
<table>
  <tr>
    <th>Module</th>
    <th>Current Version</th>
    <th>Stable Version</th>
  </tr>
  <tr>
    <td>math</td>
    <td>1.1.1</td>
    <td>1.1.1</td>
  </tr>
  <tr>
    <td>null</td>
    <td>1.0.1</td>
    <td>1.0.1</td>
  </tr>
  <tr>
    <td>empty</td>
    <td>1.0.2</td>
    <td>1.0.2</td>
  </tr>
  <tr>
    <td>logic</td>
    <td>1.0.0</td>
    <td>1.0.0</td>
  </tr>
  <tr>
    <td><a href="https://github.com/yassineDiouri/java-utils/tree/master/src/main/java/org/binx/utils/database/memdb">MemDB</a></td>
    <td>0.1.1 [SNAPSHOT]</td>
    <td>0.1.0</td>
  </tr>
</table>
## Module MemDB
### Model Architecture
<ul>
  <li><strong><i>DatabaseList : </i></strong> Container of databases (It can contain a unique default database).</li>
  <li><strong><i>Database : </i></strong> Container of schemas (It contain a default "public" schema).</li>
  <li><strong><i>Schema : </i></strong> Container of tables.</li>
  <li><strong><i>Table : </i></strong> Container of Columns and Lines (Columns represents Table header, Lines its content).</li>
  <li><strong><i>Column : </i></strong> Represents Table header, it contains column name and type and Constraints.</li>
  <li><strong><i>Constraint : </i></strong> Represents SQL constraints of Columns to be applied to ColumnValues.</li>
  <li><strong><i>Line : </i></strong> Represents Table content and a container of values (ColumnValue), it is the records inserted into tables (related to column table by contraint type and SQL contraints).</li>
  <li><strong><i>ColumnValue : </i></strong> Represents Value of columns of table, it respect type and Constraints specified on columns.</li>
</ul>

### Model Generators
<p><strong><i>MemDB</i></strong> instantiate all Models by Generators, which add tests on given arguments beside the creation of objects.</p>

### Model Managers
<p><strong><i>MemDB</i></strong> manages basic operations (CRUD, get sublists, existance ...) via Model Managers.</p>
<ul>
  <li><strong><i>DatabaseListManager : </i></strong> Offer Operations to manage list a list of databases (add new database, get database, set default database ...).</li>
  <li><strong><i>DatabaseManager : </i></strong> Offer Operations to manage an instance of database (create new database, get it, set it to default, manage his schemas list ... ).</li>
  <li><strong><i>SchemaManager : </i></strong> Offer Operations to manage an instance of schema/default schema (create new schema, get it, manage his tables list ...).</li>
  <li><strong><i>TableManager : </i></strong> Offer Operations to manage an instance of table (create new table, get it, manage his columns and lines lists ...).</li>
  <li><strong><i>ColumnManager : </i></strong> Offer Operations to manage an instance of column (create new column, get it, manage his constraints list ...).</li>
  <li><strong><i>LineManager : </i></strong> Offer Operations to manage an instance of line (create new line(empty values), get it, manage his column values list ...).</li>
  <li><strong><i>ColumnValueManager : </i></strong> Offer Operations to manage an instance of ColumnValue (create new columnValue with null or specified value, get the ColumnValue, update his value ...).</li>
  <li><strong><i>ConstraintManager : </i></strong> Offer Operations to manage an instance of constraint (create new constraint, get, delete, update his name ...).</li>
</ul>
