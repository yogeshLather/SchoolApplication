<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<body>
    <div>
        <div>
            <h1>Please Enter Student Details</h1> <br>
            <form action="/addStudentAcademicRecord" method="post">
            	Class: <input type="text" name="class"> <br>
            	RollNumber: <input type="text" name="rollNumber"> <br>
            	MathScore: <input type="text" name="mathScore"> <br>
            	EnglishScore: <input type="text" name="englishScore"> <br>
            	<input type="submit" value="Submit">
            </form>
        </div>
    </div>
</body>
</html>