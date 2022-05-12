var express = require('express');
var router = express.Router();

// mysql 연동 aws
const mysql = require('mysql');
const con = mysql.createConnection( {
    host: "react200.ci2oz0v3k09f.us-east-1.rds.amazonaws.com",
    port: "3306",
    database: 'react',
    user: "admin",
    password: "mypassword",
});

router.post('/select', function(req, res, next) {
    try {
        con.query(
            'select * from react_crud',
            (error, rows, fields)=>{
                if (error) throw error;

                console.log(rows);
                res.send(rows);
            }
        );
    } catch (error) {
        console.log('error: ',error);
    }
});

router.post('/insert', function(req, res, next) {
    let name = req.body.name;
    let eno = req.body.eno;
    let mgr = req.body.mgr;
    let salary = req.body.salary;
    //const sql = "INSERT INTO react_crud VALUES(null, ?, ?, null, 100);"
    const sql = `INSERT INTO react_crud VALUES(null, '${name}', '${eno}', '${mgr}', '${salary}');`
    try {
        con.query(sql,
            (error, rows, fields)=>{
                if (error) throw error;

                console.log(rows);
                res.send(rows);
            }
        );
    } catch (error) {
        console.log('error: ',error);
    }
});

router.post('/delete', function(req, res, next) {
    let name = req.body.name;
    const sql = `DELETE FROM react_crud WHERE name= '${name}';`
    try {
        con.query(sql,
            (error, rows, fields)=>{
                if (error) throw error;

                console.log(rows);
                res.send(rows);
            }
        );
    } catch (error) {
        console.log('error: ',error);
    }
});

router.post('/update', function(req, res, next) {
    let name = req.body.name;
    let eno = req.body.eno;
    let mgr = req.body.mgr;
    let salary = req.body.salary;
    const sql = `UPDATE react_crud SET eno='${eno}', mgr='${mgr}', salary='${salary}' WHERE name = '${name}';`
    try {
        con.query(sql,
            (error, rows, fields)=>{
                if (error) throw error;

                console.log(rows);
                res.send(rows);
            }
        );
    } catch (error) {
        console.log('error: ',error);
    }
});

/* // mysql 연동2
const mysql = require('mysql');
const con = mysql.createConnection( {
    host: "localhost",
    port: "3306",
    database: "db01",
    user: "root",
    password: "1234",
});

router.post('/', function(req, res, next) {
    console.log(req.query.command);
    console.log(req.body);
    try {
        con.query(
            'select * from table01;',
            (error, rows, fields)=>{
                if (error) throw error;

                // console.log(rows);
                res.send(rows);
            }
        );
    } catch (error) {
        console.log('error: ',error);
    }
}); */

/* // mysql 연동
const mysql = require('mysql');
const con = mysql.createConnection( {
    host: "localhost",
    port: "3306",
    database: "db01",
    user: "root",
    password: "1234",
});

router.get('/', function(req, res, next) {
    console.log(1);
    try {
        con.query(
            'select * from table01;',
            (error, rows, fields)=>{
                if (error) throw error;

                console.log(rows);
                res.send(rows);
            }
        );
    } catch (error) {
        console.log('error: ',error);
    }
}); */

/* // client send >> middle >> server recv
// /?변수=값    app.use()   req.query.변수
router.get('/', function(req, res, next) {
    console.log(req.query.command);
    res.send(req.body);
});

router.post('/:command', function(req, res, next) {
    console.log(req.params.command);
    res.send(req.body);
});*/

module.exports = router;
