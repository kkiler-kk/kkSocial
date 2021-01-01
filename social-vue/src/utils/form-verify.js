const emailTemplate = /^\w+@(\w+.)+\w+$/;

function test(template, data) {
	return template.test(data);
}

function equals(a, b) {
	return a === b;
}

function isEmpty(data) {
	return !data || data === '';
}

function emailVerify(email) {
	return emailTemplate.test(email);
}

function lengthIn(data, left, right) {
	return lengthOfMin(data, left) && lengthOfMax(data, right);
}

function lengthOfMin(data, n) {
	return data.length >= n;
}

function lengthOfMax(data, n) {
	return data.length < n;
}

export default {
	test,
	equals,
	isEmpty,
	emailVerify,
	lengthIn,
	lengthOfMin,
	lengthOfMax
}