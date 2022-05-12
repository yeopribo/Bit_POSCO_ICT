// 106~108. node 서버 구축하기
var express = require('express');
var app = express();

app.use(express.json());
app.use(express.urlencoded({ extended: false }));

var router = express.Router();

//-------------------------------------------------
// 1차경로

// 139.
var indexRouter = require('./routes/index');
var usersRouter = require('./routes/UsersRout');
var swtoolRouter = require("./routes/SwtoolRout");
var fileuploadRouter = require("./routes/UploadRout");

app.use('/', indexRouter);
app.use('/api/register', usersRouter);
app.use('/api/LoginForm', usersRouter);
app.use("/api/Swtool", swtoolRouter);
app.use("/api/upload", fileuploadRouter);
app.use(express.static("./uploads"));

/* // 172.
// require("./routes/BatchRout");

// 172-수업 방식
let cron = require('node-cron');
let count = 0;

let task = cron.schedule(
    '* * * * *', ()=>{  // 1분
        console.log(++count);
    },
    {scheduled:false}
);

// 1. routes안에 넣고 require하면 정상작동된다
// 2. 하나의 파일에서 1차주소(메인주소), 2차주소(서브주소)
// 를 기록하면 2차주소는 공용 주소가 된다
app.use('/start', 
    router.post('/1', (req, res, next)=>{
        console.log(1);
}));
app.use('/stop', 
    router.post('/2', (req, res, next)=>{
        console.log(2);
}));
// app.use('/start', (req, res, next)=>{
//     console.log('start');
//     task.start();
//     res.send('start');
// });
// app.use('/stop', (req, res, next)=>{
//     console.log('stop');
//     task.stop();
//     res.send('stop');
// }); */

/* // 130
app.use('/save', 
    router.post( '/', function(req, res, next){
        console.log(2);
        req.body.mapper = 'SwToolMapper';
        req.body.crud = 'insert';
        req.body.mapper_id = 'insertOne';
        console.log(req.body);
        res.send('OK')
    })); */

/* // 122
var swtoolRouter = require("./routes/SwtoolRout");
app.use('/api/Swtool', swtoolRouter);

app.use('/api/Swtool', 
    router.post( '/', function(req, res, next){
        console.log(1);
        // db연동해서 받아도 되지만
        res.send([
            {id:1, name:'앵무새1', salary:100, bonus:10},
            {id:2, name:'앵무새2', salary:200, bonus:20},
        ])
    })); */

/* // 122-ex6)
app.use('/api/Swtool', 
    router.post('/', function(req, res, next){
        console.log(1);
        if (req.query.type == 'list') {
            req.body.mapper = 'SwToolsMapper';
            req.body.crud = 'select';
            req.body.mapper_id = 'selectSwToolsMapper';
    
            router.use('/', require('./dbconnect_Module'))
            next('route');
        }
    }),
); */

/* // 122-ex5)
app.use('/api/Swtool', 
    router.post('/', function(req, res, next){
        console.log(1);

        req.body.mapper = 'SwToolsMapper';
        req.body.crud = 'select';
        req.body.mapper_id = 'selectSwToolsMapper';

        next('route');
    }),
    router.post('/', function(req, res, next){
        let param = req.body;
        console.log(param);

        // p363 22번째 라인 해석
        console.log(param.mapper+'.xml');
        
        // p363 18번째 라인 해석
        const mybatisMapper = require('mybatis-mapper');
        console.log(typeof mybatisMapper);

        // 책코드
        // mybatisMapper.createMapper( [param.mapper+'.xml'] );
        // 해석된 코드
        mybatisMapper.createMapper( ['SwToolsMapper.xml'] );

        // query문장을 만든다
        let query = mybatisMapper.getStatement(
            'SwToolsMapper',        // namespace 설정
            'selectSwToolsList',    // 실행할 쿼리문 id 설정
            {},                     // 인수 전달
            { language: 'sql', indent: '  ' }   // indent - 줄간격
        );
        console.log(query);
        console.log(2);
    }),
); */

/* // 122-ex4)
app.use('/api/Swtool', 
    router.post('/', function(req, res, next){
        console.log(1);

        req.body.mapper = 'SwToolsMapper';
        req.body.crud = 'select';
        req.body.mapper_id = 'selectSwToolsMapper';

        next('route');
    }),
    router.post('/', function(req, res, next){
        let param = req.body;
        console.log(param);

        // p363 22번째 라인 해석
        console.log(param.mapper+'.xml');
        
        // p363 18번째 라인 해석
        const mybatisMapper = require('mybatis-mapper');
        console.log(typeof mybatisMapper);

        // 책코드
        // mybatisMapper.createMapper( [param.mapper+'.xml'] );
        // 해석된 코드
        mybatisMapper.createMapper( ['SwToolsMapper.xml'] );
        console.log(2);
    }),
); */

/* // 122-ex3)
app.use('/api/Swtool', 
    router.post('/', function(req, res, next){
        console.log(1);

        req.body.mapper = 'SwToolsMapper';
        req.body.crud = 'select';
        req.body.mapper_id = 'selectSwToolsMapper';

        next('route');
    }),
    router.post('/', function(req, res, next){
        let param = req.body;
        console.log(param);

        // p363 22번째 라인 해석
        console.log(param.mapper+'.xml');

        console.log(2);
    }),
); */

/* // 122-ex2) 책 방식
app.use('/api/Swtool', 
    router.post('/', function(req, res, next){
        console.log(1);
        router.post('/', function(req, res, next){
            console.log(2);
        }), // router가 스택에 저장되있다
        next('route');
    }),
);  */

/* // 122-ex1)
app.use('/api/Swtool', 
    router.post('/', function(req, res, next){
        console.log(1);
        next('route');
    }),
    router.post('/', function(req, res, next){
        console.log(2);
    }),
); */

/* // router로 경로받기
app.use('/tiger', 
    router.get('/', 
        function(req, res, next){
            if(req.query.value == 1){
                console.log(1111);
                next('route');
            } else{
                console.log(2222);
                next();
            }
        },
        function(req, res, next){
            console.log(3333);
            res.send('앵무새1');
        },
    ),
    router.get('/', function(req, res, next){
        console.log(4444);
        res.send('앵무새2');
    } )
); */

/* // use는 get/post 둘다받음
app.get('/tiger', function(req, res, next) {
    console.log('get');
    res.send('호랑이');
} );

app.post('/tiger', function(req, res, next) {
    console.log('post');
    res.send('호랑이');
} ); */

/* // next()로 다음으로 넘겨줌
app.use('/tiger', 
    function(req, res, next) {
        // send를 만나면 EndPoint로 본다.
        // res.send('호랑이1');
        console.log(1);
        next();
    },
    function(req, res, next) {
        console.log(2);
        // res.send('호랑이2');
        next();
    },
    function(req, res, next) {
        console.log(3);
        res.send('호랑이3');
    },
); */

/* // value 이용
app.use('/tiger', 
    function(req, res, next) {
        if(req.query.value == 1){
            next();
        }
        else{
            console.log('tiger');
            res.send('호랑이');
        }
    },
    function(req, res, next) {
        console.log('lion');
        res.send('사자');
    }
); */

//-------------------------------------------------
var port = process.env.PORT || '5000';
app.listen(port, ()=>{console.log(`Listening on port ${port}`);} );

module.exports = app;
