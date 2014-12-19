
var valid = false;
var flag = false;

function setPresender(formName) {
	$('form[name="' + formName + '"]').submit(function(e) {
	    if(!flag){
	        e.preventDefault();
	        sendData(this);
	    }
	});
}

function sendData(form) {
	if (!initCheck())
		return false;
    flag = true;
    $(form).submit();
    return false;
}

function check(list) {
	var valid = true;
	for (var k in list)
		if (!window[list[k]](k))
			valid = false;
		
	return valid;
}

function iffilled(eid) {
	var eval = $('#' + eid).val();
	return checkField(eid, eval != "" && eval != null);
}

function isEmail(eid) {
	return checkField(eid, $('#' + eid).val().match(/^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/) != null);
}

function isPhone(eid) {
	return checkField(eid, $('#' + eid).val().match(/^\+{0,1}[0-9]+$/) != null);
}

function isNumber(eid) {
	return checkField(eid, $('#' + eid).val().match(/^[0-9]+$/) != null);
}

function checkField(eid, valid) {
	if (!valid)
		$('#' + eid + '_error').show();
	else
		$('#' + eid + '_error').hide();
	return valid;
}