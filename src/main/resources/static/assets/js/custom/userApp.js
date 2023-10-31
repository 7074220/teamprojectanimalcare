import {user_write_form} from './template-user-write-from.js';
import {ajaxRequest} from './request.js';

let hash = window.location.hash
let path = hash.substring(1);
let html = '';

/*
초기실행메쏘드
*/
function init() {
	registEvent();
	navigate();
}
/*
이벤트등록
*/
function registEvent() {
	/*
	$(window).on('load', function(e) {
		alert('load  event:' + e);
	});
	*/
	$(window).on('hashchange', function(e) {
		alert('hashchange event:' + e);
		hash = window.location.hash
		path = hash.substring(1);
		navigate();
	});
	
	$(document).on('click', function(e) {
		if ($(e.target).attr('data-navigate')) {
			alert('click event --> hash변경:' + $(e.target).attr('data-navigate'));
			window.location.hash = e.target.getAttribute('data-navigate');
		}
	});
}

/*
	이벤트발생시 처리메쏘드
*/
function navigate() {
	path = hash.substring(1);
	if (path == '/user_write_action') {
		/**************** /user_write_action******************/
		console.log('콘솔');
		//html = user_write_form();
		//$('content').html(html);
	}
}



init();

