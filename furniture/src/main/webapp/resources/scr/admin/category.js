
$(onload);

function onload() {
	setPresender('category');
	
	if ($('#parent').val() == "null")
		$('#parent').removeAttr("name");
	$('#parent').change(function () {
		var e = $(this);
		if (e.val() == "null")
			e.removeAttr("name");
		else
			e.attr("name", "parent.id");
	});
}

function initCheck() {
	var param = {'nameRu' : 'iffilled',
			'nameEn' : 'iffilled',
			};
	return check(param);
}
