<!DOCTYPE html>
<html>
<head>
    <title>Create Task</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <div class="container">
        <h1>Create Task</h1>
        <form action="CreateTaskServlet" method="post">
            <input type="text" name="title" placeholder="Task Title">
            <textarea name="description" placeholder="Task Description"></textarea>
            <input type="date" name="dueDate">
            <select name="priority">
                <option value="High">High</option>
                <option value="Medium">Medium</option>
                <option value="Low">Low</option>
            </select>
            <button type="submit" id="createTask">Create Task</button>
        </form>
    </div>
</body>
</html>
