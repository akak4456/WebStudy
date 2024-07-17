function jsFunc1() {
	var p1Tag = document.querySelector('#p1');
	p1Tag.innerHTML = 'jsFunc1() 함수 실행 완료';
}
var jsFunc2 = function () {
	var p2Tag = document.querySelector('#p2');
	p2Tag.innerHTML = 'jsFunc2() 함수 실행 완료';
};
function resultJsFunc4() {
	jsFunc3(1, 2, 3);
	jsFunc3(24, 10, 23);
}
function jsFunc3(num1, num2, num3) {
	var result = num1 + num2 + num3;
	var p4Tag = document.querySelector('#p4');
	p4Tag.innerHTML = result;
}
function resultJsFunc5() {
	var p5Tag = document.querySelector('#p5');
	p5Tag.innerHTML = jsFunc6();
}
function jsFunc6() {
	return Math.floor(Math.random() * 10 + 1);
}
function jsFunc7(num) {
	console.log(num + 1 + '번째 함수 호출 완료');
}
function calleeFunc(num) {
	var p6Tag = document.querySelector('#p6');
	p6Tag.innerHTML += num + 1 + '번째 함수 호출 완료<br>';
}
function callFuncTemTimes(otherFunc) {
	for (var i = 0; i < 10; i++) {
		otherFunc(i);
	}
}
callFuncTemTimes(calleeFunc);

function add(num) {
	let cnt = 0;
	return function () {
		cnt++;
		console.log(cnt + num);
	};
}
const adding = add(10);
adding(); // 11
adding(); // 12
adding(); // 13

console.dir(adding);
