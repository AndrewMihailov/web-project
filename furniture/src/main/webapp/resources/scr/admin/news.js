
$(onload);

function onload() {
	setPresender('news');
	
	$('#perpage').on('change', function () {
		document.location.href='?perpage=' + $(this).val();
	});
}

function initCheck() {
	var param = {'title' : 'iffilled',
			'preview' : 'iffilled',
			'text' : 'iffilled'
			};
	return check(param);
}
