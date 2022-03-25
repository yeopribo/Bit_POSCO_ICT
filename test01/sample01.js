// File - preference - Setting - wheel입력 - 체크
// 실행 단축키 : Ctrl + F5
// 주석 : Ctrl + /
// 파일이나 폴드 리네임 : F2
// console.log("Hello World");
// console.log("호랑이");

// // ex3) File - Preferences > User Snippets > javascript
// // 주석을 푼다. ( 7 - 14 )
// console.log('');

// // ex4) 변수 선언
// var a = 10; //  var >> let
// console.log(a);

// let b = 20;
// console.log(b);

// const c = 30;
// console.log(c);

// ex5)
// let a = 10;
// console.log(a);
// let b = 'tiger';
// let c = true;
// let d = 3.14;
// let e = []; // object
// let f = {}; // object
// let g = function(){};
// let h = undefined;

// console.log(typeof(a));
// console.log(typeof(b));
// console.log(typeof(c));
// console.log(typeof(d));
// console.log(typeof(e));
// console.log(typeof(f));
// console.log(typeof(g));
// console.log(typeof(h));
// // number, string, boolean, object, function, 

// ex6)

// key : value >> JSON
// let obj = {
//     a:10,
//     b:'tiger',
//     c:true,
//     d:[],
//     e:{},
//     f:function(){},
//     g:undefined
// };
// console.log(typeof(obj));
// console.log(typeof(obj.a));
// console.log(typeof(obj.b));
// console.log(typeof(obj.c));
// console.log(typeof(obj.d));
// console.log(typeof(obj.e));
// console.log(typeof(obj.f));
// console.log(typeof(obj.g));

// ex7)
// let obj = {
//     a:{
//         b:{
//             c:{
//                 d:10
//             },

//         },

//     },
// }
// let obj2 = {
//     a:1000,
//     b:'tiger',
//     c:3,
// }
// console.log(typeof(obj.a.b.c.d));
// console.log(obj.a.b.c.d);

// ex8)
// let apple = 10;
// console.log(apple, typeof(apple));

// // 메모리 생성
// // apple = new number();
// // 사용할 수 있다.
// // 메모리 해제
// // delete(apple);

// // number타입의 메모리가 삭제된다.
// // string 타입의 메모리가 생성된다.
// // delete(apple);
// // apple = new String();
// apple = 'tiger';
// console.log(apple, typeof(apple));

// // 동적 타입 변경
// let b = 10;
// b = 'lion';
// b = function(){};
// b = {};

// ex9) 지역성의 유지 여부
// var 는 스코프 밖에서도 유지됨 지역성 유지 x
// let 은 스코프 안에서만 유지됨 지역성 유지 o
// {
//     var a = 10;
// }
// console.log(a);

// {
//     let b = 10;
//     // b 사용 가능
// }
// //console.log(b);

// ex10) const - 상수화
// const a = 10;
// console.log(a);
// a = 20;
// console.log(a);

// ex11) undefined, null
// // 타입이 정의되지 않았다.
// //      a의 타입은 undefined
// let a = undefined;

// // 타입은 정해진다.(Object)
// // 참조하는 값이 없다
// let b = null;

// console.log(typeof(a));
// console.log(typeof(b));

// ex12) 문자열 연결
// Number, String
// let str = '호랑이';
// str += '코끼리';
// console.log(str);

// let s = '100';
// let n = 100;
// console.log(s+n);   // 문자열 연결
// console.log(Number(s) + n);   // 
// console.log(String(n) + 200);   //  

// console.log('-------------------------');

// // 문자열을 >> 숫자로 변환 >> 
// // 1. Number(); - 문자열 그대로 변환해서 NaN 뜸
// // 2. ParseInt(); - 문자열 없애주고 숫자로 전환
// let s1 = '100원';
// let s2 = '200원';
// console.log(Number(s1) + 1);
// console.log(parseInt(s2) + 1);

// // 슈가 코드 >> 앞에 +적어서 숫자로 변환
// let s3 = '10';
// let s4 = +'10';
// let s5 = 999 + +s3;
// console.log(typeof(s3));
// console.log(typeof(s4));
// console.log(typeof(s5));
// console.log(s5);

// ex13) 자바랑 비교
// 산술, 관계, 논리 연산 동일
// 증가, 감소 연산자 동일
// +=, 복합대입연산자 동일
// true, false
// 4대 제어문 동일
// 삼항연산 동일

// console.log(Math.pow(2, 3));
// console.log(2 ** 3);
// // 예측1) 2의 3승 결과를 2승 한다.
// // 예측2) 2의 3승의 2승
// console.log(2 ** 3 ** 2);

// 4장 책내용) 
// let result = 10;
// result = 20;

// // new == malloc();
// // delete == free();

// //await
// //yield

// let $app_le = 10;
// console.log($app_le);

// ex14)
// let a = 10;
// let b = 0x10;   // 16진수 표기
// let c = 0o777;  // 8진수
// let d = 0b1111011;    // 2진수
// console.log(a);
// console.log(b);
// console.log(c);
// console.log(d);

// function apple(){
//     return 100;
// }

// for (let i = 0; i < 3; i++) {
//     console.log(i);
// }

// function foo() {
//     return
//     {}
// }

// ex15)
// // 값이 같은가?
// console.log(10==10);
// // 1. 값이 같은가?
// // 2. 타입이 같은가?
// console.log(10===10);

// console.log(10=='10');
// console.log(10==='10');

// console.log(10===10.0);

// console.log(7 / 4); // 정확한 결과값이 나온다.
// console.log(7 % 4);

// console.log('한글');
// console.log("한글'과'컴퓨터");
// let t = 999;
// console.log(`한t글`);

// ex16)
// 문자열안에 태그를 표현할 수 있다.
// let str = `<h3>호랑이</h3>`;    // '\n', '\t'

// let first = 'tiger';
// let last = 'lion';

// console.log(`My name is ${first} and ${last}`);
// let a = 3;
// let b = 4;
// console.log(`${a + b}`);
// console.log(`${a} + ${b} = ${a + b}`);

// ex17) SYMBOL 타입
// // - e)1
// let obj = {
//     a : 10,
// };
// // 실행시간에 필요에 따라서 키값을 추가할 수 있다.
// obj.b = 20;
// console.log(obj.a);
// console.log(obj.b);

// // - e)2
// let obj2 = {
//     a : 10,
// };
// // 실행시간에 필요에 따라서 키값을 추가할 수 있다.
// obj2['b'] = 20;
// console.log(obj2['a']);
// console.log(obj2['b']);

// // - e)3 라이브러리로 제공된 객체일때
// let obj3 = {
//     a : 10,
//     b : 20,
// };
// obj3['b'] = 30;
// console.log(obj3['b']);

// console.log('--------------------');

// // - e)4 
// let obj4 = {
//     a:10,
//     monkey:20,
//     myfunc:function(){
//          return this.a+this.monkey;
//     }
// };

// // 키를 새로 만들었다고 생각하고 작성했다.
// obj4['monkey'] = 30;
// //console.log(obj4.myfunc(), obj4['monkey']);
// console.log(obj4.myfunc());

// // - e)5
// let obj5 = {
//     a:10,
//     monkey:20,
//     myfunc:function(){
//          return this.a+this.monkey;
//     }
// };

// let monkey = Symbol('monkey');
// obj5[monkey] = 999;
// console.log(obj5.myfunc());
// console.log(obj5['monkey']);
// console.log(obj5[monkey]);

// console.log('--------------------');
// let obj6 = {
//     a : 20,
//     b : 30,

//     // 함수가 사용하게 되었을때
//     // 실행시간으로 변경되는 결과에 대하여
//     // 어떻게 예측할 수 있는가?
// }
// // 속
// obj['b'] = 10;

// console.log(0 == '');

// !(x || y) == !x && !y

// let a=1, b=2, c=3;

// while(true){

// }
// //
// for(;;){
//     break;
// }

// ex18)
// let n = new Date();
// console.log(typeof(n));
// console.log(typeof(Date));
// console.log(typeof n);

// console.log(n.getFullYear(), '년');
// console.log(n.getMonth()+1, '월');    // 0월부터 출발
// console.log(n.getDate(), '일');
// // 0이 일요일
// console.log(n.getDay(), '요일');

// console.log(n.getHours(), '시');
// console.log(n.getMinutes(), '분');
// console.log(n.getSeconds(), '초');

// ex19) Date()를 이용하여 1초동안 for문의 반복횟수를 얻는다.
// let start = new Date().getTime();
// console.log(start);
// for (var i = 0; new Date().getTime() < start + 1000; i++) {
    
// }
// console.log(i);

// ex20)
// - ex1)
// let start = new Date().getTime();
// console.log('start');

// while (new Date().getTime() < start + 1000);

// console.log('end');

// - ex2) 즉시 실행 함수
// (function (num){
//     console.log(num);
// })(1000);

// - ex3)
// (function (num){
//     console.log('시간 지연 시작', num / 1000);
    
//     let start = new Date().getTime();
//     while (new Date().getTime() < start + num);
// })(3000);

// console.log('end');

// ex21) 짧은 if문
/* 
if( true ){
    console.log('100');
}
// 
true && console.log('100');

if(!false){ // if(! (num > 20) ){
    console.log('20');
}

// (num > 20) || console.log('30')
false || console.log('30');

// let num = 10;
// if( false && num++ ){
    
// }
// console.log(num); 
*/

// ex22) 함수를 나타내는 다양한 형태
/* 
// 1. 
function f1(){
    console.log('1');
}
f1();   // 함수를 호이스팅 할수있다.

// 2.
let f2 = function(){
    console.log('2');
}
f2();   // 호이스팅 할수없다.

// 3. 람다 함수
let f3 = ()=>{
    console.log('3');
}
f3();

// 4. 즉시 실행 함수(IIFE)
(function(){
    console.log('4');
})();

// 5. IIFE + 람다.
(()=>{
    console.log('5');
})();

// 6. 람다 인수 전달
((num)=>{
    console.log(num);
})(6);

// 7. 리턴 처리
let result = ((num)=>{
    return num * 10;
})(7);
console.log(result);

// 8. 첫자가 대문자로 출발한다. 
// 생성자 함수 ( == 클래스 )
function F4(){
    this.name = '호랑이'    // ,가 들어가지 않는다
    this.age = 100

    this.f1 = function(){
        console.log(this.name);
    }

    this.f2 = ()=>{
        console.log(this.age);
    }
}

let obj = new F4();
obj.f1();
obj.f2();
console.log(obj.name, obj.age); 
*/

// ex23)
/* 
function t1(){

}
t1();

function t2(num){
    console.log(num);
}
t2(10);

function t3(){
    return 100;
}
console.log(t3());

function t4(num){
    return num * 10;
}
console.log(t4(20));
 */

// ex24) 10장 중요
/* 
// - ex1)
let count = {
    num: 0,
    increase: function(){
        this.num++;
        console.log(this.num);
    }
};
console.log(count.num);
count.increase();

// - ex2)
let person = {
    name: 'tiger',
    sayHello: function(){
        console.log(`${this.name}`);
    }
};
person.sayHello();
console.log(person);
console.log('end');

// - ex3)
let empty = {

};
console.log('-------------------');

// - ex4) 속성을 ''으로 정의할 수 있다.
let obj01 = {
    'name': 'tiger',
    'age': 10,
};
console.log(obj01.name, obj01.age);

// - ex5)
let obj02 = {};
let key = 'hello';
obj02[key] = 'world';
console.log(obj02.hello);
console.log(obj02);

// - ex6) 키이름을 숫자로 정의하면 자동으로 문자열 처리한다.
let obj03 = {
    0: 10,
    1: 20,
    '2':30,
};
// 안된다.
// console.log(obj03.0);
// 안된다.
// console.log(obj03'0');
console.log('----------------test--------------');
// 둘다 된다
console.log(obj03[0]);
console.log(obj03['0']);

// - ex7) 가장 나중에 정의된 속성으로 된다.
// 속성 사용 방법 2가지.
let obj04 = {
    age:10,
    age:20,
};
console.log(obj04);
console.log(obj04.age, obj04['age']);

// 익셉션 발생
// console.log(obj04[age]);

// - ex8)
let obj05 = {
    a:10,
};
// 속성 갱신
obj05.a = 20;

// 속성 생성
obj05.b = 30;

// 속성 삭제
delete obj05.a;

console.log(obj05);

// - ex9) 중요
let x=3, y=4;
let obj06 = {
    x:x,    // 속성:값
    y:y,
}
console.log(obj06);

// - ex10) xx: yy: 을 생략할 수 있다
let xx=3, yy=4;
let obj07 = {
    xx,    // 속성:값
    yy,
}
console.log(obj07);

// - ex11)
let xxx=3, yyy=4;
let obj08 = { xxx, yyy, }
console.log(obj08);

// - ex12)
let prefix = 'prop';
let ct = 0;
let obj09 = {};
obj09['prop-0'] = 0;
obj09[prefix + '-' + ++ct] = 0;

for (let i = 2; i < 5; i++) {
    obj09[prefix + '-' + i] = 0;
}
console.log(obj09);

// - ex13) 12 연장 예제
// 대충 버리는 문법
let obj10 = {
    [`${prefix}-${ct}`]: 99,
};
console.log(obj10);

// - ex14)
let obj11 = {
    // 일반함수( new를 이용해서 객체로 생성할수 있다)
    // 생성자 함수로서의 역할을 할수 있다
    f1:function(){
        console.log('1');
        
    },
    // 메소드( new를 이용해서 객체로 생성할수 없다)
    // 생성자 함수로서의 역할을 할수 없다
    f2(){
        console.log('2');
    },
}
let tt10 = new obj11.f1();
//let tt11 = new obj11.f2();
 */

// ex25) 가변인수 함수
/* 
function f1(){
    console.log(typeof arguments);
    console.log(arguments.length);

    let sum = 0;
    for (const key in arguments) {
        console.log(key, arguments[key]);
        sum += arguments[key];
    }
    console.log(sum);
}
// f1(10);
// f1(10, 20);
f1(77, 88, 99);
 */

// ex26) 내부 함수
/* 
// 내부 함수는 밖에서는 사용 못함

// - ex1)
let f1 = function(){
    console.log('1');
    let f2 = function(){
        console.log('2');
    }
    f2();
}
f1();

// - ex2)
let f3 = function(){
    console.log('1');
    return function(){
        console.log('2');
    }
};
f3()();

// - ex3)
let f4 = function(a, b){
    console.log(a+b);
    return function(c, d, e){
        console.log(c+d+e);
    }
};
f4(10, 20)(10, 20, 30);

// - ex4)
let f5 = function(a){
    a();
    return function(c){
        c();
    }
};
f5(function(){
    console.log(99);
})(function(){
    console.log(100);
});
 */

// ex27) cf >> callback 
/* 
let f1 = function(cf){
    cf();
}
let f2 = function(){
    console.log('ex1');
}
// - ex1)
f1(f2);

// - ex2)
f1(function(){
    console.log('ex2');
});

// - ex3)
f1(()=>{
    console.log('ex3');
});

// - ex4)
const f3 = function(){
    console.log('1');
    const f4 = function(){
        console.log('2');
        
    };
    // return f4(); // 주의
    return f4;
};
f3()();

// - ex5)
const f5 = function(){
    console.log('1');
    return function(){
        console.log('2');
        
    };
};
f5()();
 */

// ex28)
/* 
// - ex1)
(function(){
    console.log('1');
    return function(){
        console.log('2');
        
    };
})()();

// ex2)
((cf)=>{
    cf();
    console.log('1');
    return (cf1)=>{
        cf1();
        console.log('2');
        return (cf2)=>{
            cf2();
            console.log('3');
            return (cf3)=>{
                cf3();
                console.log('4');
                return (cf4)=>{
                    cf4();
                    console.log('5');
                }
            }
        }
    };
})(()=>{
    console.log('a');
})(()=>{
    console.log('b');
})(()=>{
    console.log('c');
})(()=>{
    console.log('d');
})(()=>{
    console.log('e');
});

// - ex3) 커링 해보다맘
var greeting = 'greeting';
var separator = 'separator';
var name = 'name';
var emphasis = 'emphasis';

var greetDeeplyCurried = function(greeting) {
    return function(separator) {
      return function(emphasis) {
        return function(name) {
          console.log(greeting + separator + name + emphasis);
        };
      };
    };
  };
greetDeeplyCurried();
 */

// ex28)
/* 
// - ex1)
let c = function(a){ return a*10; }
console.log(c(2));

// - ex2) 람다 수정
let c2 = (a) => { return a*10; }
console.log(c2(2));

// - ex3) 람다에서 인수 전달이 1개일때 괄호 생략 가능
let c3 = a => { return a*10; }
console.log(c3(2));

// - ex4) 람다에서 return 단문장일때 return 생략할수있다. 단, {}도 같이 생략
let c4 = a =>  a*10; 
console.log(c4(2));

let c5 = function(){
    //return 숫자, 문자열, 함수, 객체;
    // return 100;
    // return 'tiger';
    // return ()=>{};
    return { a:10, b:20, };
}
let obj01 = c5();
console.log(obj01.a, obj01.b);

let c6 = ()=>{
    return { a:10, b:20, };
}
// return과 {} 빼고나니까 남아 있는 {}가 함수의 {}인지 객체의 {}인지 모호
// 객체 {}를 ()로 감싼다
let c7 = ()=>({ a:30, b:40 });
let obj02 = c7();
console.log(obj02.a, obj02.b);
 */

// ex29)
/* 
// - ex1) 기본 함수정의
(a)=>{ };

// - ex2) 실제 실행 코드
((a)=>{ })();

// - ex3)
((a)=>{ 
    console.log('1');
    ((b)=>{ 
        console.log('2');
    })();
})();

// - ex4)
((a)=>{ ((b)=>{ })(); })();

// - ex5) 즉시 실행을 안한다고 한다면
((a)=>{ ((b)=>{console.log(a+b); })(10); })(20);

// - ex6) 
let c1 = (a)=>{ (b)=>{console.log(a+b); } };

// - ex7) 
let c2 = (a)=>{ (b)=>{ } };

// - ex8) 
let c3 = a=>{ b=>{ } };

// - ex9) 
// let c4 = a => b => a + b;
// let c4 = (a) => (b) => a + b;
// let c4 = (a) => (b) => { return a + b; };
// let c4 = (a) => {return (b) => { return a + b; } };

// let c4 = (a) => {
//     return (b) => { 
//         return a + b; 
//     } 
// };
let c4 = a => b => a + b;

console.log(c4(10)(20));

// let c4 = (a) => { 
//     return (b) => a + b;
// };
 */

// ex30)
/* 
let c1 = (a) => {
    return (b) => { 
        return a + b; 
    } 
};
console.log(c1(1)(2));

let c2 = (a) => {
    return (b) => a + b;
};
console.log(c2(1)(2));

let c3 = (a) => (b) => a + b; 
console.log(c3(1)(2));
// 실전코드에서 사용된다
let c4 = a => b => a + b; 
console.log(c4(1)(2));
 */

// ex31) 클로저 함수 :
/* 
const f1 = function(){
    let a = 100;    // 생명연장을 시킨다.
    return function(){
        console.log(a);
    }
}
f1()();
 */

// ex32) setTimeout

// - 비동기 함수 : 코드의 실행순서를 지키지 않는 함수
// setTimeout( 함수, 정수 );
/* 
console.log('1');
// 비동기 함수가 없으면 함수가 블로킹
// 비동기 함수를 동기화 시킨다
{ 동기화
setTimeout( 
    function(){
        if( ){
            login = true;
        }
        console.log('2');
    }, 2000 );   // 2000은 2초
}
// ----------------------------------
if(login === true){
    exit
}
console.log('3');
 */

// ex33) setInterval
/* 
console.log('1');

let id = setInterval( 
    ()=>{
        console.log('2');
    }, 1000 );

setTimeout(
    ()=>{
        // 버튼이 클릭되었을때
        clearInterval(id);
    },
    5600
);
console.log('3');
 */

// ex34) 0 1 2 3 4 를 1초단위로 찍는 법
/* 
console.log('test');

// - ex1)
// for (var i = 0; i < 3; i++) {
//     setTimeout(
//         ()=>{
//             console.log(i);
//         },
//         1000
//     );
// }

// - ex2)
// for (var i = 0; i < 3; i++) {
//     (function(num) {
//         setTimeout(
//             function() {
//             console.log(num);
//             }, 
//             1000
//         );
//     } )(i);
// }

// - ex3)
// for (let i = 0; i < 3; i++) {
//     setTimeout(
//         ()=>{
//             console.log(i);
//         },
//         1000
//     );
// }

// - ex4)
// for (let i = 0; i < 5; i++) {
//     setTimeout(
//         ()=>{
//             console.log(i);
//         },
//         i * 1000
//     );
// }
 */

// ex35) eval() : 문자열을 코드로 해석해서 실행해주는 함수
/* 
// let str = '';
// str += 'let a = 10;';
// str += 'console.log(a);';

// eval(str);

// client >> 문자열을 만든다.(js 코드를 만든다.) ->> 서버에 날린다.
// 문자열을 받았다. >> eval을 이용해서 실행결과를 만들수 있다.
// 실행결과를 >> client에 전송

//     배열             객체
// 1. [ ]                { }
// 2. index사용     속성(key:value)
// 3. forEach가능   forEach불가
// 4. length가능    length불가
 */

// ex36)
/* 
let obj = {
    s:'tiger',
    n:10,
    b:true,
}
console.log(obj);
console.log(obj.s, obj.n, obj.b);
console.log(obj['s'], obj['n'], obj['b']);

// 출력 순서가 보장되지 않는다.
for(const key in obj){
    console.log(key, obj[key]);
}

// with키워드
with(obj){
    console.log(s, n, b);
}
 */

// ex37)
/* 
const obj = {
    // obj = this <--> a (바인딩)
    a:10,
    b:20,
    f1:function(){
        console.log(this.a, this.b);
    },
    // 람다에서 this를 사용할 수 없다
    f2:()=>{
        console.log(this.a, this.b);
    },
    f3:function(){
        for(const key in this){
            console.log(key, this[key]);
        }
    }
};
//obj.f1();
//obj.f2();
obj.f3();

let c = 'dd';
let apple = {
    a:10,
    b:'tiger',
    [c]:30,
}
console.log(apple);

const obj01 = {
    a:10,

}
obj01.b = 20;
obj01['c'] = 30;

for(let i=0; i<3; i++){
    obj01['lion' + i] = i * 10;
}

console.log(obj01);

console.log('end');
 */

// ex38)
/* 
const obj = {
    a:10,
    b:20,
};
console.log(obj);
console.log(Object.keys(obj));

let a = Object.keys(obj);
console.log(typeof a);
console.log(Array.isArray(a));

// 값만 얻을수 있다.
console.log(Object.values(obj));
 */

// ex39) 객체 병합
/* 
const obj01 = {
    a:10,
    b:20,
};

const obj02 = {
    c:30,
    d:40,
};

// 방법1)
const obj03 = Object.assign(obj01, obj02);
console.log(obj03);

// 방법2) 90% : ...을 전개 연산자
const obj04 = {...obj01, ...obj02};
console.log(obj04);

console.log('end');

let apple = (banana)=>{
    console.log(banana);
}
apple({...obj01, ...obj02});
 */

// ex40) 배열 반복
/* 
// 1.
let ar = [10, 20, 30];
console.log(ar);
console.log(ar.length);
console.log(typeof ar);
console.log(Array.isArray(ar));

// // 2. 비어있는 배열
// let br = Array();
// console.log(br.length);

// // 3. 인수전달이 1개일때는 갯수
// let cr = Array(5);
// console.log(cr);
// console.log(cr.length);

// // 4. 2개이상일때는 값
// let dr = Array(40, 50, 60);
// console.log(dr);

// // 5. 모든 타입을 적용할 수 있다
// let er = [10, 'tiger', true, [], {}, function(){}, undefined];
// console.log(er);

// // for in
// for(const index in ar){
//     console.log(index, ar[index]);
// }

// // for of
// for(const value of ar){
//     console.log(value);
// }

// forEach 함수를 사용할수 있다
// ar.forEach( 함수 );
// ar.forEach( function(){} );
console.log('');
ar.forEach( (v, i)=>{
    console.log(v, i);
} );
console.log('');
// 기존에 가지고 있는 데이터를 가공해서 새로운 데이터를 생산한다.
let br = ar.map( (value)=>{
    console.log(value);
    return value * 10;
});
console.log(br);
console.log(ar);

let cr = ar.map( value => value * 10 );
console.log(cr);
 */

// ex41)
/* 
let ar = [10, 11, 12, 13];
let br = ar.map( v => v % 2 ? 'Odd' : 'Even' );
console.log(br);
 */

// ex42)
/* 
let ar = [ 
    {
        n:'tiger',
        a:10,
    },
    {
        n:'lion',
        a:20,
    },
    {
        n:'cat',
        a:30,
    },
];
console.log(ar);
for (const index in ar) {
    console.log(ar[index].n, ar[index].a);
}

for(const v of ar){
    console.log(v.n, v.a);
}

ar.forEach( (v, i)=>{
    console.log(v);
} );

let br = ar.map( (v, i)=>{
    return v.n;
} );
console.log(br);
 */

// ex43) 배열 함수( *func : 스스로 갱신 )
/* 
// 1. toString
let ar = [10, 20, 30, 40];
let str = ar.toString();
console.log(str, typeof str);

// 2.
let date = new Date();
console.log(date);
console.log(date.toLocaleString());

// 3. pop()* : 맨 마지막 요소가 삭제된다.
ar.pop();
console.log(3, ar);

// 4. push()*
let num = ar.push(20);
console.log(4, ar, num);

// 결과적으로 1개의 요소가 추가된것임
// 병합이 일어난 것이 아니다
let br = [77, 88, 99];
ar.push(br);
console.log(5, ar);
console.log(ar[4]);

// 5.
let cr = [10, 20, 30];
let dr = [40, 50];
// 스스로는 갱신되지 않는다
let er = cr.concat(40);
console.log(cr);
console.log(er);

let fr = cr.concat(dr);
console.log(fr);

fr = cr.concat([88, 99]);
console.log(fr);

// 6. join(구분자를 삽입하면서 문자열을 연결한다)
let gr = ['tiger','lion','cat','dog'];
console.log(gr.join());
console.log(gr.join(''));
console.log(gr.join('-'));

// 7. reverse()*
console.log(gr.reverse());

// 8. shift
        // 1, 2, 3, 4
let t1 = gr.shift();
console.log(t1);
console.log(gr);

gr.unshift('rose');
console.log(gr);
 */

// ex44) 배열 정렬
/* 
// 주의 : 우연히 정렬된다
let ar = [80, 20, 10, 15];
console.log(ar);
ar.sort();
console.log(ar);

let br = [52, 273, 103, 32];
console.log(br);
br.sort();
// [103, 273, 32, 52]
console.log(br);

let cr = [99, 52, 13, 42, 66, 21];
// cr.sort( 정렬시키는 기준을 함수로 작성 );
// cr.sort( (a, b)=>
//     // 내가 함수안에서 직접 정렬하는것은 아니다
//     // 정렬 기준을 코드로 작성하면 sort가 참고한다
//     // 순차 정렬로 해석한다
//     // if(a > b){
//     //     return +1;
//     // }else{
//     //     return -1;
//     // }
//     (a > b) ? +1 : -1 );
// 순차 정렬코드
cr.sort( (a, b) => (a - b) );
console.log(cr);

// 역순 정렬
cr.sort( (a, b) => (b - a) );
console.log(cr);

//
let dr = [
    {
        n:30,
        s:'월',
    },
    {
        n:20,
        s:'화',
    },
    {
        n:10,
        s:'수',
    },
]
dr.sort((a, b)=>{
    return a.n- b.n;
});
console.log(dr);
console.log('end');
 */

// ex45) 배열 : slice
/* 
let ar = [1, 2, 3, 4, 5, 6, 7, 8];
//                2 ~ 4-1
let br = ar.slice(2, 4);
// let br = ar.slice(start, end-1);
console.log(br);

// splice(시작위치, 삭제수, 추가항목, ... )
let cr = [1, 2, 3, 99, 88, 77];
// cr.splice(1, 0, 4, 5, 6, 7);
cr.splice(2, 2, 4, 5, 6, 7);
console.log(cr);

// indexOf
let dr = ['lion','tiger','dog','cat','tiger'];
console.log(dr.indexOf('tiger'));
console.log(dr.indexOf('tig'));
console.log(dr.indexOf('tiger', 2));
console.log('');
console.log(dr.lastIndexOf('tiger'));

let er = [1, 30, 39, 29, 10, 13];
function f1(data){
    return data < 30;
};
function f2(data){
    return data < 0;
};
console.log(er.every( f1 ));

console.log(er.some(f2));

console.log('');

let fr = [1, 3, 5, 7];
console.log(fr.some((value)=>{
    return value % 2 === 0;
}));

// 배열에서 map() >> 
let ar = [1, 30, 39, 29, 10, 13];
let br = ar.filter( (v)=>{
    return v < 30;
});
console.log(br);

let cr = [
    'tiger',
    'lion',
    'dog',
    'cat',
    'rose',
];
console.log(cr.filter( (v)=>{
    return v.length >= 4;
}));

문자열 배열 객체
length         O    O    X
for Each       X    O    X
for In         O    O    O
for of         O    O    X
map            X    O    X
*/

// ex46) reduce
/* 
// 기본 예제
// var sum = [0, 1, 2, 3].reduce(function (accumulator, currentValue) {
//     console.log(accumulator, currentValue);
//     return accumulator + currentValue;
// }, 0);
//   // sum is 6
// console.log(sum);

// console.log(
//     [0, 1, 2, 3].reduce((accumulator, currentValue) => accumulator + currentValue, 0)
// );

// 객체 배열에서의 값 합산
// var initialValue = 0;
// var sum = [{x: 1}, {x:2}, {x:3}].reduce(function (accumulator, currentValue) {
//     console.log(accumulator, currentValue);
//     return accumulator + currentValue.x;
// },initialValue)

// console.log(sum) // logs 6

// 중첩 배열 펼치기
// var flattened = [[0, 1], [2, 3], [4, 5]].reduce(
//     function(accumulator, currentValue) {
//         console.log(accumulator, currentValue);
//         return accumulator.concat(currentValue);
//     }, []
// );
//   // 펼친 결과: [0, 1, 2, 3, 4, 5]
// console.log(flattened);

// in - 인덱스를 물어봄(객체 안에서는 키)
// console.log( 10 in [10, 20, 30, 40] );  // false
// console.log( 3 in [10, 20, 30, 40] );   // true
// console.log('c' in { a:10, b:20 }); // false
// console.log('a' in { a:10, b:20 }); // true

// 객체 내의 값 인스턴스 개수 세기
// var names = ['Alice', 'Bob', 'Tiff', 'Bruce', 'Alice'];

// var countedNames = names.reduce(function (allNames, name) {
//     console.log(allNames, name);
//     if (name in allNames) {
//         allNames[name]++;   // 단항연산자 ( inc )
//     }
//     else {
//         allNames[name] = 1;
//     }
//     return allNames;
// }, {});
// // countedNames is:
// // { 'Alice': 2, 'Bob': 1, 'Tiff': 1, 'Bruce': 1 }
// console.log(countedNames);

// 객체 내의 값 인스턴스 개수 세기 - 삼항연산
// var names = ['Alice', 'Bob', 'Tiff', 'Bruce', 'Alice'];

// var countedNames = names.reduce(function (allNames, name) {
//     console.log(allNames, name);
//     // add, mov
//     allNames[name] = (name in allNames) ? allNames[name]+1 : 1;

//     return allNames;
// }, {});
// // countedNames is:
// // { 'Alice': 2, 'Bob': 1, 'Tiff': 1, 'Bruce': 1 }
// console.log(countedNames);

// 속성으로 객체 분류하기
var people = [
    { name: 'Alice', age: 21 },
    { name: 'Max', age: 20 },
    { name: 'Jane', age: 20 }
];

function groupBy(objectArray, property) {
    return objectArray.reduce(function (acc, obj) {
    var key = obj[property];
    if (!acc[key]) {
        acc[key] = [];
    }
    acc[key].push(obj);
    return acc;
    }, {});
}
var groupedPeople = groupBy(people, 'age');
// groupedPeople is:
// {
//   20: [
//     { name: 'Max', age: 20 },
//     { name: 'Jane', age: 20 }
//   ],
//   21: [{ name: 'Alice', age: 21 }]
// }
console.log(groupedPeople);

// 확장 연산자와 초기값을 이용하여 객체로 이루어진 배열에 담긴 배열 연결하기
// friends - an array of objects
// where object field "books" - list of favorite books
var friends = [{
    name: 'Anna',
    books: ['Bible', 'Harry Potter'],
    age: 21
}, {
    name: 'Bob',
    books: ['War and peace', 'Romeo and Juliet'],
    age: 26
}, {
    name: 'Alice',
    books: ['The Lord of the Rings', 'The Shining'],
    age: 18
}];
  // allbooks - list which will contain all friends' books +
  // additional list contained in initialValue
var allbooks = friends.reduce(function(accumulator, currentValue) {
    return [...accumulator, ...currentValue.books];
}, ['Alphabet']);
  // allbooks = [
  //   'Alphabet', 'Bible', 'Harry Potter', 'War and peace',
  //   'Romeo and Juliet', 'The Lord of the Rings',
  //   'The Shining'
  // ]
console.log(allbooks);

// 배열의 중복 항목 제거
let arr = [1, 2, 1, 2, 3, 5, 4, 5, 3, 4, 4, 4, 4];
let result = arr.sort().reduce((accumulator, current) => {
    const length = accumulator.length
    if (length === 0 || accumulator[length - 1] !== current) {
        accumulator.push(current);
    }
    return accumulator;
}, []);
console.log(result); //[1,2,3,4,5]

let array        = [91, 4, 6, 24, 8, 7, 59, 3, 13, 0, 11, 98, 54, 23, 52, 87, 4];
let countIfLess  = (array,v)=> array.reduce( (c,n) => n < v ? c + 1 : c ,0);
let countIfEqual = (array,v)=> array.reduce( (c,n) => n == v ? c + 1 : c ,0);

console.log(
    array.reduce(
        (a,v,i,array)=>( a[countIfLess(array,v) + countIfEqual(a,v)]=v, a ),
        new Array(array.length)
    )
);
 */

// ex47)
/* 
let obj01 = {
    n:10,
    f1:function(){
        console.log(this.n);
    },
    f2:()=>{
        console.log(this.n);
    }
}
obj01.f1();
obj01.f2();

function Func(){
    this.n = 10;
    this.obj = {
        n:20,
        f1:function(){
            console.log(1, this.n);
        },
        f2:()=>{
            // 
            console.log(2, this.n);
        }
    };
}
let ins = new Func();
ins.obj.f1();
ins.obj.f2();
 */

// ex48) 생성자 함수
/* 
// 일반적으로 생성자 함수안에서는 함수를 만들지 않는다
function Func(name, age){
    // this.name = 'tiger';
    // this.age = 10;
    this.name = name;
    this.age = age;
    this.f1 = function(){
        console.log(this.name, this.age);
    };
}
let ins = new Func('lion', 20);
ins.f1();
 */

// ex49)
/* 
// -ex1) 일반함수
function f1(){
    return {
        a:10,
        f:function(){},
    }
}
let obj1 = f1();
let obj2 = f1();
console.log(obj1.f === obj2.f);

// -ex2) 생성자 함수
function F1(){
    this.a = 10;
    this.f = function(){};
}
let ins1 = new F1();
let ins2 = new F1();
console.log(ins1.f === ins2.f);

// -ex3) 생성자 함수
function F2(){
    this.a = 10;
}
// static
F2.prototype.f = function(){};

let ins3 = new F2();
let ins4 = new F2();
console.log(ins3.f === ins4.f);
 */

// ex50)
/* 
// -ex1)
let obj = {

}
obj.f1 = function(){
    console.log(1);
}
obj.f1();

// -ex2)
function F1(){

}
F1.prototype.f1 = function(){
    console.log(2);
}
let ins = new F1();
ins.f1();
 */

// ex51)
/* 
// -ex1)
// let obj0 = { name:'tiger0', n1:10, n2:60, };
// let obj1 = { name:'tiger1', n1:20, n2:70, };
// let obj2 = { name:'tiger2', n1:30, n2:80, };
// let obj3 = { name:'tiger3', n1:40, n2:90, };
// let obj4 = { name:'tiger4', n1:50, n2:10, };

// let ar = [];
// ar.push(obj0);
// ar.push(obj1);
// ar.push(obj2);
// ar.push(obj3);
// ar.push(obj4);

// ar.forEach( (v, i)=> {
//     console.log(v.name, v.n1, v.n2);
// } );

// -ex2)
// let ar = [];
// ar.push({ name:'tiger0', n1:10, n2:60, });
// ar.push({ name:'tiger1', n1:20, n2:70, });
// ar.push({ name:'tiger2', n1:30, n2:80, });
// ar.push({ name:'tiger3', n1:40, n2:90, });
// ar.push({ name:'tiger4', n1:50, n2:10, });

// ar.forEach( (v, i)=> {
//     console.log(v.name, v.n1, v.n2);
// } );

// -ex3)
// function makeInfo(name, n1, n2){
//     return {
//         name: name,
//         n1:n1,
//         n2:n2,
//     }
// }
// let ar = [];
// ar.push(makeInfo('tiger0',10,60));
// ar.push(makeInfo('tiger1',20,70));
// ar.push(makeInfo('tiger2',30,80));
// ar.push(makeInfo('tiger3',40,90));
// ar.push(makeInfo('tiger4',50,10));

// ar.forEach( (v, i)=> {
//     console.log(v.name, v.n1, v.n2);
// } );

// -ex4)
// function MakeInfo(name, n1, n2){
//     this.name = name;
//     this.n1 = n1;
//     this.n2 = n2;
// }
// let ar = [];
// console.log(new MakeInfo('tiger0',10,60));
// ar.push(new MakeInfo('tiger0',10,60));
// ar.push(new MakeInfo('tiger1',20,70));
// ar.push(new MakeInfo('tiger2',30,80));
// ar.push(new MakeInfo('tiger3',40,90));
// ar.push(new MakeInfo('tiger4',50,10));

// ar.forEach( (v, i)=> {
//     console.log(v.name, v.n1, v.n2);
// } );

// -ex5)
// function MakeInfo(name, n1, n2){
//     this.name = name;
//     this.n1 = n1;
//     this.n2 = n2;
// }
// let ar = [];
// console.log(new MakeInfo('tiger0',10,60));

// ar.push(new MakeInfo('tiger0',10,60));
// ar.push(new MakeInfo('tiger1',20,70));
// ar.push(new MakeInfo('tiger2',30,80));
// ar.push(new MakeInfo('tiger3',40,90));
// ar.push(new MakeInfo('tiger4',50,10));

// ar.forEach( (v, i)=> {
//     ar[i].sum = v.n1 + v.n2;
// } );

// MakeInfo.prototype.output = function(){
//     console.log(this.name, this.n1, this.n2, this.sum);
// }
// for( const key in ar){
    // console.log(ar[key]);
//     ar[key].output();
// }
 */

// ex52) 상속()
/* 
// -ex1)
// function Apple(){
//     this.a = 10;
// }

// function Banana(){
//     this.b = 20;
// }

// Banana.prototype = new Apple();
// Banana.prototype.constructor = Banana;

// const obj = new Banana();
// console.log(obj.a, obj.b);

// -ex2)
function Apple(){
    this.query = {
        name:'tiger',
        age:10,
    }
}

function Banana(){
    this.request = {
        x:10,
        y:20,
    }
}

Banana.prototype = new Apple();
Banana.prototype.constructor = Banana;

const ctx = new Banana();
console.log(ctx);
console.log(ctx.request);
console.log(ctx.query);

console.log();
 */

// ex53) Math
/* 
console.log(Math.PI);   // pi

console.log(Math.abs(-5));  // 절대값

console.log(Math.ceil(3.14));   // n보다 큰 정수중에 가장 가까운 정수
console.log(Math.ceil(-3.14));

console.log(Math.floor(3.14));  // n보다 작은 정수중에 가장 가까운 정수
console.log(Math.floor(-3.14));

console.log(99, Math.round(3.5));  // 반올림
console.log(99, Math.round(-3.5));

console.log(Math.max( 3, 5, 6, 7, 8, 9 ));  // 최대
console.log(Math.min( 3, 5, 6, 7, 8, 9 ));  // 최소

console.log(Math.pow( 3, 5));  // **

console.log(Math.sqrt(4));  // 루트
console.log(Math.sqrt(3));
console.log(Math.sqrt(3)*Math.sqrt(3));

function degreeToRadian( degree ){
    return Math.PI * degree / 180.0;
}
console.log(Math.sin(degreeToRadian(30)));
console.log('');

for (let i = 0; i < 10; i++) {
    // console.log(Math.random());    
    // console.log(Math.random()*10);    
    console.log(Math.floor(Math.random()*10));    

}
 */

// ex54) JSON >> 객체, 객체 >> JSON
/* 
let obj1 = {
    a:10,
    b:'tiger',
};

// 직렬화 >> 객체를 문자열로
let str = JSON.stringify(obj1);
console.log(typeof str, str);

// 보낸다.
// str은 네트워크 데이터 전송으로 사용된다

// 받았다.(역직렬화) >> 문자열을 객체로
let obj2 = JSON.parse(str);
console.log(typeof obj2, obj2);
 */

// ex55)
/* 
// -ex1)
const obj = {
    name:'tiger',
    age:10,
}
// 비구조화 할당
let {name, age} = obj;
console.log(name, age);

// -ex2)
function f1({name, age}){
    console.log(name, age);
}
f1(obj);

// -ex3)
const ar = [10, 20, 30];
let [dog, cat, tiger] = ar;
console.log(dog, cat, tiger);

// -ex4)
const obj2 = {
    aa:'tiger',
    bb:10,
}

// aa:cc >> 리네임이 일어난다.
let {aa:cc, bb:dd} = obj2;
// console.log(aa, bb);
console.log(cc, dd);

console.log('---------------------');

// -ex5)
function f2({aa:cc, bb:dd}){
    console.log(cc, dd);
}
f2(obj2);

// -ex6)
const initialState = {
    post:{

    }
}
const payload = {
    data:{
        name:'tiger',
    }
}

const {data:post} = payload;
console.log(post);
console.log(post.name);
 */

// ex56) 향상된 객체 리터럴
/* 
const a = 10;
const c = 10;
const obj = {
    a,
    b:20,
    c,
}
console.log(obj);
 */

// ex57) 함수의 디폴트 파라미터
/* 
function f1(a, b = 1000, c = 'tiger'){
    console.log(a, b, c);
}
f1(10);
f1(10, 2000);
f1(10, 2000, 'lion');
 */

// ex58) p417~ 클래스

// -ex1)
// 생성자 함수 : 클래스로도 가능하다.

// function Person(name){
//     this.name = name;
// }
// Person.prototype.f1 = function(){
//     console.log(this.name);
// }

// let p = new Person('tiger');
// p.f1();

// -ex2)
// 생성자 함수

// function Person(name){
//     this.name = name;

//     Person.prototype.f1 = function(){
//         console.log(this.name);
//     }
// }

// let p = new Person('tiger');
// p.f1();

// -ex3)
// 생성자 함수

// let Person2 = (function(){
//     function Person(name){
//         this.name = name;
        
//         Person.prototype.f1 = function(){
//             console.log(this.name);
//         }
//     }

//     return Person;
// })();

// let p = new Person2('tiger');
// p.f1();

// -ex4)
// class Person{
//     constructor(){
//         console.log(1);
//     }
// }
// let p = new Person();

// -ex5)
// class Person{
//     // 1. 
//     n3 = 30;    // let, var, this 이런거 전부 X
//     constructor(n2){
//         console.log(1);
//         // 2. 생성자 안에서 필드 선언하는 방법
//         this.n1 = 10;
//         this.n2 = n2;
//     }
// }
// let p = new Person(20);
// console.log(p.n1, p.n2, p.n3);

// -ex6)
// class Person{
//     n3 = 30;
//     constructor(n2){
//         console.log(1);
//         this.n1 = 10;
//         this.n2 = n2;    // n2 프로퍼티는 public하다
//     }
//     // .prototype.함수이름 >> 이 문법과 완전 동격
//     // 프로토타입 메서드
//     f1(){
//         // this 생략 불가
//         console.log(this.n1, this.n2, this.n3);
//     }

// }
// // 인스턴스 생성
// let p = new Person(20);
// // console.log(p.n1, p.n2, p.n3);
// p.f1();

// -ex7)
// class Person{
//     n3 = 30;
//     static n4 = 40;
//     constructor(n2){
//         console.log(1);
//         this.n1 = 10;
//         this.n2 = n2;
//     }
//     f1(){
//         console.log(this.n1, this.n2, this.n3);
//     }
//     // 정적 메서드
//     static f2(){
//         // 필드 사용 불가
//         console.log('static f2 call', this.n4);
//     }
// }
// let p = new Person(20);
// // console.log(p.n1, p.n2, p.n3);
// p.f1();
// // 정적 메서드 호출
// Person.f2();

// -ex7-1)
// function Person(){
//     Person.prototype.f1 = function(){
//         console.log('1');
//     };  // prototype 함수
//     Person.f2 = function(){
//         console.log('2');
//     }; // static 함수
// }
// let p = new Person();
// p.f1();
// Person.f2();

// -ex8) 클래스 이름이 rename이 일어난다
// let Person2 = class Person{}

// // let p1 = new Person(); // error
// let p2 = new Person2(); // 정상

// -ex9)
// class Person{
//     constructor(){
//         // default 값
//         // return this;
//         // return {};
//         // return 100; // >> return this;
//         return {a:10, b:20};
//     }
// }
// let p = new Person();
// console.log(p);

// -ex10-1)
// class Square{
//     static area(w, h){
//         return w * h;
//     }
// }
// console.log(Square.area(3, 4));

//-ex10-2)
// class Square{
//     constructor(w, h){
//         this.w = w;
//         this.h = h;
//     }
//     area(){
//         return this.w * this.h;
//     }
// }
// let p = new Square(3, 4);
// console.log(p.area());

// Math.

// -ex11)
// class Person{
//     constructor(firstName, lastName){
//         this.firstName = firstName;
//         this.lastName = lastName;
//     }
//     // getter 함수
//     get fullName(){
//         console.log('full Name');
        
//         return `${this.firstName} ${this.lastName}`;
//     }
//     // setter 함수
//     set fullName(name){
//         [this.firstName, this.lastName] = name.split(' ');
//     }
// }

// const p = new Person('white','tiger');
// console.log(p.firstName, p.lastName);
// console.log(`${p.firstName} ${p.lastName}`);
// console.log(p.fullName);    // 함수 호출이라기보다는 속성사용

// p.fullName = 'red lion';
// console.log(p.fullName);

// -ex12)
// class Person{
//     name = 'lee';
//     constructor(){
//         console.log(this.name);
//         // this를 빼면 안된다
//         // console.log(name);
//     }
// }
// let p = new Person();

// -ex13)
// class Person{
//     // #을 붙이면 private
//     #name = 'tiger';
//     constructor(name){
//         this.#name = name;
//     }
// }
// let p = new Person('lion');
// console.log(p.name);

// -ex13-2)
// class Person{
//     // #을 붙이면 private
//     constructor(name){
//         this.#name = name;
//     }
    
//     // 모순적인 코드가 된다 >> trim()을 넣음으로서 해결
//     #name = 'tiger';
//     get name(){
//         // 가변적인 코드가 추가 될 수 있다
//         // name이라는 이름을 가공할 수 있다
//         return this.#name.trim();
//     }

//     #age = 10;
//     get age(){
//         return this.#age;
//     }
// }
// let p = new Person('  lion  ');
// console.log(p.name, p.age);

// -ex14)
// class Animal{
//     f1(){
//         return 'f1';
//     }
//     f3(){
//         return 'Animal f3';
//     }
// }
// class Bird extends Animal{
//     f2(){
//         return 'f2'
//     }
//     f3(){
//         return 'Bird f3';
//     }
// }

// let b = new Bird();
// console.log(b.f1());
// console.log(b.f2());
// console.log(b.f3());

// -ex15-1)
// class Base{
//     constructor(a, b){
//         console.log(a, b);
//         this.a = a;
//         this.b = b;
//     }
// }
// class Derived extends Base{
//     // default 코드
//     // constructor(...args){
//     //     super(...args);
//     // }
// }
// new Derived();
// new Derived(3);
// new Derived(3,4);

// -ex15-2)
// class Base{
//     constructor(a, b){
//         console.log(a, b);
//         this.a = a;
//         this.b = b;
//     }
// }
// class Derived extends Base{
//     constructor(a, b, c){
//         super(a, b+c);
//     }
// }
// new Derived(3);
// new Derived(3,4);
// new Derived(3,4,5);

// -ex16)
class MyArray extends Array{
    uniq(){
        return this.filter(
            (v, i, self) => {
                return self.indexOf(v) === i;
            }
        );
    }

    average(){
        // return this.reduce( (p, c) => { return p + c }, 0) / this.length;
        return this.reduce( (p, c) => p + c , 0 ) / this.length;
    }
}
const ar = new MyArray(1, 1, 2, 2, 3, 3, 3);
console.log(ar.uniq());
console.log(ar.average());