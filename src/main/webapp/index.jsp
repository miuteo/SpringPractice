<html>
<body>
<h2>Hello World!</h2>

<%= java.util.Calendar.getInstance().getTime() %>

<a href="hello">click for hello</a>
<a href="/welcome">click for welcome</a>
<p></p>
<form action="/helloWorld" method="post">
    Name:<input type="text" name="name"/><br/>
    Password:<input type="password" name="password"><br/>
    <input type="submit" value="login">
</form>
<br/>
<a href="/empformMock">[MOCK]Add Employee</a><br>
<a href="/viewempMock">[MOCK]View Employee</a><br>
<a href="/empform2">Add Real Employee</a><br>
<a href="/viewemp2">View Real Employee</a>

</body>
</html>