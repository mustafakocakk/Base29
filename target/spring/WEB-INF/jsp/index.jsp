<html>
<head>
    <title>Base 29 Encode/Decode</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

</head>
<body>
${message}
<form method = "post" action = "/spring/base29">
    <div class="form-group">
        <label >Encode   Text</label>
        <input name="Text" placeholder="text">

    </div>

    <div class="form-check">
        <input type="checkbox" name="text"/>
        <label class="form-check-label" >encode</label>


    </div>

    <button type="submit" class="btn btn-primary">Encode</button>
</form>
</body>

</html>