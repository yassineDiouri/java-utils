# java-utils
<table>
  <tr>
    <th>Module</th>
    <th>Version</th>
  </tr>
  <tr>
    <td>math</td>
    <td>1.1.1 [STABLE]</td>
  </tr>
  <tr>
    <td>null</td>
    <td>1.0.1 [STABLE]</td>
  </tr>
  <tr>
    <td>empty</td>
    <td>1.0.2 [STABLE]</td>
  </tr>
  <tr>
    <td>logic</td>
    <td>1.0.0 [STABLE]</td>
  </tr>
  <tr>
    <td><a href="https://github.com/yassineDiouri/java-utils/tree/master/src/main/java/org/binx/utils/database/memdb">MemDB</a></td>
    <td>0.0.17 [SNAPSHOT]</td>
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
  <li><strong><i>Constraint : </i></strong> Represents SQL constraints of columns to be applied to ColumnValue.</li>
  <li><strong><i>Line : </i></strong> Represents Table content and a container of values (ColumnValue), it is the records inserted into tables (related to column table by contraint type and SQL contraints).</li>
  <li><strong><i>ColumnValue : </i></strong> Represents Value of columns of table, it respect type and Constraints specified on columns.</li>
</ul>

